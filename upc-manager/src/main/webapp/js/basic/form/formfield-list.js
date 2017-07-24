var datatable;
$(function() {
    // 定义操作变量
    var $formid=$('#formid');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/form/formFieldList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"formid",
                    "value":$formid.val()
                });
            },
            aoColumns:[
                {
                    mData:"fieldcode"
                },
                {
                    mData:"fieldname"
                },
                {
                    mData:"status",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        if(data=='N'){
                            return '<label style="color:green">正常</label>';
                        }else if(data=='F'){
                            return '<label style="color:red">冻结</label>';
                        }else if(data=='D'){
                            return '<label style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"colspan",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                    	return data;
                    }
                },
                {
                    mData:"sort",
                    sClass:"text-center",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                    	html='';
                    	html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.fieldid
                            +'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                    	html+='<a class="btn btn-danger btn-xs toDelete" fid="'+record.fieldid
                            +'" href="javascript:void(0);">&nbsp;删除&nbsp;</a>';
                    	return html;
                    }
                }]
        }));
    // 添加新的表单字段关联关系
    $('.add-btn').click(function() {
        openWindow($ctx+'/basic/form/addFormField?formid='+$formid.val(), 850, 500);
    });
    
    $('tbody').on('click', '.toEdit',function() {
    	var fieldid=$(this).attr("fid"), formid=$formid.val();
        openWindow($ctx+'/basic/form/editFormField?formid='+formid+'&fieldid='+fieldid, 750, 300);
    });
    
    // 删除
    $('tbody').on("click", '.toDelete',function() {
        var fieldid=$(this).attr("fid"),
            formid=$formid.val();
        showTipsDialog("提示信息","确定执行删除操作吗？",function() {
            $sessionAjax({
                url:$ctx+'/basic/form/deleteFormField',
                data:{formid:formid,fieldid:fieldid},
                success:function(rsp){
                    if(rsp.code=='1000'){
                        datatable.fnClearTable(0);
                        datatable.fnDraw();
                    }
                    else{
                        var msg=rsp.msg?rsp.msg:"表单字段关联删除失败，请联系管理员或稍后再试！";
                        showTipsDialog("错误信息",msg,true);
                    }
                }
            });
        },true);
    });
    
});

// 目前用于执行添加后的列表页面刷新
function search() {
    datatable.fnClearTable(0);
    datatable.fnDraw();
}