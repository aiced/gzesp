//package com.ai.gzesp.security;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.annotation.Resource;
//
//import org.apache.shiro.authc.AccountException;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import cn.rocklee.osapp.dao.beans.Criteria;
//import cn.rocklee.osapp.dao.beans.TCarRoleInterface;
//import cn.rocklee.osapp.dao.beans.TCarUser;
//import cn.rocklee.osapp.dao.service.TCarRoleInterfaceDao;
//import cn.rocklee.osapp.dao.service.TCarUserDao;
//
//
///**
// * @ClassName: MappRealm
// * @Description: mapp身份验证和授权的realm @Service("mappRealm")
// */
//
//@SuppressWarnings("restriction")
//public class MappRealm extends AuthorizingRealm {
//
//    private static final Logger logger = LoggerFactory.getLogger(MappRealm.class);
//
//    @Resource
//    private TCarUserDao tCarUserDao;
//    
//    @Resource
//    private TCarRoleInterfaceDao tCarRoleInterfaceDao;
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        String username = upToken.getUsername();
//        if (username == null) {
//            throw new AccountException("Null usernames are not allowed by this realm.");
//        }
//
//        AuthenticationInfo info = null;
//        try {
//
//        	TCarUser tcarUser = getUserByUserName(username);
//        	
//        	if (tcarUser != null) {
////	        	List<TCarRoleInterface> list = getInterfaceByRoleId(tcarUser.getUserType());
//	        	List<TCarRoleInterface> list = new ArrayList();
//	        	HashSet<String> permissions = getPermissions(list);
//	        	
//	        	 UserInfo userInfo = new UserInfo(tcarUser, permissions);
//        	
//                SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(userInfo, tcarUser.getPasswd(), getName());
//                saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));         
//                info = saInfo;             
//            } else {
//                return null;
//            }            
//        } catch (Exception e) {
//        	logger.error(e.getMessage());
//            throw new AuthenticationException(e);
//        } finally {
//        }
//        
//        return info;
//    }
//
//    private TCarUser getUserByUserName(String username) {
//        final Criteria crit = new Criteria();
//        crit.createConditon().andEqualTo("phoneNum", username);
//        final List<TCarUser> users = tCarUserDao.selectByExample(crit);        
//
//        if(users.size()>0) 
//        {
//        	return  users.get(0);
//        }else 
//        {
//            return null;
//        }
//    }
//    
//    private List<TCarRoleInterface> getInterfaceByRoleId(String roleId) {
//    	final Criteria crit = new Criteria();
//    	crit.createConditon().andEqualTo("roleId", roleId);
//    	final List<TCarRoleInterface> list = tCarRoleInterfaceDao.selectByExample(crit);        
//    	
//    	return list;
//    }
//
//    
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        if (principals == null) {
//            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
//        }
//        
//        UserInfo userInfo = (UserInfo) getAvailablePrincipal(principals);
//        logger.debug(userInfo.getInterfaceSet().toString());
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(userInfo.getInterfaceSet());
//       // info.setRoles(roles);
//        
//        return info;
//    }
//    
//    protected HashSet<String> getPermissions(List<TCarRoleInterface> interfaceList) {
//    	HashSet<String> set = new HashSet();
//    	for(TCarRoleInterface info : interfaceList) {
//    		set.add(info.getInterfaceId());
//    	}
//    	return set;
//    }
//    
//    class UserInfo implements Serializable {
//		private static final long serialVersionUID = 1L;
//		
//		String userName;
//		String phoneNum;
//		String passwd;
//		String roleId;
//		HashSet<String> interfaceSet;
//		
//		UserInfo(TCarUser tCarUser, HashSet<String> interfaceSet) {
//			this.userName =  tCarUser.getUserName();
//			this.phoneNum =  tCarUser.getPhoneNum();
//			this.passwd = tCarUser.getPasswd();
//			this.roleId =  tCarUser.getUserType();
//			this.interfaceSet =  interfaceSet;
//		}
//
//		public String getUserName() {
//			return userName;
//		}
//
//		public void setUserName(String userName) {
//			this.userName = userName;
//		}
//
//		public String getPhoneNum() {
//			return phoneNum;
//		}
//
//		public void setPhoneNum(String phoneNum) {
//			this.phoneNum = phoneNum;
//		}
//
//		public String getPasswd() {
//			return passwd;
//		}
//
//		public void setPasswd(String passwd) {
//			this.passwd = passwd;
//		}
//
//		public String getRoleId() {
//			return roleId;
//		}
//
//		public void setRoleId(String roleId) {
//			this.roleId = roleId;
//		}
//
//		public HashSet<String> getInterfaceSet() {
//			return interfaceSet;
//		}
//
//		public void setInterfaceSet(HashSet<String> interfaceSet) {
//			this.interfaceSet = interfaceSet;
//		}
//    }
//}