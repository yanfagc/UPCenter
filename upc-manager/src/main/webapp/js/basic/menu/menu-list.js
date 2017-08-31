var datatable;
$(function() {
    initZTree(zNodes);
    
    // 定义操作变量
    var $searchkey=$('#searchkey'),
        $urltype=$('#urltype'),
        $status=$('#status'),
        $systemid=$('input[name="systemid"]');
        $showtype=$('input[name="showtype"]');
        $parentid=$('input[name="parentid"]');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/menu/dataList",
            fnServerParams:function(aodata,b,c,d) {
                aodata.push({
                    "name":"searchkey",
                    "value":$searchkey.val()
                });
                aodata.push({
                    "name":"systemid",
                    "value":$systemid.val()
                });
                aodata.push({
                    "name":"status",
                    "value":$status.val()
                });
                aodata.push({
                    "name":"urltype",
                    "value":$urltype.val()
                });
                aodata.push({
                    "name":"parentid",
                    "value":$parentid.val()
                });
                aodata.push({
                    "name":"showtype",
                    "value":$showtype.val()
                });
            },
            aoColumns:[
                {
                    mData:"code"
                },
                {
                    mData:"name"
                },
                {
                    mData:"sort",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"urltype",
                    mRender:function(data, display, record) {
                        if(data=='M'){
                            return '菜单目录';
                        }else if(data=='R'){
                            return '内部地址';
                        }else if(data=='A'){
                            return '外部地址';
                        }else if(data=='RES'){
                            return '权限资源';
                        }
                        return data?'未知('+data+')':'未知(空)';
                    }
                },
                {
                    mData:"url",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"status",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='N'){
                            return '<lable style="color:green">正常</label>';
                        }else if(data=='D'){
                            return '<lable style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                        var html="";
                        if(record.status=='N'){
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.id+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.id+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        }else{
                            html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.id+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.id+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                        }
                        return html;
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 新增
    $('.add-menu-btn').click(function() {
        var parentid=$('input[name="parentid"]').val();
        var systemid=$('input[name="systemid"]').val();
        openWindow($ctx+'/basic/menu/toEdit?parentid='+parentid+'&systemid='+systemid,750,500);
    });
    // 新增
    $('.add-item-btn').click(function() {
        var parentid=$('input[name="parentid"]').val();
        openWindow($ctx+'/basic/menuitem/toEdit?menuid='+parentid,750,350);
    });
    // 切换显示
    $('.change-toMenu-btn').click(function() {
        if($('input[name="showtype"]').val()=='item'){
            $('input[name="showtype"]').val("menu");
            $('.change-toItem-btn').removeClass("btn-warning");
            $('.change-toMenu-btn').addClass("btn-warning");
            $('.add-menu-btn').removeAttr("disabled");
            $('.add-item-btn').attr("disabled","disabled");
            search();
        }
    });
    // 切换显示
    $('.change-toItem-btn').click(function() {
        if($('input[name="showtype"]').val()!='item'){
            var parentid=$('input[name="parentid"]').val();
            if(!parentid||parentid=='0'){
                return;
            }
            
            $('input[name="showtype"]').val("item");
            $('.change-toItem-btn').addClass("btn-warning");
            $('.change-toMenu-btn').removeClass("btn-warning");
            $('.add-menu-btn').attr("disabled","disabled");
            $('.add-item-btn').removeAttr("disabled");
            search();
        }
    });
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        var parentid=$('input[name="parentid"]').val();
        var systemid=$('input[name="systemid"]').val();
        var showtype=$('input[name="showtype"]').val();
        if(showtype=='item'){
            openWindow($ctx+'/basic/menuitem/toEdit?id='+id+'&menuid='+parentid,750,350);
        }else{
            openWindow($ctx+'/basic/menu/toEdit?id='+id+'&parentid='+parentid+'&systemid='+systemid,750,500);
        }
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
    // 状态变更
    function statusChange(id, toStatus) {
        $sessionAjax({
            url:$ctx+'/basic/menu/updateStatus',
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

function reloadAll(){
    var treeObj = $.fn.zTree.getZTreeObj("menuTree");
    var nodes = treeObj.getSelectedNodes();
    if (nodes.length>0) {
        treeObj.reAsyncChildNodes(nodes[0], "refresh");
    }else{
        treeObj.reAsyncChildNodes(null, "refresh");
    }
    search();
}

function initZTree(data) {
    var setting = {
        async: {
            enable: true,
            url:$ctx+'/basic/menu/zTreeData?systemid='+$('input[name="systemid"]').val(),
            autoParam:["id=pid"],
            type:'post',
            dataFilter:zNodeFilter
        },
        callback:{
            onClick:function(event, treeId, treeNode){
                $('input[name="parentid"]').val(treeNode.id);
                search();
            }
        }
    };
    zNodeFilter(null,null,data);
    $.fn.zTree.init($("#menuTree"), setting, data);
}

function zNodeFilter(id,pNode,dataList){
    if($.isArray(dataList)){
        for(var i=0;i<dataList.length;i++){
            dataList[i].isParent=true;
        }
    }else if(dataList){
        dataList.isParent=true;
    }
    return dataList;
}

