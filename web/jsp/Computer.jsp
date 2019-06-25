<%@page import="Dao.ClassifyDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.HomepageDao"%>
<%@page import="Bean.HomepageBean"%>
<%@page import="Util.JDBCUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我的主页</title >
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
            <li><a href="/Bootstrap/jsp/Login.jsp">返回登录</a></li>
            <li><a href="/Bootstrap/jsp/Cart.jsp">我的购物车</a></li>
            <li><a href="/Bootstrap/jsp/History.jsp">查看历史购物记录</a></li>
            <!-- <li><a href="#">关于我们</a></li> -->
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="/Bootstrap/jsp/Homepage.jsp">所有商品 <span class="sr-only">(current)</span></a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="Phone.jsp">手机</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="Computer.jsp">电脑</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="Tv.jsp">电视</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="table-responsive">
        <form action="/Bootstrap/computer" method="post">
        		<table class="table table-striped">
        			<tr>
                		<td>商品编号</td>
    					<td>商品名称</td>
    					<!-- <td>类别编号</td> -->
    					<!-- <td>数量</td> -->
    					<td>价格</td>
    					<td>描述</td>
    					<td>购买数量</td>
    				</tr>
    				</tr>
    		<%
    			Connection conn=null;
				Statement st=null;
				ResultSet rs=null;
				conn=JDBCUtils.getConnection();
				ClassifyDao computer=new ClassifyDao();
				ArrayList<HomepageBean> computerlist=computer.findSid(2);
    			for(int i=0;i<computerlist.size();i++){
    		 %>
    		 <tr>
    		 	<td><%=computerlist.get(i).getMid() %></td>
    		 	<td><%=computerlist.get(i).getMname() %></td>
    		 	<%-- <td><%=computerlist.get(i).getSid() %></td> --%>
    		 	<%-- <td><%=computerlist.get(i).getNum() %></td> --%>
    		 	<td><%=computerlist.get(i).getPrice() %></td>
    		 	<td><%=computerlist.get(i).getDescribe() %></td>
    		 	<td>
    		 		<select name=<%=i+1 %>> 
    		 			<option value="0">0</option> 
						<option value="1">1</option> 
						<option value="2">2</option> 
						<option value="3">3</option> 
						<option value="4">4</option> 
						<option value="5">5</option> 
					</select>
					
				</td>
    		 </tr>
    		 <%} %>
    		 <tr>
    		 	<td><input type="submit" value="确认购买"></td>
    		 </tr>
            	</table>
            	</form>
            </div>
    	</div>
    </div>
  </div>

</body>
</html>