package com.ai.gzesp.dao;

import java.util.HashMap;
import java.util.List;

public interface QueryStockDao {
	public List<HashMap<Object, Object>> querystock();//查询库存

	public List<HashMap<Object, Object>> queryLinkman();//查询联系人
}
