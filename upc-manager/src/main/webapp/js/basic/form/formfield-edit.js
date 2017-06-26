$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            colspan:{
                required:true,
                integer:true,
                morethanzero:true,
                max:10
            },
            sort:{
                required:true,
                integer:true,
                morethanzero:true,
                max:100
            }
        },
        messages:{
        	colspan:{
                required:"行字段数不允许为空！",
                integer:"请输入大于0的整型数值！",
                morethanzero:"请输入大于0的整型数值！",
                max:"最大值不允许大于10！"
            },
            sort:{
                required:"排序不允许为空！",
                integer:"请输入大于0的整型数值！",
                morethanzero:"请输入大于0的整型数值！",
                max:"最大值不允许大于100！"
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
