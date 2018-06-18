//我的订单，地址管理选项卡切换
var order_sidebar_item = document.getElementsByClassName("order_sidebar_item");
var order_item = document.getElementsByClassName("order_item");
for(let i=0,len=order_sidebar_item.length;i<len;i++){
	order_sidebar_item[i].onclick=function(){
		for(let j=0,len=order_sidebar_item.length;j<len;j++){
			order_item[j].style.display = "none";
		}
		order_item[i].style.display = "inline-block";
	}
}


//地址删除按钮
var delete_fun = function(){
	var delete_btn = document.getElementsByClassName("delete_btn");
	var location_con_item =document.getElementsByClassName("location_con_item");
	var location_verify_box= document.getElementsByClassName("location_verify_box");
	var verify_yes = document.getElementsByClassName("verify_yes");
	var verify_no = document.getElementsByClassName("verify_no");
	for(let i=0,len=delete_btn.length;i<len;i++){
		delete_btn[i].onclick = function(){
			location_verify_box[i].style.display = "block";
			verify_no[i].onclick = function(){
				location_verify_box[i].style.display = "none";
			}
			verify_yes[i].onclick = function(){
				location_con_item[i].parentNode.removeChild(location_con_item[i]);
				delete_fun();

			}
			
		}
	}
}
delete_fun();


//地址修改按钮,弹出修改表单

var zhezhao = document.getElementById("zhezhao");
var modify_btn = document.getElementsByClassName("modify_btn");
var adressdialog_modify = document.getElementById("adressdialog_modify");
var body = document.getElementById("body");
var order_location = document.getElementsByClassName("order_location");
var mess_name = document.getElementsByClassName("mess_name");
var mess_sex =document.getElementsByClassName("mess_sex");
var mess_loca = document.getElementsByClassName("mess_loca");
var mess_phone = document.getElementsByClassName("mess_phone");
var name_inp = document.getElementById("name_inp");
var sex_male_inp = document.getElementById("sex_male_inp");
var sex_female_inp = document.getElementById("sex_female_inp");
var loca_inp = document.getElementById("loca_inp");
var phone_inp = document.getElementById("phone_inp");
for(let i=0,len=modify_btn.length;i<len;i++){
	modify_btn[i].onclick = function(){
		zhezhao.style.display = "block";
		adressdialog_modify.style.display = "block";
		//将信息填入表单中		
		name_inp.value = mess_name[i].innerHTML;
		loca_inp.value = mess_loca[i].innerHTML;
		phone_inp.value = mess_phone[i].innerHTML;
		if(mess_sex[i].innerHTML=="先生"){
			sex_male_inp.checked = "true";
		}else{
			sex_female_inp.checked = "true";
		}		
	} 
}	



//弹出层关闭按钮
var modify_close_btn = document.getElementById("modify_close_btn");

modify_close_btn.onclick = function close_modify_fun(){
	adressdialog_modify.style.display = "none";
	zhezhao.style.display = "none";	
}

//弹出地址添加表单
var location_add_item = document.getElementById("location_add_item");
var adressdialog_add = document.getElementById("adressdialog_add");
location_add_item.onclick = function(){
	zhezhao.style.display = "block";
	adressdialog_add.style.display = "block";
}

//关闭添加地址弹出层
var add_close_btn = document.getElementById("add_close_btn");
add_close_btn.onclick = function(){
	zhezhao.style.display = "none";
	adressdialog_add.style.display = "none";
}



	

