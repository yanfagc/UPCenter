var mts=[{
        type:"date",items:[{value:"DATE",text:"日期格式(yyyy-MM-dd)"},{value:"TIME",text:"时间格式(HH:mm:ss)"},{value:"DATETIME",text:"日期时间(yyyy-MM-dd HH:mm:ss)"}]
    },{
        type:"upload",items:[{value:"FILE",text:"普通文件"},{value:"IMAGE",text:"图片格式"}]
    },{
        type:"hr",items:[{value:"ONEHR",text:"人力资源[单选]"},{value:"MOREHR",text:"人力资源[多选]"}]
    }];
var tvs=[];
var macrotype;

$(function() {
    macrotype=$('input[name="macrotype"]').val();
    macrotype=macrotype?macrotype:'date';
    index=getIndexFormMts(macrotype,mts);
    tvs.push({key:macrotype,value:$('input[name="defaultvalue"]').val()});
    
    $.each($('input[name="__mtype"]'),function(i,v){
        if($(v).val() == mts[index].type){
            $(v).attr('checked','checked');
        }
    });
    
    onMtypeChange(index);
    resetsize();
    
    $('input[name="dvalue"]').on('change',function(){
        var $this=$(this);
        if($this.val()=='none'||$this.val()=='current'){
            $('input[name="choosevalue"]').attr('disabled','disabled');
        }else{
            $('input[name="choosevalue"]').removeAttr('disabled');
        }
    });
    
    $('input[name="__mtype"]').on('click',onMtypeChange);
    $(window).on('resize',resetsize);
    
    $("#submitForm").validate({
        focusCleanup:true,
        focusInvalid:false,
        ignore:'',
        showText:true,
        rules:{
            fieldcode:{
                required:true,
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
                required:"字段编码不允许为空！",
                maxlength:"最大长度不能长于15位！"
            },
            fieldname:{
                required:"字段名称不允许为空！",
                integer:"最大长度不能长于30位！"
            },
            defaultvalue:{
                integer:"最大长度不能长于30位！"
            },
            colspan:{
                required:"所占列数不允许为空！",
                integer:"请输入大于0的整型数值！",
                morethanzero:"请输入大于0的整型数值！",
                max:"最大值不允许大于10！"
            }
        }
    });
    $(".submit").on("click",function() {
        $('input[name="macrotype"]').val($('select[name="__macrotype"]').val());
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

/**
 * 当扩展分类变更时，触发扩展字段的变更
 * @param param - 整形参数或事件类型参数
 */
function onMtypeChange(param){
    var k=0;
    if(typeof param=='number'){
        k=param;
    }else{
        param=$(this).val();
        for(var i=0;i<mts.length;i++){
            if(mts[i].type==param){
                k=i;
                break;
            }
        }
    }

    var html=[];
    for(var i=0,s=mts[k].items.length;i<s;i++){
        var t=(macrotype==mts[k].items[i].value)?' selected="selected"':'';
        html.push('<option value="'+mts[k].items[i].value+'"'+t+'>'+mts[k].items[i].text+'</option>');
    }
    $('select[name="__macrotype"]').html(html.join(''));
    
    // 当扩展分类为文件上传是，禁用默认值的填写
    if(mts[k].type=='upload'){
        $('#dvalue_none').prop('checked','checked').trigger('change');
        $('input[name="dvalue"]').attr('disabled','disabled');
    }else{
        $('input[name="dvalue"]').removeAttr('disabled');
    }
}

/**
 * 页面初始化时，获取扩展类型值在扩展分类中的index索引
 * @param macrotype
 * @param mts
 * @returns
 */
function getIndexFormMts(macrotype,mts) {
    var index=-1;
    if(macrotype){
        for(var i=0,s=mts.length;i<s;i++){
            for(var j=0,k=mts[i].items.length;j<k;j++){
                if(mts[i].items[j].value==macrotype){
                    index=i;
                    break;
                }
            }
            if(index>-1){
                break;
            }
        }
    }
    return index=index==-1?0:index;
}

/**
 * 页面大小变更时触发操作
 */
function resetsize(){
    $('input[name="choosevalue"]').width($('input[name="fieldcode"]').width());
}
