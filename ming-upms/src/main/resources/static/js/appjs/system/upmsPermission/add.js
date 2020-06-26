var prefix = ctx + "/system/upmsPermission";

$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/save",
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
			systemId : {
				required : true
			},
			pName : {
				required : true
			},
			name : {
				required : true
			},
			orders: {
				digits: true
			}
		},
		messages : {
			systemId : {
				required : icon + "请选择系统"
			},
			pName: {
				required : icon + "请添加父级资源"
			},
			name : {
				required : icon + "请输入资源名称"
			},
			orders: {
				digits: icon + "排序只能为整数值"
			}
		}
	})
}
$(function() {
    $("input[name='icon']").focus(function() {
        $(".icon-drop").show();
    });
    $("#signupForm").click(function(event) {
        var obj = event.srcElement || event.target;
        if (!$(obj).is("input[name='icon']")) {
            $(".icon-drop").hide();
        }
    });
    $(".icon-drop").find(".ico-list i").on("click", function() {
        $('#icon').val($(this).attr('class'));
    });

});