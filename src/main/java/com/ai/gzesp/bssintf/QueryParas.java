package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("QueryParas")
public class QueryParas {

	private String QueryType;
	
	private String QueryPara1;
	
	private String QueryPara2;

	public String getQueryType() {
		return QueryType;
	}

	public void setQueryType(String queryType) {
		QueryType = queryType;
	}

	public String getQueryPara1() {
		return QueryPara1;
	}

	public void setQueryPara1(String queryPara1) {
		QueryPara1 = queryPara1;
	}

	public String getQueryPara2() {
		return QueryPara2;
	}

	public void setQueryPara2(String queryPara2) {
		QueryPara2 = queryPara2;
	}
	
	
}
