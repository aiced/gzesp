package com.ai.osapp.dao.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 公用条件查询类
 */
public class Criteria {
    /**
     * 存放条件查询值
     */
//    private Map<String, Object> condition;

    protected List<Condition> oredCriteria = new ArrayList<Condition>();
    
    /**
     * 是否相异
     */
    protected boolean distinct;

    /**
     * 排序字段
     */
    protected String orderByClause;
    
    protected String whereClause;

    protected String getWhereClause() {
		return whereClause;
	}

	protected void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}

	private Integer mysqlOffset;

    private Integer mysqlLength;

    protected Criteria(Criteria example) {
        this.orderByClause = example.orderByClause;
//        this.condition = example.condition;
        this.distinct = example.distinct;
        this.mysqlLength = example.mysqlLength;
        this.mysqlOffset = example.mysqlOffset;
    }

    public Criteria() {
//        condition = new HashMap<String, Object>();
    }

    public void clear() {
    	oredCriteria.clear();
//        condition.clear();
        orderByClause = null;
        distinct = false;
        this.mysqlOffset = null;
        this.mysqlLength = null;
    }

    /**
     * @param condition 
	 *            查询的条件名称
	 * @param value
	 *            查询的值
     */
//    public Criteria put(String condition, Object value) {
//        this.condition.put(condition, value);
//        return (Criteria) this;
//    }

    /**
     * @param orderByClause 
	 *            排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @param distinct 
	 *            是否相异
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

//    public void setCondition(Map<String, Object> condition) {
//        this.condition = condition;
//    }
//
//    public Map<String, Object> getCondition() {
//        return condition;
//    }

    /**
     * @param mysqlOffset 
	 *            指定返回记录行的偏移量<br>
	 *            mysqlOffset= 5,mysqlLength=10;  // 检索记录行 6-15
     */
    public void setMysqlOffset(Integer mysqlOffset) {
    	if(mysqlOffset > 0) {
    		this.mysqlOffset = mysqlOffset;
    	} else {
    		this.mysqlOffset = 0;
    	}
    }

    /**
     * @param mysqlLength 
	 *            指定返回记录行的最大数目<br>
	 *            mysqlOffset= 5,mysqlLength=10;  // 检索记录行 6-15
     */
    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }
    
    public List<Condition> getOredCriteria() {
        return oredCriteria;
    }

    public void or(final Condition condition) {
        oredCriteria.add(condition);
    }

    public Condition or() {
        final Condition condition = createConditionInternal();
        oredCriteria.add(condition);
        return condition;
    }

    public Condition createConditon() {
        final Condition condition = createConditionInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(condition);
        }
        return condition;
    }

    protected Condition createConditionInternal() {
        final Condition condition = new Condition();
        return condition;
    }
    
    public static class Condition {
        protected List<Criterion> criterions = new ArrayList<Criterion>();

        public boolean isValid() {
            return criterions.size() > 0;
        }

        public List<Criterion> getCriterions() {
            return criterions;
        }

        protected void addCriterion(final String condition) {
            if (condition == null) {
                // throw new
                // RuntimeException("Value for condition cannot be null");
                return;
            }
            criterions.add(new Criterion(condition));
        }

        protected void addCriterion(final String condition, final Object value, final String property) {
            if (value == null) {
                // throw new RuntimeException("Value for " + property +
                // " cannot be null");
                return;
            }
            criterions.add(new Criterion(condition, value));
        }

        protected void addCriterion(final String condition, final Object value1, final Object value2, final String property) {
            if (value1 == null || value2 == null) {
                // throw new RuntimeException("Between values for " + property +
                // " cannot be null");
                return;
            }
            criterions.add(new Criterion(condition, value1, value2));
        }

        public Condition andIsNull(final String columnName) {
            addCriterion(columnName + " is null");
            return this;
        }

        public Condition andIsNotNull(final String columnName) {
            addCriterion(columnName + " is not null");
            return this;
        }

        public Condition andEqualTo(final String columnName, final Object value) {
            addCriterion(columnName + " =", value, columnName);
            return this;
        }

        public Condition andNotEqualTo(final String columnName, final Object value) {
            addCriterion(columnName + " <>", value, columnName);
            return this;
        }

        public Condition andGreaterThan(final String columnName, final Object value) {
            addCriterion(columnName + " >", value, columnName);
            return this;
        }

        public Condition andGreaterThanOrEqualTo(final String columnName, final Object value) {
            addCriterion(columnName + " >=", value, columnName);
            return this;
        }

        public Condition andLessThan(final String columnName, final Object value) {
            addCriterion(columnName + " <", value, columnName);
            return this;
        }

        public Condition andLessThanOrEqualTo(final String columnName, final Object value) {
            addCriterion(columnName + " <=", value, columnName);
            return this;
        }

        public Condition andBetween(final String columnName, final Object value1, final Object value2) {
            addCriterion(columnName + " between", value1, value2, columnName);
            return this;
        }

        public Condition andNotBetween(final String columnName, final Object value1, final Object value2) {
            addCriterion(columnName + " not between", value1, value2, columnName);
            return this;
        }

        public Condition andIn(final String columnName, final List<Object> values) {
            if (values != null && values.size() > 0) {
                addCriterion(columnName + " in", values, columnName);
            } else {
                addCriterion("1 != 1");
            }
            return this;
        }

        public Condition andNotIn(final String columnName, final List<Object> values) {
            if (values != null && values.size() > 0) {
                addCriterion(columnName + " not in", values, columnName);
            }
            return this;
        }

        public Condition andLeftLike(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion(columnName + " like", value + "%", columnName);
            }
            return this;
        }

        public Condition andRightLike(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion(columnName + " like", "%" + value, columnName);
            }
            return this;
        }

        public Condition andLike(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion(columnName + " like", "%" + value + "%", columnName);
            }
            return this;
        }

        public Condition andLeftNotLike(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion(columnName + " not like", value + "%", columnName);
            }
            return this;
        }

        public Condition andRightNotLike(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion(columnName + " not like", "%" + value, columnName);
            }
            return this;
        }

        public Condition andNotLike(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion(columnName + " not like", "%" + value + "%", columnName);
            }
            return this;
        }

        public Condition andLikeInsensitive(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion("upper(" + columnName + ") like", value == null ? null : "%" + value.toUpperCase() + "%", columnName);
            }
            return this;
        }

        public Condition andLeftLikeInsensitive(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion("upper(" + columnName + ") like", value == null ? null : value.toUpperCase() + "%", columnName);
            }
            return this;
        }

        public Condition andRightLikeInsensitive(final String columnName, final String value) {
            if (StringUtils.isNotBlank(value)) {
                addCriterion("upper(" + columnName + ") like", value == null ? null : "%" + value.toUpperCase(), columnName);
            }
            return this;
        }
    }

    public static class Criterion {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private boolean dateValue;

        private final String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public boolean isDateValue() {
            return dateValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(final String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(final String condition, final Object value, final String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else if (value instanceof Date) {
                this.dateValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(final String condition, final Object value) {
            this(condition, value, null);
        }

        protected Criterion(final String condition, final Object value, final Object secondValue, final String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(final String condition, final Object value, final Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}


