<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <!--link导入外部的css，js样式，如果导入的资源和本页面在同一个文件夹下，直接文件名即可-->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <%--<script src="admin/js/jquery-3.4.1.min.js"/>--%>
    <script>
        function deleteProduct(id) {
            if (confirm("您确定要删除么？")) {
                location.href="${pageContext.request.contextPath}/bookManager/bookDel?id="+id;
            }
        }
        function update() {
            if (confirm("您确定要修改么？")){
            }
        }
    </script>
    <style>
        #warning {
            width: 160px;
            height: 50px;
            position: absolute;
            /*margin-left: 10%;*/
            left:40% ;
            top:10%;
            background-color: rgb(0, 0, 0);
            border-radius: 8px;
            text-align: center;
            line-height: 50px;/*垂直居中文本*/
            z-index: 2; /*值越大，就在越前面*/
            font-size: 16px;
            color: #fff;
        }
        .pagespan{
            display: inline-block;
            height: 34px;
            font-size: 16px;
            margin-left: 5px;
            width: 150px;
            padding-top: 6px;
        }
        .wc{
            color: #7F7F7F;
        }
        .jump{
            margin-top: 6px;
            float: right;
        }
    </style>
</head>
<body >

<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            商品列表
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>我的书籍后台管理系统</a></li>
            <li><a href="#">书籍管理</a></li>
            <li class="active">书籍列表</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <!-- /.box-header 部门列表的显示  table  表格  th/td单元个   th字体加粗，行标题-->
                    <div class="box-body">

                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>书籍名称</th>
                                <th>书籍作者</th>
                                <th>出版社</th>
                                <th>书籍价格</th>
                                <th>编码</th>
                                <th>商品操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pb.list}" var="books">
                            <tr>
                                <td>${books.bookName}</td>
                                <td>${books.bookAuthor}</td>
                                <td>${books.bookPress}</td>
                                <td>${books.price}</td>
                                <td>${books.pic}</td>
                                <td>
                                    <a class="btn btn-success" data-toggle="modal" data-target="#myModal${books.bookId}">
                                        <i class="fa fa-edit"></i> 修改
                                    </a>
                                    <a class="btn btn-danger"  href="javascript:deleteProduct(${books.bookId});" >
                                        <i class="fa fa-remove"></i> 删除
                                    </a>
                                    <!-- 模态框（Modal） -->
                                    <div class="modal fade" id="myModal${books.bookId}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title" id="myModalLabel">书籍信息修改</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="${pageContext.request.contextPath}/bookManager/bookUpdate" method="post">
                                                        <!--隐藏域 提交ID-->
                                                        <input type="hidden" name="bookId" id="bookId" value="${books.bookId}">
                                                        <div class="form-group">
                                                            <label for="bookName">书籍名称</label>
                                                            <input type="text" class="form-control ww" id="bookName" name="bookName"  value="${books.bookName}">
                                                        </div>
                                                        <p style="margin-top: 10px"></p>
                                                        <div class="form-group">
                                                            <label for="bookAuthor">书籍作者</label>
                                                            <input type="text" class="form-control ww" id="bookAuthor" name="bookAuthor"  value="${books.bookAuthor}">
                                                        </div>
                                                        <p style="margin-top: 10px"></p>
                                                        <div class="form-group">
                                                            <label for="bookPress">出版社</label>
                                                            <input type="text" class="form-control ww" id="bookPress" name="bookPress"  value="${books.bookPress}">
                                                        </div>
                                                        <p style="margin-top: 10px"></p>
                                                        <div class="form-group">
                                                            <label for="price">书籍价格</label>
                                                            <input type="number" step="0.01" class="form-control ww" id="price" name="price" value="${books.price}">
                                                        </div>
                                                        <p style="margin-top: 10px"></p>
                                                        <div class="form-group">
                                                            <label for="pic">编码</label>
                                                            <input type="text" class="form-control ww" id="pic" name="pic"  value="${books.pic}">
                                                        </div>
                                                        <p style="margin-top: 10px"></p>
                                                        <div class="box-footer">
                                                            <input type="submit" class="btn btn-success" onclick="update()" value="修改   "/>
                                                            <input type="reset" class="btn btn-info pull-right" data-dismiss="modal" value="关闭"/>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                        <!--    分页  -->
                        <div>
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <li ><a href="${pageContext.request.contextPath}/bookList?currentPage=1&rows=${row}">首页</a></li>
                                    <c:if test="${pb.currentPage == 1}">
                                    <li class="disabled">
                                        </c:if>
                                        <c:if test="${pb.currentPage != 1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/bookList?currentPage=${pb.currentPage - 1}&rows=${row}" aria-label="Previous">
                                            </c:if>
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>

                                    <c:forEach begin="${begin}" end="${end}" var="i">
                                        <c:if test="${pb.currentPage == i}">
                                            <li class="active"><a href="${pageContext.request.contextPath}/bookList?currentPage=${i}&rows=${row}">${i}</a></li>
                                        </c:if>
                                        <c:if test="${pb.currentPage != i}">
                                            <li><a href="${pageContext.request.contextPath}/bookList?currentPage=${i}&rows=${row}">${i}</a></li>
                                        </c:if>
                                    </c:forEach>

                                    <c:if test="${pb.currentPage == pb.totalPage}">
                                    <li class="disabled">
                                        </c:if>
                                        <c:if test="${pb.currentPage != pb.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/bookList?currentPage=${pb.currentPage + 1}&rows=${row}" aria-label="Next">
                                            </c:if>
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                    <li ><a href="${pageContext.request.contextPath}/bookList?currentPage=${pb.totalPage}&rows=${row}">末页</a></li>
                                    <span class="pagespan">
                                      共${pb.totalCount}条记录，共${pb.totalPage}页
                                    </span>
                                    <div class="jump">
                                        <form action="">
                                            <span class="wc">跳到第</span>
                                            <input type="number" name="currentPage" id="Pagenum"  style="width: 50px">
                                            <span class="wc">页</span>
                                            <input type="submit" class="btn btn-info btn-sm" value="确定">
                                        </form>
                                    </div>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>

<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        // $('#example1').DataTable()
        $('#example1').DataTable({
            'paging'      : false,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : false,
            'info'        : false,
            'autoWidth'   : false
        })
        // Date picker
        $("#starttime").datepicker({
            autoclose: true
        })
        $("#Completetime").datepicker({
            autoclose: true
        })
    })
</script>
<script>
    $(function () {
        var check = function () {
            var value = $("#Pagenum").val();
            if (value > ${pb.totalPage}) {
                $("#Pagenum").val(${pb.totalPage});
            }
            if (value < 0){
                $("#Pagenum").val(1);
            }
        }
        $("#Pagenum").keyup(check).blur(check);
    });
</script>
</body>
</html>