<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <style>
        div{
            font-size: 30px;
            font-weight: bold;
            width: 600px;
            height: 200px;
            margin: 0 auto;
            text-align: center;
            line-height:100px ;
        }
        #tip{
            color: red;
        }
    </style>
</head>
<body>
<div class="msg">
    <h2>${registerMsg}<span id="tip"></span></h2>
    <script>
        var second = 3;
        function tip(){
            if (second>0) {
                setTimeout(tip, 1000);
                $("#tip").html(second + "s");
                second--;
            }else {
                location="${pageContext.request.contextPath}/book/login.jsp";
            }

        }
        tip();
    </script>
</div>
<div>
    <img src="img/success_bg.png" width="300px" >
</div>
</body>
</html>
