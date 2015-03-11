function doneClick(obj) {
//	getElementById

//  设置属性。
 var storeName = document.getElementById("storeName");
 if (storeName.value.length !== 0){
	 alert(storeName.value);
 }else{
	 alert("店名不能为空");
	 return;
 }
 
 var phoneNum = document.getElementById("phoneNum");
 if (phoneNum.value.length !== 0){
	 alert(phoneNum.value);
 }else{
	 alert("联系方式不能为空");
	 return;
 }
 
 alert(storeName.value + phoneNum.value);

 
}