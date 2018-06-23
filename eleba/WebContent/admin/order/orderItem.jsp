<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table width="100%">
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单项列表</strong>
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
							<td align="center" width="20%">图片</td>
							<td align="center" width="15%">产品名</td>
							<td align="center" width="15%">数量</td>
							<td align="center" width="15%">小计</td>

						</tr>
						<c:forEach items="${itemList}" var="orderitem" varStatus="vs">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${vs.count}</td>

								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="20%"><img width="40" height="45"
									src="${pageContext.request.contextPath }/user/image/${orderitem.product.pimage}"></td>

								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="15%">${orderitem.product.pname}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="15%">${orderitem.count}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="15%">${orderitem.subtotal}</td>
							</tr>
						</c:forEach>
						<tr>
							<td class="ta_01" style="WIDTH: 100%" align="center"
								bgColor="#f5fafe" colSpan="5">
								<INPUT class="button_ok" type="button" onclick="history.go(-1)"
								value="返回" /> <span id="Label1"></span>
							</td>
					</table>
				</td>
			</tr>
	</table>