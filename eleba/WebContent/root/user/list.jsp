<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>

</HEAD>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
				</TD>
			</tr>
			<tr>
				<td class="ta_01" align="center">
					<form
						action="${pageContext.request.contextPath}/root/user/list.action"
						method="post">
						<input type="text" name="username" value="${user.username}" /> <input
							type="submit" value="查询" />
					</form>

				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="4%">序号</td>
							<td align="center" width="10%">用户名称</td>
							<td align="center" width="10%">真实姓名</td>
							<td align="center" width="10%">邮箱</td>
							<td align="center" width="10%">电话</td>
							<td align="center" width="10%">生日</td>
							<td align="center" width="10%">性别</td>
							<td align="center" width="10%">状态</td>
							<td width="7%" align="center">激活</td>
							<td width="7%" align="center">冻结</td>
						</tr>
						<c:forEach items="${list }" var="user" varStatus="vs">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="4%">${vs.count }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.username}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.name}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.email}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.telephone}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%"><fmt:formatDate value="${user.birthday}"
										pattern="yyyy-MM-dd" /></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.sex}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%"><c:if test="${user.state==1}">激活</c:if> <c:if
										test="${user.state==0}">冻结</c:if></td>
								<td align="center" style="HEIGHT: 22px"><a
									href="${ pageContext.request.contextPath }/root/user/active.action?uid=${user.uid}">
										<img
										src="${pageContext.request.contextPath}/images/i_edit.gif"
										border="0" style="CURSOR: hand">
								</a></td>

								<td align="center" style="HEIGHT: 22px"><a
									href="${ pageContext.request.contextPath }/root/user/freeze.action?uid=${user.uid}">
										<img src="${pageContext.request.contextPath}/images/i_del.gif"
										width="16" height="16" border="0" style="CURSOR: hand">
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td colspan="7">第${pageBean.currPage}页/共${ pageBean.totalPage}页
					<c:if test="${pageBean.currPage != 1}">
						<a
							href="${ pageContext.request.contextPath }/root/user/list.action?currPage=1">首页</a>
					</c:if> <c:if test="${pageBean.currPage >= 1}">
						<a
							href="${ pageContext.request.contextPath }/root/user/list.action?currPage=${pageBean.currPage-1}">上一页</a>|
						</c:if> <c:if test="${pageBean.currPage < pageBean.totalPage}">
						<a
							href="${ pageContext.request.contextPath }/root/user/list.action?currPage=${pageBean.currPage+1}">下一页</a>|
							</c:if> <c:if test="${pageBean.currPage != pageBean.totalPage}">
						<a
							href="${ pageContext.request.contextPath }/root/user/list.action?currPage=${pageBean.totalPage}">尾页</a>|
							</c:if>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

