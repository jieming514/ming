var prefix = "/system/upmsRole"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'post', // 服务器数据的请求方式 get or post
						url : prefix + "/selectAuthRoleUser/"+roleId, // 服务器数据的加载地址
						showRefresh : true,
						showToggle : true,
						showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
					            username:$('#username').val(),
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
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.userId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.userId
												+ '\')"><i class="fa fa-key"></i></a> ';
										return d ;
									}
								} ]
					});
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function goBack() {
    window.history.back(-1);
}

function remove(userId) {

    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/deleteUserRoleInfo",
            type : "post",
            data : {
                'roleId' : roleId,
                'userId' : userId
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    reLoad();
                }else{
                    layer.msg(r.msg);
                }
            }
        });
    })
}
