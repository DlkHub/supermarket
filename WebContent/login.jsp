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
				placeholder="QQ??????/??????/??????" /> <input type="password" id="password"
				name="password" placeholder="??????" /> <input id="login" type="submit"
				value="??????">
		</form>
		<label id="jizhumima"><input type="checkbox" /> ????????????</label> <label
			id="zidongdenglu"><input type="checkbox" /> ????????????</label> <span
			id="zhaohuimima">????????????</span> <span id="register">????????????</span>
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
		alert("??????????????????????????????");
	}
	else{
	$.ajax({
  		type:"POST",//????????????
  		url:"/Supermarket/Userservlet",//?????????url
  		data:{method:"verify","username":username,"password":password}, //????????????
  		dataType:"text",//ajax???????????????url????????????????????????
  		success:function(data){
  		     if(data==1){
  		    
  		     }
  		     if(data==0){
  		    	 alert("??????????????????????????????");
  		    	$("#username").val('');
	  		   	$("#password").val('');
  		     }
  		     if(data==-1){
  		    	 alert("??????????????????????????????????????????????????????");
  		    	$("#username").val('');
  		   	$("#password").val('');
  		     }
  		}});
	}


});
</script>
</html>