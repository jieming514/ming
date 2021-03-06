var prefix = ctx + "/system/upmsOrganization";

// 是否全部展开
var _expandFlag_all = false;

$(function() {
	load();
});

function load() {
    var treeTable = $('#exampleTable')
            .bootstrapTreeTable(
                    {
                        type : 'get', // 服务器数据的请求方式 get or post
                        url : prefix + "/list", // 服务器数据的加载地址
                        ajaxParams: {
                            name : $('#name').val()
                        }, // 请求数据的ajax的data属性
                        id: 'organizationId',
                        parentId: 'pid',
                        expandColumn: 2,// 在哪一列上面显示展开按钮
                        striped: false, // 是否各行渐变色
                        bordered: true, // 是否显示边框
                        expandAll: false, // 是否全部展开
                        expandFirst: true, // 是否默认第一级展开--expandAll为false时生效
                        columns : [{
                                    field: 'selectItem',
                                    radio: true
                                },
                                {
                                    field : 'organizationId',
                                    title : '编号ID',
                                    width: '8%',
                                    align: 'center',
                                    valign: 'center'
                                },
                                {
                                    field : 'name',
                                    title : '组织名称',
                                    fixed: true,
                                    formatter: function(value,row, index) {
                                        if (row == "") {
                                            return row.name;
                                        } else {
                                            return '</i> <span class="nav-label">' + row.name + '</span>';
                                        }
                                    }
                                },

                                {
                                    field : 'description',
                                    title : '组织描述'
                                },
                                {
                                    field : 'ctime',
                                    title : '创建时间'
                                },
                                {
                                    title : '操作',
                                    field : 'id',
                                    align : 'center',
                                    formatter: function(value,item, index) {
                                        var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit('
                                                + item.organizationId
                                                + ')"><i class="fa fa-edit"></i></a> ';
                                        var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                                + item.organizationId
                                                + '\')"><i class="fa fa-remove"></i></a> ';
                                        var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                                + item.organizationId
                                                + '\')"><i class="fa fa-key"></i></a> ';
                                        return e + d ;
                                    }
                                } ]
                    });
}
function reLoad() {
    var params = {
        name : $("#name").val()
    };
    $('#exampleTable').bootstrapTreeTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
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
				'organizationId' : id
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
			ids[i] = row['organizationId'];
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

// 展开和关闭
function expandAll() {
    if(_expandFlag_all){
        $('#exampleTable').bootstrapTreeTable('expandAll');
    }else{
        $('#exampleTable').bootstrapTreeTable('collapseAll');
    }
    _expandFlag_all = _expandFlag_all?false:true;
}