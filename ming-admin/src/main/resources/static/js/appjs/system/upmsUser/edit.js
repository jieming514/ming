var prefix = ctx + "/system/upmsUser";

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
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}

function getTree() {
    layer.open({
        type : 2,
        title : '部门机构树',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '300px', '400px' ],
        content : ctx + '/system/upmsOrganization/getOrganizationTree', // iframe的url
        btn : ['确认', '取消'],
        success : function(layero, index) {
            var body = layer.getChildFrame('body', index);
            var data = {};
            data['treeId'] = $("#organizationId").val();
            data['treeName'] = $("#organizationName").val();
            body.find("#treeId").val(data['treeId']);
            body.find("#treeName").val(data['treeName']);
        },
        yes: function(index, layero){
            var body = layer.getChildFrame("body", index);
            var data = {};
            data['treeId'] = body.find("#treeId").val();
            data['treeName'] = body.find("#treeName").val();
            $("#organizationId").val(data['treeId']);
            $("#organizationName").val(data['treeName']);
            layer.close(index);
        },
        btn2 : function(index) {
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        }
    });
}