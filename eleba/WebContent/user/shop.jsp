<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/public.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/user/css/shop.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/user/js/jquery.min.js"></script>
<title>商家</title>
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
	<!-- 头部 -->
	<div class="shop_top">
		<div class="shop_top_contain">
			<div id="shop_info" class="shop_info">
				<img class="shop_info_image" src="/${businessImgServer}${b.imgurl}">
				<div class="shop_info_nama">${b.name}</div>
				<div id="shop_info_extra" class="shop_info_extra">
					<div class="shop_info_grade">
						<span>4.1分</span> <span>综合评价</span> <span>高于周边商家<em>31.4</em></span>
					</div>
					<div class="shop_info_desc">${b.description}</div>
					<div class="shop_info_adress">
						<span>商家地址： 广州市越秀区八旗二马路72号之一至之三首层自编1号</span> <span>营业时间：
							10:00-20:30</span>
					</div>
					<div class="shop_info_delivery">
						由<span>金牌隆江猪脚饭(八旗二马路店)</span>提供配送服务
					</div>
				</div>
			</div>

			<div class="shop_server">
				<span class="shop_server_price"> <em>起送价</em> <em>20元</em>
				</span> <span class="shop_server_carrige"> <em>配送费</em> <em>优惠配送费</em>
				</span> <span class="shop_server_time"> <em>平均送达速度</em> <em>34分钟</em>
				</span>
			</div>
		</div>
	</div>
	<div class="shop_main">
		<div id="shop_main_left" class="shop_main_left">
			<ul class="shop_main_tab">
				<li class="shop_main_tab_item">所有商品</li>
				<li class="shop_main_tab_item">评价</li>
			</ul>
			<!-- 食物 -->

			<div class="shop_food shop_main_left_item">
				<c:forEach items="${list}" var="p">
					<div class="shop_food_item">
						<img class="food_item_image" src="/${productImgServer}${p.pimage}">
						<div class="food_item_message">
							<span>${p.pname}</span> <span>¥${p.price}</span>
						</div>
						<div class="food_item_button" id="${p.pid}"
							onclick="add2cart(${p.pid})">加入购物车</div>
						<div class="food_item_choose">
							<span class="food_item_choose_sub" id="${p.pid}-">-</span> <input
								class="food_item_choose_inp" type="rext" name="" value="1">
							<span class="food_item_choose_plus" id="${p.pid}+">+</span>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- 评价 -->
			<div class="shop_comment shop_main_left_item">
				<ul class="shop_comment_tab">
					<li class="shop_comment_tab_item">全部</li>
					<li class="shop_comment_tab_item">满意</li>
					<li class="shop_comment_tab_item">不满意</li>
					<li class="shop_comment_tab_item">有图</li>
				</ul>
				<ul class="shop_comment_list comment_all">
					<li class="shop_comment_list_item">
						<div class="comment_list_item_top">
							<img class="comment_image" src="image/me.png">
							<ul class="comment_mess">
								<li>匿**户</li>
								<li>
									<ul class="comment_icon_list">
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<!-- <li class="comment_text comment_mess_active">惊喜</li> -->
									</ul> <span class="comment_text comment_mess_active">惊喜</span> <span>70分钟送达</span>
								</li>
								<li></li>
							</ul>
							<span class="comment_time">2018-08-11 12:00:00</span>
						</div>
						<ul class="comment_food_list">
							<li class="comment_food_list_item"><span>芝麻八爪寿司（单件）</span>
								<ul class="comment_food_icon_list">
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon"></li>
								</ul> <span class="food_icon_active">满意</span></li>
							<li class="comment_food_list_item"><span>芝麻八爪寿司（单件）</span>
								<ul class="comment_food_icon_list">
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon"></li>
								</ul> <span class="food_icon_active">满意</span></li>
							<li class="comment_food_list_item"><span>芝麻八爪寿司（单件）</span>
								<ul class="comment_food_icon_list">
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon"></li>
								</ul> <span class="food_icon_active">满意</span></li>
						</ul>
					</li>
					<li class="shop_comment_list_item">
						<div class="comment_list_item_top">
							<img class="comment_image" src="image/me.png">
							<ul class="comment_mess">
								<li>匿**户</li>
								<li>
									<ul class="comment_icon_list">
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<li class="heart-solid icon com_icon_active"></li>
										<!-- <li class="comment_text comment_mess_active">惊喜</li> -->
									</ul> <span class="comment_text comment_mess_active">惊喜</span> <span>70分钟送达</span>
								</li>
								<li></li>
							</ul>
							<span class="comment_time">2018-08-11 12:00:00</span>
						</div>
						<ul class="comment_food_list">
							<li class="comment_food_list_item"><span>芝麻八爪寿司（单件）</span>
								<ul class="comment_food_icon_list">
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon"></li>
								</ul> <span class="food_icon_active">满意</span></li>
							<li class="comment_food_list_item"><span>芝麻八爪寿司（单件）</span>
								<ul class="comment_food_icon_list">
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon"></li>
								</ul> <span class="food_icon_active">满意</span></li>
							<li class="comment_food_list_item"><span>芝麻八爪寿司（单件）</span>
								<ul class="comment_food_icon_list">
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon food_icon_active"></li>
									<li class="heart-solid icon"></li>
								</ul> <span class="food_icon_active">满意</span></li>
						</ul>
					</li>
				</ul>
				<ul class="shop_comment_list comment_good">
				</ul>
				<ul class="shop_comment_list comment_bad">
				</ul>
				<ul class="shop_comment_list comment_pic">
				</ul>
			</div>
		</div>
		<div class="shop_main_right">
			<div class="shop_main_right_title">商家公告</div>
			<div class="shop_main_right_ps">${b.notice}</div>
			<div class="shop_main_right_carrige">
				<span>配送费说明</span> <span>配送费¥4</span>
			</div>
			<div class="shop_main_right_repor">举报商家</div>


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
				<div class="list_top">
					<span>1号购物车</span> <span id="delete" class="delete">[清空]</span>
				</div>
				<ul id="list_center" class="list_center">
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
<script type="text/javascript">
	function add2cart(pid) {
		alert("1111");
		alert(pid);
	}
</script>

<script src="${pageContext.request.contextPath }/user/js/iconfont.js"></script>
<script src="${pageContext.request.contextPath }/user/js/shop.js"></script>
<script src="${pageContext.request.contextPath }/user/js/public.js"></script>
</html>