<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>无权访问</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
</head>
<body class="skin-blue sidebar-mini">
<div style="background-color:#ecf0f5">
    <!-- Content Header (Page header) -->
    <section class="content-header">

    </section>

    <!-- Main content -->
    <section class="content">

        <div class="error-page">
            <h2 class="headline text-yellow"> 403</h2>
            <h3><i class="fa fa-warning text-yellow"></i> 对不起，您无权访问当前页面.</h3>
            <div class="error-content">
                <p>
                    很抱歉，根据访问策略，当前页面无法访问.
                </p>
                <p>
                    如您确认需要访问，可以联系<a href="javascript:void(0);">系统管理员</a>.
                </p>
                <%--<form class='search-form'>
                    <div class='input-group'>
                        <input type="text" name="search" class='form-control' placeholder="Search"/>
                        <div class="input-group-btn">
                            <button type="submit" name="submit" class="btn btn-warning btn-flat"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                </form>--%>
            </div><!-- /.error-content -->
        </div><!-- /.error-page -->
    </section><!-- /.content -->
</div>
</body>
</html>