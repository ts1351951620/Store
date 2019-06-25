<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Util.JDBCUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dao.AddCartDao"%>
<%@page import="Bean.CarBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>购物车</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="navbar-brand"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true" ></span></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/Bootstrap/jsp/Login.jsp">返回登录</a></li>
            <li><a href="/Bootstrap/jsp/Homepage.jsp">返回购物</a></li>
            <li><a href="/Bootstrap/jsp/Cart.jsp">查看购物车</a></li>
            <!--<li><a href="#">关于我们</a></li> -->
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    		<c:if test="${requestScope.car1.size()==0 }">
        	<h1>&nbsp;&nbsp;&nbsp;&nbsp;您还没购买任何商品,<a href="/Bootstrap/jsp/Homepage.jsp">点击前去购买</a></h1>
        	</c:if>
        	<c:if test="${requestScope.car1.size()!=0}">
        	<div class="table-responsive">
        		<form action="/Bootstrap/deletehistory" method="post">
    			<h4><font color="#FF0000">${requestScope.uid}</font> 的购买记录：</h4>
        		<table class="table table-striped">
        			<tr>
						<td>商品编号</td>
						<td>商品名称</td>
						<td>用户账户</td>
						<td>商品单价</td>
						<td>购买数量</td>
						<td>商品总价</td>
					</tr>
					<c:forEach items="${requestScope.car1}" begin="0" end="${requestScope.car1.size()}" varStatus="stat">
					<tr>
    		 			<td>${requestScope.car1[stat.index].getMid()}</td>
    		 			<td>${requestScope.car1[stat.index].getMname() }</td>
    		 			<td>${requestScope.car1[stat.index].getUid() }</td>
    		 			<td>${requestScope.car1[stat.index].getPrice() }</td>
    		 			<td>${requestScope.car1[stat.index].getNum() }</td>
    		 			<td>${requestScope.car1[stat.index].getMoney() }</td>
					<tr>
					</c:forEach>
					<tr>
						<td><input type="submit" value="清除所有购物记录"></td>
					</tr>
				</table>
        		</form>
        		
            </div>
        	</c:if>
        	
    	</div>
</body>
</html>