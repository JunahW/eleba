<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/index.css"></link>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/user/js/jquery.min.js"></script>
<title>饿了吧首页</title>
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
		<!-- 搜索 -->
		<div class="search">
			<div class="search_block">
				<form>
					<input id="search_input" class="search_input" name="search"
						type="text" placeholder="搜索商家美食...">
				</form>
				<a href="#" class="search_icon"> <svg class="icon_search"
						aria-hidden="true">
  					<use xlink:href="#icon-sousuo"></use>
				</svg>
				</a>
			</div>
		</div>
		<!-- 商家店铺盒子 -->

		<div class="shop_box">
			<c:forEach items="${list}" var="b">
				<a
					href="${pageContext.request.contextPath }/product/list.action?bid=${b.bid}&currPage=1"
					class="shop_item">
					<div class="shop_img_box">
						<img src="/${businessImgServer}${b.imgurl}">
					</div>
					<div class="shop_text_box">
						<span class="shop_name">${b.name }</span> <span class="carriage">配送费¥6</span>
					</div>
					<div class="shop_detail">
						<!-- 细节展示 -->
						<span class="shop_name">${b.name }</span> <span class="shop_type">简餐</span>
						<span class="shop_type">烧腊饭</span>
						<div class="boundary"></div>
						<!-- 分界线 -->
						<div class="tips">
							<span class="carriage">优惠配送费</span> <span class="time">平均42分钟送达</span>
						</div>
						<span class="remark">${b.notice}</span>
						<!-- 三角形 -->
						<div class="shop_detail_triangle"></div>
						<!-- 白色三角形 -->
						<div class="shop_detail_triangle_white"></div>
					</div>
				</a>
			</c:forEach>
		</div>

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
				<div class="list_top" id="list_top">
					<span>1号购物车</span> <span id="delete" class="delete">[清空]</span>
				</div>
				<ul id="list_center" class="list_center">
					<li class="list_item"><span class="food_name">柱侯牛腩汤面（捞）</span>
						<span class="quantity"> <span class="sub">-</span> <input
							class="quan_input" type="text" value="1"> <span
							class="plus">+</span>
					</span> <span class="price">18</span></li>
					<li class="list_item"><span class="food_name">柱侯牛腩汤面（捞）</span>
						<span class="quantity"> <span class="sub">-</span> <input
							class="quan_input" type="text" value="1"> <span
							class="plus">+</span>
					</span> <span class="price">18</span></li>
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
					onclick="javascript:location.href='${pageContext.request.contextPath}/buyer/submit.action'">去结算</button>
			</div>
		</div>
	</div>
</body>

<script src="${pageContext.request.contextPath }/user/js/iconfont.js"></script>
<script src="${pageContext.request.contextPath }/user/js/index.js"></script>
</html>