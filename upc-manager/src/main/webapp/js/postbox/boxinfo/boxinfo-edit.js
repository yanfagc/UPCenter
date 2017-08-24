$(function() {
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            boxInfoId:{
                required:true,
                maxlength:10,
                integer:true,
                morethanzero:true
            },
            groupName:{
                required:true
            },
            boxGroupId:{
                required:true
            },
            secKey:{
                required:true,
                maxlength:64,
                numOrLetterOrLine:true
            },
            checknum:{
                integer:true,
                maxlength:10
            }
        },
        messages:{
            boxInfoId:{
                required:'内部编码不允许为空！',
                maxlength:'最大长度不允许超过10位！',
                integer:'仅允许输入大于0的整数值！',
                morethanzero:'仅允许输入大于0的整数值！'
            },
            groupName:{
                required:'所属箱子组不允许为空！'
            },
            boxGroupId:{
                required:'请选择正确的箱子组！'
            },
            secKey:{
                required:'加密密钥不允许为空',
                maxlength:'最大长度不允许超过64位',
                numOrLetterOrLine:'仅允许输入数字英文或下划线！'
            },
            checknum:{
                integer:'请输入正确的整型数值！',
                maxlength:'最大长度不允许超过10位'
            }
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

    $('#submitForm').on('change','select[name="province"]',function(){
        var province=$(this).find(":selected").attr("area-node");
        if(!province){
            $('select[name="city"]').html('<option value="" area-node=""> --- 选择城市/地区 --- </option>');
            return;
        }
        $sessionAjax({
            url:$ctx+'/basic/area/findByParent?parent='+province,
            type:'get',
            success:function(rsp){
                var html=[];
                html.push('<option value="" area-node=""> --- 选择城市/地区 --- </option>');
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
        url:$ctx+'/postbox/boxgroup/ajaxFind',
        dynamicData:{
            province:$(':input[name="province"]'),
            city:$(':input[name="city"]')
        },
        reader:'input[name="groupName"]',
        writer:'input[name="boxGroupId"]',
        onclick:function(id,data,result){
            $('input[name="longitude"]').val(data['longitude']);
            $('input[name="latitude"]').val(data['latitude']);

        },
        keyProps:{
            key:'boxGroupId',
            title:'groupName',
            serverKey:'searchkey',
            data:'body'
        },
        properties:{
            width:139,
            top:26,
            left:0,
            fontSize:12
        }
    });
    ajaxRepairer.init();
});

