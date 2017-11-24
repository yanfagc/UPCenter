var datatable;
$(function() {
    // 定义操作变量
    var $searchkey=$('#searchkey'), $status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/area/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"searchkey",
                    "value":$searchkey.val()
                });
                aodata.push({
                    "name":"status",
                    "value":$status.val()
                });
            },
            aoColumns:[
                {
                    mData:"id",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"node",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"name",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"spell",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"parentName",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"status",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='N'){
                            return '<lable style="color:green">正常</label>';
                        }else if(data=='C'){
                            return '<lable style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 新增表单信息
    $('.add-btn').click(function() {
        openWindow($ctx+'/basic/dictdata/toEdit',750,400);
    });
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/basic/dictdata/toEdit?id='+id,750,400);
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
            url:$ctx+'/basic/dictdata/updateStatus',
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
