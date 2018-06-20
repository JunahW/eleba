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


//只显示一个地址框
var location_box_item = document.getElementsByClassName("location_box_item");
function shoe_only_laction(){	
	for(let i=1,len=location_box_item.length;i<len;i++){
		location_box_item[i].style.display="none";
	}
}
shoe_only_laction();

//点击按钮 显示或收起
var show_more_btn = document.getElementById("show_more_btn");
show_more_btn.onclick = function(){
	if(show_more_btn.innerText == "显示更多地址>"){
		for(let i=1,len=location_box_item.length;i<len;i++){
			location_box_item[i].style.display="block";
		}
		show_more_btn.innerText = "收起>";
	}else{
		for(let i=1,len=location_box_item.length;i<len;i++){
			location_box_item[i].style.display="none";
		}
		show_more_btn.innerText = "显示更多地址>";
	}
}

//选中地址框，改变边框颜色
for(let i=0,len=location_box_item.length;i<len;i++){
	location_box_item[i].onclick = function(){
		for(let j=0,len=location_box_item.length;j<len;j++){
			location_box_item[j].style.border = " 1px solid #eee";
		}
		location_box_item[i].style.border = "1px solid #0089dc";
	}
}






