//点击搜索框，搜索框拉长
var search_input = document.getElementById("search_input");
search_input.onclick=function(){
	search_input.style.width = "306px";
}
//搜索框恢复
search_input.onmouseout=function(){
	search_input.style.width = "236px";
}
//鼠标悬浮向下图标时，显示下拉框
var btn_down = document.getElementById("btn_down");
var dropBox = document.getElementById("dropBox");
btn_down.onmouseenter=function(){
	dropBox.style.display = "block";
}
//鼠标离开下拉框，隐藏下拉框
dropBox.onmouseleave=function(){
	dropBox.style.display = "none";
}
//显示外卖店家细节
var shop_item = document.getElementsByClassName("shop_item");
var shop_detail = document.getElementsByClassName("shop_detail");
var shop_detail_triangle = document.getElementsByClassName("shop_detail_triangle");
var shop_detail_triangle_white = document.getElementsByClassName("shop_detail_triangle_white");
for(let i=0,shop_len=shop_item.length;i<shop_len;i++){
	shop_item[i].onmouseenter=function(){
		if(i%4==0){//外卖细节框的方向在右边
			shop_detail[i].classList.add("detail_right");
			shop_detail_triangle[i].classList.add("shop_detail_triangle_right");
			shop_detail_triangle_white[i].classList.add("shop_detail_triangle_white_right");
			
		}else{
			shop_detail[i].classList.add("detail_left");
			shop_detail_triangle[i].classList.add("shop_detail_triangle_left");
			shop_detail_triangle_white[i].classList.add("shop_detail_triangle_white_left");
		}
		shop_detail[i].style.display="block";
	}
}
//隐藏外卖细节
for(let i=0,shop_len=shop_item.length;i<shop_len;i++){
	shop_item[i].onmouseleave=function(){
		shop_detail[i].style.display="none";
	}
}
//点击侧边条，侧边栏展示
var sidebar_tabs = document.getElementById("sidebar_tabs");
sidebar_tabs.onclick=function(){
	sidebar.style.right="0px";
}

//点击返回按钮，侧边栏收起
var btn_return = document.getElementById("btn_return");
var sidebar = document.getElementById("sidebar");
btn_return.onclick=function(){
	sidebar.style.right="-295px";
}
//显示加减按钮
var list_item = document.getElementsByClassName("list_item");
var quan_input = document.getElementsByClassName("quan_input");
var plus = document.getElementsByClassName("plus");
var sub = document.getElementsByClassName("sub");
var price = document.getElementsByClassName("price");
var len = quan_input.length;
var show_plus_btn =	function(){
	for(let i=0;i<len;i++){
	list_item[i].onmouseover=function(){
		plus[i].style.opacity = "1";
		sub[i].style.opacity = "1";
	}
	}
}
show_plus_btn();
//隐藏加减按钮

var hidden_plus_btn = function(){
	for(let i=0;i<len;i++){
	list_item[i].onmouseout=function(){
		plus[i].style.opacity = "0";
		sub[i].style.opacity = "0";
	}
	}
} 
hidden_plus_btn();

//加按钮

var plus_btn_click = function(){
	for(let i=0;i<len;i++){
	plus[i].onclick=function(){
		//计算单价
		var unit_price = parseInt(price[i].innerHTML)/parseInt(quan_input[i].value);
		var new_value = parseInt(quan_input[i].value)+1;
		quan_input[i].value = new_value;
		price[i].innerHTML = unit_price*new_value;
	}
	}
} 
plus_btn_click();
//减按钮
var list_center = document.getElementById("list_center");
var sub_btn_click = function(){
	for(let i=0;i<len;i++){
		sub[i].onclick=function(){
			//计算单价
			var old_value = parseInt(quan_input[i].value);
			//若数量小于等于1，按减按钮清除,并重新获取相关元素
			if(old_value<=1){			
				list_center.removeChild(list_item[i]);
				list_item = document.getElementsByClassName("list_item");
				quan_input = document.getElementsByClassName("quan_input");
				plus = document.getElementsByClassName("plus");
				sub = document.getElementsByClassName("sub");
				price = document.getElementsByClassName("price");
				len = quan_input.length;
				show_plus_btn();
				hidden_plus_btn();
				plus_btn_click();
				sub_btn_click();
				clear_fun();
				return;
			}

			var unit_price = parseInt(price[i].innerHTML)/old_value;
			var new_value = parseInt(quan_input[i].value)-1;
			quan_input[i].value = new_value;
			price[i].innerHTML = unit_price*new_value;
		}
	}
}
sub_btn_click();
//清空按钮
var sidebar_content = document.getElementById("sidebar_content");
var car_list = document.getElementById("car_list");
var car_delete = document.getElementById("delete");
var list_bottom = document.getElementById("list_bottom");
car_delete.onclick=function(){
	sidebar_content.removeChild(car_list);
	list_bottom.parentNode.removeChild(list_bottom);
}
//如果没有订单，删除购物车顶部,及底部
function clear_fun(){
if(! list_center.getElementsByTagName("li")[0]){
	car_list.parentNode.removeChild(car_list);
	list_bottom.parentNode.removeChild(list_bottom);

}
}
clear_fun();


// //计算购物车总数，总价
// var bottom_quantity = document.getElementById("bottom_quantity");
// var bottom_count = document.getElementById("bottom_count");



