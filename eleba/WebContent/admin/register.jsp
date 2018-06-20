<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
</HEAD>

<body>
	<form action="${pageContext.request.contextPath}/user/register.action"
		method="post" enctype="multipart/form-data">
		用戶名：<input type="text" id="" name="username" maxlength="15"><br>
		密码：<input type="password" id="" name="password"><br> 姓名：<input
			type="text" id="" name="name"><br> 邮箱：<input
			type="email" id="" name="email"><br> 手机号码：<input
			type="text" id="" name="name"><br> 生日：<input type="date"
			id="" name="birthday"><br> 男<input type="radio" id=""
			name="sex" value="1" checked> 女<input type="radio" id=""
			name="sex" value="0"><br> <input type="hidden"
			name="type" value="1"> 图片：<input type="file" name="ufile">
		验证码：<input type="text" id="" name="code"><br> <input
			type="submit" id="" name="" value="注册"><br>

	</form>

</body>
</HTML>