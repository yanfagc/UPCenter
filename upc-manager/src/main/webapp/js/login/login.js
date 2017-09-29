// JavaScript Document
//支持Enter键登录
document.onkeydown = function(e){
	if($(".bac").length==0)
	{
		if(!e) e = window.event;
		if((e.keyCode || e.which) == 13){
			var obtnLogin=document.getElementById("submit_btn");
			obtnLogin.focus();
		}
	}
};

$(function(){
	var _account=getCookieAccount();
	if(_account){
		$('#j_username').val(_account);
		$('#j_remember').attr('checked','checked');
	}

	//提交表单
	$('#submit_btn').click(function(){
		show_loading();
//		var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
		if($('#j_username').val() == ''){
			show_err_msg('请输入您的用户名！');	
			$('#j_username').focus();
		}else if($('#j_password').val() == ''){
			show_err_msg('请输入您的密码！');
			$('#j_password').focus();
		}else{
			// 尝试处理记住登录帐号
            rememberAccount();
			//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
		    $('#login_form').ajaxSubmit({
	            beforeSubmit:function() {
	                show_msg('登录中，请稍候...','/');
	            },
	            success:function(rsp) {
	                if(rsp.code=='1000'){
	                    location.href=$ctx+'/index';
	                }else{
	                    var msg=rsp.msg?rsp.msg:"登录失败，请联系管理员或稍后再试！";
	                    show_err_msg(msg);
	                }
	            },
	            error:function(rsp) {
	                show_err_msg('登录失败，请检查网络链接是否正常');
	            }
	        });	
		}
	});

	/** 切换图片验证码 */
	$('form').on('click','#captcha_img',function(){
		$('#captcha_img').attr('src',$ctx+'/getVCode?_t='+new Date());
	});
});

// 记住登录帐号
function rememberAccount(){
	var _isRemember=$('#j_remember').is(":checked");
	if(_isRemember){
        var _account=$('#j_username').val();
        if (_account) {
            // var expires = new Date();
            // expires.setTime(expires.getTime() + 7**3600000);
            _expires = ";expires=-1"// + expires.toUTCString();
            document.cookie = "cookie_account=" + _account + _expires + ";path=/";
            return;
        }
	}
    var expires = new Date(0);
    document.cookie = "cookie_account="+ ";expires=" + expires.toUTCString() + ";path=/";
}

function getCookieAccount(){
    //读cookie属性，这将返回文档的所有cookie
    var allcookies = document.cookie;
    //查找name的cookie的开始位置
    var name = "cookie_account=";
    var pos = allcookies.indexOf(name);
    //如果找到了具有该名字的cookie，那么提取并使用它的值
    if (pos != -1){                       //如果pos值为-1则说明搜索"version="失败
        var start = pos + name.length;         //cookie值开始的位置
        var end = allcookies.indexOf(";",start);    //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
        if (end == -1) end = allcookies.length;    //如果end值为-1说明cookie列表里只有一个cookie
        var value = allcookies.substring(start,end); //提取cookie的值
        return (value);              //对它解码
    }
    else {
        //搜索失败，返回空字符串
    	return "";
    }
}
