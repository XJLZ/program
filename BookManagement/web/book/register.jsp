<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/register.css">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/md5.js"></script>
    <script src="js/gt.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/messages_zh.min.js"></script>
    <script src="js/additional-methods.js"></script>
    <link rel="stylesheet" href="css/validation.css">
</head>
<body>
<!--     <span class="box">
        <a href="#"><img src="image/01.jpg" alt=""></a>
    </span> -->
<div id="register">
    <h1>用户注册${pageContext.request.contextPath}</h1>
    <form action="${pageContext.request.contextPath}/user/register" method="post" id="registerForm" name="myform"><!--onsubmit="return check();"-->
        <input class="input01" type="text" autocomplete="off" id="username" required="required" placeholder="用户名/手机/邮箱" name="username" >
        <input class="input01"  type="password" id="password" required="required" placeholder="密码" name="password">
        <input class="input01"  type="password" id="confirmPassword" required="required" placeholder="确认密码" name="confirmPassword">
        <div>
            <div id="captcha1">
                <p id="wait1" class="show">正在加载验证码......</p>
            </div>
        </div>
        <br>
        <p id="notice1" class="hide" style="display: none; color: #ff0000; font-weight: bold">请先完成验证</p>
        <p>
            <span><a href="login.jsp">已有账号？立即登录</a></span>
        </p>
        <button class="but" type="submit" id="submit1">注册</button>
    </form>
</div>
</body>

<%--

<script>

    //校验表单数据
    //校验用户名
    //单词字符，长度8到20位
    function checkUsername() {
        //1.获取用户名值
        var username = $("#username").val();
        //2.定义正则
        var reg_username = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;//6到12位数字与字母组合
        //3.判断，给出提示信息
        var flag = reg_username.test(username);
        if(flag){
            //用户名合法
            $("#username").css("border","");
        }else{
            //用户名非法,加一个红色边框
            $("#username").css("border","1px solid red");
        }
        return flag;
    }
    //校验密码
    function checkPassword() {
        //1.获取密码值
        var password = $("#password").val();
        //2.定义正则
        var reg_password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;//6到12位数字与字母组合
        //3.判断，给出提示信息
        var flag = reg_password.test(password);
        if(flag){
            //密码合法
            $("#password").css("border","");
        }else{
            //密码非法,加一个红色边框
            $("#password").css("border","1px solid red");
        }
        return flag;
    }
    //确认密码
    function confirmPasseord(){
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        if (password != confirmPassword || confirmPassword == "" || confirmPassword == null){
            $("#confirmPassword").css("border","1px solid red");
        }else{
            $("#confirmPassword").css("border","");
        }
    }
    // 在表单提交之前给密码进行加密/混淆
    $("#registerForm").submit(function(){
        if(checkUsername() && checkPassword()){
            //成功
            var psd = $("#password").val();
            psd = md5(psd);
            $("#password").val(psd);
            var cfpsd = $("#confirmPassword").val();
            cfpsd = md5(cfpsd);
            $("#confirmPassword").val(cfpsd);
            return true;
        }else {
            //失败
            return false;
        }
    });
    //当某一个组件失去焦点是，调用对应的校验方法
    $("#username").blur(checkUsername);
    $("#password").blur(checkPassword);
    $("#confirmPassword").blur(confirmPasseord);
</script>

--%>

<script>
    $("#submit1").click(function () {
        var psd = $("#password").val();
        psd = md5(psd);
        console.log(psd);
        $("#password").val(psd);
        var cfpsd = $("#confirmPassword").val();
        cfpsd = md5(cfpsd);
        $("#confirmPassword").val(cfpsd);
    });

</script>

<%--验证码--%>
<script>
    var handler1 = function (captchaObj) {
        $("#submit1").click(function (e) {
            var result = captchaObj.getValidate();
            if (!result) {
                $("#notice1").show();
                setTimeout(function () {
                    $("#notice1").hide();
                }, 2000);
                e.preventDefault();
            }
        });
        // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
        captchaObj.appendTo("#captcha1");
        captchaObj.onReady(function () {
            $("#wait1").hide();
            $(".but").css("background-color","#4a77d4");
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
                product: "popup", // 产品形式，包括：float，popup
                width: "100%"
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler1);
        }
    });
</script>

<%--jQuery Validate--%>
<script>
    $().ready(function() {
        $("#myform").validate({
            submitHandler:function(form){
                form.submit(function() {
                    console.log(1234);
                });
            }
        });
        // 在键盘按下并释放及提交后验证提交表单
        $("#registerForm").validate({
            rules: {
                username: "required",
                password: "required",
                confirmPassword: "required",
                username: {
                    required: true,
                    checkUsername:true
                },
                password: {
                    required: true,
                    checkPassword: true
                },
                confirmPassword: {
                    required: true,
                    checkPassword: true,
                    equalTo: "#password"
                }
            },
            messages: {
                username: "请输入您的名字",
                password: "请输入您的姓氏",
                username: {
                    required: "请输入用户名",
                    minlength: "用户名必需由两个字母组成",
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码长度不能小于 5 个字母"
                },
                confirmPassword: {
                    required: "请输入密码",
                    minlength: "密码长度不能小于 5 个字母",
                    equalTo: "两次密码输入不一致"
                }

            }
        });
    });
</script>

<script>
    $("#username").on("input propertchange",function(){
        console.log($(this).val());

        // $.ajax({
        //     url:"checkRegisterUsername",
        //     data:{
        //         registerUsername:$(this).val()
        //     },
        //     dataType:'json',//服务器返回json格式数据
        //     type:'post',//HTTP请求类型
        //     //timeout:10000,//超时时间设置为10秒；
        //     success:function(data){
        //         console.log(1);
        //         console.log(data);
        //     },
        //     error:function(xhr,type,errorThrown){
        //         console.log(0);
        //         console.log(errorThrown);
        //         console.log(xhr);
        //         console.log(type);
        //     }
        // });

    })
</script>



</html>