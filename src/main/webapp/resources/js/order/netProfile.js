function saveClick(obj) {
//	userName  姓名
//	userCard  身份证号
//	card01    第一张
//	card02	  第二张	
	var userName = document.getElementById('userName');
	var userCard = document.getElementById('userCard');  
	var card01 = document.getElementById('card01');   
	var card02 = document.getElementById('card02');   

    if (userName.value.length == 0){
    	alert("姓名不能为空");   	
    	return;
    }else if(userCard.value.length == 0){
//    	身份证验证
    	alert("身份证号不能为空");   	
    	return;
    }
	alert($("card01").attr("src").length);   	

//    if(card01.attr("src").length==0){
//    	alert("证件照片不能为空");   	
//    	return;
//    }else if(card02.attr("src").length==0){
//    	alert("证件照片不能为空");   	
//    	return;
//    }
    
	alert("111");   	

//	alert("姓名:"+userName.value + "卡号"+ userCard.value ); 	
	
	//弹出去，重新加载数据库。
}