$(function() {
	initZTree(zNodes);
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
