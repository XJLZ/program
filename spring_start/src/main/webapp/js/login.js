 function foo(){
            if(myform.name.value=="")
            {
                alert("请输入用户名");
                myform.name.focus();
                return false;
            }
            if (myform.pwd.value=="")
            {
                alert("请输入密码");
                myform.pwd.focus();
                return false;
            }
            if (myform.yzm.value=="")
            {
                alert("请输入验证码");
                myform.yzm.focus();
                return false;
            }
        }