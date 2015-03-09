package com.ai.wx.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.wx.consts.DataConstants;
import com.ai.wx.entity.CheckModel;
import com.ai.wx.util.EncoderHandler;

/**
 * 微信开发者验证 服务类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
@Service
public class ValidateService {

    /**
     * 微信开发者验证
     * 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败 
     * 
     * @param wxAccount
     * 
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @Transactional
    public boolean validate(CheckModel tokenModel) {
        // 微信加密签名,signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
        String signature = tokenModel.getSignature();
        // 时间戳 
        Long timestamp = tokenModel.getTimestamp();
        // 随机数  
        Long nonce = tokenModel.getNonce();
        // 随机字符串
        //String echostr = tokenModel.getEchostr();
        
        if (signature != null && timestamp != null && nonce != null) {
            String[] str = { DataConstants.TOKEN, timestamp + "", nonce + "" };
            Arrays.sort(str); // 字典序排序
            // 将三个参数字符串拼接成一个字符串进行sha1加密 
            String bigStr = str[0] + str[1] + str[2];
            // SHA1加密
            String digest = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
            // 确认请求来至微信
            if (digest.equals(signature)) {
                // 最好此处将echostr存起来，以后每次校验消息来源都需要用到
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    


}
