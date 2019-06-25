<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Util.JDBCUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dao.AddCartDao"%>
<%@page import="Bean.CarBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>购物车</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
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
            <li><a href="Login.jsp">返回登录</a></li>
            <li><a href="Homepage.jsp">返回购物</a></li>
            <li><a href="history">查看历史购物记录</a></li>
            <!--<li><a href="#">关于我们</a></li> -->
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

   <!--  <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="/Bootstrap/jsp/Homepage.jsp">所有商品 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">手机</a></li>
            <li><a href="#">书刊</a></li>
            <li><a href="#">家电</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div> -->
    	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    		<% 	String uid=String.valueOf(session.getAttribute("uid"));%>
    		<h4><font color="#FF0000"><%=uid %></font> 的购物车：</h4>
        	<div class="table-responsive">
        		<form action="/Bootstrap/clear" method="post">
        		<table class="table table-striped">
        			<tr>
						<td>商品编号</td>
						<td>商品名称</td>
						<td>用户账户</td>
						<td>商品单价</td>
						<td>购买数量</td>
						<td>商品总价</td>
						<td>是否删除</td>
					</tr>
					
    		<% 	
    			AddCartDao cartDao=new AddCartDao();
		   		List<CarBean> car1=cartDao.findUid(uid);
    	   		for(int i=0;i<car1.size();i++){
    		%>
    		 		 <tr>
    		 			<td><%=car1.get(i).getMid() %></td>
    		 			<td><%=car1.get(i).getMname() %></td>
    		 			<td><%=car1.get(i).getUid() %></td>
    		 			<td><%=car1.get(i).getPrice() %></td>
    		 			<td><%=car1.get(i).getNum() %></td>
    		 			<td><%=car1.get(i).getMoney() %></td>
    		 			<td><input type="button" name=<%=i+1 %> value="x" onclick="window.location.href='/Bootstrap/delete?'+<%=car1.get(i).getMid()%>"></td>
			 <%}%>
			 <%
				AddCartDao cartDao2=new AddCartDao();
			 %>
					<tr>
						 <td>总计：<%=cartDao.findMoney(uid) %></td> 
					</tr>
					<tr>
						<td><input type="submit" value="是否结算"></td>
						<td><input type="button" value="继续购物" onclick="window.location.href='/Bootstrap/jsp/Homepage.jsp'"></td>
					</tr>
				</table>
				</form>
            </div>
    	</div>
    </div>
  </div>
</body>
</html>