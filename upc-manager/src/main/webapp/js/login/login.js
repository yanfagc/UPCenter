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