var datatable;
$(function() {
    // 定义操作变量
    var $searchkey=$('#searchkey');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/loginlog/dataList",
            fnServerParams:function(aodata,b,c,d) {
                aodata.push({
                    "name":"searchkey",
                    "value":$searchkey.val()
                });
            },
            aoColumns:[
                {
                    mData:"account"
                },
                {
                    mData:"nickname"
                },
                {
                    mData:"loginip"
                },
                {
                    mData:"logintime",
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                        return data?formatDatetime(data):'';
                    }
                },
                {
                    mData:"remark"
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });

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

