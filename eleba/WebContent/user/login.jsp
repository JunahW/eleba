<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/login.css"></link>
<title>用户登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/login.action"
		method="post">
		<div class="box">
			<input class="user" placeholder="用户名" name="username"> <input
				class="password" placeholder="密码" type="password" name="password">
			<!-- 验证码 -->
			<div class="pic">
				<input class="pic_in" placeholder="验证码 "><img
					src="${pageContext.request.contextPath }/captcha.svl"
					onclick="this.src='${pageContext.request.contextPath }/captcha.svl?d='+new Date()"
					alt="换一张">
			</div>
			<span style="color: red;">${msg}</span>
			<button class="btn" type="submit">登录</button>
			<div class="tips">
				<span class="tips_text">还没有账户，请点击<a href="user_register.jsp">注册</a></span>
			</div>
		</div>
	</form>
</body>
</html>