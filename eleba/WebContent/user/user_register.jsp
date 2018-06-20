<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/shop_person_register.css"></link>
<title>用户注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/register.action"
		method="post" enctype="multipart/form-data">
		<div class="box">
			<input class="box_in user" placeholder="用户名" name="username">
			<input class="box_in password" placeholder="密码" name="password">
			<input class="box_in name" placeholder="姓名" name="name"> <input
				class="box_in email" placeholder="email" name="email"> <input
				class="box_in phone" placeholder="手机" name="telephone"> <input
				class="box_in date" placeholder="年/月/日" name="birthday">
			<div class="box_in sex_file_in">
				<input type="radio" name="sex" class="sex" value="1"><label>男</label>
				<input type="radio" name="sex" class="sex" value="0"><label>女</label>
				<input type="file" class="ufile" value="选择文件"
					onChange="document.form1.path.value=this.value"
					accept="image/png,image/jpg,image/jepg">
			</div>
			<input type="hidden" name="type" value="0" />

			<button class="box_in btn" type="submit">注册</button>
		</div>
	</form>
</body>
</html>