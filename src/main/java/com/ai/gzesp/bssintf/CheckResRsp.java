package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.5	资源操作接口 响应类
 * @author xmh
 *
 */
@XStreamAlias("CheckResRsp")
public class CheckResRsp {
	
	private ResourcesRsp ResourcesRsp;

	public ResourcesRsp getResourcesRsp() {
		return ResourcesRsp;
	}

	public void setResourcesRsp(ResourcesRsp resourcesRsp) {
		ResourcesRsp = resourcesRsp;
	}
	

}
