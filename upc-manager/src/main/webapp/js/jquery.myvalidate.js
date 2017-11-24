(function($) {
$.extend($.fn, {
    options:{
        showText:true,//错误提示的label框中是否显示错误文本
        focusCleanup:true,
        focusInvalid:false,
        rules:{},
        messages:{}
    },
    initOpts:{
        showText:true//错误提示的label框中是否显示错误文本
    },
    messages:{
        required:'必填参数不允许为空！',
        integer:'请输入正确的整数值！',
        float:'请输入正确的小数数值！',
        numberOrLetter:'请输入数字或字母！',
        en_code:'请输入数字字母或下划线！',
        cn_code:'请输入汉字！',
        noSpecial:'不允许输入特殊字符！',
        morethanzero:'请输入大于0的数值！',
        min:'最小值不允许小于${}',
        max:'最大值不允许大于${}',
        minlimit:'最小值不允许小于特定的值！',
        maxlimit:'最大值不允许大于特定的值！',
        minlength:'最小长度不允许小于${}位！',
        maxlength:'最大长度不允许大于${}位！',
        minbytes:'最小长度不允许小于${}位（一个中文按三个字符计算）',
        maxbytes:'最大长度不允许大于${}位（一个中文按三个字符计算）',
        mincodes:'最小长度不允许小于${}位（一个中文按二个字符计算）',
        maxcodes:'最大长度不允许大于${}位（一个中文按二个字符计算）',
        money:'请输入正确的金额数字！',
        email:'请输入正确的邮箱地址！',
        idcard:'请输入正确的身份证号码！',
        mobile:'请输入正确的手机号码！',
        phone:'请输入正确的电话号码！',
        zipcode:'请输入正确的邮政编码！',
        equalTo:'指定的两项数值必须相等！',
        notEqualTo:'指定的两项数值必须不相等！'
    },
    args:{
        wi:[7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ],
        valideCode:[1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ]
    },
    //全量更新校验规则，即将新规则完全覆盖旧的规则
    //举例：字段field原来存在有required和minlength两项，新规则设置required后，minlength也将失效
    //@see updateSelective
    update: function(newopts) {
        if(!newopts){
            return;
        }
        $.fn.updateRules(newopts.rules);
        $.fn.updateMessages(newopts.messages);
    },
    //增量更新校验规则，即插入新的规则，或者更新旧规则的某个明确写出的规则项
    //举例：字段field原来存在有required和minlength两项，新规则设置required、maxlength后，minlength不会失效
    //@see update
    updateSelective:function(newopts){
        if(!newopts){
            return;
        }
        $.fn.updateRulesSelective(newopts.rules);
        $.fn.updateMessagesSelective(newopts.messages);
    },
    //重置规则，即重置为一开始调用validate方法的规则
    reset:function(){
        $.fn.resetRules();
    },
    //重置规则，即重置为一开始调用validate方法的规则
    resetSelective:function(optNames){
        $.fn.resetRulesSelective(optNames);
    },
    validate: function( options ) {
        if ( !this.length ) {
            if ( options && options.debug && window.console ) {
                console.warn( "Nothing selected, can't validate, returning nothing." );
            }
            return;
        }
        $.fn.extend($.fn.options, options);
        
        var $this=this,rules=options.rules?options.rules:{},messages=options.messages?options.messages:{};
        
        //复制一份到初始化数据中，该数据运行过程中始终不变，用于支持reset规则
        $.fn.initOpts.rules={};
        $.fn.initOpts.messages={};
        for(var key in rules){
            $.fn.initOpts.rules[key]=rules[key];
            $.fn.initOpts.messages[key]=messages[key];
        }
        
        $this.bind('submit',function() {
            try {
                $this.find('input[type="submit"],button[type="submit"]').attr('disabled','disabled');
                var res=$.fn.validForm();
                if(!res){
                    $this.find('input[type="submit"],button[type="submit"]').removeAttr('disabled');
                }
                return res;
            }
            catch (e){
                alert(e);
                return false;
            }
        });
        
        // 添加form表单元素的绑定事件
        $.each(rules, function(key, value){
            $.fn.bindValid(key,$this);
        });
    },
    bindValid:function(key,$form){
        $form.on('blur',':input[name="'+key+'"]',function(){
            $.fn.valid($(this),key,$.fn.options.rules[key],$.fn.options.messages[key]);
        });
        $form.on('focus',':input[name="'+key+'"]',function(){
            $.fn.beforeValid($(this),key,$.fn.options.rules[key],$.fn.options.messages[key]);
        });
    },
    beforeValid:function(eventElement, key, value, msg) {
        $.fn.validResult.success(eventElement,key);
    },
    validForm:function() {
        var options=$.fn.options,
            rules=options.rules,
            messages=options.messages,
            success=true;
        $.each(rules, function(key, value){
            var msg=messages[key];
            var objs=$(":input[name='"+key+"']");
            if(objs.length>0){
                $.each(objs,function(i,v) {
                    var result=$.fn.valid($(v),key,value,msg);
                    // 一旦有验证失败的元素，则整体验证失败，但验证程序仍然执行
                    if(result.success==false){
                        success=false;
                    }
                });
            }else{
                $.each(value, function(i,v){
                    if(i=='required' && v==true){
                        try{
                            easyDialog.open({
                                container:{
                                    header:'<div style="font-size:15px;">操作提示</div>',
                                    content:'<div style="font-size:15px;">'+msg[i]+'</div>',
                                    yesFn:function(){
                                        closeDialog();
                                    },
                                    noFn:false
                                }
                            });
                        }catch(e){
                            alert(msg[i]);
                        }
                        success=false;
                        return false;
                    }
                });
            }
        });
        
        return success;
    },
    valid:function(eventElement, key, value, msg) {
        var result={
            success:true
        };
        $.each(value, function(i,v) {
            if(i!='error'&&i!='unique'){
                var r=true;
                try {
                    r=eval('$.fn.validCheck.'+i+'(eventElement,key,v)');
                    if(!r){
                        result.key=i;
                        result.param=v;
                        result.success = false;
                        result.errmsg=msg[i];
                    }
                }
                catch(e){
                    r=true;
                }
                return r;
            }
        });
        $.fn.validResult.handle(eventElement,key,result);
        return result;
    },
    // item: 元素，可能为空
    // name: 元素name
    // rulename: rule规则的item名称
    getMessage:function(item,name,rulename){
        var options=$.fn.options,message=$.fn.messages[rulename],value=options.rules[name][rulename];
        try{
            if(options.messages[name][rulename]){
                message=options.messages[name][rulename];
            }
        }catch(e){
        }

        // 替换文中出现的${}字符串为rule中填写的value值
        try{
            var realmsg='',exists=false,length=message.length,begin=0;
            for(var i=0;i<length;){
                if(message[i]=='$'&&!exists&&i<length-1&&message[i+1]=='{'){
                    exists=true;
                    begin=i;
                    realmsg=message.substr(0,begin);
                    i+=1;
                    continue;
                }else if(exists&&message[i]=='}'){
                    begin=i+1;
                    realmsg+=value;
                }
                i++;
            }
            if(begin<length-1){
                realmsg+=message.substr(begin);
            }
            message=realmsg;
        }catch(e){alert(e);}
        return message;
    },
    validResult :{
        handle: function(item, name, result) {
            if(result.success) {
                $.fn.validResult.success(item,name,result);
            }
            else {
                $.fn.validResult.error(item,name,result);
            }
        },
        error: function(item, name,result) {
            var options=$.fn.options;
            item.addClass("error");
            var title=item.attr('title');
            if(title&&title!=result.errmsg){
                item.attr("otitle",title);
            }else if(!title){
                item.attr("otitle","");
            }
            item.attr("title",result.errmsg);

            var errmsg=$.fn.getMessage(item,name,result.key);
            var text=$.fn.options.showText?errmsg:'';
            var $error=$("<label forname='"+name+"' class='error' title='"+errmsg+"'>"+text+"</label>");
            if(options.rules[name].unique ==true){
                if(!options.rules[name].error){
                    options.rules[name].error=true;
                    if(options.errorPlacement){
                        options.errorPlacement($error,item);
                    }else if($.fn.isMultiple(item)){
                        item.parent().append($error);
                    }else{
                        item.after($error);
                    }
                }
            }
            else{
                if($.fn.isMultiple(item)){
                    if(item.parent().find("label.error").length==0){
                        if(options.errorPlacement){
                            options.errorPlacement($error,item);
                        }else{
                            item.parent().append($error);
                        }
                    }
                }else{
                    if(item.nextAll().filter("label.error").length==0){
                        if(options.errorPlacement){
                            options.errorPlacement($error,item);
                        }else{
                            item.after($error);
                        }
                    }
                }
            }
        },
        success: function(item, name,result) {
            var options=$.fn.options;
            options.rules[name].error=false;
            item.removeClass("error");
            item.attr('title',item.attr('otitle'));
            if(options.rules[name].unique ==true){
                $('label[forname="'+name+'"].error').remove();
            }else{
                if($.fn.isMultiple(item)){
                    item.nextAll().filter('label.error').remove();
                }else{
                    item.next('label.error').remove();
                }
            }
        }
    },
    validCheck: {
        // 匹配必填项
    	required: function(item, name, param) {
            if(!param){
                return true;
            }
            if($.fn.isMultiple(item)){
                return $("input[name='"+name+"']:checked").length>=1;
            }else{
                var value=item.val();
                return $.trim(value).length > 0;
            }
        },
        // 匹配整数（包含负数）
        integer:function(item,name,param) {
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^\-?(0|([1-9][0-9]*))$/;
            return reg.test(value);
        },
        // 匹配小数（包含负数、整数）
        float:function(item,name,param) {
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^\-?(0|([1-9][0-9]*))(\.[0-9]+)?$/;
            return reg.test(value);
        },
        // 匹配英文或数字（英文大小写均可）
        numberOrLetter:function(item,name,param){
        	var value=item.val();
        	if(param!=true || $.trim(value).length==0){
        		return true;
        	}
        	var reg=/^[0-9a-zA-Z]+$/;
        	return reg.test(value);
        },
        en_code:function(item,name,param){
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^[a-zA-Z0-9_]+$/;
            return reg.test(value);
        },
        // 仅限中文（unicode汉字字符，部分特殊汉字可能未包含在其中）
        cn_code:function(item,name,param){
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^[\u4E00-\u9FA5]+$/;
            return reg.test(value);
        },
        // 不允许输入特殊字符
        noSpecial:function(item,name,param) {
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/[`~!@#$^&*()=|{}':;',\[\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]/;
            return !reg.test(value);
        },
        // 匹配大于0的数值（包含整数和小数）
        morethanzero:function(item,name,param) {
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^[1-9]\d*(\.\d+)?$/;
            return reg.test(value);
        },
        // 最小值
        min: function(item, name, param) {
            var value=item.val();
            if(!value){
                return true;
            }

            return value >= param;
        },
        // 最大值
        max: function(item, name, param) {
            var value=item.val();
            if(!value){
                return true;
            }
            return value <= param;
        },
        // 对比最小值，如结束时间不得小于开始时间
        minlimit: function(item, name, param) {
            var value=item.val(),pv=$(":input[name='"+param+"'],textarea[name='"+param+"']").val();
            return $.trim(value)>=$.trim(pv);
        },
        // 对比最大值，如开始时间不得大于结束时间
        maxlimit: function(item, name, param) {
            var value=item.val(),pv=$(":input[name='"+param+"'],textarea[name='"+param+"']").val();
            return $.trim(value)<=$.trim(pv);
        },
        // 最小长度
        minlength: function(item, name, param) {
            if($.fn.isMultiple(item)){
                return $("input[name='"+name+"']:checked").length>=param;
            }else{
                var value=item.val();
                return $.trim(value).length >= param;
            }
        },
        // 最大长度
        maxlength: function(item, name, param) {
            if($.fn.isMultiple(item)){
                return $("input[name='"+name+"']:checked").length<=param;
            }else{
                var value=item.val();
                return $.trim(value).length <= param;
            }
        },
        // 最小byte长度，一个中文三个字节计算长度
        minbytes: function(item, name, param) { // 一个中文三个字节长度计算，用于配合数据库长度限定
    	   var value=item.val().replace(/[^\x00-\xff]/g,"aaa");
    	   return $.trim(value).length >= param;
        },
        // 最大byte长度，一个中文三个字节长度计算
        maxbytes: function(item, name, param) { // 一个中文三个字节长度计算，用于配合数据库长度限定
    	   var value=item.val().replace(/[^\x00-\xff]/g,"aaa");
    	   return $.trim(value).length <= param;
        },
        // 最小unicode长度，一个中文两个字节长度计算
        mincodes: function (item, name, param) { // 一个中文两个字节长度计算，用于配合界面展示宽度限定
    	   var value=item.val().replace(/[^\x00-\xff]/g,"aa");
    	   return $.trim(value).length >= param;
        },
        // 最大unicode长度，一个中文两个字节长度计算
        maxcodes: function (item, name, param) { // 一个中文两个字节长度计算，用于配合界面展示宽度限定
    	   var value=item.val().replace(/[^\x00-\xff]/g,"aa");
    	   return $.trim(value).length <= param;
        },
        // 匹配金额
        money: function(item, name, param) {
    	   var value=item.val();
    	   if(param!=true || $.trim(value).length==0){
    	      return true;
    	   }
    	   var reg=/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    	   return reg.test(value);
        },
        // 匹配Email地址
        email:function(item,name,param) {
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
            return reg.test(value);
        },
        // 匹配身份证号
        idcard:function(item,name,param){
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            
            return $.fn.idCardValidate(value);
        },
        // 匹配手机号码
        mobile:function(item,name,param){
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
            return reg.test(value);
        },
        // 匹配电话号码
        phone:function(item,name,param){
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^(\(\d{3,4}\)|\d{3,4}-|\d{3,4})?\d{7,8}$/;
            return reg.test(value);
        },
        // 匹配邮政编码
        zipcode:function(item,name,param){
            var value=item.val();
            if(param!=true || $.trim(value).length==0){
                return true;
            }
            var reg=/^[1-9]\d{5}(?!\d)$/;
            return reg.test(value);
        },
        // 匹配两个输入项是否相等
        equalTo:function(item,name,param){
            var value=item.val(),compareValue=$(':input[name="'+param+'"]').val();
            return value==compareValue;
        },
        // 匹配两个输入项是否不相等
        notEqualTo:function(item,name,param){
            var value=item.val(),compareValue=$(':input[name="'+param+'"]').val();
            return value!=compareValue;
        }
    },
    isMultiple: function(item) {
        return item.is(":radio") || item.is(":checkbox");
    },
    updateRules:function(opt){
        if(!opt){
            return;
        }
        var options=$.fn.options;
        for(var key in opt){
            if(!key){
                continue;
            }

            if(!options.rules[key]){
                $.fn.bindValid(key,$(this));
            }
            
            options.rules[key]=opt[key];
            if($.fn.isMultiple($(':input[name="'+key+'"]'))){
                options.rules[key].unique=true;
            }
        }
    },
    updateMessages:function(opt){
        if(!opt){
            return;
        }
        var options=$.fn.options;
        for(var key in opt){
            if(!key){
                continue;
            }
            options.messages[key]=opt[key];
        }
    },
    updateRulesSelective:function(opt){
        if(!opt){
            return;
        }
        var options=$.fn.options;
        for(var key in opt){
            if(!key){
                continue;
            }
            if(!options.rules[key]){
                if($.fn.isMultiple($(':input[name="'+key+'"]'))){
                    options.rules[key]={unique:true};
                }else{
                    options.rules[key]={};
                }
                $.fn.bindValid(key,$(this));
            }
            var item=options.rules[key],newitem=opt[key];
            for(var ikey in newitem){
                item[ikey]=newitem[ikey];
            }
        }
    },
    updateMessagesSelective:function(opt){
        if(!opt){
            return;
        }
        var options=$.fn.options;
        for(var key in opt){
            if(!key){
                continue;
            }
            if(!options.messages[key]){
                options.messages[key]={};
            }
            
            var item=options.messages[key],newitem=opt[key];
            for(var ikey in newitem){
                item[ikey]=newitem[ikey];
            }
        }
    },
    resetRules:function(){
        $.fn.options=$.fn.initOpts;
    },
    resetRulesSelective:function(names){
        if(!names){
            return;
        }
        if(!$.isArray(names)){
            names=[names];
        }
        
        var options=$.fn.options,initOpts=$.fn.initOpts;
        for(var i=0,s=names.length;i<s;i++){
            options.rules[names[i]]=initOpts.rules[names[i]]?initOpts.rules[names[i]]:{};
            options.messages[names[i]]=initOpts.messages[names[i]]?initOpts.messages[names[i]]:{};
        }
    },
    idCardValidate:function(idCard){
        idCard = $.trim(idCard.replace(/ /g, ""));
        if (idCard.length == 18) {
            var a_idCard = idCard.split("");
            if($.fn.validateCodeBy18IdCard(a_idCard)){
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }
    },
    validateCodeBy18IdCard:function(a_idCard){
        var sum = 0;
        if (a_idCard[17].toLowerCase() == 'x') {
            a_idCard[17] = 10;
        }
        for ( var i = 0; i < 17; i++) {
            sum += $.fn.args.wi[i] * a_idCard[i];
        }
        if (a_idCard[17] == $.fn.args.valideCode[sum % 11]) {
            return true;
        } else {
            return false;
        }
    }
});
}(jQuery));
