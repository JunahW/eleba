<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/public.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/order.css">
<title>我的订单</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/user/js/jquery.min.js"></script>
</head>
<body id="body">
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
		<ul class="order_sidebar">
			<li class="order_sidebar_item"><svg class="order_sidebar_icon"
					aria-hidden="true">
			<use xlink:href="#icon-single"></use></svg> 我的订单</li>
			<li class="order_sidebar_item"><svg class="order_sidebar_icon"
					aria-hidden="true">
			<use xlink:href="#icon-dizhi"></use></svg> 地址管理</li>
		</ul>
		<!-- 所有订单 -->
		<div class="order_item order_box">
			<div class="order_box_top">我的所有订单</div>
			<table class="order_box_con">
				<thead>
					<tr>
						<th>下单时间</th>
						<th class="thead_order_con">订单内容</th>
						<th></th>
						<th>支付金额(元)</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="order">
						<tr class="order_tr">
							<td class="order_time"><fmt:formatDate
									value="${order.ordertime}" pattern="yyyy-MM-dd" /></td>
							<td class="order_shop_image"><img class=""
								src="image/shop.png"></td>
							<td class="order_info">
								<p class="order_info_food">
									<span class="order_info_food_list">豆干2份 </span> <span
										class="food_quantity"></span>菜品
								</p>
								<p claa="order_no">${order.oid}</p>
							</td>
							<td class="order_amount">${order.total}</td>
							<td class="order_status"><c:if test="${order.state==0}">等待发货</c:if>
								<c:if test="${order.state==1}">等待送达</c:if> <c:if
									test="${order.state==2}">已送到，去评价</c:if></td>
							<td class="order_detail"><a
								href="${pageContext.request.contextPath }/buyer/detail.action?oid=${order.oid}"><span
									class="order_detail_btn">订单详情</span></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<!-- 地址管理 -->
		<div class="order_item order_location">
			<div class="order_location_top">地址管理</div>
			<ul class="order_location_con">
				<li class="location_con_item">
					<ul class="location_mess_list">
						<li class="mess_name">1翁俊河</li>
						<li class="mess_sex">先生</li>
						<li class="mess_loca">仲恺</li>
						<li class="mess_phone">13602286536</li>
					</ul>
					<div class="location_btn modify_btn">修改</div>
					<div class="location_btn delete_btn">删除</div>
					<div class="location_verify_box">
						<span class="verify_quesion">确定删除收货地址?</span> <span
							class="verify_answer verify_yes">确定</span> <span
							class="verify_answer verify_no">取消</span>
					</div>
				</li>
				<li class="location_con_item">
					<ul class="location_mess_list">
						<li class="mess_name">1翁俊河</li>
						<li class="mess_sex">女士</li>
						<li class="mess_loca">仲恺</li>
						<li class="mess_phone">13602286536</li>
					</ul>
					<div class="location_btn modify_btn">修改</div>
					<div class="location_btn delete_btn">删除</div>
					<div class="location_verify_box">
						<span class="verify_quesion">确定删除收货地址?</span> <span
							class="verify_answer verify_yes">确定</span> <span
							class="verify_answer verify_no">取消</span>
					</div>
				</li>
				<li class="location_con_item">
					<ul class="location_mess_list">
						<li class="mess_name">1翁俊河</li>
						<li class="mess_sex">先生</li>
						<li class="mess_loca">仲恺</li>
						<li class="mess_phone">13602286536</li>
					</ul>
					<div class="location_btn modify_btn">修改</div>
					<div class="location_btn delete_btn">删除</div>
					<div class="location_verify_box">
						<span class="verify_quesion">确定删除收货地址?</span> <span
							class="verify_answer verify_yes">确定</span> <span
							class="verify_answer verify_no">取消</span>
					</div>
				</li>
				<li class="location_con_item">
					<ul class="location_mess_list">
						<li class="mess_name">1翁俊河</li>
						<li class="mess_sex">先生</li>
						<li class="mess_loca">广州仲恺 建中路12号</li>
						<li class="mess_phone">13602286536</li>
					</ul>
					<div class="location_btn modify_btn">修改</div>
					<div class="location_btn delete_btn">删除</div>
					<div class="location_verify_box">
						<span class="verify_quesion">确定删除收货地址?</span> <span
							class="verify_answer verify_yes">确定</span> <span
							class="verify_answer verify_no">取消</span>
					</div>
				</li>
				<li class="location_con_item location_add_item"
					id="location_add_item">+添加新地址</li>
			</ul>
		</div>
	</div>
	<!-- 修改表单弹出层 -->
	<div id="adressdialog_modify" class="adressdialog">
		<div class="adressdialog_top">编辑地址</div>
		<div class="adressform">
			<div class="adressform_item">
				<label>姓名</label><input id="name_inp" type="text"
					placeholder="请输入您的姓名" name="">
			</div>
			<div class="adressform_item">
				<label>性别</label> <input class="form_radio" id="sex_male_inp"
					type="radio"><label>先生</label> <input class="form_radio"
					id="sex_female_inp" type="radio"><label>女士</label>
			</div>
			<div class="adressform_item">
				<label>地址</label><input id="loca_inp" type="text"
					placeholder="请输入您的详细地址" name="">
			</div>
			<div class="adressform_item">
				<label>手机号</label><input id="phone_inp" type="text"
					placeholder="请输入您的手机号码" name="">
			</div>
		</div>
		<div class="adressdialog_bottom">
			<span class="from_btn from_yes">保存</span> <span
				class="from_btn from_no">取消</span>
		</div>
		<!-- 关闭按钮 -->
		<div id="modify_close_btn">+</div>
	</div>

	<!-- 添加新地址弹出层 -->
	<div id="adressdialog_add" class="adressdialog">
		<div class="adressdialog_top">添加新地址</div>
		<div class="adressform">
			<div class="adressform_item">
				<label>姓名</label><input id="name_inp" type="text"
					placeholder="请输入您的姓名" name="">
			</div>
			<div class="adressform_item">
				<label>性别</label> <input class="form_radio" id="sex_male_inp"
					type="radio"><label>先生</label> <input class="form_radio"
					id="sex_female_inp" type="radio"><label>女士</label>
			</div>
			<div class="adressform_item">
				<label>地址</label><input id="loca_inp" type="text"
					placeholder="请输入您的详细地址" name="">
			</div>
			<div class="adressform_item">
				<label>手机号</label><input id="phone_inp" type="text"
					placeholder="请输入您的手机号码" name="">
			</div>
		</div>
		<div class="adressdialog_bottom">
			<span class="from_btn from_yes">保存</span> <span
				class="from_btn from_no">取消</span>
		</div>
		<!-- 关闭按钮 -->
		<div id="add_close_btn">+</div>
	</div>
	<div id="zhezhao"></div>
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
					onclick="javascript:location.href='${pageContext.request.contextPath}/cart/submit.action'">去结算</button>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath }/user/js/public.js"></script>
<script src="${pageContext.request.contextPath }/user/js/order.js"></script>
<script src="${pageContext.request.contextPath }/user/js/iconfont.js"></script>
</html>