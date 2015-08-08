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
public class RespRechargeCheckHandler implements IDealRechargeResp {

	@Autowired
	private RechargeService rechargeService;

	public void dealResp(RechargeResp resp, byte[] msg) {
		//读取包体部分并加到 resp 里面
//        byte [] areaNum = new byte[4]; //地区代码
//        System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5+12, areaNum, 0, 4); //获取响应报文areaNum部分
//
//        resp.setAreaNum(new String(areaNum).trim());
        
		//根据包头里成功标志更新接口日志表 itf_d_recharge_log 里的响应结果
        int n1 = rechargeService.updateRechargeLog(resp.getLogId(), resp.getSuccessFlag(), resp.getResultCode(), null, null, null);

	}

}
