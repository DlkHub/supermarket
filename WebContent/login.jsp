<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<style type="text/css">
#body {
	width: 852px;
	height: 653px;
	box-shadow: 10px 10px 50px #888888;
}

#img4 {
	position: absolute;
	margin-top: 116px;
	margin-left: 88px;
}

#img4:hover {
	cursor: pointer;
}

#img5 {
	z-index: 2;
	position: absolute;
	margin-top: 116px;
	margin-left: 190px;
}

#img5:hover {
	cursor: pointer;
	display: none;
}

#img6 {
	z-index: 1;
	position: absolute;
	margin-top: 116px;
	margin-left: 190px;
}

#img6:hover {
	cursor: pointer;
	z-index: 3;
}

#form {
	position: absolute;
	margin-top: 270px;
	margin-left: 20px;
	height: 150px;
	width: 300px;
	display: inline-block;
}

#username {
	padding-left: 5px;
	font-size: 26px;
}

#username:focus {
	outline: 0;
}

#password {
	margin-top: 3px;
	padding-left: 5px;
	font-size: 26px;
}

#password:focus {
	outline: 0;
}

#login {
	margin-left: 10px;
	margin-top: 10px;
	height: 30px;
	width: 300px;
}

#jizhumima {
	position: absolute;
	color: gray;
	margin-left: 40px;
	margin-top: 554px;
}

#jizhumima input {
	border: 1px solid black;
	width: 18px;
	height: 19px;
}

#zidongdenglu {
	position: absolute;
	color: gray;
	margin-left: 40px;
	margin-top: 600px;
}

#zidongdenglu input {
	border: 1px solid black;
	width: 18px;
	height: 19px;
}

#zhaohuimima {
	position: absolute;
	color: gray;
	margin-top: 560px;
	margin-left: 245px;
}

#register {
	position: absolute;
	color: gray;
	margin-top: 606px;
	margin-left: 245px;
}

#zhaohuimima:hover {
	cursor: pointer;
}

#register:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<div id="body">
		<img id="img3" src="img/photo1.png" /> <img id="img4"
			src="img/photo2.png" /> <img id="img5" src="img/photo3.png" /> <img
			id="img6" src="img/photo4.png" />
		<form id="form" action="/Supermarket/Loginservlet" method="post">
			<input type="text" id="username" name="username"
				placeholder="QQ号码/手机/邮箱" /> <input type="password" id="password"
				name="password" placeholder="密码" /> <input id="login" type="submit"
				value="登录">
		</form>
		<label id="jizhumima"><input type="checkbox" /> 记住密码</label> <label
			id="zidongdenglu"><input type="checkbox" /> 自动登陆</label> <span
			id="zhaohuimima">找回密码</span> <span id="register">注册账号</span>
	</div>
</body>
<script>
$(document).ready(function(){
 $("#register").click(function(){
	 window.location.href='register.jsp';
 });
 $(document).keyup(function(event){  
	    if(event.keyCode == 13){  
	    	$("#login").click();
	    }
	}) 
 
});
$("#login").click(function(){
	var username=$("#username").val();
	var password=$("#password").val();
	if(username==""||password==""){
		alert("用户名或密码不能为空");
	}
	else{
	$.ajax({
  		type:"POST",//请求类型
  		url:"/Supermarket/Userservlet",//请求的url
  		data:{method:"verify","username":username,"password":password}, //请求参数
  		dataType:"text",//ajax接口（请求url）返回的数据类型
  		success:function(data){
  		     if(data==1){
  		    
  		     }
  		     if(data==0){
  		    	 alert("密码错误，请重新输入");
  		    	$("#username").val('');
	  		   	$("#password").val('');
  		     }
  		     if(data==-1){
  		    	 alert("用户不存在，请您点击注册按钮完成注册");
  		    	$("#username").val('');
  		   	$("#password").val('');
  		     }
  		}});
	}


});
</script>
</html>