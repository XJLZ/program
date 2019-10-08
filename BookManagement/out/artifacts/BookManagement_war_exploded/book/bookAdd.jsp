<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!--     导入核心标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门添加</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <!--link导入外部的css,js样式  如果导入的资源和本页面在同一个文件夹下,直接文件夹名就可  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body>
<div class="wrapper row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
            <div class="box-body">
                <form action="${pageContext.request.contextPath}/bookManager/bookInsert" method="post">
                    <div class="form-group">
                        <label for="bookName">书籍ID</label>
                        <input type="text" class="form-control " name="bookId" id="bookId"/>
                    </div>
                    <div class="form-group">
                        <label for="bookName">书籍名称</label>
                        <input type="text" class="form-control " id="bookName" name="bookName" />
                    </div>
                    <p style="margin-top: 10px"></p>
                    <div class="form-group">
                        <label for="bookAuthor">书籍作者</label>
                        <input type="text" class="form-control " id="bookAuthor" name="bookAuthor" />
                    </div>
                    <p style="margin-top: 10px"></p>
                    <div class="form-group">
                        <label for="bookPress">出版社</label>
                        <input type="text" class="form-control " id="bookPress" name="bookPress" />
                    </div>
                    <p style="margin-top: 10px"></p>
                    <div class="form-group">
                        <label for="price">书籍价格</label>
                        <input type="number" step="0.01" class="form-control " id="price" name="price"/>
                    </div>
                    <p style="margin-top: 10px"></p>
                    <div class="form-group">
                        <label for="pic">编码</label>
                        <input type="text" class="form-control" id="pic" name="pic"/>
                    </div>
                    <p style="margin-top: 10px"></p>
                    <div class="box-footer">
                        <button type="submit" class="btn btn-success">添加</button>
                        <button type="reset" class="btn btn-info pull-right">重置</button>
                    </div>
                </form>

            </div>
            <!-- /.box-body -->

            <!-- /.box-footer -->
        </form>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

</html>
