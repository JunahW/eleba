<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet" type="text/css" href="css/login.css"></link>
<title>注册成功</title>
</head>
<body>
	<div class="box">
		注册成功，请去邮箱激活吧！<br> <a
			href="${pageContext.request.contextPath }/user/shop_register.jsp">已激活，点击登录</a>
	</div>
</body>
</html>