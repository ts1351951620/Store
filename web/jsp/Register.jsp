<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册页面</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
</head>
<body>
    <div class="container">
    <form class="form-horizontal" action="/Bootstrap/register" method="post">
    <span style="font-size:55px;"> &nbsp; </span>
    
    <table align="center" border="0">
    	<tr>
    		<div class="form-signin-heading">
    	</tr>
    	<tr>
    		<td>
    			<h1>欢迎注册</p></h1>
    		</td>
    	</tr>
    	<tr>
    		<td height="30px"></td>
    	</tr>
    	<tr>
    		<td width="300px" height="50px">
    		<input name="uid" class="form-control" type="text" id="formGroupInputLarge" placeholder="请输入账号" style="height:50px;" required>
			<br/>
       		</td>
    	</tr>
    	<tr>
    		<td>
    			<input name="password" type="password" id="inputPassword" class="form-control" placeholder="请输入密码" style="height:50px;" required>
    			<br/>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input name="name" type="text" id="inputTel" class="form-control" placeholder="请输入真实姓名" style="height:50px;" required>
    			<br/>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input name="tel" type="text" id="inputTel" class="form-control" placeholder="请输入手机号码" style="height:50px;" required>
    			<br/>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<button class="btn btn-lg btn-primary btn-block" type="submit" >立即注册</button>
    		</td>
    	</tr>
    </table>
    </form>
    </div>
</body>
<!-- <script type="text/javascript">
	var i=0;
	function count(){
		i++;
		document.getElementById("count").innerHTML=i;
		
	}
	
</script> -->
</html>