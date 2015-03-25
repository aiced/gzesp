package com.ai.gzesp.sgip;

import java.io.IOException;

import com.huawei.insa2.util.Args;
import com.huawei.insa2.util.Cfg;

public class SgipConfig {

    /**
     * sgip链接参数
     */
    private static Args args;
    
    static {
        try {
            args = new Cfg("sgip_cfg.xml").getArgs("SGIPConnect");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Args getArgs() {
        return args;
    }
    
    
}
