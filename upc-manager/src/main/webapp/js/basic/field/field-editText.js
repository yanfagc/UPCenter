$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            fieldcode:{
                required:true,
                en_code:true,
                maxlength:15
            },
            fieldname:{
                required:true,
                maxlength:30
            },
            defaultvalue:{
                maxlength:30
            },
            colspan:{
                required:true,
                integer:true,
                morethanzero:true,
                max:10
            }
        },
        messages:{
            fieldcode:{
                required:"字段编码不允许为空！"
            },
            fieldname:{
                required:"字段名称不允许为空！"
            },
            defaultvalue:{
                integer:"最大长度不能长于30位！"
            },
            colspan:{
                required:"所占列数不允许为空！"
            }
        }
    });
    $(".submit").on("click",function() {
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
