<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<style type="text/css">
		#body{
			width: 852px;
			height: 653px;
			box-shadow: 10px 10px 50px #888888;
		}
		#topic{
			position: absolute;
			font-size: 50px;
			color: brown;
			margin-top: 175px;
			margin-left: 70px;
		}
		#username{
			width: 270px;
			padding-left: 10px;
			border: 0;
			margin-top: 288px;
			margin-left: 37px;
			position: absolute;
			font-size: 26px;
			border-bottom:1px solid #CCCCCC;
		}
		#username:focus{
				outline:0;
				}
		#password{
			width: 270px;
			padding-left: 10px;
			border: 0;
			margin-top: 340px;
			margin-left: 37px;
			position: absolute;
			font-size: 26px;
			border-bottom:1px solid #CCCCCC;
		}
		#password:focus{
				outline:0;
				}
		#sub{
			position: absolute;
			margin-top: 330px;
			margin-left:275px;
		}
		
	</style>
</head>
<body>
	<div id="body">
		<img id="img3" src="img/photo1.png" />
		<span id="topic">欢迎注册</span>
	    <input type="text" id="username" placeholder="QQ号码/手机/邮箱" />
	<input type="password" id="password" placeholder="密码"/>
	<img id="sub" src="img/photo5.png" />
	</div>	
	</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#sub").click(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		if(username==""||password==""){
			alert("用户名或密码不能为空");
		}
		else{
		$.ajax({
	  		type:"POST",//请求类型
	  		url:"/Supermarket/Userservlet",//请求的url
	  		data:{method:"insert","username":username,"password":password}, //请求参数
	  		dataType:"text",//ajax接口（请求url）返回的数据类型
	  		success:function(){
	  		     
	  		}});
		window.location.href='login.jsp';
		}
	 });

});
</script>

</html>