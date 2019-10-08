<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功了</h1>
<p>返回值是String/ModelAndView</p>
<h2><strong>${one.name}</strong><i>${one.age}</i>  <strong>${one.date}</strong></h2>
<h2><strong>${user.name}</strong><i>${user.age}</i>  <strong>${user.date}</strong></h2>
<hr>
<p>无返回值，使用原生servlet</p>
<h2>${name}</h2>
</body>
</html>
