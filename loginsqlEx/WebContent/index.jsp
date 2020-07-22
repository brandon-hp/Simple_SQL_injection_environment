<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
<%@ page import="bean.Useritem" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login suceess</title>
</head>

<body>
你已经登录成功！
 <%
      Useritem user=(Useritem)request.getAttribute("user");
	response.setHeader("Refresh", "10;URL="+request.getContextPath()+"/show.jsp");
     %>
     
<table border="1" align="center">
        <tr>
            <td>用户名:</td>
            <td><%=user.getUserName()%></td>
        </tr>
        <tr>
            <td>密&nbsp;码:</td>
            <td><%=user.getPassword()%></td>
        </tr>
 
    </table>
</body>

</html>