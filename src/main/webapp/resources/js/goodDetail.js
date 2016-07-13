     $(document).ready(function(){
       
       //添加tabslist 选项的点击事件
       $('.tabslist li').click(function(){
    	   
         //特殊判断,如果是可选叠加包,可以多选, 要有multi_select的属性才触发
         if(typeof($(this).attr('multi_select')) != 'undefined'){  
             if( $(this).hasClass('tab-on') ){
                 //如果该选项已经被选中，则取消选中
            	 $(this).removeClass('tab-on');
               }
             else{
                 //如果没被选中，则更改为选中的样式 ,其他兄弟元素不变
                 $(this).addClass('tab-on');           	 
             }

         }
         else{
             if( $(this).hasClass('tab-on') ){
                 //如果该选项已经被选中，返回
                 return false;
               }
               //如果没被选中，则更改为选中的样式 ,其他兄弟元素更改为没选项中样式 
               $(this).addClass('tab-on'); 
               $(this).siblings().removeClass('tab-on');        	 
         }

         
         //如果选择了A/B/C 套餐 还需要展示描述, 要有pckplan_desc的属性才触发
         if(typeof($(this).attr('pckplan_desc')) != 'undefined'){
        	 //$('#pckplan_desc').show();
        	 $('#pckplan_desc').html($(this).attr('pckplan_desc'));
         }
         
         //如果选择了不同套餐月费 还需要展示描述, 要有attr_desc的属性才触发
         if(typeof($(this).attr('package_desc')) != 'undefined'){
        	 //$('#package_desc').show();
        	 $('#package_desc').html($(this).attr('package_desc'));
         }  
         
         //bss产品如果选择了不同套餐, 要把values1值赋给product_id , 配置物品属性时values1配置的是bss的product_id，
         //调用bss接口时需要传此参数
         if(typeof($(this).attr('values1')) != 'undefined'){
        	 $('#product_id').val($(this).attr('values1'));
         }         
       });
       
       //激活图文详情页面tab导航 图文详情不用tab页了
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
	    
	    //轮播广告添加hammer.js 滑动手势功能
	       $('#myCarousel').hammer().on('swipeleft', function(){
	     	  $(this).carousel('next');
	     	});
	     	$('#myCarousel').hammer().on('swiperight', function(){
	     	  $(this).carousel('prev');
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
    //edit_by_wenh_2015_4_17
     if($('#phone_number').text()=='请选择号码')
     {
     	alert("请选择号码");
     	return false;
     }
     attr_val += '^' + $('#phone_number').attr('attr_val'); //再加上号码属性
     if($('#net_type')){attr_val += '^' + $('#net_type').attr('attr_val')}; //再加上网络类型 2G/3G/4G/CARD
     if($('#save_money')){attr_val += '^' + $('#save_money').attr('attr_val')}; //再加上预存款
     if($('#ser_type')){attr_val += '^' + $('#ser_type').attr('attr_val')};//再加上预付费还是后付费20160622
     //if($('#product_id')){attr_val += '^' + $('#product_id').attr('attr_val')};//再加上bss产品id,20160622
    
     $('#attr_val').val(attr_val); 
     var goods_disc = getGoodsDisc();
     $('#goods_disc').val(goods_disc); 	
 	$('#form1').submit();
 	//alert($('#attrs').val());	

}

//合约购机 商品详情页面 新号入网 按钮跳转到订单填写页面
function phoneGotoOrderMainNew(){
	//先检查有货没货，没货不进入订单填写页面
	if(parseInt($('#amountChange_id').attr('goods_amount')) <= 0){
		return false;
	}
    var attr_val = getAttrVal();
    if($('#net_type')){attr_val += '^' + $('#net_type').attr('attr_val')}; //再加上网络类型 2G/3G/4G/CARD
    if($('#save_money')){attr_val += '^' + $('#save_money').attr('attr_val')}; //再加上预存款
    $('#attr_val').val(attr_val); 
    var goods_disc = getGoodsDisc();
    $('#goods_disc').val(goods_disc);     
	$('#form1').attr('action', $('#form1').attr('url1')); //替换action路径，新号和老用户跳转路径不一样
	$('#form1').submit();
	//alert($('#attrs').val());
}

//合约购机 商品详情页面 老用户办理 按钮跳转到订单填写页面
function phoneGotoOrderMainOld(){
	var attr_val = getAttrVal();
	$('#attr_val').val(attr_val); 
	if($('#net_type')){attr_val += '^' + $('#net_type').attr('attr_val')}; //再加上网络类型 2G/3G/4G/CARD
	if($('#save_money')){attr_val += '^' + $('#save_money').attr('attr_val')}; //再加上预存款
    var goods_disc = getGoodsDisc();
    $('#goods_disc').val(goods_disc); 	
	$('#form1').attr('action', $('#form1').attr('url2')); //替换action路径，新号和老用户跳转路径不一样
	$('#form1').submit();
	//alert($('#attrs').val());
}

//上网卡 商品详情页面 立即购买 按钮跳转到订单填写页面
function cardGotoOrderMain(){
    var attr_val = getAttrVal(); //获取所有被选中的属性的值，拼串
    attr_val += '^' + $('#phone_number').attr('attr_val'); //再加上号码属性
    if($('#net_type')){attr_val += '^' + $('#net_type').attr('attr_val')}; //再加上网络类型 2G/3G/4G/CARD
    if($('#save_money')){attr_val += '^' + $('#save_money').attr('attr_val')}; //再加上预存款
    if($('#ser_type')){attr_val += '^' + $('#ser_type').attr('attr_val')};//再加上预付费还是后付费20160622
	$('#attr_val').val(attr_val); 
    var goods_disc = getGoodsDisc();
    $('#goods_disc').val(goods_disc); 	
	$('#form1').submit();
	//alert($('#attrs').val());
}

//提交之前校验下是否有属性没选
function checkAttrVal(){
	var flag = true;
	var desc = "";
	$('.tabslist').each(function(i){
		if($(this).find('.tab-on').length == 0){
			flag = false;
			desc = $(this).find('li').attr('attr_code') + "未选择！";
			return false; //退出循环
		}
		
		});	
	
	if(!flag){
		alert(desc);
	}
	return flag;	
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

//拼串 ,获取商品名称型号价格颜色尺寸等简单描述，并且获取所有被选中的属性的值
function getGoodsDisc(){
	var goods_disc = $('#goods_name').val();
	goods_disc += ',商品价格'+$('#goods_price').val() + ',靓号费'+$('#nice_fee').val() + ',订单总费用'+$('#total_price').val();
	$('.tab-on').each(function(i){
		goods_disc += ',' + $(this).html(); //拼上选中的选项内容
		 
		});
    return goods_disc;
}

//选择号码页面 点击号码 预占号码后的 自定义回调函数
function afterUpdateNumber(data){
	if(data.status == 'SUCCESS'){
		$('#serial_number').val(data.serial_number);
		$('#phone_number').html(data.serial_number); //赋值给父页面里的某个 标签属性
		$('#phone_number').attr('attr_val',  $('#phone_number').attr('attr_val') + data.serial_number + '|' + data.serial_number);//修改号码的属性
		
		$('#nice_fee').val(data.nice_fee); //靓号预存款
		
		$('#total_price').val( parseFloat($('#goods_price').val()) + parseFloat($('#nice_fee').val()) ); //订单总价=商品价格+靓号预存款
		//$('#total_price').val( $('#goods_price').val() + $('#nice_fee').val() ); 
		$('#current_price').html($('#total_price').val()); //商品的总价格也要跟着改变
		back2Main(); //回到主页面 隐藏子页面
	}
	else{
		//如果号码预占失败，停留在号码选择页面
	}
}
