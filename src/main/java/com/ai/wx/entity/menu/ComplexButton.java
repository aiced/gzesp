package com.ai.wx.entity.menu;

/**
 * 复杂菜单：包含有二级菜单项的一级菜单<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class ComplexButton extends Button{
    
    private CommonButton[] sub_button;

    public CommonButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(CommonButton[] sub_button) {
        this.sub_button = sub_button;
    } 
    
    
}
