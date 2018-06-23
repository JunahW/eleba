<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单列表</strong>
				</TD>
			</tr>

			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="10%">序号</td>
							<td align="center" width="15%">订单编号</td>
							<td align="center" width="15%">订单金额</td>
							<td align="center" width="15%">收货人</td>
							<td align="center" width="15%">订单状态</td>
							<td align="center" width="15%">订单详情</td>
						</tr>
						<c:forEach items="${orderList}" var="order" varStatus="vs">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${vs.count}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${order.oid}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${order.total}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">翁俊河</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">
									<%-- <c:if test="${order.state==0}">已付款</c:if> --%> <c:if
										test="${order.state==0}">
										<a
											href="${ pageContext.request.contextPath }/admin/order/updateState.action?oid=${order.oid}"><font
											color="blue">发货</font></a>
									</c:if> <c:if test="${order.state==2}">
													订单完成
									</c:if>
								</td>
								<td align="center" style="HEIGHT: 22px"><input
									type="button" value="订单详情"
									onclick="javascript:location.href='${pageContext.request.contextPath }/admin/order/orderDetail.action?oid=${order.oid}'" /></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>

			<!-- 分页 -->
			<tr align="center">
				<td colspan="7">第${pageBean.currPage}页/共${ pageBean.totalPage}页
					<c:if test="${pageBean.currPage != 1}">
						<a
							href="${ pageContext.request.contextPath }/admin/order/list.action?currPage=1">首页</a>
					</c:if> <c:if test="${pageBean.currPage >= 1}">
						<a
							href="${ pageContext.request.contextPath }/admin/order/list.action?currPage=${pageBean.currPage-1}">上一页</a>|
						</c:if> <c:if test="${pageBean.currPage < pageBean.totalPage}">
						<a
							href="${ pageContext.request.contextPath }/admin/order/list.action?currPage=${pageBean.currPage+1}">下一页</a>|
							</c:if> <c:if test="${pageBean.currPage != pageBean.totalPage}">
						<a
							href="${ pageContext.request.contextPath }/admin/order/list.action?currPage=${pageBean.totalPage}">尾页</a>|
							</c:if>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

