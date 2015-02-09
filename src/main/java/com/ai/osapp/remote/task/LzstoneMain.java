package com.ai.osapp.remote.task;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LzstoneMain implements ServletContextListener{     
    private Timer timer = null;     
    //初始化监听器，创建实例，执行任务     
    public void contextInitialized(ServletContextEvent event){     
            timer = new Timer();     
//            timer.schedule(new LzstoneTimeTask(),0,1*1000);     
    }     
    //销毁监听器，停止执行任务     
    public void contextDestroyed(ServletContextEvent event){     
           //注意，在此计时器调用的计时器任务的 run 方法内调用此方法，就可以绝对确保正在执行的任务是此计时器所执行的最后一个任务。     
           timer.cancel();     
     }     
}     
