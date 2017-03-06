package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class CheckbackResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckbackResultExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCheckbackIdIsNull() {
            addCriterion("checkback_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdIsNotNull() {
            addCriterion("checkback_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdEqualTo(Integer value) {
            addCriterion("checkback_id =", value, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdNotEqualTo(Integer value) {
            addCriterion("checkback_id <>", value, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdGreaterThan(Integer value) {
            addCriterion("checkback_id >", value, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkback_id >=", value, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdLessThan(Integer value) {
            addCriterion("checkback_id <", value, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("checkback_id <=", value, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdIn(List<Integer> values) {
            addCriterion("checkback_id in", values, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdNotIn(List<Integer> values) {
            addCriterion("checkback_id not in", values, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdBetween(Integer value1, Integer value2) {
            addCriterion("checkback_id between", value1, value2, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andCheckbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("checkback_id not between", value1, value2, "checkbackId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdIsNull() {
            addCriterion("application_message_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdIsNotNull() {
            addCriterion("application_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdEqualTo(Integer value) {
            addCriterion("application_message_id =", value, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdNotEqualTo(Integer value) {
            addCriterion("application_message_id <>", value, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdGreaterThan(Integer value) {
            addCriterion("application_message_id >", value, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_message_id >=", value, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdLessThan(Integer value) {
            addCriterion("application_message_id <", value, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_message_id <=", value, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdIn(List<Integer> values) {
            addCriterion("application_message_id in", values, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdNotIn(List<Integer> values) {
            addCriterion("application_message_id not in", values, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("application_message_id between", value1, value2, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andApplicationMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_message_id not between", value1, value2, "applicationMessageId");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultIsNull() {
            addCriterion("checkback_result is null");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultIsNotNull() {
            addCriterion("checkback_result is not null");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultEqualTo(Boolean value) {
            addCriterion("checkback_result =", value, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultNotEqualTo(Boolean value) {
            addCriterion("checkback_result <>", value, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultGreaterThan(Boolean value) {
            addCriterion("checkback_result >", value, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("checkback_result >=", value, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultLessThan(Boolean value) {
            addCriterion("checkback_result <", value, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultLessThanOrEqualTo(Boolean value) {
            addCriterion("checkback_result <=", value, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultIn(List<Boolean> values) {
            addCriterion("checkback_result in", values, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultNotIn(List<Boolean> values) {
            addCriterion("checkback_result not in", values, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultBetween(Boolean value1, Boolean value2) {
            addCriterion("checkback_result between", value1, value2, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackResultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("checkback_result not between", value1, value2, "checkbackResult");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdIsNull() {
            addCriterion("checkback_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdIsNotNull() {
            addCriterion("checkback_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdEqualTo(Integer value) {
            addCriterion("checkback_manager_id =", value, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdNotEqualTo(Integer value) {
            addCriterion("checkback_manager_id <>", value, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdGreaterThan(Integer value) {
            addCriterion("checkback_manager_id >", value, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkback_manager_id >=", value, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdLessThan(Integer value) {
            addCriterion("checkback_manager_id <", value, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("checkback_manager_id <=", value, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdIn(List<Integer> values) {
            addCriterion("checkback_manager_id in", values, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdNotIn(List<Integer> values) {
            addCriterion("checkback_manager_id not in", values, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("checkback_manager_id between", value1, value2, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("checkback_manager_id not between", value1, value2, "checkbackManagerId");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonIsNull() {
            addCriterion("checkback_reson is null");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonIsNotNull() {
            addCriterion("checkback_reson is not null");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonEqualTo(String value) {
            addCriterion("checkback_reson =", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonNotEqualTo(String value) {
            addCriterion("checkback_reson <>", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonGreaterThan(String value) {
            addCriterion("checkback_reson >", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonGreaterThanOrEqualTo(String value) {
            addCriterion("checkback_reson >=", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonLessThan(String value) {
            addCriterion("checkback_reson <", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonLessThanOrEqualTo(String value) {
            addCriterion("checkback_reson <=", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonLike(String value) {
            addCriterion("checkback_reson like", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonNotLike(String value) {
            addCriterion("checkback_reson not like", value, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonIn(List<String> values) {
            addCriterion("checkback_reson in", values, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonNotIn(List<String> values) {
            addCriterion("checkback_reson not in", values, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonBetween(String value1, String value2) {
            addCriterion("checkback_reson between", value1, value2, "checkbackReson");
            return (Criteria) this;
        }

        public Criteria andCheckbackResonNotBetween(String value1, String value2) {
            addCriterion("checkback_reson not between", value1, value2, "checkbackReson");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}