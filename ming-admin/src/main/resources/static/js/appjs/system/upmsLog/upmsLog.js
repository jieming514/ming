var prefix = ctx + "/system/upmsLog";

$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
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
						//search : true, // 是否显示搜索框
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                                //name:$('#searchName').val(),
                                username:$('#username').val(),
								limit: params.limit,
								offset:params.offset
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
									checkbox : true,
									width : '4%',
								},
																{
									field : 'logId', 
									title : '编号',
									width : '8%',
									align : 'center'
								},
																{
									field : 'description', 
									title : '操作描述',
									width : '10%'
								},
																{
									field : 'username', 
									title : '操作用户',
									align : 'center',
									width : '12%'
								},
								{
									field : 'startTime', 
									title : '操作时间',
									align : 'center',
									width : '16%'
								},
								{
									field : 'spendTime', 
									title : '消耗时间',
									align : 'center',
									width : '8%',
									formatter : function(value, row, index) {
									    return value + "ms";
									}
								},
								{
									field : 'basePath', 
									title : '根路径',
									width : '14%'
								},
																{
									field : 'uri', 
									title : 'URI',
									width : '10%'
								},
																{
									field : 'method', 
									title : '请求类型',
									align : 'center',
									width : '6%'
								},
																{
									field : 'ip', 
									title : 'IP地址',
									align : 'center',
									width : '10%'
								},
																{
									field : 'result', 
									title : '结果',
									align : 'center',
									width : '10%',
									formatter : function(value, row, index) {
                                        if(value == 1) {
                                              return "<span class='label label-danger'>失败</span>";
                                        }else if(value == 0) {
                                            return "<span class='label label-success'>成功</span>";
                                        }
                                        return "<span class='label label-danger'>未知</span>";
									}
								},
								{
								    field : 'id',
								    title : '操作',
								    align : 'center',
								    width : '10%',
                                    formatter : function(value, row, index) {
                                        var s = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="详情" onclick="show('
                                                + row.logId
                                                + ')"><i class="fa fa-search"></i></a> ';
                                        return s;
                                    }
								}]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'logId' : id
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
			ids[i] = row['logId'];
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
/* 展示详情信息*/
function show(logId) {
    layer.open({
        type : 2,
        title : '日志详情',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '600px' ],
        content : prefix + '/show/' + logId, // iframe的url
        btn : ['关闭'],
        yes : function(index, layero) {
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        }
    });

}