var prefix = ctx + "/system/upmsPermission";

$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTreeTable(
					{
						id: 'permissionId',
                        code: 'permissionId',
                        parentCode: 'pid',
                        type: "GET", // 请求数据的ajax类型
                        url: prefix + '/list', // 请求数据的ajax的url
                        ajaxParams: {sort:'orders'}, // 请求数据的ajax的data属性
                        expandColumn: '2',// 在哪一列上面显示展开按钮
                        striped: false, // 是否各行渐变色
                        expandAll: false, // 是否全部展开
						columns : [
								{
									field : 'permissionId', 
									title : '编号',
									visible: false,
                                    align: 'center',
                                    valign: 'center',
                                    width: '5%'
								},
                                {
                                    field : 'systemName',
                                    align: 'center',
                                    valign: 'center',
                                    title : '所属系统',
                                    width: '10%'
                                },
								{
									field : 'name',
									valign: 'center',
									title : '名称',
									width: '12%'
								},
																{
									field : 'type', 
									title : '类型',
									align: 'center',
									valign: 'center',
									width: '5%',
                                    formatter : function(item, index) {
                                        if(item.type == 1) {
                                            return "<span class='label label-success'>目录</span>";
                                        }else if(item.type == 2) {
                                            return "<span class='label label-primary'>菜单</span>";
                                        }else if(item.type == 3) {
                                             return "<span class='label label-warning'>按钮</span>";
                                         }
                                        return "<span class='label label-danger'>未知</span>";
                                    }
								},
																{
									field : 'permissionValue',
									valign: 'center',
									title : '权限值',
									width: '12%'
								},
																{
									field : 'uri', 
									title : '路径',
									width: '20%'
								},
																{
									field : 'icon',
									align: 'center',
									valign: 'center',
									title : '图标',
									width: '5%',
									formatter : function(item, index) {
									    return "<i class='" + item.icon + "' aria-hidden='true'></i>";
									}
								},
																{
									field : 'status',
									align: 'center',
									valign: 'center',
									title : '状态',
									width: '4%',
                                    formatter : function(item, index) {
                                        if(item.status == 0) {
                                            return "<span class='label label-warning'>禁用</span>";
                                        }else if(item.status == 1) {
                                            return "<span class='label label-success'>正常</span>";
                                        }
                                        return "<span class='label label-danger'>未知</span>";
                                    }
								},
								{
									field : 'ctime',
									align: 'center',
									valign: 'center',
									title : '创建时间',
									width: '8%'
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(item, index) {
									    var a = '<a class="btn btn-info btn-sm '+s_add_h+'" href="#" mce_href="#" title="添加子节点" onclick="add('
                                                + item.permissionId
                                                + ')"><i class="fa fa-plus"></i></a> ';
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit('
												+ item.permissionId
												+ ')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-danger btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove('
												+ item.permissionId
												+ ')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ item.permissionId
												+ '\')"><i class="fa fa-key"></i></a> ';
										if(item.type == 3) {
										    return e + d ;
										}
										return a + e + d ;
									}
								} ]
					});
}
function reLoad() {
	load();
}
//上一级目录
function add(pid) {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/' +pid // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'permissionId' : id
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

function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['permissionId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}
