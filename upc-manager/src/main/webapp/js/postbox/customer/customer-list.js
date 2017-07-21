var datatable;
$(function() {
    // 定义操作变量
    var $realName=$('#realName'),$mobilePhone=$('#mobilePhone'),$status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/postbox/customer/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"realName",
                    "value":$realName.val()
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
                    mData:"realname",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"sex",
                    mRender:function(data, display, record) {
                        if(data=='MALE'){
                            return '男';
                        }else if(data=='FEMALE'){
                            return '女';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"mobilePhone",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:null,
                    mRender:function(data, display, record) {
                        var addr=record.province?record.province:'';
                        addr+=record.city?' '+record.city:'';
                        return addr;
                    }
                },
                {
                    mData:"status",
                    mRender:function(data, display, record) {
                        if(data=='NORMAL'){
                            return '<lable style="color:green">正常</label>';
                        }else if(data=='FROZEN'){
                            return '<lable style="color:red">冻结</label>';
                        }else if(data=='DEMISE'){
                            return '<lable style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"registerTime",
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
                            html+='<a class="btn btn-primary btn-xs toView" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;详情&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs toFrozen" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;冻结&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }else if(record.status=='DEMISE'){
                            html+='<a class="btn btn-primary btn-xs toView" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;详情&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs" fid="'+record.customerInfoId+'" style="visibility:hidden">&nbsp;隐藏&nbsp;</a>';
                        }else if(record.status=='FROZEN'){
                            html+='<a class="btn btn-primary btn-xs toView" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;详情&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.customerInfoId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }
                        return html;
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 查询详情
    $('tbody').on("click", '.toView', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/postbox/customer/viewDetail?id='+id,750,350);
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
            url:$ctx+'/postbox/customer/updateStatus',
            data:{'customerInfoId':id,'status':toStatus},
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
