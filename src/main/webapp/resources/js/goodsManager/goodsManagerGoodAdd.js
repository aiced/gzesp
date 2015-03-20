// 点击关键字搜索按钮
function searchWord(obj) {
//	搜索框：searchInput
	var searchKey = document.getElementById('searchInput');
    if (searchKey.value.length == 0){
		window.location.reload(); 
    	return;
    }   
	var searchKey = $('#searchInput').val();
	var param = {"searchKey":searchKey};

	$.ajax({
		   type: "POST",
		   url: "queryGoodsByAjax",
		   data: param,
		   success: function(data){
			   //alert(data);
		     $('#datagrid').html(data);
		   }
		});	

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
	   var startInput = document.getElementById('searchInput');
	   startInput.value = null;
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
	var searchLowPrice = startInput.value;
	var searchHightPrice = endInput.value;
 	alert("起始价格:"+searchLowPrice + "终止价格："+ searchHightPrice );   	

    var param = {"searchLowPrice":searchLowPrice,"searchHightPrice":searchHightPrice};
	$.ajax({
		   type: "POST",
		   url: "queryGoodsByAjax",
		   data: param,
		   success: function(data){
		     $('#datagrid').html(data);
		     showFlowView(obj);
		   }
		});
	

}



function resetPrice(obj) {
	var startInput = document.getElementById('startInput');
	startInput.value = null;
	var endInput = document.getElementById('endInput');
	endInput.value = null;
}

//  选择类型：
//1:合约购机
//2:上网卡
//3:宽带预约
//4:特色流量包
function setTagCondition(obj) {
	
	var searchType = obj;
    var param = {"searchType":searchType};
	$.ajax({
		   type: "POST",
		   url: "queryGoodsByAjax",
		   data: param,
		   success: function(data){
		     $('#datagrid').html(data);
		     showFlowView(obj);
		   }
		});
}


