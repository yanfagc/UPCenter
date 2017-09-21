var datatable;
$(function() {
    // 定义操作变量
    var $prepayInfoId=$('#prepayInfoId'), $payInfoId=$('#payInfoId'),$appId=$('#appId'), $channel=$('#channel'),$payChannelOrderId=$('#payChannelOrderId');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/pay/payInfo/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"prepayInfoId",
                    "value":$prepayInfoId.val()
                });
                aodata.push({
                    "name":"payInfoId",
                    "value":$payInfoId.val()
                });
                aodata.push({
                    "name":"appId",
                    "value":$appId.val()
                });
                aodata.push({
                    "name":"channel",
                    "value":$channel.val()
                });
                aodata.push({
                    "name":"payChannelOrderId",
                    "value":$payChannelOrderId.val()
                });
            },
            aoColumns:[
                {
                    mData:"prepayInfoId"
                },{
                    mData:"appId"
                },{
                    mData:"amount",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return data/100;
                    }
                },{
                    mData:"payInfoId"
                },{
                    mData:"channel",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='wx'){
                            return '<lable style="color:green">微信</label>';
                        }else if(data=='ali'){
                            return '<lable style="color:dodgerblue">支付宝</label>';
                        }else if(data=='jd'){
                            return '<lable style="color:red;">京东支付</label>';
                        }else if(data=='union'){
                            return '<lable style="color:gray;">银联</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },{
                    mData:"payChannelOrderId"
                },{
                    mData:"createTime",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                    }
                },{
                    mData:"paySuccessTime",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                    }
                },{
                    mData:null,
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return '<a class="btn btn-primary btn-xs toViewDetails" payChannelOrderId="'+record.payChannelOrderId
                            +'" channel="'+record.channel+'" href="javascript:void(0);">&nbsp;渠道订单详情&nbsp;</a>&nbsp;';
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 导出订单列表
    $('.add-btn').click(function() {
        var channel=$("#channel").val();
        var payChannelOrderId=$("#payChannelOrderId").val();
        var prepayInfoId=$("#prepayInfoId").val();
        var payInfoId=$("#payInfoId").val();
        var appId=$("#appId").val();
        var iDisplayLength = 10;
        //openWindow($ctx+'/pay/payInfo/download?channel='+channel+'&payChannelOrderId='+payChannelOrderId+'&iDisplayLength='+iDisplayLength+'&$prepayInfoId='+prepayInfoId+'&appId='+appId+'&payInfoId='+payInfoId,750,350);
        window.location.href=$ctx+'/pay/payInfo/download?channel='+channel+'&payChannelOrderId='+payChannelOrderId+'&iDisplayLength='+iDisplayLength+'&prepayInfoId='+prepayInfoId+'&appId='+appId+'&payInfoId='+payInfoId;
    });
    
/*    // 角色菜单
    $('tbody').on("click", '.toSettingMenus', function(){
    	var roleid=$(this).attr("fid");
    	var sysid=$(this).attr("sysid");
    	openWindow($ctx+'/basic/role/toSettingMenus?roleid='+roleid+'&sysid='+sysid,550,480);
    });*/

    // 查看渠道订单详情
    $('tbody').on("click", '.toViewDetails', function(){
        var channel=$(this).attr("channel");
        var payChannelOrderId=$(this).attr("payChannelOrderId");
        openWindow($ctx+'/pay/payInfo/toViewDetail?channel='+channel+'&payChannelOrderId='+payChannelOrderId,850,480);
    });
    
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var appId=$(this).attr("fid");
        openWindow($ctx+'/pay/appInfo/toEdit?appId='+appId,750,350);
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
            url:$ctx+'/pay/appInfo/updateStatus',
            data:{'appId':id,'status':toStatus},
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

    var map = {"wx":"spcoi", "ali":"spcoi", "jd":"spcoi", "union":"spcoi", "":""};
    $("#channel").bind("change", function(){
        var divId = map[this.value];
        if (divId == ""){
            $("#spcoi").hide();
        }else {
            $("#"+divId).show();
        }
    });
});
function search() {
    datatable.fnClearTable(0);
    datatable.fnDraw();
}

Date.prototype.Format = function(fmt) {

    var o = {
        "M+": this.getMonth() + 1,
        //月份

        "d+": this.getDate(),
        //日

        "h+": this.getHours(),
        //小时

        "m+": this.getMinutes(),
        //分

        "s+": this.getSeconds(),
        //秒

        "q+": Math.floor((this.getMonth() + 3) / 3),
        //季度

        "S": this.getMilliseconds() //毫秒

    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}
