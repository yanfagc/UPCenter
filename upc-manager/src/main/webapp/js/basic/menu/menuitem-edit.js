$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            itemcode:{
                required:true,
                maxlength:12
            },
            itemname:{
                required:true,
                maxlength:30
            },
            sort:{
                required:true,
                min:0,
                max:999
            },
            resource:{
                maxlength:128
            }
        },
        messages:{
            itemcode:{
                required:"权限编码不允许为空！",
                maxlength:"最大长度不能长于12位！"
            },
            itemname:{
                required:"权限不允许为空！",
                maxlength:"最大长度不能大于30位"
            },
            sort:{
                required:"排序值不允许为空！",
                min:"排序值不能小于0",
                max:"排序值不能大于999"
            },
            resource:{
                maxlength:"权限资源不能大于128位"
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
                        opener.reloadAll();
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

