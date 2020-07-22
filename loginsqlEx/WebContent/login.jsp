<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>login web</title>
</head>

<body>
	<div class="logo"></div>
	<form action="${pageContext.request.contextPath}/servlet/Userservlet?method=login" method="post">

		<h1  align="center">登录 界面</h1>

		<div class="fromitem" align="center">用户名:
			<input type="text" placeholder="用户名" required="" id="username" name="username1"/>
			<span class='hint' id='hint_user'></span>
		</div>
		<p></p>
		<div class="fromitem" align="center">密 码   :

		<input type="password" placeholder="密码" required="" id="password" name="password1" />
		<span class='hint' id='hint_pwd'></span>
		
		</div>
		<p></p>
		<div class="fromitem" align="center">

		<input type="submit" value="登 录" />
		
		</div>
		<p></p>
		<div align="center">关卡选项
	<select id="gate" name="gate">
<option value="1">关卡1</option>
<option value="2">关卡2</option>
<option value="3">关卡3</option>
<option value="4">关卡4</option>
<option value="5">关卡5</option>
<option value="6">关卡6</option>
</select>
	</div>
	</form>

</body>

</html>