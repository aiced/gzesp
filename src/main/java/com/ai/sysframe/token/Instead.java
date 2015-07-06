package com.ai.sysframe.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代客下单注解，在店铺管理界面点击代客下单功能后，用此注解给session 存放一个随机数值，
 * 提交订单时判断session是否有此值，从而区分是代客下单还是普通用户下单
 * @author xmh
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Instead {
	
	boolean save() default true;

	//boolean remove() default false;
}
