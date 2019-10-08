<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="UTF-8">
    <title>书籍查询</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 1. 导入CSS的全局样式 -->
    <link href="book/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="book/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="book/js/bootstrap.min.js"></script>
    <style type="text/css">
        .container h1 {
            text-align: center;
        }
        td{
            text-align: center;
            line-height: 35px;
        }
        th{
            text-align: center;
            line-height: 35px;
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
<body>
<div class="container">
    <h1>书籍查询</h1>
    <p></p>
    <p></p>
    <p></p>
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form action="${pageContext.request.contextPath}/bookManager/bookSearch">
            <div class="input-group">
                <input id="bookName" type="text" class="form-control" name="bookName" placeholder="Search for..."/>
                <span class="input-group-btn">
                    <input type="submit" class="btn btn-success"  value="查询"/>
                </span>
            </div><!-- /input-group -->
            </form>
        </div><!-- /.col-lg-6 -->
</div><!-- /.row -->

<p style="margin-top: 20px"></p>
    <section class="content">
    <div class="col-md-1"></div>
    <div class="col-md-10">
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
        <c:if test="${not empty pb.list }">
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li ><a href="${pageContext.request.contextPath}/bookSearch?bookName=${bookName}&currentPage=1&rows=${row}">首页</a></li>
                    <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${pb.currentPage != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/bookSearch?bookName=${bookName}&currentPage=${pb.currentPage - 1}&rows=${row}" aria-label="Previous">
                            </c:if>
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

                    <c:forEach begin="${begin}" end="${end}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active"><a href="${pageContext.request.contextPath}/bookSearch?bookName=${bookName}&currentPage=${i}&rows=${row}">${i}</a></li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li><a href="${pageContext.request.contextPath}/bookSearch?bookName=${bookName}&currentPage=${i}&rows=${row}">${i}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/bookSearch?bookName=${bookName}&currentPage=${pb.currentPage + 1}&rows=${row}" aria-label="Next">
                            </c:if>
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li ><a href="${pageContext.request.contextPath}/bookSearch?bookName=${bookName}&currentPage=${pb.totalPage}&rows=${row}">末页</a></li>

                        <span class="pagespan">
                            共${pb.totalCount}条记录，共${pb.totalPage}页
                        </span>
                        <div class="jump">
                            <form action="">
                                <span class="wc">跳到第</span>
                                <input type="hidden" name="bookName" value="${bookName}">
                                <input type="number" id="Pagenum" step="1" name="currentPage"  style="width: 50px">
                                <span class="wc">页</span>
                                <input type="submit" class="btn btn-info btn-sm" value="确定">
                            </form>
                        </div>
                    </c:if>

                </ul>
            </nav>
        </div>
    </div>
    </section>
</body>

<script>
    function search() {
        var pName = $("#searchPname").val();
        // pName = encodeURI(encodeURI(pName));
        location.href="${pageContext.request.contextPath}/bookManager/productSearch?pName="+pName;
    }
</script>
<script type="text/javascript">
    function deleteProduct(id) {
        if (confirm("您确定要删除么？")) {
            location.href="${pageContext.request.contextPath}/bookManager/bookDel?id="+id;
        }
    }
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
</html>




















