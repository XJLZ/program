<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>传统方式</h3>
<form action="file/upload" method="post" enctype="multipart/form-data" >
    文件：<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>
<h2>springMVC方式</h2>
<form action="file/uploadMVC" method="post" enctype="multipart/form-data" >
    文件：<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
