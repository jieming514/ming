var prefix = ctx + "/system/upmsDictData";

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
            dictType : {
                required : true
            },
            dictLabel : {
                required : true
            },
            dictValue : {
                required : true
            }
        },
        messages : {
            dictType : {
                required : icon + "请输入字典类型"
            },
            dictLabel : {
                required : icon + "请输入字典标签"
            },
            dictValue : {
                required : icon + "请输入字典键值"
            }
        }
    });
}

//修改标签样式
function changeLabel() {
    var labelType = $('#listClass').val();
    var labelName = $('#listClass').find("option:selected").text();
    $('#labelShow').removeClass();
    $('#labelShow').addClass("label label-"+labelType);
    $('#labelShow').text(labelName);
}