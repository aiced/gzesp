package com.ai.gzesp.recharge;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ai.gzesp.dto.RechargeReq;
import com.ai.gzesp.utils.Base64Utils;
import com.ai.gzesp.utils.DESUtil;

public class RechargeUtil {
	
	private static final Logger log = Logger.getLogger(RechargeUtil.class); 
	
	//沃掌柜系统中预制4种面值的充值卡 100 50 30 10
	private static int[] valueArray = {100, 50, 30, 10};

	/**
	 * 字符串位数不足num的情况下右补空格
	 * @param oldStr
	 * @param num
	 */
	public static String fillNull(String oldStr, int num){
		StringBuffer sb = new StringBuffer(5);
		sb.append("%-");
		sb.append(num);
		sb.append("s");
		return String.format(sb.toString(), oldStr);  //最后拼成如："%-10s"
	}
	
	/**
	 * 数字位数不足num位的情况下左补空格
	 * %08d
	 * 0 代表前面补充0         
     * 4 代表长度为4         
     * d 代表参数为正数型
	 * @param oldStr
	 * @param num
	 */
	public static String fillZero(int oldNum, int num){
		StringBuffer sb = new StringBuffer(5);
		sb.append("%0");
		sb.append(num);
		sb.append("d");
		return String.format(sb.toString(), oldNum);  //最后拼成如："%08d"
	}
	
	/**
	 * 开始计算所有的可能的组合，并且按卡的总张数排序
	 * @param temp_fee
	 */
	public static List<Map<Integer, Integer>> startCompute(int temp_fee){
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
		
		//根据总张数排序
		Collections.sort(groupsList, new Comparator<Map<Integer, Integer>>(){

			@Override
			public int compare(Map<Integer, Integer> arg0,
					Map<Integer, Integer> arg1) {
				int num0 = 0;
				int num1 = 0;
				for (Map.Entry<Integer, Integer> entry : arg0.entrySet()) {
					num0 += entry.getValue();
					  }
				for (Map.Entry<Integer, Integer> entry : arg1.entrySet()) {
					num1 += entry.getValue();
					  }
				//如果arg0小于arg1,返回一个正数;如果arg0大于arg1，返回一个负数;如果他们相等，则返回0;
				if(num0 < num1){
					return -1 ;
				}
				else if(num0 > num1){
					return 1;
				}
				else{
					return 0;
				}
				
			}});
		
		log.debug("【充值面额组合】" + groupsList);	
		
		//log.debug("【充值】end:" + System.currentTimeMillis());
		//log.debug("【充值】end:" + (System.currentTimeMillis()-start));
		
		return groupsList;
	}
	
