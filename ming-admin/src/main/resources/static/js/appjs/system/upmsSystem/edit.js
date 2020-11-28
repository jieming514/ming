var prefix = ctx + "/system/upmsSystem";

$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			title : {
				required : true
			},
			description : {
				required : true,
				maxlength : 100
			},
			basepath : {
				required : true,
				url: true
			},
			orders: {
				digits:true
			}
		},
		messages : {
			title: {
				required : icon + "请输入系统标题"
			},
			description: {
				required : icon + "请输入系统描述",
				maxlength: icon + "系统描述内容过长，请保持在100字以内！"
			},
			basepath: {
				required : icon + "请输入系统url",
				url: icon + "网站格式不正确，正确格式：http://ip:port/index"
			},
			orders: {
				digits: icon + "排序只能为整数值！"
			}
		}
	})
}