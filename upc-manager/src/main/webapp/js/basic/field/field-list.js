var datatable;
$(function() {
    // 定义操作变量
    var $fieldcode=$('#fieldcode'), $fieldname=$('#fieldname'), $fieldtype=$('#fieldtype');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/field/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"fieldcode",
                    "value":$fieldcode.val()
                });
                aodata.push({
                    "name":"fieldname",
                    "value":$fieldname.val()
                });
                aodata.push({
                    "name":"fieldtype",
                    "value":$fieldtype.val()
                });
            },
            aoColumns:[
                {
                    mData:"fieldcode"
                },
                {
                    mData:"fieldname"
                },
                {
                    mData:"fieldtype",
                    mRender:function(data, display, record) {
                        if(data=='INPUT'){
                            return '单行文本';
                        }else if(data=='TEXTAREA'){
                            return '多行文本';
                        }else if(data=='SELECT'){
                            return '选择框';
                        }else if(data=='CHECKBOX'){
                            return '复选框';
                        }else if(data=='RADIO'){
                            return '单选框';
                        }else if(data=='MACROS'){
                            return '宏控件';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"macrotype",
                    mRender:function(data, display, record) {
                        if(data=='TEXT'){
                            return '普通文本';
                        }else if(data=='INT'){
                            return '整形数值';
                        }else if(data=='FLOAT'){
                            return '浮点数值';
                        }else if(data=='EMAIL'){
                            return '邮箱Email';
                        }else if(data=='DATE'){
                            return '日期格式(yyyy-MM-dd)';
                        }else if(data=='TIME'){
                            return '时间格式(HH:mm:ss)';
                        }else if(data=='DATETIME'){
                            return '日期时间(yyyy-MM-dd HH:mm:ss)';
                        }else if(data=='FILE'){
                            return '普通文件';
                        }else if(data=='IMAGE'){
                            return '图片格式';
                        }else if(data=='ONEHR'){
                            return '人力资源[单选]';
                        }else if(data=='MOREHR'){
                            return '人力资源[多选]';
                        }
                        return (data==0||data)?data:'--';
                    }
                },
                {
                    mData:"defaultvalue",
                    mRender:function(data, display, record) {
                        if(record.macrotype=='macros'){//宏控件
                            if(data=='current'){
                                return '当前值';
                            }
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"colspan"
                },
                {
                    mData:"status",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='N'){
                            return '<lable style="color:green">正常</label>';
                        }else if(data=='F'){
                            return '<lable style="color:red">冻结</label>';
                        }else if(data=='D'){
                            return '<lable style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                    	return '<a class="btn btn-primary btn-xs toEditRule" fid="'+record.id
                        	+'" href="javascript:void(0);">&nbsp;字段规则&nbsp;</a>';
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                        var html="";
                        if(record.status=='N'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs toFrozen" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;冻结&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }else if(record.status=='D'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs" fid="'+record.id
                                    +'" style="visibility:hidden">&nbsp;隐藏&nbsp;</a>';
                        }else if(record.status=='F'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.id
                                    +'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }
                        return html;
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 新增单行文本
    $('.add-input').click(function() {
    	openWindow($ctx+'/basic/field/toAdd?type=INPUT');
    });
    // 新增多行文本
    $('.add-textarea').click(function() {
    	openWindow($ctx+'/basic/field/toAdd?type=TEXTAREA');
    });
    // 新增选择框
    $('.add-select').click(function() {
    	openWindow($ctx+'/basic/field/toAdd?type=SELECT');
    });
    // 新增复选框
    $('.add-checkbox').click(function() {
    	openWindow($ctx+'/basic/field/toAdd?type=CHECKBOX');
    });
    // 新增单选框
    $('.add-radio').click(function() {
    	openWindow($ctx+'/basic/field/toAdd?type=RADIO');
    });
    // 新增宏控件
    $('.add-macros').click(function() {
    	openWindow($ctx+'/basic/field/toAdd?type=MACROS');
    });
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/basic/field/toEdit?id='+id);
    });
	// 编辑字段规则
    $('tbody').on("click", '.toEditRule', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/basic/field/toEditRule?id='+id);
    });
    // 注销
    $('tbody').on("click", '.toDemise',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行注销操作吗？",function() {
            statusChange(id,'D');
        },true);
    });
    // 恢复
    $('tbody').on("click",'.toNormal',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行恢复操作吗？",function() {
            statusChange(id,'N');
        },true);
    });
    // 冻结
    $('tbody').on("click",'.toFrozen',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行冻结操作吗？",function() {
            statusChange(id,'F');
        },true);
    });
    // 状态变更
    function statusChange(id, toStatus) {
        $sessionAjax({
            url:$ctx+'/basic/field/updateStatus',
            data:{'id':id,'status':toStatus},
            success:function(rsp){
                if(rsp.code=='1000'){
                    search();
                }else{
                    var msg=rsp.msg?rsp.msg:"状态变更失败，请联系管理员或稍后再试！";
                    showTipsDialog("错误信息",msg,true);
                }
            }
        });
    }
});
function search() {
    datatable.fnClearTable(0);
    datatable.fnDraw();
}
