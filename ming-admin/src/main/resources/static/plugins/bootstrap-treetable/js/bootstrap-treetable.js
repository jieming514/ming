/**
 * bootstrap-treetable
 * v1.0.6-beta
 * @author swifly
 * @url https://gitee.com/cyf783/bootstrap-treetable/
 */
(function($) {
    "use strict";

    var BootstrapTreeTable = function(el, options) {
        this.options = options;
        this.$el = $(el);
        this.$el_ = this.$el.clone();
        this.hasSelectItem = false; // 是否有radio或checkbox
        this.data_list = null; //用于缓存格式化后的数据-按父分组
        this.data_obj = null; //用于缓存格式化后的数据-按id存对象
        this.hiddenColumns = []; //用于存放被隐藏列的field
        this.lastAjaxParams; //用户最后一次请求的参数
        this.isFixWidth = false; //是否有固定宽度
        this.init();
    };
    // 初始化
    BootstrapTreeTable.prototype.init = function() {
        // 初始化容器
        this.initContainer();
        // 初始化工具栏
        this.initToolbar();
        // 初始化表头
        this.initHeader();
        // 初始化表体
        this.initBody();
        // 初始化数据服务
        this.initServer();
        // 动态设置表头宽度
        this.autoTheadWidth(true);
    };
    // 初始化容器
    BootstrapTreeTable.prototype.initContainer = function() {
        var self = this;
        // 在外层包装一下div，样式用的bootstrap-table的
        var $container = $("<div class='bootstrap-tree-table'></div>");
        var $treetable = $("<div class='treetable-table'></div>");
        self.$el.before($container);
        $container.append($treetable);
        $treetable.append(self.$el);
        self.$el.addClass("table");
        if (self.options.striped) {
            self.$el.addClass('table-striped');
        }
        if (self.options.bordered) {
            self.$el.addClass('table-bordered');
        }
        if (self.options.hover) {
            self.$el.addClass('table-hover');
        }
        if (self.options.condensed) {
            self.$el.addClass('table-condensed');
        }
        self.$el.html("");
    };
    // 初始化工具栏
    BootstrapTreeTable.prototype.initToolbar = function() {
        var self = this;
        var $toolbar = $("<div class='treetable-bars'></div>");
        if (self.options.toolbar) {
            $(self.options.toolbar).addClass('tool-left');
            $toolbar.append($(self.options.toolbar));
        }
        var $rightToolbar = $('<div class="btn-group tool-right">');
        $toolbar.append($rightToolbar);
        self.$el.parent().before($toolbar);
        // 是否显示刷新按钮
        if (self.options.showRefresh) {
            var $refreshBtn = $('<button class="btn btn-default btn-outline" type="button" aria-label="refresh" title="刷新"><i class="glyphicon glyphicon-repeat"></i></button>');
            $rightToolbar.append($refreshBtn);
            self.registerRefreshBtnClickEvent($refreshBtn);
        }
        // 是否显示列选项
        if (self.options.showColumns) {
            var $columns_div = $('<div class="btn-group pull-right" title="列"><button type="button" aria-label="columns" class="btn btn-default btn-outline dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="glyphicon glyphicon-list"></i> <span class="caret"></span></button></div>');
            var $columns_ul = $('<ul class="dropdown-menu columns" role="menu"></ul>');
            $.each(self.options.columns, function(i, column) {
                if (column.field != 'selectItem') {
                    var _li = null;
                    if (typeof column.visible == "undefined" || column.visible == true) {
                        _li = $('<li role="menuitem"><label><input type="checkbox" checked="checked" data-field="' + column.field + '" value="' + column.field + '" > ' + column.title + '</label></li>');
                    } else {
                        _li = $('<li role="menuitem"><label><input type="checkbox" data-field="' + column.field + '" value="' + column.field + '" > ' + column.title + '</label></li>');
                        self.hiddenColumns.push(column.field);
                    }
                    $columns_ul.append(_li);
                }
            });
            $columns_div.append($columns_ul);
            $rightToolbar.append($columns_div);
            // 注册列选项事件
            self.registerColumnClickEvent();
        } else {
            $.each(self.options.columns, function(i, column) {
                if (column.field != 'selectItem') {
                    if (!(typeof column.visible == "undefined" || column.visible == true)) {
                        self.hiddenColumns.push(column.field);
                    }
                }
            });
        }
    };
    // 初始化隐藏列
    BootstrapTreeTable.prototype.initHiddenColumns = function() {
        var self = this;
        $.each(self.hiddenColumns, function(i, field) {
            self.$el.find("." + field + "_cls").hide();
        });
    };
    // 初始化表头
    BootstrapTreeTable.prototype.initHeader = function() {
        var self = this;
        var $thr = $('<tr></tr>');
        $.each(self.options.columns, function(i, column) {
            var $th = null;
            // 判断有没有选择列
            if (i == 0 && column.field == 'selectItem') {
                self.hasSelectItem = true;
                $th = $('<th style="width:36px"></th>');
            } else {
                $th = $('<th style="' + ((column.width) ? ('width:' + column.width) : '') + '" class="' + column.field + '_cls"></th>');
            }
            if ((!self.isFixWidth) && column.width) {
                self.isFixWidth = column.width.indexOf("px") > -1 ? true : false;
            }
            $th.text(column.title);
            $thr.append($th);
        });
        var $thead = $('<thead class="treetable-thead"></thead>');
        $thead.append($thr);
        self.$el.append($thead);
    };
    // 初始化表体
    BootstrapTreeTable.prototype.initBody = function() {
        var self = this;
        var $tbody = $('<tbody class="treetable-tbody"></tbody>');
        self.$el.append($tbody);
        // 默认高度
        if (self.options.height) {
            $tbody.css("height", self.options.height);
        }
    };
    // 初始化数据服务
    BootstrapTreeTable.prototype.initServer = function(parms) {
        var self = this;
        // 加载数据前先清空
        self.data_list = {};
        self.data_obj = {};
        var $tbody = self.$el.find("tbody");
        // 添加加载loading
        var $loading = '<tr><td colspan="' + self.options.columns.length + '"><div style="display: block;text-align: center;">正在努力地加载数据中，请稍候……</div></td></tr>'
        $tbody.html($loading);
        if (self.options.url) {
            $.ajax({
                type: self.options.type,
                url: self.options.url,
                data: parms ? parms : self.options.ajaxParams,
                dataType: "JSON",
                success: function(data, textStatus, jqXHR) {
                    self.renderTable(data);
                    self.trigger('load-success', data);
                },
                error: function(res, textStatus) {
                    var _errorMsg = '<tr><td colspan="' + self.options.columns.length + '"><div style="display: block;text-align: center;">' + xhr.responseText + '</div></td></tr>'
                    $tbody.html(_errorMsg);
                    self.trigger('load-error', textStatus, res);
                },
            });
        } else {
            if(self.options.data){
                self.renderTable(self.options.data);
                self.trigger('load-success', self.options.data);
            }else{
                self.trigger('load-error');
            }
        }
    };
    // 加载完数据后渲染表格
    BootstrapTreeTable.prototype.renderTable = function(data) {
        var self = this;
        var $tbody = self.$el.find("tbody");
        // 先清空
        $tbody.html("");
        if (!data || data.length <= 0) {
            var _empty = '<tr><td colspan="' + self.options.columns.length + '"><div style="display: block;text-align: center;">没有找到匹配的记录</div></td></tr>'
            $tbody.html(_empty);
            return;
        }
        // 缓存并格式化数据
        self.formatData(data);
        // 获取所有根节点
        var rootNode = self.data_list["_root_"];
        // 开始绘制
        if (rootNode) {
            $.each(rootNode, function(i, item) {
                var _child_row_id = "row_id_" + i
                self.recursionNode(item, 1, _child_row_id, "row_root");
            });
        }
        // 下边的操作主要是为了查询时让一些没有根节点的节点显示
        $.each(data, function(i, item) {
            if (!item.isShow) {
                var tr = renderRow(item, false, 1, "", "");
                $tbody.append(tr);
            }
        });
        self.$el.append($tbody);
        self.registerExpanderEvent();
        self.registerRowClickEvent();
        self.initHiddenColumns();
        // 动态设置表头宽度
        self.autoTheadWidth()
    };
    // 动态设置表头宽度
    BootstrapTreeTable.prototype.autoTheadWidth = function(initFlag) {
        var self = this;
        if (self.options.height > 0) {
            var $thead = self.$el.find("thead");
            var $tbody = self.$el.find("tbody");
            var borderWidth = parseInt(self.$el.css("border-left-width")) + parseInt(self.$el.css("border-right-width"))

            $thead.css("width", $tbody.children(":first").width());
            if (initFlag) {
                var resizeWaiter = false;
                $(window).resize(function() {
                    if (!resizeWaiter) {
                        resizeWaiter = true;
                        setTimeout(function() {
                            if (!self.isFixWidth) {
                                $tbody.css("width", self.$el.parent().width() - borderWidth);
                            }
                            $thead.css("width", $tbody.children(":first").width());
                            resizeWaiter = false;
                        }, 300);
                    }
                });
            }
        }

    };
    // 缓存并格式化数据
    BootstrapTreeTable.prototype.formatData = function(data) {
        var self = this;
        var _root = self.options.rootIdValue ? self.options.rootIdValue : null
        $.each(data, function(index, item) {
            // 添加一个默认属性，用来判断当前节点有没有被显示
            item.isShow = false;
            // 这里兼容几种常见Root节点写法
            // 默认的几种判断
            var _defaultRootFlag = item[self.options.parentId] == '0' ||
                item[self.options.parentId] == 0 ||
                item[self.options.parentId] == null ||
                item[self.options.parentId] == '';
            if (!item[self.options.parentId] || (_root ? (item[self.options.parentId] == self.options.rootIdValue) : _defaultRootFlag)) {
                if (!self.data_list["_root_"]) {
                    self.data_list["_root_"] = [];
                }
                if (!self.data_obj["id_" + item[self.options.id]]) {
                    self.data_list["_root_"].push(item);
                }
            } else {
                if (!self.data_list["_n_" + item[self.options.parentId]]) {
                    self.data_list["_n_" + item[self.options.parentId]] = [];
                }
                if (!self.data_obj["id_" + item[self.options.id]]) {
                    self.data_list["_n_" + item[self.options.parentId]].push(item);
                }
            }
            self.data_obj["id_" + item[self.options.id]] = item;
        });
    };
    // 递归获取子节点并且设置子节点
    BootstrapTreeTable.prototype.recursionNode = function(parentNode, lv, row_id, p_id) {
        var self = this;
        var $tbody = self.$el.find("tbody");
        var _ls = self.data_list["_n_" + parentNode[self.options.id]];
        var $tr = self.renderRow(parentNode, _ls ? true : false, lv, row_id, p_id);
        $tbody.append($tr);
        if (_ls) {
            $.each(_ls, function(i, item) {
                var _child_row_id = row_id + "_" + i
                self.recursionNode(item, (lv + 1), _child_row_id, row_id)
            });
        }
    };
    // 绘制行
    BootstrapTreeTable.prototype.renderRow = function(item, isP, lv, row_id, p_id) {
        var self = this;
        // 标记已显示
        item.isShow = true;
        item.row_id = row_id;
        item.p_id = p_id;
        item.lv = lv;
        var $tr = $('<tr id="' + row_id + '" pid="' + p_id + '"></tr>');
        var _icon = self.options.expanderCollapsedClass;
        if (self.options.expandAll) {
            $tr.css("display", "table");
            _icon = self.options.expanderExpandedClass;
        } else if (lv == 1) {
            $tr.css("display", "table");
            _icon = (self.options.expandFirst) ? self.options.expanderExpandedClass : self.options.expanderCollapsedClass;
        } else if (lv == 2) {
            if (self.options.expandFirst) {
                $tr.css("display", "table");
            } else {
                $tr.css("display", "none");
            }
            _icon = self.options.expanderCollapsedClass;
        } else {
            $tr.css("display", "none");
            _icon = self.options.expanderCollapsedClass;
        }
        $.each(self.options.columns, function(index, column) {
            // 判断有没有选择列
            if (column.field == 'selectItem') {
                self.hasSelectItem = true;
                var $td = $('<td style="text-align:center;width:36px"></td>');
                if (column.radio) {
                    var $ipt = $('<input name="select_item" type="radio" value="' + item[self.options.id] + '"></input>');
                    $td.append($ipt);
                }
                if (column.checkbox) {
                    var $ipt = $('<input name="select_item" type="checkbox" value="' + item[self.options.id] + '"></input>');
                    $td.append($ipt);
                }
                $tr.append($td);
            } else {
                var $td = $('<td name="' + column.field + '" class="' + column.field + '_cls"></td>');
                if (column.width) {
                    $td.css("width", column.width);
                }
                if (column.align) {
                    $td.css("text-align", column.align);
                }
                if (self.options.expandColumn == index) {
                    $td.css("text-align", "left");
                }
                if (column.valign) {
                    $td.css("vertical-align", column.valign);
                }
                if (self.options.showTitle) {
                    $td.addClass("ellipsis");
                }
                // 增加formatter渲染
                if (column.formatter) {
                    $td.html(column.formatter.call(self, item[column.field], item, index));
                } else {
                    if (self.options.showTitle) {
                        // 只在字段没有formatter时才添加title属性
                        $td.attr("title", item[column.field]);
                    }
                    $td.text(item[column.field]);
                }
                if (self.options.expandColumn == index) {
                    if (!isP) {
                        $td.prepend('<span class="treetable-expander"></span>')
                    } else {
                        $td.prepend('<span class="treetable-expander ' + _icon + '"></span>')
                    }
                    for (var int = 0; int < (lv - 1); int++) {
                        $td.prepend('<span class="treetable-indent"></span>')
                    }
                }
                $tr.append($td);
            }
        });
        return $tr;
    };
    // 注册刷新按钮点击事件
    BootstrapTreeTable.prototype.registerRefreshBtnClickEvent = function(btn) {
        var self = this;
        $(btn).off('click').on('click', function() {
            self.refresh();
        });
    };
    // 注册列选项事件
    BootstrapTreeTable.prototype.registerColumnClickEvent = function() {
        var self = this;
        $(".bootstrap-tree-table .treetable-bars .columns label input").off('click').on('click', function() {
            var $this = $(this);
            if ($this.prop('checked')) {
                self.showColumn($(this).val());
            } else {
                self.hideColumn($(this).val());
            }
        });
    };
    // 注册行点击事件
    BootstrapTreeTable.prototype.registerRowClickEvent = function() {
        var self = this;
        self.$el.find("tbody").find("tr").find("td").off('click dblclick').on('click dblclick', function(e) {
            var $td = $(this),
                $tr = $td.parent(),
                $ipt = $tr.find("input[name='select_item']"),
                item = self.data_obj["id_" + $ipt.val()],
                field = $td.attr("name"),
                value = item[field];
            self.trigger(e.type === 'click' ? 'click-cell' : 'dbl-click-cell', field, value, item, $td);
            self.trigger(e.type === 'click' ? 'click-row' : 'dbl-click-row', item, $tr, field);
            if (self.hasSelectItem) {
                if ($ipt.attr("type") == "radio") {
                    $ipt.prop('checked', true);
                    self.$el.find("tbody").find("tr").removeClass("treetable-selected");
                    $(this).addClass("treetable-selected");
                } else {
                    if ($ipt.prop('checked')) {
                        $ipt.prop('checked', false);
                        $(this).removeClass("treetable-selected");
                    } else {
                        $ipt.prop('checked', true);
                        $(this).addClass("treetable-selected");
                    }
                }
            }
        });
    };
    // 注册小图标点击事件--展开缩起
    BootstrapTreeTable.prototype.registerExpanderEvent = function() {
        var self = this;
        self.$el.find("tbody").find("tr").find(".treetable-expander").off('click').on('click', function() {
            var _isExpanded = $(this).hasClass(self.options.expanderExpandedClass);
            var _isCollapsed = $(this).hasClass(self.options.expanderCollapsedClass);
            if (_isExpanded || _isCollapsed) {
                var tr = $(this).parent().parent();
                var row_id = tr.attr("id");
                var _ls = self.$el.find("tbody").find("tr[id^='" + row_id + "_']"); //下所有
                if (_isExpanded) {
                    $(this).removeClass(self.options.expanderExpandedClass);
                    $(this).addClass(self.options.expanderCollapsedClass);
                    if (_ls && _ls.length > 0) {
                        $.each(_ls, function(index, item) {
                            $(item).css("display", "none");
                        });
                    }
                } else {
                    $(this).removeClass(self.options.expanderCollapsedClass);
                    $(this).addClass(self.options.expanderExpandedClass);
                    if (_ls && _ls.length > 0) {
                        $.each(_ls, function(index, item) {
                            // 父icon
                            var _p_icon = $("#" + $(item).attr("pid")).children().eq(self.options.expandColumn).find(".treetable-expander");
                            if (_p_icon.hasClass(self.options.expanderExpandedClass)) {
                                $(item).css("display", "table");
                            }
                        });
                    }
                }
            }
        });
    };
    // 刷新数据
    BootstrapTreeTable.prototype.refresh = function(parms) {
        var self = this;
        if (parms) {
            self.lastAjaxParams = parms;
        }
        self.initServer(self.lastAjaxParams);
    };
    // 添加数据刷新表格
    BootstrapTreeTable.prototype.appendData = function(data) {
        var self = this;
        // 下边的操作主要是为了查询时让一些没有根节点的节点显示
        $.each(data, function(i, item) {
            var _data = self.data_obj["id_" + item[self.options.id]];
            var _p_data = self.data_obj["id_" + item[self.options.parentId]];
            var _c_list = self.data_list["_n_" + item[self.options.parentId]];
            var row_id = ""; //行id
            var p_id = ""; //父行id
            var _lv = 1; //如果没有父就是1默认显示
            var tr; //要添加行的对象
            if (_data && _data.row_id && _data.row_id != "") {
                row_id = _data.row_id; // 如果已经存在了，就直接引用原来的
            }
            if (_p_data) {
                p_id = _p_data.row_id;
                if (row_id == "") {
                    var _tmp = 0
                    if (_c_list && _c_list.length > 0) {
                        _tmp = _c_list.length;
                    }
                    row_id = _p_data.row_id + "_" + _tmp;
                }
                _lv = _p_data.lv + 1; //如果有父
                // 绘制行
                tr = self.renderRow(item, false, _lv, row_id, p_id);

                var _p_icon = $("#" + _p_data.row_id).children().eq(self.options.expandColumn).find(".treetable-expander");
                var _isExpanded = _p_icon.hasClass(self.options.expanderExpandedClass);
                var _isCollapsed = _p_icon.hasClass(self.options.expanderCollapsedClass);
                // 父节点有没有展开收缩按钮
                if (_isExpanded || _isCollapsed) {
                    // 父节点展开状态显示新加行
                    if (_isExpanded) {
                        tr.css("display", "table");
                    }
                } else {
                    // 父节点没有展开收缩按钮则添加
                    _p_icon.addClass(self.options.expanderCollapsedClass);
                }

                if (_data) {
                    $("#" + _data.row_id).before(tr);
                    $("#" + _data.row_id).remove();
                } else {
                    // 计算父的同级下一行
                    var _tmp_ls = _p_data.row_id.split("_");
                    var _p_next = _p_data.row_id.substring(0, _p_data.row_id.length - 1) + (parseInt(_tmp_ls[_tmp_ls.length - 1]) + 1);
                    // 画上
                    $("#" + _p_next).before(tr);
                }
            } else {
                tr = self.renderRow(item, false, _lv, row_id, p_id);
                if (_data) {
                    $("#" + _data.row_id).before(tr);
                    $("#" + _data.row_id).remove();
                } else {
                    // 画上
                    var tbody = self.$el.find("tbody");
                    tbody.append(tr);
                }
            }
            item.isShow = true;
            // 缓存并格式化数据
            self.formatData([item]);
        });
        self.registerExpanderEvent();
        self.registerRowClickEvent();
        self.initHiddenColumns();
    };
    // 展开/折叠指定的行
    BootstrapTreeTable.prototype.toggleRow = function(id) {
        var self = this;
        var _rowData = self.data_obj["id_" + id];
        var $row_expander = $("#" + _rowData.row_id).find(".treetable-expander");
        $row_expander.trigger("click");
    };
    // 展开指定的行
    BootstrapTreeTable.prototype.expandRow = function(id) {
        var self = this;
        var _rowData = self.data_obj["id_" + id];
        var $row_expander = $("#" + _rowData.row_id).find(".treetable-expander");
        var _isCollapsed = $row_expander.hasClass(self.$el.options.expanderCollapsedClass);
        if (_isCollapsed) {
            $row_expander.trigger("click");
        }
    };
    // 折叠 指定的行
    BootstrapTreeTable.prototype.collapseRow = function(id) {
        var self = this;
        var _rowData = self.data_obj["id_" + id];
        var $row_expander = $("#" + _rowData.row_id).find(".treetable-expander");
        var _isExpanded = $row_expander.hasClass(self.$el.options.expanderExpandedClass);
        if (_isExpanded) {
            $row_expander.trigger("click");
        }
    };
    // 展开所有的行
    BootstrapTreeTable.prototype.expandAll = function() {
        var self = this;
        self.$el.find("tbody").find("tr").find(".treetable-expander").each(function(i, n) {
            var _isCollapsed = $(n).hasClass(self.options.expanderCollapsedClass);
            if (_isCollapsed) {
                $(n).trigger("click");
            }
        })
    };
    // 折叠所有的行
    BootstrapTreeTable.prototype.collapseAll = function() {
        var self = this;
        self.$el.find("tbody").find("tr").find(".treetable-expander").each(function(i, n) {
            var _isExpanded = $(n).hasClass(self.options.expanderExpandedClass);
            if (_isExpanded) {
                $(n).trigger("click");
            }
        })
    };
    // 显示指定列
    BootstrapTreeTable.prototype.showColumn = function(field, flag) {
        var self = this;
        var _index = $.inArray(field, self.hiddenColumns);
        if (_index > -1) {
            self.hiddenColumns.splice(_index, 1);
        }
        self.$el.find("." + field + "_cls").show();
        //是否更新列选项状态
        if (flag && self.options.showColumns) {
            var $input = $(".bootstrap-tree-table .treetable-bars .columns label").find("input[value='" + field + "']")
            $input.prop("checked", 'checked');
        }
    };
    // 隐藏指定列
    BootstrapTreeTable.prototype.hideColumn = function(field) {
        var self = this;
        self.hiddenColumns.push(field);
        self.$el.find("." + field + "_cls").hide();
        //是否更新列选项状态
        if (self.options.showColumns) {
            var $input = $(".bootstrap-tree-table .treetable-bars .columns label").find("input[value='" + field + "']")
            $input.prop("checked", '');
        }
    };
    // 获取已选行
    BootstrapTreeTable.prototype.getSelections = function() {
        var self = this;
        // 所有被选中的记录input
        var $ipt = self.$el.find("tbody").find("tr").find("input[name='select_item']:checked");
        var chk_value = [];
        // 如果是radio
        if ($ipt.attr("type") == "radio") {
            var _data = self.data_obj["id_" + $ipt.val()];
            chk_value.push(_data);
        } else {
            $ipt.each(function(_i, _item) {
                var _data = self.data_obj["id_" + $(_item).val()];
                chk_value.push(_data);
            });
        }
        return chk_value;
    };
    // 触发事件
    BootstrapTreeTable.prototype.trigger = function(name) {
        var self = this;
        var args = Array.prototype.slice.call(arguments, 1);

        name += '.bs.tree.table';
        self.options[BootstrapTreeTable.EVENTS[name]].apply(self.options, args);
        self.$el.trigger($.Event(name), args);

        self.options.onAll(name, args);
        self.$el.trigger($.Event('all.bs.tree.table'), [name, args]);
    };
    // 销毁
    BootstrapTreeTable.prototype.destroy = function() {
        var self = this;
        var $container = self.$el.parent().parent();
        self.$el.insertBefore($container);
        $(self.options.toolbar).insertBefore(self.$el);
        $container.remove();
        this.$el.html(this.$el_.html());
    };

    // 组件方法
    BootstrapTreeTable.METHODS = [
        "getSelections",
        "refresh",
        "appendData",
        "toggleRow",
        "expandRow",
        "collapseRow",
        "expandAll",
        "collapseAll",
        "showColumn",
        "hideColumn",
        "destroy"
    ];

    // 组件事件
    BootstrapTreeTable.EVENTS = {
        'all.bs.tree.table': 'onAll',
        'click-cell.bs.tree.table': 'onClickCell',
        'dbl-click-cell.bs.tree.table': 'onDblClickCell',
        'click-row.bs.tree.table': 'onClickRow',
        'dbl-click-row.bs.tree.table': 'onDblClickRow',
        'load-success.bs.tree.table': 'onLoadSuccess',
        'load-error.bs.tree.table': 'onLoadError'
    };
    // 默认配置
    BootstrapTreeTable.DEFAULTS = {
        id: 'id', // 选取记录返回的值,用于设置父子关系
        parentId: 'parentId', // 用于设置父子关系
        rootIdValue: null, // 设置根节点id值----可指定根节点，默认为null,"",0,"0"
        data: null, // 构造table的数据集合
        type: "GET", // 请求数据的ajax类型
        url: null, // 请求数据的ajax的url
        ajaxParams: {}, // 请求数据的ajax的data属性
        expandColumn: 0, // 在哪一列上面显示展开按钮
        expandAll: false, // 是否全部展开
        expandFirst: true, // 是否默认第一级展开--expandAll为false时生效
        striped: false, // 是否各行渐变色
        bordered: true, // 是否显示边框
        hover: true, // 是否鼠标悬停
        condensed: false, // 是否紧缩表格
        columns: [], // 列
        toolbar: null, // 顶部工具条
        height: 0, // 表格高度
        showTitle: true, // 是否采用title属性显示字段内容（被formatter格式化的字段不会显示）
        showColumns: true, // 是否显示内容列下拉框
        showRefresh: true, // 是否显示刷新按钮
        expanderExpandedClass: 'glyphicon glyphicon-chevron-down', // 展开的按钮的图标
        expanderCollapsedClass: 'glyphicon glyphicon-chevron-right', // 缩起的按钮的图标
        onAll: function(data) {
            return false;
        },
        onLoadSuccess: function(data) {
            return false;
        },
        onLoadError: function(status) {
            return false;
        },
        onClickCell: function(field, value, row, $element) {
            return false;
        },
        onDblClickCell: function(field, value, row, $element) {
            console.log(field)
            console.log(value)
            console.log(row)
            console.log($element)
            return false;
        },
        onClickRow: function(row, $element) {
            return false;
        },
        onDblClickRow: function(row, $element) {
            return false;
        }
    };

    $.fn.bootstrapTreeTable = function(option) {
        var value,
            args = Array.prototype.slice.call(arguments, 1);
        this.each(function() {
            var $this = $(this),
                data = $this.data('bootstrap.tree.table'),
                options = $.extend({}, BootstrapTreeTable.DEFAULTS, $this.data(),
                    typeof option === 'object' && option);
            if (typeof option === 'string') {
                if ($.inArray(option, BootstrapTreeTable.METHODS) < 0) {
                    throw new Error("Unknown method: " + option);
                }
                if (!data) {
                    return;
                }
                value = data[option].apply(data, args);
                if (option === 'destroy') {
                    $this.removeData('bootstrap.tree.table');
                }
            }
            if (!data) {
                $this.data('bootstrap.tree.table', (data = new BootstrapTreeTable(this, options)));
            }
        });
        return typeof value === 'undefined' ? this : value;
    };
})(jQuery);