package com.ai.gzesp.recharge;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.RechargeResp;
import com.ai.gzesp.service.RechargeService;

/**
 * 处理 一卡充充值查询接口 响应报文<br>
 * 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespRechargeRqyHandler implements IDealRechargeResp {

	@Autowired
	private RechargeService rechargeService;

	public void dealResp(RechargeResp resp, byte[] msg) {
		//读取包体部分并加到 resp 里面
        byte [] chargePhoneNum = new byte[15]; //被充值号码
        System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12, chargePhoneNum, 0, 15); //获取响应报文chargePhoneNum部分

        byte [] chargeSerilNum = new byte[20]; //充值流水号
        System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12+15, chargeSerilNum, 0, 20); 
        
        byte [] chargeTime = new byte[20]; //充值时间, YYYYMMDDHH24MISS
        System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12+15+20, chargeTime, 0, 20); 
        
        byte [] chargeResult = new byte[2]; //充值结果
        System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12+15+20+20, chargeResult, 0, 2); 
        
        byte [] chargeValue = new byte[10]; //充值金额
        System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12+15+20+20+2, chargeValue, 0, 10); 

        resp.setChargeSerilNum(new String(chargeSerilNum).trim());
        resp.setChargeResult(new String(chargeResult).trim());
        resp.setChargeValue(new String(chargeValue).trim());
        
		//根据包体里返回的原充值流水号更新接口日志表 itf_d_recharge_log 里的响应结果
        int n1 = rechargeService.updateRechargeRqyLog(resp.getChargeSerilNum(), resp.getChargeResult(), resp.getChargeValue());

	}

}
