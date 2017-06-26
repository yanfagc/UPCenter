$(function() {
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
            itemvalue:{
                required:true,
                maxlength:15
            },
            itemname:{
                required:true,
                maxlength:15
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
            itemvalue:{
                required:'实际值不允许为空！',
                maxlength:"最大长度不能长于15位！"
            },
            itemname:{
                required:'显示值不允许为空！',
                maxlength:'最大长度不能长于15位！'
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
        $.each($('.itemstable tbody input[type="checkbox"]'),function(i,v){
            if($(v).is(':checked')){
                var defaultvalue=$(this).parent().parent().find('input[name="itemvalue"]').val();
                $('input[name="defaultvalue"]').val(defaultvalue);
                return false;
            }
        });
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
    if($('.itemstable tbody tr').length==0){
        addNewItem({
            renderTo:'.itemstable tbody',
            bSelected:true,
            bUp:false,
            bDown:false,
            bDel:false
        });
    }else{
        changeItemStatus();
    }
    $('.itemstable tbody').on('click','.item-remove',function() {
        $(this).parent().parent().remove();
        changeItemStatus();
    });
    $('.itemstable thead').on('click','.item-add',function() {
        addNewItem({
            renderTo:'.itemstable tbody'
        });
        changeItemStatus();
    });
    
    $('.itemstable tbody').on('click','.item-up',function() {
        var $this=$(this), $tr=$this.parent().parent(), $tbody=$tr.parent(), $trs=$tbody.children('tr'), index=$trs.index($tr);
        if(index>0){
            $before=$trs.eq(index-1).before($tr);
            changeItemStatus();
        }
    });
    $('.itemstable tbody').on('click','.item-down',function() {
        var $this=$(this), $tr=$this.parent().parent(), $tbody=$tr.parent(), $trs=$tbody.children('tr'), index=$trs.index($tr);
        if(index<$trs.length-1){
            $trs.eq(index+1).after($tr);
            changeItemStatus();
        }
    });
    $('.itemstable tbody').on('click','input[type="checkbox"]',function() {
        if($(this).is(':checked')){
            $('.itemstable tbody input[type="checkbox"]').not(this).removeAttr('checked');
        }
    });
    
    // 更改item行的向上、向下、删除按钮可操作状态
    function changeItemStatus() {
        var $items=$('.itemstable tbody tr');
        if($items.length==0){
            return;
        }
        $.each($items,function(i,item){
            var $item=$(item);
            if(i==0){
                $item.find('.item-up').attr('disabled','disabled');
                $item.find('.item-remove').hide();
            }else{
                $item.find('.item-up').removeAttr('disabled');
                $item.find('.item-remove').show();
            }
            if(i==$items.length-1){
                $item.find('.item-down').attr('disabled','disabled');
            }else{
                $item.find('.item-down').removeAttr('disabled');
            }
        });
    }
});
function addNewItem(params) {
    var opt=$.extend({
        renderTo:'body',
        bSelect:false,
        bUp:true,// 是否可向上移动
        bDown:true,// 是否可向下移动
        bDel:true
    // 是否可删除
    },params);
    var html=[];
    html.push('<tr style="text-align:center;">');
    // 排序
    html.push('<td style="padding:8px;">');
    html.push('<a href="javascript:void(0);" class="btn btn-success btn-xs item-up">↑&nbsp;向上</a>&nbsp;&nbsp;');
    html.push('<a href="javascript:void(0);" class="btn btn-warning btn-xs item-down">↓&nbsp;向下</a>');
    html.push('</td>');
    // 默认值
    html.push('<td style="padding:8px;">');
    html.push('<input type="checkbox" value="1"/>');
    html.push('</td>');
    // 实际值
    html.push('<td style="padding:4px;">');
    html.push('<input name="itemvalue" class="form-control input-sm myspanAll" type="text" placeholder="实际值"/>');
    html.push('</td>');
    // 显示值
    html.push('<td style="padding:4px;">');
    html.push('<input name="itemname" class="form-control input-sm myspanAll" type="text" placeholder="显示值"/>');
    html.push('</td>');
    // 操作
    html.push('<td style="padding:8px;">');
    html.push('<a href="javascript:void(0);" class="btn btn-warning btn-xs item-remove">X&nbsp;删除</a>');
    html.push('</td>');
    html.push('</tr>');
    var obj=$(html.join(""));
    if(opt.bSelected==true){
        obj.find('input[type="checkbox"]').attr('checked','checked');
    }
    if(!opt.bUp){
        obj.find('.item-up').attr('disabled','disabled');
    }
    if(!opt.bDown){
        obj.find('.item-down').attr('disabled','disabled');
    }
    if(!opt.bDel){
        obj.find('.item-remove').hide();
    }
    $(opt.renderTo).append(obj);
}
