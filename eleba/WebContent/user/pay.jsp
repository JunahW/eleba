<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/public.css"></link>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/pay.css"></link>
<title></title>
</head>
<body>
	<!-- 导航条 -->
	<div id="nav_bar" class="nav_bar">
		<!-- 导航条内容 -->
		<div class="nav_container">
			<!-- logo -->
			<a
				href="${pageContext.request.contextPath }/business/list.action?currPage=1"
				class="logo nav_bar_item"></a>
			<!-- 首页 -->
			<a
				href="${pageContext.request.contextPath }/business/list.action?currPage=1"
				class="index nav_bar_item nav_focus">首页</a>
			<!-- 我的订单 -->
			<a href="${pageContext.request.contextPath }/buyer/orders.action"
				class="orders nav_bar_item">我的订单</a>
			<!-- 加盟合作 -->
			<a
				href="${pageContext.request.contextPath }/user/shop_person_register.jsp"
				class="join nav_bar_item" target="_blank">加盟合作</a>
			<!-- 菜单按钮 -->
			<span id="btn_down" class="btn_down nav_bar_item"> <svg
					class="icon_down" aria-hidden="true">
  					<use xlink:href="#icon-xiangxia"></use>
				</svg>
			</span>
			<!-- 用户账号 -->
			<c:if test="${buyer_session.username!=null}">
				<span class="user nav_bar_item">${buyer_session.username}</span>
			</c:if>
			<c:if test="${buyer_session.username==null}">
				<a class="join nav_bar_item"
					onclick="javascript:location.href='${pageContext.request.contextPath }/user/login.jsp'">登录/注册</a>
			</c:if>
			<!-- 下拉框 -->
			<div id="dropBox" class="dropBox">
				<div class="dropBox_triangle"></div>
				<!-- 三角形 -->
				<div id="drop_con" class="drop_con">
					<!-- 下拉框内容 -->
					<a href="" class="drop_con_item"> <svg class="icon_user"
							aria-hidden="true">
  							<use xlink:href="#icon-gerenyonghutouxiang2"></use>
						</svg> 个人中心
					</a> <a href="" class="drop_con_item"> <svg class="icon_location"
							aria-hidden="true">
  							<use xlink:href="#icon-dizhi"></use>
						</svg> 我的地址
					</a>
				</div>
			</div>
			<c:if test="${buyer_session.username!=null}">
				<a href="${pageContext.request.contextPath }/user/logout.action"
					class="nav_bar_item">退出登录</a>
			</c:if>
		</div>
	</div>
	<div class="main">
		<div class="left">
			<div class="left_top">订单详情</div>
			<table class="order_table">
				<thead>
					<tr>
						<th>商品</th>
						<th>份数</th>
						<th>小计(元)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders.orderitems}" var="item">
						<tr>
							<td>${item.product.pname}</td>
							<td>${item.count}</td>
							<td>${item.subtotal}</td>
						</tr>
					</c:forEach>
					<!-- <tr>
						<td>配送费</td>
						<td></td>
						<td>¥2.50</td>
					</tr>
					<tr>
						<td>餐盒</td>
						<td></td>
						<td>¥1.50</td>
					</tr> -->
				</tbody>
			</table>
			<div class="left_bottom">
				<span class="money"><em>共¥</em>${orders.total}</span>
				<!-- <span class="count">共<em>1</em>份商品 -->
				</span>
			</div>
		</div>
		<div class="right">
			<div class="tittle">收货地址</div>

			<c:forEach items="${addrs}" var="addr">
				<div class="location_box">
					<div class="location_box_item">
						<div class="item_icon">
							<svg class="icon_loca" aria-hidden="true">
  							<use xlink:href="#icon-dizhi"></use>
						</svg>
						</div>
						<div class="item_text">
							<div class="item_text_mess">
								<span class="name">${addr.name}</span> <span class="sex">先生</span> <span
									class="phone">${addr.phone}</span>
							</div>
							<div class="item_text_loca">${addr.addr}</div>
						</div>
					</div>
			</c:forEach>

		</div>
		<span class="show_more_btn" id="show_more_btn">显示更多地址></span>
		<div class="tittle">其他信息</div>
		<div class="other_item">
			<span>配送方式</span><span>本订单由 [商家] 提供配送</span>
		</div>
		<div class="other_item">
			<span>订单备注</span><input type="text">
		</div>
		<button class="pay_btn">确认下单</button>
	</div>
	</div>


	<script src="${pageContext.request.contextPath }/user/js/iconfont.js"></script>
	<script src="${pageContext.request.contextPath }/user/js/pay.js"></script>
</body>
</html>