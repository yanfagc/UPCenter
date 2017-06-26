var datatable;
$(function() {
    // 定义操作变量
    var $formid=$('#formid'),
        $fieldid=$('#fieldid'),
        $colspan=$('#colspan'),
        $fieldcode=$('#fieldcode'),
        $fieldname=$('#fieldname');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/basic/form/canAddList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"formid",
                    "value":$formid.val()
                });
                aodata.push({
                    "name":"fieldcode",
                    "value":$fieldcode.val()
                });
                aodata.push({
                    "name":"fieldname",
                    "value":$fieldname.val()
                });
            },
            aoColumns:[
                {
                    mData:"id",
                    sClass:"text-center",
                    mRender:function(data,display,record){
                        return '<input name="fieldid" type="checkbox" value="'+data+'"/>';
                    }
                },
                {
                    mData:"fieldcode"
                },
                {
                    mData:"fieldname"
                },
                {
                    mData:"colspan",
                    mRender:function(data,display,record){
                    	return '<input name="colspan" class="form-control" type="text" value="'+data+'">';
                    }
                }]
        }));

    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });
    
    // 确定保存
    $('.submit').click(function(){
        var ids='',colspans='';
        $.each($('input[name="fieldid"]:checked'),function(){
            if(ids.length>0){
                ids+=',';
                colspans+=',';
            }
            ids+=$(this).val();
            colspans+=$(this).parents('tr').find('input[name="colspan"]').val();
        });
        $fieldid.val(ids);
        $colspan.val(colspans);
        var options={
            beforeSubmit:function() {
                if($fieldid.val().length<=0){
                    showTipsDialog("操作提示","请选择需要添加的字段！",function() {
                        closeDialog();
                    });
                    return false;
                }else{
                    showTipsDialog("操作提示","服务器处理中，请稍候...");
                }
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
function search() {
    $('#fieldid').val('');
    $('input[name="fieldid"]').attr('checked','checked');
    datatable.fnClearTable(0);
    datatable.fnDraw();
}
