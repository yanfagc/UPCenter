var datatable;
$(function() {
    // 定义操作变量
    var $realname=$('#realname'),$mobilePhone=$('#mobilePhone'),$status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/postbox/repairer/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"realname",
                    "value":$realname.val()
                });
                aodata.push({
                    "name":"mobilePhone",
                    "value":$mobilePhone.val()
                });
                aodata.push({
                    "name":"status",
                    "value":$status.val()
                });
            },
            aoColumns:[
                {
                    mData:"realname"
                },
                {
                    mData:"mobilePhone",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"province",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"city",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"status",
                    mRender:function(data, display, record) {
                        if(data=='NORMAL'){
                            return '<label style="color:green">正常</label>';
                        }else if(data=='FROZEN'){
                            return '<label style="color:red">冻结</label>';
                        }else if(data=='DEMISE'){
                            return '<label style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"createtime",
                    mRender:function(data, display, record) {
                        return data?formatDatetime(data):'';
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                        var html="";
                        if(record.status=='NORMAL'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs toFrozen" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;冻结&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }else if(record.status=='DEMISE'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs" fid="'+record.repairerInfoid+'" style="visibility:hidden">&nbsp;隐藏&nbsp;</a>';
                        }else if(record.status=='FROZEN'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.repairerInfoid+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }
                        return html;
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 新增维修员信息
    $('.add-btn').click(function() {
        openWindow($ctx+'/postbox/repairer/toEdit',750,350);
    });
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/postbox/repairer/toEdit?id='+id,750,350);
    });
    // 注销
    $('tbody').on("click", '.toDemise',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行注销操作吗？",function() {
            statusChange(id,'DEMISE');
        },true);
    });
    // 恢复
    $('tbody').on("click",'.toNormal',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行恢复操作吗？",function() {
            statusChange(id,'NORMAL');
        },true);
    });
    // 冻结
    $('tbody').on("click",'.toFrozen',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行冻结操作吗？",function() {
            statusChange(id,'FROZEN');
        },true);
    });
    // 状态变更
    function statusChange(id, toStatus) {
        $sessionAjax({
            url:$ctx+'/postbox/repairer/updateStatus',
            data:{'repairerInfoid':id,'status':toStatus},
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