	/**
	 * 算各种面额的组合，temp_fee是需要计算的面额，以valueArray数组里的valueArrayIndex的面额开始算，算出的组合存放在groups里，
	 * @param temp_fee
	 * @param valueArrayIndex
	 * @param groups
	 */
	private static void compute(int temp_fee, int valueArrayIndex, Map<Integer, Integer> groups) {
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
	private static void computeSub(int temp_fee, Map<Integer, Integer> groupsParent, int valueArrayIndex, List<Map<Integer, Integer>> groupsList) {
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
	public static int floor(int num1, int num2){
		return (int)Math.floor(num1/num2);
	}
	
	/**
	 * 除法取余数：如 5/3 ,返回2
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int mod(int num1, int num2){
		return num1 % num2;
	}
	
	
	
	/**
	 * 生成接口请求包头+包体
	 * 为使连接的双方保证数据的发送和接收的一致性，在所有数据包前增加”@”为包的开始标志，数据包尾加“0x1a”为包的结束标志。
     * 数据包头中的包长字段不包含这两个字符在内
	 * @param interfaceType
	 * @param param
	 */
	public static String genReq(RechargeReq param, String interfaceType, String serialNum, String serialNumType, String reqTime){
		//先生成包体，因为包头里需要知道包体的长度
		String reqBody = genReqBody(interfaceType, param); 
		//再生成包头
		String reqHead = genReqHead(reqBody, param.getSerialNum(), interfaceType, serialNum, serialNumType, reqTime);
		
		return RechargeCons.prefix + reqHead + reqBody + RechargeCons.Suffix;
	}
	

	/**
	 * 生成请求包头，根据请求接口类型
	 * @param interfaceType
	 * @param param
	 * @return
	 */
	public static String genReqBody(String interfaceType, RechargeReq param){
		//StringBuffer reqBody = new StringBuffer(100);
		//prependHeadA1(req);
		String reqBody = null;
		if(InterfaceType.recharge.getInterfaceCode().equals(interfaceType)){
			reqBody = genReqBodyOfRecharge(param); //充值接口包体
		}
		else if(InterfaceType.active.getInterfaceCode().equals(interfaceType)){
			reqBody = genReqBodyOfActive(param); //激活接口包体
		}
		else if(InterfaceType.check.getInterfaceCode().equals(interfaceType)){
			reqBody = genReqBodyOfCheck(param); //对账接口包体
		}
		else{
			
		}
		return reqBody;
	}
	
	/**
	 * 生成充值接口的包体
	 * ChargeMoney	充值金额	10	XXX.XX(元) 左对齐、右补空格（20、30、50、100、200、300、500）
	 * AgentID	卡号	20	左对齐、右补空格 当为一卡充充值时，此字段填卡号
     * pasword	卡密码	32	当为一卡充充值时，此字段填卡密码,且用3DES加密，加密结果base64处理，左对齐、右补空格
     * SerialNum	发起方流水号	20	左对齐、右补空格
	 * @param param
	 * @return
	 */
	public static String genReqBodyOfRecharge(RechargeReq param){
		StringBuffer reqBody = new StringBuffer(100);
		reqBody.append(fillNull(String.valueOf(param.getChargeMoney()), 10));
		reqBody.append(fillNull(String.valueOf(param.getAgentID()), 20));
		
		byte[] temp = DESUtil.encryptModeRecharge(RechargeCons.desKey.getBytes(), param.getPasword().getBytes());
		String target = Base64Utils.encodeStr(temp);
		reqBody.append(fillNull(target, 32));
		
		reqBody.append(fillNull(String.valueOf(param.getSerialNum()), 20));
		
		return reqBody.toString();
	}
	
	/**
	 * 生成激活接口的包体
	 * CardNum	卡号	20	左对齐、右补空格 当为一卡充充值时，此字段填卡号
     * Cardpwd	卡密码	32	当为一卡充充值时，此字段填卡密码,且用3DES加密，加密结果base64处理，左对齐、右补空格
	 * @param param
	 * @return
	 */
	public static String genReqBodyOfActive(RechargeReq param){
		StringBuffer reqBody = new StringBuffer(100);
		reqBody.append(fillNull(String.valueOf(param.getAgentID()), 20));
		
		byte[] temp = DESUtil.encryptModeRecharge(param.getPasword().getBytes());
		String target = Base64Utils.encodeStr(temp);
		reqBody.append(fillNull(target, 32));
		
		return reqBody.toString();
	}	
	
	/**
	 * 生成对账接口的包体
     * ChargeSerilNum	发起方流水号	20	左对齐、右补空格
     * AccountNumber 被充值帐号 15  左对齐，右补空格
     * CardNumber	卡号	20	左对齐、右补空格 当为一卡充充值时，此字段填卡号
     * 
	 * @param param
	 * @return
	 */
	public static String genReqBodyOfCheck(RechargeReq param){
		StringBuffer reqBody = new StringBuffer(100);
		reqBody.append(fillNull(String.valueOf(param.getChargeSerilNum()), 20));
		reqBody.append(fillNull(String.valueOf(param.getAccountNumber()), 15));
		reqBody.append(fillNull(String.valueOf(param.getAgentID()), 20));
		
		return reqBody.toString();
	}
	
	/**
	 * 生成请求包头
	 * @param reqBody
	 */
	public static String genReqHead(String reqBody, String logId, String interfaceType, String serialNum, String serialNumType, String reqTime){
		StringBuffer reqHead = new StringBuffer(113);
		appendHeadA1(reqHead, reqBody);
		appendHeadA2(reqHead, logId);
		appendHeadA3(reqHead);
		appendHeadA4(reqHead, interfaceType);
		appendHeadA5(reqHead);
		appendHeadA6(reqHead, interfaceType, serialNum);
		appendHeadA7(reqHead, interfaceType, serialNumType);
		appendHeadA8(reqHead);
		appendHeadA9(reqHead, reqTime, logId);
		appendHeadA10(reqHead);
		appendHeadA11(reqHead);
		appendHeadA12(reqHead);
		appendHeadA13(reqHead, reqTime);
		return reqHead.toString();
	}
	
	/**
	 * A1数据包大小(5位):以字节为单位,左对齐不足后补空格；数据包的大小是包头长度（113）和包体长度之和。
	 * @param req
	 * @param reqBody
	 * @return
	 */
	private static void appendHeadA1(StringBuffer reqHead, String reqBody){
		int len = 113 + reqBody.getBytes().length; //数据包的大小是包头长度（113）和包体长度之和
		String a1 = fillNull(String.valueOf(len), 5);
		reqHead.append(a1); 
	}
	
	/**
	 * A2流水号（20位）：业务流水号，标志每笔具体交易。流水号不足20位则左对齐，右补空格。
	 * 发起方在所有的交易中都应该填写流水号字段，并且保证流水号的唯一性
	 * @param reqHead
	 */
	private static void appendHeadA2(StringBuffer reqHead, String logId){
		//String logId = generateLogId();
		String a2 = fillNull(logId, 20);
		reqHead.append(a2);
	}
	
	/**
	 * A3标志（1位）：1 表示成功 0 表示失败，仅适用于响应包；
     * 在请求包中为空格； 响应包在返回0时表示失败，并且把相应的错误码填写在A12字段中，
     * 在返回1是表示成功，同时，A12字段需要填写代码00000
	 * @param reqHead
	 */
	private static void appendHeadA3(StringBuffer reqHead){
		reqHead.append(" ");
	}
	
	/**
	 * A4交易类型（6位）： 010202，010203，010204，010205，010206，010201
	 * @param reqHead
	 * @param interfaceType
	 */
	private static void appendHeadA4(StringBuffer reqHead, String interfaceType){
		reqHead.append(interfaceType);
	}
	
	/**
	 * A5业务类型（2位）：00-99 标志各种业务。00为空中充值，01为一卡充业务。目前只填01
	 * @param reqHead
	 * @param interfaceType
	 */
	private static void appendHeadA5(StringBuffer reqHead){
		reqHead.append("01");
	}
	
	/**
	 * A6业务号码（20位）：当A4交易类型为010202或010201时，
	 * A6字段的含义为：移动电话号码、固话号码、宽带帐号，小灵通/大灵通或固定值
	 * @param reqHead
	 * @param serialsNum
	 */
	private static void appendHeadA6(StringBuffer reqHead, String interfaceType, String serialNum){
		String a6 = null;
		if(InterfaceType.recharge.getInterfaceCode().equals(interfaceType) ||
				InterfaceType.rechargeCheck.getInterfaceCode().equals(interfaceType)){
			a6 = fillNull(serialNum, 20);
		}
		else{
			a6 = fillNull("", 20);
		}
		reqHead.append(a6);
	}
	

	/**
	 * A7业务号码类型(1位)： 1 GSM；2 固话；3 宽带；4 小灵通或大灵通。当A4为010203时，此值为空格
	 * @param reqHead
	 */
	private static void appendHeadA7(StringBuffer reqHead, String interfaceType, String serialNumType){
		String a7 = null;
		if(InterfaceType.recharge.getInterfaceCode().equals(interfaceType) ||
				InterfaceType.rechargeCheck.getInterfaceCode().equals(interfaceType)){
			a7 = fillNull(serialNumType, 1);
		}
		else{
			a7 = fillNull("", 1);
		}
		
		reqHead.append(a7);
	}
	
	/**
	 * A8第三方系统接入ID (3位):唯一标识一个第三方接入系统
	 * @param reqHead
	 */
	private static void appendHeadA8(StringBuffer reqHead){
		reqHead.append(RechargeCons.ID);
	}
	
	/**
	 * A9第三方系统接入验证码 (32位):采用3DES对特定数据进行加密，结果base64处理，用以验证接入方身份； 
     * 加密用的密钥为双方商定好的16字符128位密钥。
     * 加密用的特定数据为：A13+A8+A2的后8位，合计23个字符数据
	 * @param reqHead
	 * @param reqTime
	 */
	private static void appendHeadA9(StringBuffer reqHead, String reqTime, String logId){
		StringBuffer src = new StringBuffer(23);
		src.append(reqTime);
		src.append(RechargeCons.ID);
		src.append(fillNull(logId, 20).substring(12));
		byte[] temp = DESUtil.encryptModeRecharge(src.toString().getBytes());
		String target = Base64Utils.encodeStr(temp);
		
		reqHead.append(target);
	}
	
	/**
	 * A10包编号（5位）：标志该笔流水的第几包数据，从00001开始
	 * @param reqHead
	 */
	private static void appendHeadA10(StringBuffer reqHead){
		reqHead.append("00001");
	}
	
	/**
	 * A11最后一包标志（1位）：在进行多包发送的情况下,该标志用以标明是否为最后一数据包: 
	 * 1 最后一包数据，无后续包 ; 0 非最后一包数据，有后续包。
	 * @param reqHead
	 */
	private static void appendHeadA11(StringBuffer reqHead){
		reqHead.append("1");
	}

	/**
	 * A12错误码（5位）：在标志为失败时需检查该错误码。错误码包括系统操作错误和业务处理错误。成功交易填写00000
	 * @param reqHead
	 */
	private static void appendHeadA12(StringBuffer reqHead){
		reqHead.append("00000");
	}
	
	/**
	 * A13请求时间（12位）：YYMMDDHHMMSS
	 * @param reqHead
	 * @param reqTime
	 */
	private static void appendHeadA13(StringBuffer reqHead, String reqTime){
		reqHead.append(reqTime);
	}
	

    /**
     * 生成16位接口流水号，用于插入 ITF_D_RECHARGE_LOG
     * interfaceType: 2：充值接口 4：充值记录查询接口 1：充值号码验证接口 3：卡激活接口 5：充值对账接口
     * @param interfaceType
     * @return
     */
    public static String generateLogId(int interfaceType) {
    	StringBuffer sb = new StringBuffer(16);
        Random random = new Random();
        sb.append(interfaceType); //
        sb.append(System.currentTimeMillis()); //13位
        //加2位随机整数 0-99之间的随机整数，不足2位左补一位随机数
        sb.append(StringUtils.leftPad(String.valueOf(random.nextInt(100)), 2, String.valueOf(random.nextInt(10)).charAt(0))); 
        return sb.toString();
    }
    
    /**
     * 获取当前时间戳 yyMMddHHmmss<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getCurentTime(){
        return new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
    }
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		   // 0 代表前面补充0     
		   // 4 代表长度为4     
		   // d 代表参数为正数型     
		//String str = String.format("%04d", 1);  
//		String str = String.format("%-10s", ""); 
//        System.out.println(str);
//        System.out.println("bbbb");
//        
//        System.out.println(fillNull("abc", 10));
//        
//        String s = "aaaaa";
//        System.out.println(s.getBytes().length);
//        System.out.println(s.getBytes(Charset.forName("utf-8")).length);
//        
//        System.out.println(getCurentTime());
//        
//        System.out.println(fillNull("1234567890", 20).substring(12));
		
/*		StringBuffer src = new StringBuffer(23);
		src.append("150707120113");
		src.append("1234567890123456");
		src.append(fillNull("1234567890123456", 20).substring(12));
		byte[] temp = DESUtil.encryptModeRecharge(src.toString().getBytes());
		String target = Base64Utils.encodeStr(temp);
		System.out.println(target);*/
		
/*		String src = "123  ";
		System.out.println(src);
		byte[] sizeBytes = src.getBytes();
		System.out.println(new String(src.getBytes()).trim());
		System.out.println(Integer.parseInt(new String(src.getBytes()).trim()));*/
		
/*		String heart = RechargeCons.prefix + RechargeCons.HEARTBEAT_REQ + RechargeCons.Suffix;
		System.out.println(heart);
		byte[] heartByte = heart.getBytes(RechargeCons.charCode);
		System.out.println(new String(heart.getBytes()).equals(heart));*/
		
//		System.out.println(fillZero(13, 8));
		
		
//        String log_id = generateLogId();
//        System.out.println(log_id);
//        String partition_id = log_id.substring(14, 16);
//        System.out.println(partition_id);
		
//		Map<String, String> map1 = null;
//		Map<String, String> map2 = new HashMap<String, String>();
//		
//		System.out.println(MapUtils.isEmpty(map1));
//		System.out.println(MapUtils.isEmpty(map2));
		
		for(int i = 0; i < 100; i++){
			Random random = new Random();
			int j = random.nextInt(100);
			System.out.print(j);
			System.out.print("|");
			System.out.print(StringUtils.leftPad(String.valueOf(j), 2, String.valueOf(random.nextInt(10)).charAt(0)));
			System.out.print("\n");
			
		}
	}
}
