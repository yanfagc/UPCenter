var datatable,resourceArray=[];
$(function() {
    // 初始化树形菜单
	initZTree(zNodes);

    // 定义datatable查询操作变量
    var $roleid=$('#roleid'), $menuid=$('#menuid');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/role/roleItemList",
            bPaginate:false,
            sServerMethod:'GET',
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"roleid",
                    "value":$roleid.val()
                });
                aodata.push({
                    "name":"menuid",
                    "value":$menuid.val()
                });
            },
            aoColumns:[
                {
                    mData:null,
                    sClass:"text-center",
                    mRender:function(data, display, record){
                        var checked=false,item,mid=$('#menuid').val();
                        for(var i in resourceArray){
                            if(resourceArray[i]&&resourceArray[i].mid==mid){
                                item=resourceArray[i];
                                for(var j in resourceArray[i].res){
                                    if(resourceArray[i].res[j]=="mi_"+record.id){
                                        checked=true;
                                    }
                                }
                            }
                        }
                        if (!item){
                            checked=record.checked;
                        }

                        return '<input name="checkedId" type="checkbox" value="mi_'+record.id+'"'+(checked?'checked="checked"':'')+'/>';
                    }
                },{
                    mData:"name",
                    mRender:function(data, display, record){
                        return (data==0||data)?data:'';
                    }
                },{
                    mData:"url",
                    mRender:function(data, display, record){
                        return (data==0||data)?data:'';
                    }
                }]
        }));

    $('#dataList').on('click','tbody tr',function(){
        var $this=$(this);
        $this
    });

	// 提交按钮事件
    $(".submit").on("click",function() {
        settingResource();
        $('#resources').val(JSON.stringify(resourceArray));
        var options={
            beforeSubmit:function() {
                showTipsDialog("操作提示","服务器处理中，请稍候...");
            },
            success:function(rsp) {
                if(rsp.code=='1000'){
                    showTipsDialog("保存成功","数据保存成功！",function() {
                        closeDialog();
                    });
                }else{
                    var msg=rsp.msg?rsp.msg:"数据保存失败，请联系管理员或稍后再试！";
                    showTipsDialog("错误信息",msg,true);
                }
            },
            error:function(rsp) {
                if(rsp.status==404||rsp.status=='404'){
                    showTipsDialog("错误信息","数据保存失败，无法访问目标地址！",true);
                }else{
                    showTipsDialog("错误信息","数据保存失败，请联系管理员或稍后再试！",true);
                }
            }
        };
        $sessionAjaxSubmit($("#submitForm"),options);
    });
});

function initZTree(data) {
    var setting = {
    	check:{
    		enable:false
    	},
        callback:{
    	    onClick:function(event,treeId,node,clickFlag){
                settingResource();
    	        $('#menuid').val(node.id.substr(2));
                datatable.fnClearTable(0);
                datatable.fnDraw();
            }
        }
    };
    zNodeFilter(data,1);
    $.fn.zTree.init($("#menuTree"), setting, data);
}

function zNodeFilter(dataList,deep){
    if($.isArray(dataList)){
        for(var i=0;i<dataList.length;i++){
            dataList[i].open=(deep==1);
            zNodeFilter(dataList[i].children,deep+1);
        }
    }
    return dataList;
}

function settingResource(){
    var resources=[],item={};
    $.each($('input[name="checkedId"]:checked'),function(i,v){
        resources.push($(v).val());
    });

    item.mid=$('#menuid').val();
    item.res=resources;

    var exists=false;
    for(var i in resourceArray){
        if(resourceArray[i]&&resourceArray[i].mid==item.mid){
            resourceArray[i]=item;
            exists=true;
        }
    }
    if (!exists){
        resourceArray.push(item);
    }
}
