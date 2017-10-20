$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            adminPassword:{
                required:true
            },
            newPassword:{
                required:true,
                minlength:1,
                maxlength:20
            },
            rePassword:{
                required:true,
                equalTo:'newPassword'
            }
        },
        messages:{
            adminPassword:{
                required:"管理员密码不允许为空！",
                maxlength:"最大长度不能长于15位！"
            },
            newPassword:{
                required:'新密码不允许为空！',
                minlength:'最小长度不能小于1位！',
                maxlength:'最大长度不能长于20位！'
            },
            rePassword:{
                required:'重复密码不允许为空！',
                equalTo:'重复密码与新密码不一致！'
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
                    showTipsDialog("保存成功","用户密码修改成功！",function() {
                        closeDialog();
                        window.close();
                    });
                }else{
                    var msg=rsp.msg?rsp.msg:"密码修改失败，请联系管理员或稍后再试！";
                    showTipsDialog("错误信息",msg,true);
                }
            },
            error:function(rsp) {
                if(rsp.status==404||rsp.status=='404'){
                    showTipsDialog("错误信息","密码修改失败，无法访问目标地址！",true);
                }else{
                    showTipsDialog("错误信息","密码修改失败，请联系管理员或稍后再试！",true);
                }
            }
        };
        $sessionAjaxSubmit($("#submitForm"),options);
    });
});

// function relogin(){
//     window.opener.relogin();
//     window.close();
// }
