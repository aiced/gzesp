package com.ai.gzesp.recharge;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.RechargeResp;
import com.ai.gzesp.service.RechargeService;

/**
 * 处理 一卡充充值接口 响应报文<br>
 * 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespRechargeHandler implements IDealRechargeResp {

	@Autowired
	private RechargeService rechargeService;

	public void dealResp(RechargeResp resp, byte[] msg) {
		//读取包体部分并加到 resp 里面
		//只有响应头里是成功标志的活着错误码是00000的才会有包体
		if(resp.getSuccessFlag().equals("1")){
			byte [] agentBalance = new byte[10];
			System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12, agentBalance, 0, 10); //获取响应报文agentBalance部分
			
			byte [] uniconSerilNum = new byte[20];
			System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12+10, uniconSerilNum, 0, 20); //获取响应报文uniconSerilNum部分
			
			resp.setAgentBalance(new String(agentBalance).trim());
			resp.setUniconSerilNum(new String(uniconSerilNum).trim());
		}
        
		//根据包头里成功标志更新接口日志表 itf_d_recharge_log 里的响应结果
		int n1 = rechargeService.updateRechargeLog(resp.getLogId(), resp.getSuccessFlag(), resp.getResultCode(), resp.getAgentBalance(), resp.getUniconSerilNum(), null);

		//激活接口响应返回后，响应包里没有卡号信息，
		//只能从已经更新了结果的 itf_d_recharge_log表里根据log_id获取 卡号，来更新inv_d_recharge_card表的状态
		Map<String, String> card = rechargeService.getActiveLog(resp.getLogId());
		
		//更新卡库存表里的 卡状态为 已充值或充值失败
		String card_status = resp.getSuccessFlag().equals("1") ? "3" : "B" ;
        int n2 = rechargeService.updateRechargeCard(card.get("CARD_NO"), card_status);

	}
	

}
