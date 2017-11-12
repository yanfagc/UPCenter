$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
        	minlength:{
                integer:true,
                min:0,
                max:5
            },
            maxlength:{
                integer:true,
                morethanzero:true,
                max:5
            },
            minval:{
                maxlength:32,
                numberOrLetter:true
            },
            maxval:{
            	maxlength:32,
                numberOrLetter:true
            },
            regular:{
            	maxlength:128
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
    var minlimit=new $.minefn.autoComplete({
		id:'autoComplete_minlimit',
		type:'get',
		url:$ctx+'/basic/field/ajaxFieldInfo',
		reader:'input[for="minlimit"]',
		writer:'input[name="minlimit"]',
		keyProps:{
			key:'id',
			title:'fieldname',
			serverKey:'key'
		},
		properties:{
			width:140,
			top:30,
			left:0,
			fontSize:12
		}
	});
    minlimit.init();
    
    var maxlimit=new $.minefn.autoComplete({
		id:'autoComplete_maxlimit',
		type:'get',
		url:$ctx+'/basic/field/ajaxFieldInfo',
		reader:'input[for="maxlimit"]',
		writer:'input[name="maxlimit"]',
		keyProps:{
			key:'id',
			title:'fieldname',
			serverKey:'key'
		},
		properties:{
			width:140,
			top:30,
			left:0,
			fontSize:12
		}
	});
    maxlimit.init();
});
