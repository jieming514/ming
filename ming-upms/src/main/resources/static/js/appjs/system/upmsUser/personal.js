$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		submitUserInfo();
	}
});

/*用户管理-头像*/
function avatar() {
    var url = 'system/user/profile/avatar';
    $.modal.open("修改头像", url);
}


function submitUserInfo() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/system/upmsUser/update?userId="+userId,
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


function submitChangPassword () {

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
                remote: {
                    url: "system/user/checkEmailUnique",
                    type: "post",
                    dataType: "json",
                    data: {
                        "userId": function() {
                            return $("#userId").val();
                        },
                        "email": function() {
                            return $.common.trim($("#email").val());
                        }
                    },
                    dataFilter: function (data, type) {
                        return $.validate.unique(data);
                    }
                }
            },
            phone:{
                required:true,
                isPhone:true,
                remote: {
                    url: "system/user/checkPhoneUnique",
                    type: "post",
                    dataType: "json",
                    data: {
                        "userId": function() {
                            return $("#userId").val();
                        },
                        "phonenumber": function() {
                            return $.common.trim($("#phonenumber").val());
                        }
                    },
                    dataFilter: function (data, type) {
                        return $.validate.unique(data);
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
                    url: "system/user/profile/checkPassword",
                    type: "get",
                    dataType: "json",
                    data: {
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