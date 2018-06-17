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

	<table cellSpacing="1" cellPadding="5" width="100%" align="center"
		bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26"><strong><STRONG>店主详情</STRONG> </strong></td>
		</tr>

		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				店主编码：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${boss.uid}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商家姓名：</td>
			<td class="ta_01" bgColor="#ffffff">${boss.name}</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				店主邮箱：</td>
			<td class="ta_01" bgColor="#ffffff">${boss.email}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				店主电话：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${boss.telephone}</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				店主生日：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff"><fmt:formatDate
					value="${boss.birthday}" /></td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				店主性别：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${boss.sex}</td>
		</tr>

		<tr>
			<td height="100px" width="18%" align="center" bgColor="#f5fafe"
				class="ta_01">身份证照：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${boss.imgurl}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
			</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${boss.imgurl}</td>
		</tr>
	</table>
	<table cellSpacing="1" cellPadding="5" width="100%" align="center"
		bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26"><strong><STRONG>商家详情</STRONG> </strong></td>
		</tr>

		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商家编码：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${business.bid}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商家名称：</td>
			<td class="ta_01" bgColor="#ffffff">${business.name}</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				入驻时间：</td>
			<td class="ta_01" bgColor="#ffffff"><fmt:formatDate
					value="${business.createtime}" />
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				激活时间：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff"><fmt:formatDate
					value="${business.statetime}" /></td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商家电话：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${business.telephone}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商铺状态：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff"><c:if
					test="${business.state==1}">运营</c:if> <c:if
					test="${business.state==0}">冻结</c:if></td>
		</tr>

		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商铺简介：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${business.description}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商铺排序：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${business.sort}</td>
		</tr>

		<tr height="100px">
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商铺图片：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${business.imgurl}</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				商铺公告：</td>
			<td width="32%" class="ta_01" bgColor="#ffffff">${business.notice}</td>
		</tr>
	</table>
	<center>
		<input class="button_ok" type="button" onclick="history.go(-1)"
			value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<c:if test="${business.state==2}">
			<input class="button_ok" type="button"
				onclick="javascript:location.href='${pageContext.request.contextPath}/root/business/active.action?bid=${business.bid}'"
				value="审核通过" />
		</c:if>
	</center>
</body>
</HTML>