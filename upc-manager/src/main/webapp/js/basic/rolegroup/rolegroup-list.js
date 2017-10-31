var datatable;
$(function() {
    // 定义操作变量
    var $searchkey=$('#searchkey'), $status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/group/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"searchkey",
                    "value":$searchkey.val()
                });
            },
            aoColumns:[
                {
                    mData:"groupcode"
                },
                {
                    mData:"groupname",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"remark",
                    mRender:function(data, display, record) {
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"createtime",
                    mRender:function(data, display, record) {
                        return formatDatetime(data);
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                        var html="";
                        html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.id
                        	+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                        return html;
                    }
                }]
        }));
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    // 新增
    $('.add-btn').click(function() {
        openWindow($ctx+'/basic/group/toEdit',750,350);
    });
    // 编辑
    $('tbody').on("click", '.toEdit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/basic/group/toEdit?id='+id,750,350);
    });
});
function search() {
    datatable.fnClearTable(0);
    datatable.fnDraw();
}
