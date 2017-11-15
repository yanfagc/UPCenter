$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            minval:{
                maxlength:32
            },
            maxval:{
            	maxlength:32
            }
        }
    });
    $(".submit").on("click",function() {
        var macrostype=$('input[name="macrotype"]').val();
        if(macrostype=='DATE'||macrostype=='TIME'||macrostype=='DATETIME'){
            var minvaltype=$('input[name="minval_radio"]:checked').val(),
                maxvaltype=$('input[name="maxval_radio"]:checked').val();
            if(minvaltype=='N'||minvaltype=='W'){
                $('input[name="minval"]').val(minvaltype);
            }else{
                $('input[name="minval"]').val($('input[name="minval_show"]').val());
            }

            if(maxvaltype=='N'||maxvaltype=='W'){
                $('input[name="maxval"]').val(maxvaltype);
            }else{
                $('input[name="maxval"]').val($('input[name="maxval_show"]').val());
            }
        }

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

    // 最小值选项变更时触发方法
    $('#submitForm').on('change','input[name="minval_radio"]',function(){
        var val=$(this).val();
        if(val=='N' || val=='W'){
            $('#minval_td').html('');
        }else{
            var macrostype=$('input[name="macrotype"]').val(),pattern='';
            if(macrostype=='DATE'){
                pattern='yyyy-MM-dd';
            }else if(macrostype=='TIME'){
                pattern='HH:mm:ss';
            }else if(macrostype=='DATETIME'){
                pattern='yyyy-MM-dd HH:mm:ss';
            }
            $('#minval_td').html('<input name="minval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" onclick="WdatePicker({dateFmt:\''+pattern+'\'})"/>');
        }
    });

    // 最大值选项变更时触发方法
    $('#submitForm').on('change','input[name="maxval_radio"]',function(){
        var val=$(this).val();
        if(val=='N' || val=='W'){
            $('#maxval_td').html('');
        }else{
            var macrostype=$('input[name="macrotype"]').val(),pattern='';
            if(macrostype=='DATE'){
                pattern='yyyy-MM-dd';
            }else if(macrostype=='TIME'){
                pattern='HH:mm:ss';
            }else if(macrostype=='DATETIME'){
                pattern='yyyy-MM-dd HH:mm:ss';
            }
            $('#maxval_td').html('<input name="maxval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" onclick="WdatePicker({dateFmt:\''+pattern+'\'})"/>');
        }
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
