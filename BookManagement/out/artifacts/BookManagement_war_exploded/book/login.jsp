<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>管理员登录</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script src="js/md5.js"></script>
  <script src="js/gt.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
  <h3 style="text-align: center;">管理员登录</h3>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    <div class="form-group">
      <label for="username">用户名：</label>
      <input type="text" name="username" autocomplete="off" required class="form-control" id="username" placeholder="请输入用户名"/>
    </div>

    <div class="form-group">
      <label for="password">密码：</label>
      <input type="password" name="password" class="form-control" required id="password" placeholder="请输入密码"/>
    </div>
    <div>
      <div id="captcha1">
        <p id="wait1">正在加载验证码......</p>
      </div>
    </div>
    <br>
    <p id="message"  style="display: none; color: #ff0000; font-weight: bold; text-align: center">请先完成验证</p>

    <hr/>
    <div class="form-group" style="text-align: center;">
      <input class="btn btn btn-primary" type="submit" id="submit1" value="登录">
    </div>
  </form>

  <!-- 出错显示的信息框 -->
  <div id="msgBox" class="alert alert-warning alert-dismissible" role="alert" style="text-align: center">
    <button type="button" class="close" data-dismiss="alert" >
      <span>&times;</span>
    </button>
    <strong id="msg">${login_error}</strong>
  </div>
</div>
</body>

<script>

    if ($("#msg").html() == null || $("#msg").html() ==""){
        $("#msgBox").css("display","none");
    } else {
        $("#msgBox").css("display","block");
    }

      // 在表单提交之前给密码进行加密/混淆
      $("form").submit(function(){
      	var psd = $("#password").val();
      	psd = md5(psd);
      	$("#password").val(psd);
      });
  </script>

<script>
    var handler1 = function (captchaObj) {
        $("#submit1").click(function (e) {
            var result = captchaObj.getValidate();
            console.log(!result);
            if (!result) {
                $("#message").show();
                setTimeout(function () {
                    $("#message").hide();
                }, 2000);
                e.preventDefault();
            }else {
                return true;
            }
        });
        // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
        captchaObj.appendTo("#captcha1");
        captchaObj.onReady(function () {
            $("#wait1").hide();
        });
        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
    $.ajax({
        url: "/gt/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 调用 initGeetest 初始化参数
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                product: "float", // 产品形式，包括：float，popup
                width: "100%"
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler1);
        }
    });
</script>
</html>
