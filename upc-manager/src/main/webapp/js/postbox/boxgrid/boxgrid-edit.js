$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            gridCode:{
                required:true,
                maxlength:10
            },
            sort:{
                required:true,
                integer:true,
                morethanzero:true
            }
        },
        messages:{
            gridCode: {
                required:'内部编码不允许为空！',
                maxlength:'最大长度不允许超过10位！'
            },
            sort:{
                required:'内部编码不允许为空！',
                integer:'仅允许输入大于0的整数值！',
                morethanzero:'仅允许输入大于0的整数值！'
            },
        }
    });
    $(".submit").on("click",function() {
        var groupName=$('input[name="groupName"]').val(),
            boxCode=$('input[name="boxCode"]').val();
        $('input[name="boxName"]').val(groupName+' '+boxCode);
        var options={
            beforeSubmit:function() {
                var check=$.fn.validForm();
                if(!check){
                    return false;
                }
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

