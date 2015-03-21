
     $(document).ready(function(){
       
       //添加tabslist 选项的点击事件
       $('.tabslist li').click(function(){
         if( $(this).hasClass('tab-on') ){
           //如果该选项已经被选中，返回
           return false;
         }
         //如果没被选中，则更改为选中的样式 ,其他兄弟元素更改为没选项中样式 
         $(this).addClass('tab-on'); 
         $(this).siblings().removeClass('tab-on');
       });
       
       //激活图文详情页面tab导航
       $('#myTab a').click(function (e) {
          e.preventDefault();
          $(this).tab('show');
	    });
	    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	          e.target // newly activated tab
	          e.relatedTarget // previous active tab
	          //$(this).css('background-color', '#ffa200');
	          //$(e.relatedTarget).css('background-color', '#f4f4f4');
	        });       
       
     });
     
	    
//地市筛选触发事件
function cityFilter()
{
	//alert($(event.srcElement).attr('city_code'));
	//将下拉选项的文字赋值给按钮
	//$('#btnCity span').before($(event.srcElement).html());
	$('#btnCity').html($(event.srcElement).html() + '<span class="caret"></span>');
	//ajax刷新筛选结果
}

//子页面显示 隐藏其他子页面和主页面
function showSubpage(pageId){
    //控制图文详情div 隐藏与显示 
      $('#' + pageId).show(); //图文详情页展示
      //$('#page_main').hide(); //主页面隐藏
      $('#' + pageId).siblings().hide();//隐藏其他兄弟页面包括主页面
}

//回到主页面 隐藏子页面
function back2Main(){
    $('#page_main').show(); //主页面显示
    $('div[id *= subpage_]').hide(); //subpage_ 开头的id的div页面隐藏
 }


//新号入网 商品详情页面 立即购买 按钮跳转到订单填写页面
function planGotoOrderMain(){
    var attr_val = getAttrVal(); //获取所有被选中的属性的值，拼串
    attr_val += '^' + $('#serial_number').attr('attr_val'); //再加上号码属性
	$('#attrs').val(attr_val); 
	$('#form1').submit();
	//alert($('#attrs').val());
}

//合约购机 商品详情页面 新号入网 按钮跳转到订单填写页面
function phoneGotoOrderMainNew(){
    var attr_val = getAttrVal();
	$('#attrs').val(attr_val); 
	$('#form1').attr('action', $('#form1').attr('url1')); //替换action路径，新号和老用户跳转路径不一样
	$('#form1').submit();
	//alert($('#attrs').val());
}

//合约购机 商品详情页面 老用户办理 按钮跳转到订单填写页面
function phoneGotoOrderMainOld(){
	var attr_val = getAttrVal();
	$('#attrs').val(attr_val); 
	$('#form1').attr('action', $('#form1').attr('url2')); //替换action路径，新号和老用户跳转路径不一样
	$('#form1').submit();
	//alert($('#attrs').val());
}

//获取所有被选中的属性的值，拼串 
function getAttrVal(){
	var attr_val = "";
	$('.tab-on').each(function(i){
		 attr_val += $(this).attr('attr_val'); //^分割,|分割
		 if(i < $('.tab-on').length -1){
				attr_val += '^'; //^分割,|分割
			}
		});
    return attr_val;
}

//选择号码页面 点击号码 预占号码后的 自定义回调函数
function afterUpdateNumber(data){
	if(data.status == 'SUCCESS'){
		$('#serial_number').html(data.serial_number); //赋值给父页面里的某个 标签属性
		$('#serial_number').attr('attr_val',  $('#serial_number').attr('attr_val') + data.serial_number + '|' + data.serial_number);
		back2Main(); //回到主页面 隐藏子页面
	}
	else{
		
	}
}
