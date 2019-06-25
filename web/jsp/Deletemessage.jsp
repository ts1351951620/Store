<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
</head>
 <body>
 <div class="container">
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="navbar-brand"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true" style="font-size:25px;">购物商城后台管理</span></div>
        </div>
      </div>   
    </nav>
    <br/>
    <%
    	String uid=session.getAttribute("uid")+"";
     %>
    <div class="container-fluid">
  	<div class="row">
  		<div class="col-xs-2">管理员：<%=uid %></div>
  		<div class="col-xs-2"><a href="/Bootstrap/jsp/Manger.jsp">添加商品</a></div>
  		<!-- <div class="col-xs-2"><a href="#">新增商品类</a></div> -->
  		<div class="col-xs-2"><a href="/Bootstrap/jsp/Allmessage.jsp">查看商品</a></div>
  		<div class="col-xs-2"><a href="/Bootstrap/jsp/Deletemessage.jsp">删除商品</a></div>
	    <div class="col-xs-2"><a href="/Bootstrap/jsp/Login.jsp">返回登录</a></div>
	</div>
	<form action="/Bootstrap/deletemessage" method="post">
	<table align="center" border="0">	
    	<tr>
    		<td height="30px"></td>
    	</tr>
    	<tr>
    		<td width="300px" height="50px">
    		<input name="mname" class="form-control" type="text" id="formGroupInputLarge" placeholder="输入所要删除的商品名" style="height:50px;" required>
			<br/>
       		</td>
    	</tr>
    	<tr>
    		<td>
    			<button class="btn btn-lg btn-primary btn-block" type="submit" >删除商品</button>
    		</td>
    	</tr>
    </table>
	</form>

	</div>
</div>
</body>
</html>