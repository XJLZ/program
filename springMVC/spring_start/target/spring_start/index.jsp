<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/moment-with-locales.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<body>

<%--<form action="/param/saveAccount" method="post"><br>--%>
    <%--用户名：<input type="text" name="username"><br>--%>
    <%--密码：<input type="text" name="password"><br>--%>
    <%--金额：<input type="text" name="money"><br>--%>
    <%--用户名字：<input type="text" name="user.name"><br>--%>
    <%--用户年龄：<input type="text" name="user.age"><br>--%>
    <%--<input type="submit">--%>
<%--</form>--%>

<%--将数据封装到list和map中--%>
<form action="/param/saveAccount" method="post"><br>
    用户名：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    金额：<input type="text" name="money"><br>
    <p>进list</p>
    用户名字：<input type="text" name="list[0].name"><br>
    用户年龄：<input type="text" name="list[0].age"><br>
    <p>进map</p>
    用户名字：<input type="text" name="map['one'].name"><br>
    用户年龄：<input type="text" name="map['one'].age"><br>
    <input type="submit">
</form>


<%--日期转换--%>
<form action="/param/saveUser" method="post"><br>
    用户名字：<input type="text" name="name"><br>
    用户年龄：<input type="text" name="age"><br>
    <%--日期: <input type="date" name="date">--%>
    <div class='input-group date' id='date1'>
        <input type='text' class="form-control" name="date" />
        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
    </div>
    <input type="submit">
</form>

<div class="row">
    <div class='col-sm-3'>
        <div class="form-group">
            <label>选择日期：</label>
            <!--指定 date标记-->
            <div class='input-group date' id='date1'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
    <div class='col-sm-3'>
        <div class="form-group">
            <label>选择日期+时间：</label>
            <!--指定 date标记-->
            <div class='input-group date' id='date2'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    $(function () {
        $('#date1').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn')
        });
        $('#date2').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });
    });
</script>
</html>
