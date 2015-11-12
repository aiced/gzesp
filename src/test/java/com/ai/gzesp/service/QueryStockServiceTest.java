package com.ai.gzesp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryStockServiceTest extends BaseTest{
@Autowired
private QueryStockService  qs;

@Test
public void test1(){
	qs.querystock();
}
}