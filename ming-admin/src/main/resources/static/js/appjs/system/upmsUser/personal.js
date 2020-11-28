var prefix = ctx + "/system/upmsUser";

$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		submitUserInfo();
		submitChangPassword();
	}
});

/*用户管理-头像*/
function avatar() {
    var url = ctx + 'system/user/profile/avatar';
    $.modal.open("修改头像", url);
}


function submitUserInfo() {
    if($("#form-user-edit").valid()) {
        $.ajax({
            cache : true,
            type : "POST",
            url : prefix + "/update",
            data : $('#form-user-edit').serialize(),// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("Connection error");
            },
            success : function(data) {
                if (data.code == 0) {
                    layer.msg("操作成功");
                } else {
                    layer.alert(data.msg)
                }

            }
        });
    }
}


function submitChangPassword() {
    if($("#form-user-resetPwd").valid()) {
        $.ajax({
            cache : true,
            type : "POST",
            url : prefix + "/resetPwd",
            data : {
                userId : function() {
                    return $("#userId").val();
                },
                password : function() {
                    return $("#newPassword").val();
                }
            },
            async : false,
            error : function(request) {
                laryer.alert("Connection error");
            },
            success : function(data) {
                if (data.code == 0) {
                    layer.alert("更新密码成功");
                    $('#form-user-resetPwd')[0].reset();
                } else {
                    layer.alert(data.msg)
                }
            }
        });
    }
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    /*用户信息-修改*/
    $("#form-user-edit").validate({
        onsubmit:true,
        onkeyup: false,
        rules:{
            realname:{
                required:true,
            },
            email:{
                required:true,
                email:true,
                isEmail:true,
                remote: {
                    url: prefix + "/checkEmailUnique",
                    type: "post",
                    dataType: "json",
                    data: {
                        "userId": function() {
                            return $("#userId").val();
                        },
                        "email": function() {
                            return $("#email").val();
                        }
                    },
                    dataFilter: function (data, type) {
                        if(data != null && data == 1) {
                            return false
                        }
                        return true;
                    }
                }
            },
            phone:{
                required:true,
                isPhone:true,
                remote: {
                    url: prefix + "/checkPhoneUnique",
                    type: "post",
                    dataType: "json",
                    data: {
                        "userId": function() {
                            return $("#userId").val();
                        },
                        "phone": function() {
                            return $("#phone").val();
                        }
                    },
                    dataFilter: function (data, type) {
                        if(data != null && data == 1) {
                            return false
                        }
                        return true;
                    }
                }
            },
        },
        messages: {
            "realname": {
                required: icon + "请输入用户名称",
            },
            "email": {
                required: icon + "请输入邮箱",
                remote: icon + "Email已经存在"
            },
            "phone":{
                required: icon + "请输入手机号码",
                remote: icon + "手机号码已经存在"
            }
        },
        focusCleanup: true
    });

    /*用户管理-修改密码*/
    $("#form-user-resetPwd").validate({
        onkeyup: false,
        rules:{
            oldPassword:{
                required:true,
                remote: {
                    url: prefix + "/checkPassword",
                    type: "post",
                    dataType: "json",
                    data: {
                        userId: function() {
                            return $("#userId").val();
                        },
                        password: function() {
                            return $("input[name='oldPassword']").val();
                        }
                    }
                }
            },
            newPassword: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
            confirmPassword: {
                required: true,
                equalTo: "#newPassword"
            }
        },
        messages: {
            oldPassword: {
                required: "请输入原密码",
                remote: "原密码错误"
            },
            newPassword: {
                required: "请输入新密码",
                minlength: "密码不能小于6个字符",
                maxlength: "密码不能大于20个字符"
            },
            confirmPassword: {
                required: "请再次输入新密码",
                equalTo: "两次密码输入不一致"
            }

        },
        focusCleanup: true
    });

}

function getUserRole() {
    userId = $("#userId").val(),
	$('#exampleTable').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : ctx + "/system/upmsRole/selectRoleByUserId/"+userId, // 服务器数据的加载地址
        showRefresh : true,
        showToggle : true,
        showColumns : true,
        iconSize : 'outline',
        toolbar : '#exampleToolbar',
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect : false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        pageSize : 10, // 如果设置了分页，每页数据条数
        pageNumber : 1, // 如果设置了分布，首页页码
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                limit : params.limit,
                offset : params.offset
            };
        },
        columns : [
                {
                    field : 'roleId',
                    align : 'center',
                    title : '编号'
                },
                {
                    field : 'name',
                    align : 'center',
                    title : '角色名称'
                },
                {
                    field : 'title',
                    align : 'center',
                    title : '角色标题'
                },
                {
                    field : 'description',
                    title : '角色描述'
                },
                {
                    title : '资源',
                    align : 'center',
                    field : 'id',
                    formatter : function(value, row, index) {
                        return "<a href='#' onclick='getTree("+row.roleId+")'>查看资源</a>";
                    }
                }]
    });
}

//获取资源树
function getTree(roleId) {
    layer.open({
        type : 2,
        title : '角色资源列表',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '400px', '500px' ],
        content : ctx + '/system/upmsPermission/getPermissionTree/'+roleId, // iframe的url
        btn : ['确认'],
        yes : function(index, layero) {
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        }
    });
}