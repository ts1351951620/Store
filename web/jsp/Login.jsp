<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录页面</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">

  </head>

  <body>
    <div class="container">
	  	<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true" style="font-size:55px;"></span>
	  </div>
      <form class="form-signin" action="/Bootstrap/loginservlet" method="post">
        <h2 class="form-signin-heading">请 登 录</h2>
        <label for="uid" class="sr-only">username</label>
        <input type="text" name="uid" class="form-control" placeholder="请输入账号" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="请输入密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <input type="text" name="random" class="form-control" placeholder="请输入验证码">
        <br>
		<img src="/Bootstrap/image">(区分大小写)
		<a href="/Bootstrap/jsp/Login.jsp">看不清,请点击这里</a>
		<br><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">点击登录</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" onClick="javascript:window.open('Register.jsp')">用户注册</button>
      </form>

 
  </body>
</html>