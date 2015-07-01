package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 充值缴费service
 * @author xmh
 *
 */
@Service
public class RechargeService {
	
    private static final Logger log = Logger.getLogger(RechargeService.class); 
	
	//沃掌柜系统中预制4种面值的充值卡 100 50 30 10
	private int[] valueArray = {100, 50, 30, 10};

	public void recharge(int total_fee){
		log.debug("【充值】需要充值" + total_fee + "厘，开始计算充值卡面额组合");
		int temp_fee = total_fee/1000; //单位换成元
		
		startCompute(temp_fee);
		
	}
	
	/**
	 * 开始计算所有的可能的组合
	 * @param temp_fee
	 */
	private void startCompute(int temp_fee){
		//long start = System.currentTimeMillis(); //计时
		//log.debug("【充值】start:" + start);
		
		//所有组合的存放在list里面，每种组合是个map，key是面额，value是张数
		List<Map<Integer, Integer>> groupsList = new ArrayList<Map<Integer, Integer>>();
		
		// 组合1：以100面额开始算
		Map<Integer, Integer> groups1 = new HashMap<Integer, Integer>();
		compute(temp_fee, 0, groups1);
		groupsList.add(groups1);
		
		//组合1 里面 再细分各种不同组合，但最少都是要有1张100的才会继续往下拆 ，比如{50=2, 100=2, 10=1}
		computeSub(temp_fee, groups1, 0, groupsList);
		
		// 组合2：以50面额开始算
		if (groups1.containsKey(valueArray[0])) {
			Map<Integer, Integer> groups2 = new HashMap<Integer, Integer>();
			compute(temp_fee, 1, groups2);
			groupsList.add(groups2);
			
			//组合2 里面 再细分各种不同组合
			computeSub(temp_fee, groups2, 1, groupsList);
		}

		// 组合3：以30面额开始算
		if (groups1.containsKey(valueArray[0])
				|| groups1.containsKey(valueArray[1])) {
			Map<Integer, Integer> groups3 = new HashMap<Integer, Integer>();
			compute(temp_fee, 2, groups3);
			groupsList.add(groups3);
			
			//组合3 里面 再细分各种不同组合
			computeSub(temp_fee, groups3, 2, groupsList);
		}
		// 组合4：以10面额开始算
		if (groups1.containsKey(valueArray[0])
				|| groups1.containsKey(valueArray[1])
				|| groups1.containsKey(valueArray[2])) {
			Map<Integer, Integer> groups4 = new HashMap<Integer, Integer>();
			compute(temp_fee, 3, groups4);
			groupsList.add(groups4);
			
			//组合4 里面 再细分各种不同组合
			computeSub(temp_fee, groups4, 3, groupsList);
		}
		
		log.debug("【充值面额组合】" + groupsList);		
		
		//log.debug("【充值】end:" + System.currentTimeMillis());
		//log.debug("【充值】end:" + (System.currentTimeMillis()-start));
	}
	
	/**
	 * 算各种面额的组合，temp_fee是需要计算的面额，以valueArray数组里的valueArrayIndex的面额开始算，算出的组合存放在groups里，
	 * @param temp_fee
	 * @param valueArrayIndex
	 * @param groups
	 */
	private void compute(int temp_fee, int valueArrayIndex, Map<Integer, Integer> groups) {
		//log.debug("【充值】compute:temp_fee=" + temp_fee + ", valueArrayIndex=" + valueArrayIndex );
		// 组合1
		int num1 = floor(temp_fee, valueArray[valueArrayIndex]); // 需要多少个100面额的
		int mod_fee1 = mod(temp_fee, valueArray[valueArrayIndex]); // 看除以100的余数
		if(num1 > 0){
			groups.put(valueArray[valueArrayIndex], num1); //加到组合的map里
		}
		// 如果还有余数 需要递归
		if (mod_fee1 > 0 && (valueArrayIndex + 1 < valueArray.length)) {
			compute(mod_fee1, valueArrayIndex + 1, groups); //再看需要多少个50面额的，如果有余额继续看30,10的
		}
	}
	
	/**
	 * 当计算出{50=2, 100=2, 10=1} 这种组合的时候，需要把100=2 继续拆分 成 {50=4, 100=1, 10=1}, 而且50=4 要递归拆分下去 
	 * 直到拆成 {50=1, 100=1, 10=13, 30=1}，把所有的组合都算出来
	 * @param temp_fee
	 * @param groupsParent
	 * @param valueArrayIndex
	 * @param groupsList
	 */
	private void computeSub(int temp_fee, Map<Integer, Integer> groupsParent, int valueArrayIndex, List<Map<Integer, Integer>> groupsList) {
		//log.debug("【充值】compute:temp_fee=" + temp_fee + ", valueArrayIndex=" + valueArrayIndex );
		// 组合21
		if(valueArrayIndex < valueArray.length-1 && groupsParent.containsKey(valueArray[valueArrayIndex]) && groupsParent.get(valueArray[valueArrayIndex]) > 1){
			for(int i = 1; i < groupsParent.get(valueArray[valueArrayIndex]); i++){
				Map<Integer, Integer> groups21 = new HashMap<Integer, Integer>();
				
				//举例：如果 {50=4, 100=1, 10=1}，要把100=1放groups21里， 如果{50=2, 100=2, 10=1}，要把100=2-1放到groups21里
				//如果 {50=4, 100=1, 10=1}，temp_fee2=temp_fee-100*1-50*3， 如果{50=2, 100=2, 10=1}，temp_fee2=temp_fee-100*1
				int temp_fee2 = temp_fee;
				for(int j = 0; j <= valueArrayIndex; j++){
					if(j < valueArrayIndex && groupsParent.containsKey(valueArray[j])){
						groups21.put(valueArray[j], groupsParent.get(valueArray[j]));
						temp_fee2 = temp_fee2 - (valueArray[j] * (groupsParent.get(valueArray[j])));
					}
					else if(j == valueArrayIndex && groupsParent.containsKey(valueArray[j])){
						groups21.put(valueArray[j], groupsParent.get(valueArray[j])-i);
						temp_fee2 = temp_fee2 - (valueArray[j] * (groupsParent.get(valueArray[j])-i));
					}
				}
				
				compute( temp_fee2, valueArrayIndex+1, groups21); //
				groupsList.add(groups21);
				
				if((valueArrayIndex+1) < valueArray.length-1){
					computeSub(temp_fee, groups21, valueArrayIndex+1, groupsList); //如果不是最后一种面额则递归
				}
			}
		}
	}
	

	
	
	/**
	 * 除法向下取整  :如 5/3 ,返回1
	 * @param num1
	 * @param num2
	 * @return
	 */
	private int floor(int num1, int num2){
		return (int)Math.floor(num1/num2);
	}
	
	/**
	 * 除法取余数：如 5/3 ,返回2
	 * @param num1
	 * @param num2
	 * @return
	 */
	private int mod(int num1, int num2){
		return num1 % num2;
	}
	
	public static void main(String[] args) {
		int total_fee = 1000;
	    int[] array = {1000, 500, 300, 100};
	    
/*	    Map<Integer, Integer> groups = new HashMap<Integer, Integer>();
	    
	    compute(total_fee, 0, groups);*/
		
		System.out.println(Math.floor(total_fee/array[0]));
		System.out.println((int)Math.floor(total_fee/array[0]));
	}
}
