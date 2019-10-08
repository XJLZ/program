<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<a href="account/findAll">查询账户</a>

<form action="account/save" method="post">
    账户：<input type="text" name="name">
    金钱：<input type="text" name="money">
    <input type="submit" value="保存">
</form>
</body>
</html>