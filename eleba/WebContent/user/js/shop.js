//显示店家信息框
var shop_info = document.getElementById("shop_info");
var shop_info_extra = document.getElementById("shop_info_extra");
shop_info.onmouseover = function() {
	shop_info_extra.style.display = "block";
}
// 隐藏店家信息框
shop_info.onmouseout = function() {
	shop_info_extra.style.display = "none";
}
// 食物，评价选项卡
var shop_main_tab_item = document.getElementsByClassName("shop_main_tab_item");
var shop_main_left_item = document
		.getElementsByClassName("shop_main_left_item");
for (let i = 0, len = shop_main_tab_item.length; i < len; i++) {
	shop_main_tab_item[i].onclick = function() {
		for (let j = 0, len_2 = shop_main_tab_item.length; j < len_2; j++) {
			shop_main_left_item[j].style.display = "none";
		}
		shop_main_left_item[i].style.display = "block";
	}
}

// 显示加减框
var food_item_button = document.getElementsByClassName("food_item_button");
var food_item_choose = document.getElementsByClassName("food_item_choose");
var food_item_choose_sub = document
		.getElementsByClassName("food_item_choose_sub");
var food_item_choose_plus = document
		.getElementsByClassName("food_item_choose_plus");
var food_item_choose_inp = document
		.getElementsByClassName("food_item_choose_inp");
for (let i = 0, len = food_item_button.length; i < len; i++) {
	food_item_button[i].onclick = function() {
		food_item_button[i].style.display = "none";
		var pid=food_item_button[i].id
		
		 $.post("/eleba/cart/addCart.action",{'pid':pid},function(result){
		        console.log(result);
		    },'json');
		
		
		food_item_choose[i].style.display = "inline-block";
	}
}
// 减按钮
for (let i = 0, len = food_item_button.length; i < len; i++) {
	food_item_choose_sub[i].onclick = function() {
		if (food_item_choose_inp[i].value <= 1) {
			food_item_button[i].style.display = "inline-block";
			food_item_choose[i].style.display = "none";
			return;
		}
		
		var pid=food_item_choose_sub[i].id;
		pid=pid.substring(0,pid.length-1);
		
		 $.post("/eleba/cart/addCart.action",{'count':'-1','pid':pid},function(result){
		        console.log(result);
		    },'json');
		
		food_item_choose_inp[i].value = parseInt(food_item_choose_inp[i].value) - 1;
	}
}
// 加按钮
for (let i = 0, len = food_item_button.length; i < len; i++) {
	food_item_choose_plus[i].onclick = function() {
		
		var pid=food_item_choose_plus[i].id;
		pid=pid.substring(0,pid.length-1);
		
		
		 $.post("/eleba/cart/addCart.action",{'pid':pid},function(result){
		        console.log(result);
		    },'json');
		
		food_item_choose_inp[i].value = parseInt(food_item_choose_inp[i].value) + 1;
	}
}

// 评价选项卡
var shop_comment_tab_item = document
		.getElementsByClassName("shop_comment_tab_item");
var shop_comment_list = document.getElementsByClassName("shop_comment_list");
for (let i = 0, len = shop_comment_tab_item.length; i < len; i++) {
	shop_comment_tab_item[i].addEventListener("click", addcart);
	function addcart() {
		for (let j = 0, len_2 = shop_comment_tab_item.length; j < len_2; j++) {
			shop_comment_list[j].style.display = "none";
		}
		shop_comment_list[i].style.display = "block";
	}
}
