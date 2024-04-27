<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录/注册</title>
	<script src="../jquery-3.5.1.min.js"></script>
	<script>
	
		$(function(){
			$("#qh").click(function(){
				if ($(".login-form").css("display") === 'block') {
					$("h2").html("注册");
					$(this).html("返回登录");
					$(".login-form").css("display","none") ;
				    $(".register-form").css("display","block") ;
				} else {
					$("h2").html("登录");
					$(this).html("没有账号？立即注册");
				    $(".login-form").css("display","block") ;
				    $(".register-form").css("display","none") ;
				}
			})
		})
	   
	</script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            width: 400px;
            background-color: #fff;
            padding: 40px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        input {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            box-sizing: border-box;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
		.cbox{
			width: 20px;
		}
		
        .login-form {
            display: block;
        }

        .register-form {
            display: none;
        }

        .toggle-form {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>登录</h2>${pd }
        <form class="login-form" action="DengluServlet" method="get">
            <input type="text" placeholder="用户名" name="name" required>
            <input type="password" placeholder="密码" name="pas" required>
            <button type="submit">登录</button>
        </form>
		
        <form class="register-form" action="Zhucservlet"  method="post">
            <input type="text" placeholder="用户名" name="name" id="name" >
            <input type="text" placeholder="手机号" name="phone" id="dhtxt" >
            <input type="password" placeholder="密码" name="pas" id="pas" >
            你的性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="男" name="sex" class="cbox">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="女" class="cbox" name="sex">女
            <button type="submit" id="zc">注册</button>
            <script type="text/javascript">
            $(function() {
        		$("#zc").click(function() {
					if($("#pas").val()==""||$("#pas").val().length<8){
						alert("请输入最少8位数的密码");
						return false;
					}
					if($("#dhtxt").val().length!=11){
						alert("请输入11位的手机号");
						return false;
					}
					if($("#name").val()==""){
						alert("用户名不能为空");
						return false;
					}
					if($("input[type='radio']:checked").length <= 0){
						alert("请选择性别");
						return false;
					}
				})
			})
            </script>
        </form>
        <div class="toggle-form">
            <a href="#" id="qh">没有账号？立即注册</a>
        </div>
    </div>

    
</body>
</html>