var datatable;
$(function() {
    // 定义操作变量
    var $searchkey=$('#searchkey'), $valuetype=$('#valuetype'), $status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/dicttype/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"searchkey",
                    "value":$searchkey.val()
                });
                aodata.push({
                    "name":"valuetype",
                    "value":$valuetype.val()
                });
                aodata.push({
                    "name":"status",
                    "value":$status.val()
                });
            },
            aoColumns:[
                {
                    mData:"typecode"
                },
                {
                    mData:"typename"
                },
                {
                    mData:"valuetype",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='N'){
                            return '无数据';
                        }else if(data=='B'){
                            return '布尔数据';
                        }else if(data=='T'){
                            return '文本数据';
                        }else if(data=='I'){
                            return '整型数据';
                        }else if(data=='F'){
                            return '浮点型数据';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"status",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='N'){
                            return '<label style="color:green">正常</label>';
                        }else if(data=='F'){
                            return '<label style="color:red">冻结</label>';
                        }else if(data=='D'){
                            return '<label style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"remark",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"createtime",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return formatDatetime(data);
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
    // 新增表单信息
    $('.add-btn').click(function() {
        openWindow($ctx+'/basic/dicttype/toEdit', 750, 350);
    });
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/basic/dicttype/toEdit?id='+id, 750, 350);
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
            url:$ctx+'/basic/dicttype/updateStatus',
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
