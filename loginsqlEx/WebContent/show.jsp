<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"   

    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>search info</title>
</head>

<body>

<center>
		<form action="servlet/Userservlet" method="get">
			请输入专业编号： <input type="text" name="major">
				<input type="submit" value="查询"> 
		</form>
		
	</center>
             <table align="center" cellpadding="1" cellspacing="1" class="admin-list">
                 <thead >
                     <tr class="admin-list-head">
                         <th align="center">姓名</th>
                         <th align="center">专业</th>
                     </tr>
                 </thead>
                
                 <tbody>
               <c:forEach var="news" items="${newsList}" >
                     <tr>
                         <td>${news.getRealname()}</td>
                         <td>${news.getMajor()}</td>
                     </tr> 
                 </c:forEach>

                   
                </tbody>
               
             </table>
</body>

</html>