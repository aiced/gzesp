package com.ai.wx.entity.menu;

/**
 * 普通菜单类，可能是二级菜单项，也有可能是不含二级菜单的一级菜单<br>
 * 自定义菜单是一个3x5结构的，即菜单最多只能有二级，一级菜单最多只能有3个，每个一级菜单下最多可以有5个二级菜单项 菜单项都有一个key值。当用户点击某个菜单项时，微信会将该菜单项的key值以事件推送的方式发送给我们的后台处理程序
 * 
 * @author 14040909
 */
public class CommonButton extends Button{
    
    private String type;
    
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
