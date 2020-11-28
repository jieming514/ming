var prefix = ctx + "/system/upmsOrganization";

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
			pName : {
				required : true
			},
			name : {
				required : true
			}
		},
		messages : {
			pName : {
				required : icon + "请填写所属上级"
			},
			name : {
				required : icon + "请输入组织名称"
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
        content : prefix + '/getOrganizationTree', // iframe的url
        btn : ['确认', '取消'],
        success : function(layero, index) {
            var body = layer.getChildFrame('body', index);
            var data = {};
            data['treeId'] = $("#pid").val();
            data['treeName'] = $("#pName").val();
            body.find("#treeId").val(data['treeId']);
            body.find("#treeName").val(data['treeName']);
        },
        yes: function(index, layero){
            var body = layer.getChildFrame("body", index);
            var data = {};
            data['treeId'] = body.find("#treeId").val();
            data['treeName'] = body.find("#treeName").val();
            $("#pid").val(data['treeId']);
            $("#pName").val(data['treeName']);
            layer.close(index);
        },
        btn2 : function(index) {
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        }
    });
}