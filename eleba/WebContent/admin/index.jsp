<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<title>饿了吧商家中心</title>
<meta http-equiv="Content-Language" content="zh-cn" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/general.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
body {
	color: white;
}
</style>
</head>
<body style="background: #278296">
	<form method="post"
		action="${pageContext.request.contextPath }/admin/user/login.action"
		target="_parent" name='theForm' onsubmit="return validate()">
		<table cellspacing="0" cellpadding="0" style="margin-top: 100px"
			align="center">
			<tr>
				<td style="padding-left: 50px">
					<table>
						<tr>
							<td>账户：</td>
							<td><input type="text" name="username"
								placeholder="手机号/用户名称" value="${user.username}" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="password" placeholder="密码" name="password" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><span style="color: red;">${msg}</span></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value="进入管理中心" class="button" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<script language="JavaScript">
	<!--使得页面不被嵌套-->
		if (top.location != location) {
			top.location.href = location.href;
		}
		document.forms['theForm'].elements['username'].focus();

		/**
		 * 检查表单输入的内容
		 */
		function validate() {
			var validator = new Validator('theForm');
			validator.required('username', user_name_empty);
			//validator.required('password', password_empty);
			if (document.forms['theForm'].elements['captcha']) {
				validator.required('captcha', captcha_empty);
			}
			return validator.passed();
		}
	</script>
</body>