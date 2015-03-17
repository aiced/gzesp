// 点击关键字搜索按钮
function searchWord(obj) {
//	搜索框：searchInput
	var aMark = document.getElementById('searchInput');
    if (aMark.value.length == 0){
    	alert("请输入搜索条件");   	
    	return;
    }    
	alert("正在搜索关键字" + aMark.value);   	
}


//显示筛选条件
function showFlowView(whichpic) {
// alert("I am an alert box!!");
//	getElementById
  var aMark = document.getElementById("searchMark");
  if (aMark.style.display == "none"){
	  aMark.style.display = "block";
   }else{
	   aMark.style.display = "none";
  }  
}

//	综合排序
function multipleSoft(obj) {
	alert('综合排序');   	

}


// 是否选择对号
function showSelectedView(obj,list_size) {
	var id = "leftItemSelected_" + obj;
	if(getComputedStyle(document.getElementById(id)).visibility == "hidden"){
        document.getElementById(id).style.visibility = "visible";
	}else{
        document.getElementById(id).style.visibility = "hidden";		
	}
	
	//清空所有的数据列表
//	alert('obj'+obj + 'list_size'+list_size);
	for(var i = 0;i<list_size;i++){
		if(i== obj){
			continue;
		}
		var id = "leftItemSelected_" + i;
		if (getComputedStyle(document.getElementById(id)).visibility == "visible"){
			document.getElementById(id).style.visibility = "hidden";
		   }
	}	
	


	 //  从新设置数组元素，没有加入，有删除。
	  
}




// 点击确定，重置
function searchPrice(obj) {
//	奖励区间开始：startInput
//	奖励区间结束：endInput	
	var startInput = document.getElementById('startInput');
	var endInput = document.getElementById('endInput');
    if (startInput.value.length == 0){
    	alert("起始价格不能为空");   	
    	return;
    }else if(endInput.value.length == 0){
    	alert("终止价格不能为空");   	
    	return;
    }else if(startInput.value >= endInput.value){
    	alert("起始价格 要小于 终止价格");   	
    	return;
    }
	alert("起始价格:"+startInput.value + "终止价格："+ endInput.value );   	

}

function resetPrice(obj) {
	var startInput = document.getElementById('startInput');
	startInput.value = null;
	var endInput = document.getElementById('endInput');
	endInput.value = null;
}

//  选择类型：
//1:新网入号;
//2:合约购机
//3:上网卡
//4:特色流量包
//5:宽带预约
function setTagCondition(obj) {
	alert('点击了'+ obj);   	
}


