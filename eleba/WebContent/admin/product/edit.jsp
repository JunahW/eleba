<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
</HEAD>

<body>
	<!--  -->
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/admin/product/update.action"
		method="post" enctype="multipart/form-data">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品编号：</td>
				<td class="ta_01" bgColor="#ffffff"><input
					type="hidden" name="pid" id="pid" value="${product.pid}">
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pname" value="${product.pname}" id="pname" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					是否上架：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="pflag">
						<option value="1"
							<c:if test="${product.pflag==1}">selected="selected"</c:if>>是</option>
						<option value="0"
							<c:if test="${product.pflag==0}">selected="selected"</c:if>>>否</option>
				</select></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="price" value="${product.price}" id="price" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品图片：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="file"
					name="pfile" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品描述：</td>
				<td class="ta_01" bgColor="#ffffff"><textarea name="pdesc"
						rows="5" cols="30">${product.pdesc}</textarea></td>
			</tr>


			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品日期：</td>
				<td class="ta_01" bgColor="#ffffff"><fmt:formatDate
						value="${product.pdate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>