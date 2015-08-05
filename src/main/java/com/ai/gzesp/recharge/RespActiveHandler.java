package com.ai.gzesp.recharge;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.RechargeResp;
import com.ai.gzesp.service.RechargeService;

/**
 * 处理 一卡充激活接口 响应报文<br>
 * 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespActiveHandler implements IDealRechargeResp {

	@Autowired
	private RechargeService rechargeService;

	public void dealResp(RechargeResp resp, byte[] msg) {
		
		//卡激活接口无包体部分
		
		//根据包头里成功标志更新接口日志表 itf_d_recharge_log 里的响应结果
		int n1 = rechargeService.updateRechargeLog(resp.getLogId(), resp.getSuccessFlag(), resp.getResultCode(), null, null, null);

		//激活接口响应返回后，响应包里没有卡号信息，
		//只能从已经更新了结果的 itf_d_recharge_log表里根据log_id获取 卡号，来更新inv_d_recharge_card表的状态
		Map<String, String> card = rechargeService.getActiveLog(resp.getLogId());
		
		//更新卡库存表里的 卡状态为 激活或激活失败
		String card_status = resp.getSuccessFlag().equals("1") ? "1" : "A" ;
        int n2 = rechargeService.updateRechargeCard(card.get("CARD_NO"), card_status);
	}

}
