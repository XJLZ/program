<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <script src="js/jquery-1.11.0.js"></script>
</head>
<body>
<a href="user/testString">testString</a>
<p></p>
<a href="user/testVoid">testVoid</a>

<p></p>
<a href="user/ModelAndView">ModelAndView</a>

<p></p>
<a href="user/testKey">testKey</a>

<p></p>

<button id="btn">异步请求</button>

</body>

<script>
    $(function () {
        $("#btn").click(function () {
        //   发送ajax请求
            $.ajax({
                url:"user/ajax",
                type:"post",
                contentType:"application/json;charset=utf-8",
                data:{"name":"Jack", "age":"23", "date":"2019-12-12"},
                dataType:"json",
                success:function (data) {
                    console.log(data);
                }
            });
        });
    })
</script>
</html>
