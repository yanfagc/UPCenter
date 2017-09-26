<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>用户权限管理中心</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
  </head>
  <body class="skin-blue sidebar-mini">
    <div class="wrapper">
      <header class="main-header">
        <a href="javascript:void(0)" class="logo">
          <span class="logo-mini">UPC</span>
          <span class="logo-lg">用户权限管理中心</span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
          <a href="javascript:void(0)" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">您有4条新的消息</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- start message -->
                        <a href="#">
                          <div class="pull-left">
                            <img src="${ctx}/plugins/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image"/>
                          </div>
                          <h4>
                            Support Team
                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                          </h4>
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li><!-- end message -->
                      <li>
                        <a href="#">
                          <div class="pull-left">
                            <img src="${ctx}/plugins/dist/img/user3-128x128.jpg" class="img-circle" alt="user image"/>
                          </div>
                          <h4>
                            AdminLTE Design Team
                            <small><i class="fa fa-clock-o"></i> 2 hours</small>
                          </h4>
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <div class="pull-left">
                            <img src="${ctx}/plugins/dist/img/user4-128x128.jpg" class="img-circle" alt="user image"/>
                          </div>
                          <h4>
                            Developers
                            <small><i class="fa fa-clock-o"></i> Today</small>
                          </h4>
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <div class="pull-left">
                            <img src="${ctx}/plugins/dist/img/user3-128x128.jpg" class="img-circle" alt="user image"/>
                          </div>
                          <h4>
                            Sales Department
                            <small><i class="fa fa-clock-o"></i> Yesterday</small>
                          </h4>
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <div class="pull-left">
                            <img src="${ctx}/plugins/dist/img/user4-128x128.jpg" class="img-circle" alt="user image"/>
                          </div>
                          <h4>
                            Reviewers
                            <small><i class="fa fa-clock-o"></i> 2 days</small>
                          </h4>
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li class="footer"><a href="#">See All Messages</a></li>
                </ul>
              </li>
              <!-- Notifications: style can be found in dropdown.less -->
              <li class="dropdown notifications-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-bell-o"></i>
                  <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">您有10条提醒</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li>
                        <a href="#">
                          <i class="fa fa-users text-aqua"></i> 5 new members joined today
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the page and may cause design problems
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="fa fa-users text-red"></i> 5 new members joined
                        </a>
                      </li>

                      <li>
                        <a href="#">
                          <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="fa fa-user text-red"></i> You changed your username
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li class="footer"><a href="#">View all</a></li>
                </ul>
              </li>
              <!-- Tasks: style can be found in dropdown.less -->
              <li class="dropdown tasks-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-flag-o"></i>
                  <span class="label label-danger">9</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">您有9个任务</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- Task item -->
                        <a href="#">
                          <h3>
                            Design some buttons
                            <small class="pull-right">20%</small>
                          </h3>
                          <div class="progress xs">
                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">20% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item -->
                      <li><!-- Task item -->
                        <a href="#">
                          <h3>
                            Create a nice theme
                            <small class="pull-right">40%</small>
                          </h3>
                          <div class="progress xs">
                            <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">40% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item -->
                      <li><!-- Task item -->
                        <a href="#">
                          <h3>
                            Some task I need to do
                            <small class="pull-right">60%</small>
                          </h3>
                          <div class="progress xs">
                            <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">60% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item -->
                      <li><!-- Task item -->
                        <a href="#">
                          <h3>
                            Make beautiful transitions
                            <small class="pull-right">80%</small>
                          </h3>
                          <div class="progress xs">
                            <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">80% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item -->
                    </ul>
                  </li>
                  <li class="footer">
                    <a href="#">View all tasks</a>
                  </li>
                </ul>
              </li>
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="${ctx}/plugins/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"/>
                  <span class="hidden-xs">Alexander Pierce</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="${ctx}/plugins/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                    <p>
                      Alexander Pierce - Web Developer
                      <small>Member since Nov. 2012</small>
                    </p>
                  </li>
                  <!-- Menu Body -->
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="${ctx}/logout" class="btn btn-default btn-flat">退出</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <aside class="main-sidebar">
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="${ctx}/plugins/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>超级管理员</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <%--<c:set var="activeUrl"/>
          <c:set var="activeUrlType"/>--%>
          <ul class="sidebar-menu">
            <li class="header">用户权限管理</li>
            <c:forEach items="${resourceList}" var="item" varStatus="status">
              <li class="treeview ${status.index eq 0?'active':''}">
                <a href="javascript:void(0);">
                  <i class="fa ${item.icon}"></i> <span>${item.name}</span> <i class="fa fa-angle-left pull-right"></i>
                  <ul class="treeview-menu">
                    <c:forEach items="${item.children}" var="menu">
                      <c:choose>
                        <c:when test="${menu.urltype eq 'R'}">
                          <c:if test="${empty activeUrl}"><c:set var="activeUrl" value="${ctx}${menu.url}"/></c:if>
                          <li><a href="javascript:void(0);" onclick="goPage('${ctx}${menu.url}')"><i class="fa ${menu.icon}"></i>${menu.name}</a></li>
                        </c:when>
                        <c:when test="${menu.urltype eq 'A'}">
                          <c:if test="${empty activeUrl}"><c:set var="activeUrl" value="${menu.url}"/></c:if>
                          <li><a href="javascript:void(0);" onclick="goPage('${menu.url}')"><i class="fa ${menu.icon}"></i>${menu.name}</a></li>
                        </c:when>
                        <c:otherwise>
                          <li><a href="javascript:void(0);"><i class="fa ${menu.icon}"></i>${menu.name}</a></li>
                        </c:otherwise>
                      </c:choose>

                    </c:forEach>
                  </ul>
                </a>
              </li>
            </c:forEach>
          </ul>
        </section>
        <!-- /.sidebar -->
        	
      </aside>
      <div class="content-wrapper">
        <iframe id="content-iframe" src="${activeUrl}" style="border:none; width:100%;height:100%;background-color:#ecf0f5"></iframe>
      </div>
      
    </div>
    <script src="${ctx}/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/dist/js/app.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/dist/js/demo.js" type="text/javascript"></script>
    <script type="text/javascript">
    $.browser={};
    $.browser.mozilla = /firefox/.test(navigator.userAgent.toLowerCase());
    $.browser.webkit = /webkit/.test(navigator.userAgent.toLowerCase());
    $.browser.opera = /opera/.test(navigator.userAgent.toLowerCase());
    $.browser.msie = /msie/.test(navigator.userAgent.toLowerCase());
    
    $(function() {
        var iframe = document.getElementById("content-iframe");
        if (iframe.attachEvent) {
            iframe.attachEvent("onload", function () {
                resetSize();
            });
        } else {
            iframe.onload = function () {
                resetSize();
            };
        }

        $(window).resize(function () {
            resetSize();
        });
    });
    
    function goPage(url) {
    	document.getElementById('content-iframe').src=url;
    }
    
    function resetSize() {
    	var $window=$(window);
    	var h1=$window.height() - 60;
//    	var w1=$window.width()-230;
    	$('#content-iframe').css("height",h1);//.css("width",w1);
    	var doc=getDocument("content-iframe");
    	if(doc){
    		var h2=getScrollHeight(doc);
    		var contentdiv=$(doc.getElementById('content'));
    		if(contentdiv[0]){
    			contentdiv.css("height", h2);
    		}
    	}
    }
    function getDocument(id) {
    	if($.browser.msie){
    		return document.frames[id].document;
    	}
    	
    	var iframe=document.getElementById(id);
    	if(iframe.document){
    		return iframe.document;
    	}else{
    		return iframe.contentWindow.document;
    	}
    }
    function getWindow(id){
    	var iframe=document.getElementById(id);
    	if(iframe.window){
    		return iframe.window;
    	}else{
    		return iframe.contentWindow;
    	}
    }
    function getScrollHeight(doc)
    {
        var scrollHeight=0;
        if(doc.documentElement&&doc.documentElement.scrollHeight)
        {
        	scrollHeight=doc.documentElement.scrollHeight;
        }
        else if(doc.body)
        {
        	scrollHeight=doc.body.scrollHeight;
        }
        return scrollHeight;
    }
    </script>
  </body>
</html>
