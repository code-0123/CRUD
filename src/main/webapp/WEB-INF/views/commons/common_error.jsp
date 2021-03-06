<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<head>

    <%@ include file="../include/head.jsp"%>

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <%@ include file="../include/main_header.jsp"%>
    <%@ include file="../include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Error Page</h1>
                    </div><!-- /.col -->

                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">

                <section class="content container-fluid">

                    <h3><i class="fa fa-warning text-red"></i>${exception.getMessage()}</h3>
                    <ul>
                        <c:forEach items="${exception.getStackTrace()}" var="stack">
                            <li>${stack.toString()}</li>
                        </c:forEach>
                    </ul>
                </section>


            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
        <div class="p-3">
            <h5>Title</h5>
            <p>Sidebar content</p>
        </div>
    </aside>
    <!-- /.control-sidebar -->

    <%@ include file="../include/main_footer.jsp"%>

</div>
<!-- ./wrapper -->

<%@ include file="../include/plugin_js.jsp"%>

</body>
</html>
