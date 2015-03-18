function saveClick(obj) {
//	userName  姓名
//	userCard  身份证号
//	card01    第一张
//	card02	  第二张	
	var userName = document.getElementById('userName');
	var userCard = document.getElementById('userCard');    

    if (userName.value.length == 0){
    	alert("姓名不能为空");   	
    	return;
    }else if(userCard.value.length == 0){
//    	身份证验证
    	alert("身份证号不能为空");   	
    	return;
    }
    if(isCardNo(userCard.value) === false)
	 {
		 alert("您输入的身份证号码不正确，请重新输入");
		 return false;
	 }
    
//	alert( $('#firstCard').attr("src"));   	
//	alert( $('#secondCard').attr("src"));   	

    if($('#secondCard').attr("src") =='/esp/resources/image/order/card01.png'){
    	alert("证件照片不能为空");   	
    	return;
    }else if($('#secondCard').attr("src") =='/esp/resources/image/order/card02.png'){
    	alert("证件照片不能为空");   	
    	return;
    }
}