var datatable;
$(function() {
    // 定义操作变量
    var $searchkey=$('#searchkey'), $sysid=$('#sysid'), $groupid=$('#groupid'), $status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/role/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"searchkey",
                    "value":$searchkey.val()
                });
                aodata.push({
                    "name":"systemId",
                    "value":$sysid.val()
                });
                aodata.push({
                    "name":"groupid",
                    "value":$groupid.val()
                });
                aodata.push({
                    "name":"status",
                    "value":$status.val()
                });
            },
            aoColumns:[
                {
                    mData:"rolecode"
                },{
                    mData:"rolename"
                },{
                    mData:"groupname"
                },{
                    mData:"systemname"
                },{
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
                },{
                    mData:"createtime",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return formatDatetime(data);
                    }
                },{
                	mData:null,
                	sClass:"text-center",
                	mRender:function(data, display, record) {
                		return '<a class="btn btn-primary btn-xs toSettingResources" fid="'+record.id
                				+'" sysid="'+record.systemId+'" href="javascript:void(0);">&nbsp;菜单权限&nbsp;</a>&nbsp;';
                	}
                },{
                	mData:null,
                	sClass:"text-center",
                	mRender:function(data, display, record) {
                		return '<a class="btn btn-primary btn-xs toEdit" fid="'+record.id
                        		+'" href="javascript:void(0);">&nbsp;权限设置&nbsp;</a>&nbsp;';
                	}
                },{
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
    // 新增角色信息
    $('.add-btn').click(function() {
        openWindow($ctx+'/basic/role/toEdit',750,350);
    });
    
    // 菜单权限
    $('tbody').on("click", '.toSettingResources', function(){
    	var roleid=$(this).attr("fid");
    	var sysid=$(this).attr("sysid");
    	openWindow($ctx+'/basic/role/toSettingResources?roleid='+roleid+'&sysid='+sysid,750,350);
    });
    
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/basic/role/toEdit?id='+id,750,350);
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
            url:$ctx+'/basic/role/updateStatus',
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
