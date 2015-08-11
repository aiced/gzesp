package com.ai.gzesp.recharge;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.RechargeResp;
import com.ai.gzesp.service.RechargeService;

/**
 * 处理 一卡充对账接口 响应报文<br>
 * 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespCheckHandler implements IDealRechargeResp {

	@Autowired
	private RechargeService rechargeService;

	public void dealResp(RechargeResp resp, byte[] msg) {

		//读取包体部分并加到 resp 里面
		//只有响应头里是成功标志的活着错误码是00000的才会有包体
		if(resp.getSuccessFlag().equals("1")){
			byte [] chargeSerilNum = new byte[20];
			System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12, chargeSerilNum, 0, 20); //获取响应报文chargeSerilNum部分
			
			byte [] chargeStatus = new byte[2];
			System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12+20, chargeStatus, 0, 2); //获取响应报文chargeStatus部分
			
			resp.setChargeSerilNum(new String(chargeSerilNum).trim()); //包体里原充值流水号
			resp.setChargeStatus(new String(chargeStatus).trim()); //对账结果
			
			//根据包头里成功标志更新接口日志表 itf_d_recharge_log 里的响应结果,对账前没插接口日志，所以收到响应后不用更新
			int n1 = rechargeService.updateCheckStatus(resp.getChargeSerilNum(), resp.getChargeStatus());
		}
        
	}

}
