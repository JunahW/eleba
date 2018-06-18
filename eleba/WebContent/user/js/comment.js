
//商家服务评价
var comment_icon = document.getElementById("comment_icon");
var comment_tips = document.getElementById("comment_tips");
var comment_icon_arr = comment_icon.getElementsByTagName("li");
for(let i=0,len=comment_icon_arr.length;i<len;i++){
	comment_icon_arr[i].onclick = function comment_icon(){
		//清除样式
		for(let j=0,len2=comment_icon_arr.length;j<len2;j++){
			if(comment_icon_arr[j].classList.contains("com_icon_active")){
				comment_icon_arr[j].classList.remove("com_icon_active");			
			}	
		}
		switch(i){
			case 0:comment_tips.innerHTML = "极差";break;
			case 1:comment_tips.innerHTML = "失望";break;
			case 2:comment_tips.innerHTML = "一般";
			       comment_tips.style.color="#f3b518";
			       break;
			case 3:comment_tips.innerHTML = "满意";
   				   comment_tips.style.color="#f18b1b";
				    break;
			case 4:comment_tips.innerHTML = "惊喜";
			       comment_tips.style.color="#eb6643";
					break;
		}
		for(let k=0;k<i+1;k++){
			comment_icon_arr[k].classList.add("com_icon_active");
		}
	}
}


//菜品评价
var food_icon_item = document.getElementsByClassName("food_icon_item");
var food_icon_arr = [];
var food_tips = document.getElementsByClassName("food_tips");
for(let i=0,len=food_icon_item.length;i<len;i++){
	food_icon_arr[i] = food_icon_item[i].getElementsByTagName("li");
	
	for(let j=0,len2=food_icon_arr[i].length;j<len2;j++){
		food_icon_arr[i][j].onclick = function(){
			//清除样式
			for(let k=0;k<len2;k++){
				if(food_icon_arr[i][k].classList.contains("food_icon_active")){
					food_icon_arr[i][k].classList.remove("food_icon_active");			
				}	
			}
			for(let q=0;q<j+1;q++){
				food_icon_arr[i][q].classList.add("food_icon_active");
			}
		
			switch(j){
				case 0:food_tips[i].innerHTML = "极差";
						food_tips[i].style.color="#999";
						break;
				case 1:food_tips[i].innerHTML = "失望";
						food_tips[i].style.color="#999";
						break;
				case 2:food_tips[i].innerHTML = "一般";
				       food_tips[i].style.color="#f3b518";
				       break;
				case 3:food_tips[i].innerHTML = "满意";
	   				   food_tips[i].style.color="#f18b1b";
					    break;
				case 4:food_tips[i].innerHTML = "惊喜";
				       food_tips[i].style.color="#eb6643";
						break;
		}
		}
	}

}






