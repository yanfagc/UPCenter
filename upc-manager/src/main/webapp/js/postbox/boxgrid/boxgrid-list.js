var datatable;
$(function() {
    // 定义操作变量
    var $gridCode=$('#gridCode');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/postbox/boxgrid/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"gridCode",
                    "value":$gridCode.val()
                });
            },
            aoColumns:[
                {
                    mData:"boxInfoId",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"gridCode",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"status",
                    mRender:function(data, display, record) {
                        if(data=='NOACTIVE'){
                            return '未激活';
                        }else if(data=='NORMAL'){
                            return '<label style="color:green">正常</label>';
                        }else if(data=='REPAIR'){
                            return '<label style="color:red">维修</label>';
                        }else if(data=='DEMISE'){
                            return '<label style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"expressStatus",
                    mRender:function(data, display, record) {
                        if(data=='EMPTY'){
                            return '未存放快递';
                        }else if(data=='FULL'){
                            return '已存放快递';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"gridSize",
                    mRender:function(data, display, record) {
                        if(data=='MEDIUM'){
                            return '中型';
                        }else if(data=='SMALL'){
                            return '小型';
                        }else if(data=='LARGE'){
                            return '大型';
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
                    mData:"proxyCustomerInfoId",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"opentime",
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
                        if(record.status=='NOACTIVE'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toActive" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;激活&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }else if(record.status=='NORMAL'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs toRepair" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;维修&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }else if(record.status=='DEMISE'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNoActive" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-warning btn-xs" fid="'+record.boxGridId+'" style="visibility:hidden">&nbsp;隐藏&nbsp;</a>';
                        }else if(record.status=='REPAIR'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.boxGridId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }
                        return html;
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 新增快递格子数据
    $('.add-btn').click(function() {
        var boxInfoId=$('input[name="boxInfoId"]').val();
        openWindow($ctx+'/postbox/boxgrid/toEdit?boxInfoId='+boxInfoId,750,420);
    });

    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        var boxInfoId=$('input[name="boxInfoId"]').val();
        openWindow($ctx+'/postbox/boxgrid/toEdit?id='+id+'&boxInfoId='+boxInfoId,750,420);
    });
    // 激活
    $('tbody').on("click", '.toActive',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行激活操作吗？",function() {
            statusChange(id,'NORMAL');
        },true);
    });
    // 注销
    $('tbody').on("click", '.toDemise',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行注销操作吗？",function() {
            statusChange(id,'DEMISE');
        },true);
    });
    // 恢复为未激活
    $('tbody').on("click",'.toNoActive',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行恢复操作吗？该操作会恢复至未激活状态",function() {
            statusChange(id,'NOACTIVE');
        },true);
    });
    // 恢复为激活
    $('tbody').on("click",'.toNormal',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行恢复操作吗？该操作会恢复至激活状态",function() {
            statusChange(id,'NORMAL');
        },true);
    });
    // 维修
    $('tbody').on("click",'.toRepair',function() {
        var id=$(this).attr("fid");
        showTipsDialog("提示信息","确定执行维修操作吗？",function() {
            statusChange(id,'FROZEN');
        },true);
    });
    // 状态变更
    function statusChange(id, toStatus) {
        $sessionAjax({
            url:$ctx+'/postbox/boxgrid/updateStatus',
            data:{'boxGridId':id,'status':toStatus},
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
