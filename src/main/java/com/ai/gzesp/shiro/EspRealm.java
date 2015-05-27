package com.ai.gzesp.shiro;

import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.UserService;
import com.ai.gzesp.utils.MD5Util;

/**
 * @author xmh
 * 身份验证和授权的realm
 */
@Service
public class EspRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	/* 
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* 
	 * 登陆身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String phone_number = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		
		//正常校验应该放在这里，这边因为controller里还需要再次获取user_id，还要再查询一次，所以把这一步校验放controller里，这边直接认证通过
/*		Map<Object, Object> userMap = userService.getUserInfoByPhonePassword(phone_number, password);
		
		AuthenticationInfo authenticationInfo = null;
		
		//如果非空表示手机号密码能查询到用户，验证通过
		if(userMap != null){
			authenticationInfo = new SimpleAuthenticationInfo(phone_number, password, getName());
		}*/
		
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(phone_number, password, getName());
		
		return authenticationInfo;
	}

}
