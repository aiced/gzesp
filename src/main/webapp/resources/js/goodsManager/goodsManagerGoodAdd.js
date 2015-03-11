function showFlowView(whichpic) {
// alert("I am an alert box!!");
//	getElementById
  var aMark = document.getElementById("searchMark");
  if (aMark.style.display == "none"){
	  aMark.style.display = "block";
   }else{
	   aMark.style.display = "none";
  }
//  设置属性。
  
}

function showSelectedView(obj) {
//		getElementById
//	  var aMark = document.getElementById("itemSelected");
	//进行数组的元素个数判断，大于4返回。
	
	
	var id = "leftItemSelected_" + obj;
	var aMark = document.getElementById(id);
	  if (aMark.style.display == "none"){
		  aMark.style.display = "block";
	   }else{
		   aMark.style.display = "none";
	  }
	 //  从新设置数组元素
	  resetSelecedArr(obj);
	  
}

function resetSelecedArr(obj) {

}


