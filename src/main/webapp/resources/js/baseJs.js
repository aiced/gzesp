/**
 * @author 文辉
 */

$(document).ready(function(){  
   //[返回]按钮点击
  $("#top_left").click(function(){  
  //在这里操作返回
  	history.back();
  });  

});
//校验身份证_start
//校验个人身份证
function checkEnergyCard(strPersonID){
	 var allowancePersonValue=strPersonID;
	 //是否为空
	 if(allowancePersonValue==""){
		 alert("身份证号不能空");
		 return false;
	 }
	 //校验长度，类型
	 else if(isCardNo(allowancePersonValue) === false)
	 {
		 alert("您输入的身份证号码不正确，请重新输入");
		 return false;
	 }
	 //检查省份
	 else if(checkProvince(allowancePersonValue) === false)
	 {
		 alert("您输入的身份证号码不正确，请重新输入");
		 return false;
	 }
	 //校验生日
	 else if(checkBirthday(allowancePersonValue) === false)
	 {
		 alert("您输入的身份证号码生日不正确,请重新输入");
		 return false;
	 }
	 //检验位的检测
	 else if(checkParity(allowancePersonValue) === false)
	 {
		 alert("您的身份证校验位不正确,请重新输入");
		 return false;
	 }else{
		 return true;
	 }
	}
//身份证省的编码
var vcity={ 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
        21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
        33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
        42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
        51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
        63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"
       };

//检查号码是否符合规范，包括长度，类型
function isCardNo(card){
 //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
 var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/;
 if(reg.test(card) === false){
  //alert("demo");
  return false;
 }
 return true;
}

//取身份证前两位,校验省份
function checkProvince(card){
 var province = card.substr(0,2);
 if(vcity[province] == undefined){
  return false;
 }
 return true;
}
//检查生日是否正确
function checkBirthday(card){
 var len = card.length;
 //身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字
 if(len == '15'){ 
     var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;
     var arr_data = card.match(re_fifteen);
     var year = arr_data[2];
     var month = arr_data[3];
     var day = arr_data[4];
     var birthday = new Date('19'+year+'/'+month+'/'+day);
     return verifyBirthday('19'+year,month,day,birthday);
 }
 //身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X
 if(len == '18'){
     var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
     var arr_data = card.match(re_eighteen);
     var year = arr_data[2];
     var month = arr_data[3];
     var day = arr_data[4];
     var birthday = new Date(year+'/'+month+'/'+day);
     return verifyBirthday(year,month,day,birthday);
 }
 return false;
}

//校验日期
function verifyBirthday(year,month,day,birthday){
 var now = new Date();
 var now_year = now.getFullYear();
 //年月日是否合理
 if(birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day)
 {
     //判断年份的范围（3岁到100岁之间)
     var time = now_year - year;
     if(time >= 3 && time <= 100)
     {
         return true;
     }
     return false;
 }
 return false;
}

