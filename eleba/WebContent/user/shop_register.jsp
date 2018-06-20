<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/shop_person_register.css"></link>
<title>商家注册</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/business/register.action"
		method="post" enctype="multipart/form-data">
		<div class="box">
			<input class="box_in user" placeholder="店铺名" name="name">
			<input class="box_in phone" placeholder="手机" name="">
			<input class="box_in user" placeholder="用户名" name="username">
			<input class="box_in password" placeholder="密码" name="password"><br />
			<input type="file" class="file" name="bfile" accept="image/png,image/jpg,image/jepg">
			<span style="color: red;">${msg}</span>
			<button class="box_in btn" type="submit">注册商家</button>
		</div>
	</form>
</body>
</html>