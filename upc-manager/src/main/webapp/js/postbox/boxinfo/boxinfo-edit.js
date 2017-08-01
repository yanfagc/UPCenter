$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            groupCode:{
                required:true,
                maxlength:32,
                numOrLetterOrLine:true
            },
            groupName:{
                required:true,
                maxlength:100
            },
            companyInfoId:{
                required:true
            },
            repairerInfoId:{
                required:true
            }
        },
        messages:{
            groupCode:{
                required:'箱子组编码不允许为空！',
                maxlength:'最大长度不允许超过32位！',
                numOrLetterOrLine:'仅允许输入数字英文或下划线！'
            },
            groupName:{
                required:'箱子组名称不允许为空！',
                maxlength:'最大长度不能长于100位！'
            },
            companyInfoId:{
                required:'所属企业不允许为空！'
            },
            repairerInfoId:{
                required:'维修员不允许为空！'
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

    $('#submitForm').on('change','select[name="province"]',function(){
        var province=$(this).find(":selected").attr("area-node");
        if(!province){
            $('select[name="city"]').html('<option value="" area-node=""> --- 选择城市 --- </option>');
            return;
        }
        $sessionAjax({
            url:$ctx+'/basic/area/findByParent?parent='+province,
            type:'get',
            success:function(rsp){
                var html=[];
                html.push('<option value="" area-node=""> --- 选择城市 --- </option>');
                for(var i=0;i<rsp.body.length;i++){
                    html.push('<option value="');
                    html.push(rsp.body[i].name);
                    html.push('" area-node="');
                    html.push(rsp.body[i].node);
                    html.push('">');
                    html.push(rsp.body[i].name);
                    html.push('</option>');
                }
                $('select[name="city"]').html(html.join(''));
            }
        });
    });

    var ajaxRepairer=new $.jme.autoComplete({
        id:'ajaxRepairer',
        url:$ctx+'/postbox/repairer/ajaxFind',
        data:{
            province:$(':input[name="province"]').val(),
            city:$(':input[name="city"]').val()
        },
        reader:'input[name="repairerName"]',
        writer:'input[name="repairerInfoId"]',
        keyProps:{
            key:'repairerInfoid',
            title:'realname',
            serverKey:'searchKey',
            data:'body'
        },
        properties:{
            width:137,
            top:26,
            left:0,
            fontSize:12
        }
    });
    ajaxRepairer.init();
});