//校验位的检测
function checkParity(card){
 //15位转18位
 card = changeFivteenToEighteen(card);
 var len = card.length;
 if(len == '18'){
     var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
     var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
     var cardTemp = 0, i, valnum;
     for(i = 0; i < 17; i ++)
     {
         cardTemp += card.substr(i, 1) * arrInt[i];
     }
     valnum = arrCh[cardTemp % 11];
     if (valnum == card.substr(17, 1))
     {
         return true;
     }
     return false;
 }
 return false;
}
//15位转18位身份证号
function changeFivteenToEighteen(card){
 if(card.length == '15')
 {
     var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
     var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
     var cardTemp = 0, i;  
     card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);
     for(i = 0; i < 17; i ++)
     {
         cardTemp += card.substr(i, 1) * arrInt[i];
     }
     card += arrCh[cardTemp % 11];
     return card;
 }
 return card;
}
//校验身份证_end
//校验银行卡号_通过ajax
//@param strBankCard 银行卡号
function checkBankCard(strBankCard)
{
	var bReturn=false;
	var param = {"BankCard":strBankCard};
	$.ajax({
		   type: "POST",
		   url: "checkBankCard",
		   data: param,
		   async: false,
		   success: function(bRet){
			   //alert(bRet);
			   if (!bRet) {
				   alert("银行卡号格式不正确，请重新输入");
				   bReturn=false;
			   }
			   else
			   {
				   bReturn=true;
			   }
		     //$('#datagrid').html(data);
		   }
		});
	return bReturn;
}
//判断手机号是否已经注册过
function  checkPhoneNum(strPhoneNum)
{
	var bReturn=false;
	var param = {"PhoneNum":strPhoneNum};
	$.ajax({
		   type: "POST",
		   url: "/esp/common/checkPhoneNum",
		   data: param,
		   async: false,
		   success: function(bRet){
			   //alert(bRet);
			   if (!bRet) {
				   alert("该手机号已经注册过");
				   bReturn=false;
			   }
			   else
			   {
				   bReturn=true;
			   }
		   }
		});
	return bReturn;
}
//判断微信号是否已经注册过
function checkWeChat(strWeChat)
{
	var bReturn=false;
	var param = {"WeChat":strWeChat};
	$.ajax({
		   type: "POST",
		   url: "/esp/common/checkWeChat",
		   data: param,
		   async: false,
		   success: function(bRet){
			   if (!bRet) {
				   alert("该微信号已经注册过");
				   bReturn=false;
			   }
			   else
			   {
				   bReturn=true;
			   }
		   }
		});
	return bReturn;
}
//倒计时发送验证码
/*-------------------------------------------*/  
var InterValObj; //timer变量，控制时间  
var count = 60; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  
var code = ""; //验证码  
var codeLength = 6;//验证码长度  
var m_btnName;
//timer处理函数  
function SetRemainTime() {  
	//alert(btnName);
    if (curCount == 0) {                  
        window.clearInterval(InterValObj);//停止计时器  
        $(m_btnName).removeAttr("disabled");//启用按钮  
        $(m_btnName).text("重新发送");  
        code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
    }  
    else {  
        curCount--;  
        $(m_btnName).text(curCount + "秒内输入验证码");  
    }  
}  
//js日期比较(yyyy-mm-dd)
function CompareDate(startDate,endDate) {
    var arr = startDate.split("-");
    var starttime = new Date(arr[0], arr[1], arr[2]);
    var starttimes = starttime.getTime();

    var arrs = endDate.split("-");
    var lktime = new Date(arrs[0], arrs[1], arrs[2]);
    var lktimes = lktime.getTime();

    if (starttimes >= lktimes) {
        return false;
    }
    else
        return true;

}
//发送验证码
function sendMessage(strPhone,btnName) {  
    curCount = count;  
    var phone=strPhone;//手机号码  
    m_btnName=btnName;
    //产生验证码  
    for (var i = 0; i < 6; i++) {  
        code += parseInt(Math.random() * 9).toString();  
    }
    //设置button效果，开始计时  
    $(m_btnName).attr("disabled", "true");  
    $(m_btnName).text(curCount + "秒内输入验证码");  
    InterValObj = setInterval("SetRemainTime()", 1000); //启动计时器，1秒执行一次  
//向后台发送处理数据  
//    $.ajax({  
//        type: "POST", //用POST方式传输  
//        dataType: "text", //数据格式:JSON  
//        url: 'Login.ashx', //目标地址  
//        data: "phone=" + phone + "&code=" + code,  
//        error: function (XMLHttpRequest, textStatus, errorThrown) { },  
//        success: function (msg){ }  
//    });  
	var bReturn=false;
	var param = {"phone":strPhone,"code":code};
	$.ajax({
		   type: "POST",
		   url: "yanzhengma",
		   data: param,
		   async: false,
		   success: function(bRet){
			   if (!bRet) {
				   alert("验证码发送失败！");
				   bReturn=false;
			   }
			   else
			   {
				   alert("验证码发送成功！");
				   bReturn=true;
			   }
		   }
		});
	return bReturn;
}  
