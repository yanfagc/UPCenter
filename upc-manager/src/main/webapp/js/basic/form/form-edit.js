$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            formcode:{
                required:true,
                maxlength:15
            },
            formname:{
                required:true,
                maxlength:30
            },
            colcounts:{
                required:true,
                integer:true,
                morethanzero:true,
                max:10
            },
            remark:{
                maxlength:1024
            }
        },
        messages:{
            formcode:{
                required:"表单编码不允许为空！",
                maxlength:"最大长度不能长于15位！"
            },
            formname:{
                required:"表单名称不允许为空！",
                integer:"最大长度不能长于30位！"
            },
            colcounts:{
                required:"行字段数不允许为空！",
                integer:"请输入大于0的整型数值！",
                morethanzero:"请输入大于0的整型数值！",
                max:"最大值不允许大于10！"
            },
            remark:{
                integer:"最大长度不能长于1024位！"
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
