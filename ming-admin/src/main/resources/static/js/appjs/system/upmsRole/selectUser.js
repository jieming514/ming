var prefix = ctx + "/system/upmsRole";

$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : ctx + "/system/upmsUser/list", // 服务器数据的加载地址
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
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
                                offset:params.offset,
					            username:$('#username').val(),
					            phone : $('#phone').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'userId',
									title : '编号'
								},
																{
									field : 'username',
									title : '帐号'
								},
																{
									field : 'realname',
									title : '姓名'
								},
								{
                                    field : 'phone',
                                    title : '电话'
                                },
                                                                {
                                    field : 'email',
                                    title : '邮箱'
                                },
                                {
									field : 'locked',
									title : '状态',
									formatter : function(value, row, index) {
									    if(value == 1) {
                                            return "<span class='label label-warning'>锁定</span>";
                                        }else if(value == 0) {
                                            return "<span class='label label-success'>正常</span>";
                                        }
                                        return "<span class='label label-danger'>未知</span>";
									}
								} ]
					});
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}


function batchAdd() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要添加的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
    // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['userId'];
        });
        $.ajax({
            type : 'POST',
            data : {
                roleId : roleId,
                ids : ids
            },
            url : prefix + '/addRoleForUser',
            success : function(r) {
                if (r.code == 0) {
                    parent.layer.msg(r.msg);
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {

    });
}
