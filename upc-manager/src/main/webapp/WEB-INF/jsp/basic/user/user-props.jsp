<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑用户扩展信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑用户扩展信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/user/saveExtendUserData" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">登录帐号：</td>
            <td style="width:32%;padding:4px;">
              <input name="account" class="form-control input-sm myspan6" disabled="disabled" type="text" placeholder="登录帐号" value="${record.account}">
            </td>
            <td style="width:16%;text-align:right;">显示名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="nickname" class="form-control input-sm myspan6" disabled="disabled" type="text" placeholder="显示名称" value="${record.nickname}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">属性表单：</td>
            <td style="width:32%;padding:4px;" colspan="3">
              <select id="formid" name="formid" class="form-control input-sm myspan6">
                <option value="">---请选择---</option>
              	<c:forEach items="${formList}" var="form">
                <option value="${form.id}" ${form.id eq formInfo.id?'selected="selected"':''}>${form.formname}</option>
              	</c:forEach>
              </select>
            </td>
          </tr>
          ${formHtml.html}
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script type="text/javascript">
  $(function(){
	  $('form').on('change','#formid',function(){
		  var formid=$(this).val();
		  if(formid){
			  location.href='${ctx}/basic/user/toUserProps?userid=${record.id}&formid='+formid;
		  }else{
			  location.href='${ctx}/basic/user/toUserProps?userid=${record.id}';
		  }
	  });
	  
	  $(".submit").on("click",function() {
	        var options={
	            beforeSubmit:function() {
	                /* var check=$.fn.validForm();
	                if(!check){
	                    return false;
	                } */
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
  </script>
</html>