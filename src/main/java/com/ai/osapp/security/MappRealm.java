package com.ai.osapp.security;

import java.io.Serializable;
import java.util.HashSet;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName: MappRealm
 * @Description: mapp身份验证和授权的realm @Service("mappRealm")
 */

@SuppressWarnings("restriction")
public class MappRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MappRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        AuthenticationInfo info = null;
        try {

//                SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(userInfo, getPasswd(), getName());
//                saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));         
//                info = saInfo;             
        } catch (Exception e) {
        	logger.error(e.getMessage());
            throw new AuthenticationException(e);
        } finally {
        }
        
        return info;
    }

    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        
        UserInfo userInfo = (UserInfo) getAvailablePrincipal(principals);
        logger.debug(userInfo.getInterfaceSet().toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(userInfo.getInterfaceSet());
       // info.setRoles(roles);
        
        return info;
    }
    
    class UserInfo implements Serializable {
		private static final long serialVersionUID = 1L;
		
		String userName;
		String phoneNum;
		String passwd;
		String roleId;
		HashSet<String> interfaceSet;
		

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		public String getRoleId() {
			return roleId;
		}

		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}

		public HashSet<String> getInterfaceSet() {
			return interfaceSet;
		}

		public void setInterfaceSet(HashSet<String> interfaceSet) {
			this.interfaceSet = interfaceSet;
		}
    }
}