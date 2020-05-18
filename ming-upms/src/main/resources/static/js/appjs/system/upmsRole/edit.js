$().ready(function() {
	validateRule();
	getRoleHasPermission(roleId);
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
		url : "/system/upmsRole/update",
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

function getRoleHasPermission(roleId) {
    var url = "/system/upmsPermission/selectRoleHasPermission/" + roleId;
    var settings = {
        check: {
            enable: true ,//显示复选框
            chkStyle : "checkbox"
        },
        async: {
            enable: true,//要开启async功能必须设置为true,其他地方同理
            dataType: "json",
            type: "post",
            url: url,
            success : function(data) {
            	console.log(data);
            }
        },
        data: {
            simpleData: {
                enable: true,
                idKey : "permissionId",   //节点数据中保存唯一标识的属性名称
                pIdKey : "pid",    //节点数据中保存其父节点唯一标识的属性名称
                rootPId : null  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
            },
            key: {
                name : "name"  //zTree 节点数据保存节点名称的属性名称  默认值："name"
            }
        }
    };
    var zTreeNodes=[];
    zTreeObj = $.fn.zTree.init($("#permissionTree"), settings, zTreeNodes);
    zTreeObj.expandAll(true);   //true 节点全部展开、false节点收缩


}