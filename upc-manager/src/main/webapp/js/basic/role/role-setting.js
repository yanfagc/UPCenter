$(function() {
    // 初始化树形菜单
	initZTree(zNodes);

	// 提交按钮事件
    $(".submit").on("click",function() {
        settingResource();
        var options={
            beforeSubmit:function() {
                showTipsDialog("操作提示","服务器处理中，请稍候...");
            },
            success:function(rsp) {
                if(rsp.code=='1000'){
                    showTipsDialog("保存成功","数据保存成功！",function() {
                        closeDialog();
                        window.close();
                    });
                    if(window.opener){
                        opener.search();
                    }
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
    		enable:true
    	}
    };
    zNodeFilter(data,1);
    $.fn.zTree.init($("#menuTree"), setting, data);
}

function zNodeFilter(dataList,deep){
    if($.isArray(dataList)){
        for(var i=0;i<dataList.length;i++){
            dataList[i].isParent=true;
            dataList[i].open=(deep==1);
            zNodeFilter(dataList[i].children,deep+1);
        }
    }else if(dataList){
        dataList.isParent=true;
    }
    return dataList;
}

function settingResource(){
    var checked=$.fn.zTree.getZTreeObj('menuTree').getCheckedNodes();
    var resources=[];
    for(var i=0;i<checked.length;i++){
        resources.push({
            "id":checked[i].id,
            "type":checked[i].isParent?'m':'mi'
        });
    }
    if(resources.length>0){
        $('#resources').val(JSON.stringify(resources));
    }
}
