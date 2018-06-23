<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/user/css/public.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/user/css/order_detail.css">
<title>订单详情</title>
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
	<div class="detail_main">
		<div class="detail_top">订单详情</div>
		<div class="detail_center">
			<div class="detail_mess">
				<span>订单已完成</span> <span>14:34确认送达</span>
			</div>
			<div class="comment">
				<a href="comment.html">去评价</a>
			</div>
		</div>
		<!-- 食物信息 -->
		<table class="detail_food">
			<thead class="food_thead">
				<tr>
					<th><img src="image/shop.png">
						<div>
							<span>林记隆江猪脚饭</span> <span>订单号：111111111111</span>
						</div></th>
					<th>商家电话:</th>
					<th>121212121s</th>
				</tr>
			</thead>
			<tbody>

				<tr class="food_tr">
					<td>菜品</td>
					<td>数量</td>
					<td>小计(元)</td>
				</tr>

				<c:forEach items="${cart}" var="item">
					<tr class="food_tr">
						<td>${item.product.pname}</td>
						<td>${item.count}</td>
						<td>${item.subtotal}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		<!-- 运送信息 -->
		<ul class="detail_carrige">
			<li class="detail_carrige_item">配送信息</li>
			<li class="detail_carrige_item">配送方式： 林记隆江猪脚饭提供配送服务</li>
			<li class="detail_carrige_item">送达时间： 11:30-11:45</li>
			<li class="detail_carrige_item">联 系 人： 翁俊河(先生)</li>
			<li class="detail_carrige_item">联系电话： 13602286536</li>
			<li class="detail_carrige_item">收货地址： 仲恺</li>
			<li class="detail_carrige_item">发票信息： 无发票</li>
			<li class="detail_carrige_item">备 注： 无备注</li>
		</ul>
	</div>




	<!-- 侧边栏 -->
	<div id="sidebar" class="sidebar">
		<div id="sidebar_tabs" class="sidebar_tabs">
			<!-- 侧边条 -->
			<div class="my_order">
				<!-- 我的订单 -->
				<svg class="icon_single" aria-hidden="true">
  					<use xlink:href="#icon-single"></use>
				</svg>
			</div>
			<div class="shop_car">
				<!-- 购物车 -->
				<svg class="icon_car" aria-hidden="true">
  					<use xlink:href="#icon-gouwuchekong"></use>
				</svg>
				购物车
			</div>
		</div>
		<div id="sidebar_content" class="sidebar_content">
			<!-- 侧边栏内容 -->
			<div id="btn_return" class="btn_return">
				<!-- 返回按钮 -->
				<span>购物车</span> <span> <svg class="icon_right"
						aria-hidden="true">
  						<use xlink:href="#icon-shuangjiantouyou"></use>
					</svg>
				</span>
			</div>
			<div id="car_list" class="car_list">
				<div class="list_top">
					<span>1号购物车</span> <span id="delete" class="delete">[清空]</span>
				</div>
				<ul id="list_center" class="list_center">

				</ul>
			</div>
			<div class="list_bottom" id="list_bottom">
				<!-- 购物车底部 -->
				<div class="message">
					<!-- <span>共<span id="bottom_quantity">??</span>份
					</span> -->
					<!-- 数量 -->
					<!--	<span>总计<span id="bottom_count">???</span>元
					</span>
					 总价格 -->
				</div>
				<button class="balance"
					onclick="javascript:location.href='${pageContext.request.contextPath}/cart/pay.action'">去结算</button>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath }/user/js/iconfont.js"></script>
<script src="${pageContext.request.contextPath }/user/js/public.js"></script>
<script src="${pageContext.request.contextPath }/user/js/order_detaill.js"></script>
</html>