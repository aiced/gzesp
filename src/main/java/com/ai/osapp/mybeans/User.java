package com.ai.osapp.mybeans;

import java.io.Serializable;

public class User implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    /**
     * @Fields 员工Id
     */
    private String userId;
    
    /**
     * @Fields 员工名称
     */
    private String userName;
    
    private String departId;
        
    private String eparchyCode;
    
    private String password;

    private String loginName;
    
    private String userType;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getEparchyCode() {
        return eparchyCode;
    }

    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}    
}
