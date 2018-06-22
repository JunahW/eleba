<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table width="100%">
	<c:forEach items="${itemList}" var="orderitem">
		<tr>
			<td><img width="40" height="45"
				src="${ pageContext.request.contextPath }/${orderitem.product.pimage}"></td>
			<td>${orderitem.product.pname}</td>
			<td>${orderitem.count}</td>
			<td>${orderitem.subtotal}</td>
		</tr>
	</c:forEach>
</table>