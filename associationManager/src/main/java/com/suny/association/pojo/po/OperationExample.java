package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class OperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationExample() {
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

        public Criteria andOperationIdIsNull() {
            addCriterion("operation_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNotNull() {
            addCriterion("operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationIdEqualTo(Long value) {
            addCriterion("operation_id =", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotEqualTo(Long value) {
            addCriterion("operation_id <>", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThan(Long value) {
            addCriterion("operation_id >", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_id >=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThan(Long value) {
            addCriterion("operation_id <", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThanOrEqualTo(Long value) {
            addCriterion("operation_id <=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdIn(List<Long> values) {
            addCriterion("operation_id in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotIn(List<Long> values) {
            addCriterion("operation_id not in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdBetween(Long value1, Long value2) {
            addCriterion("operation_id between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotBetween(Long value1, Long value2) {
            addCriterion("operation_id not between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationMessageIsNull() {
            addCriterion("operation_message is null");
            return (Criteria) this;
        }

        public Criteria andOperationMessageIsNotNull() {
            addCriterion("operation_message is not null");
            return (Criteria) this;
        }

        public Criteria andOperationMessageEqualTo(String value) {
            addCriterion("operation_message =", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageNotEqualTo(String value) {
            addCriterion("operation_message <>", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageGreaterThan(String value) {
            addCriterion("operation_message >", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageGreaterThanOrEqualTo(String value) {
            addCriterion("operation_message >=", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageLessThan(String value) {
            addCriterion("operation_message <", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageLessThanOrEqualTo(String value) {
            addCriterion("operation_message <=", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageLike(String value) {
            addCriterion("operation_message like", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageNotLike(String value) {
            addCriterion("operation_message not like", value, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageIn(List<String> values) {
            addCriterion("operation_message in", values, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageNotIn(List<String> values) {
            addCriterion("operation_message not in", values, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageBetween(String value1, String value2) {
            addCriterion("operation_message between", value1, value2, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationMessageNotBetween(String value1, String value2) {
            addCriterion("operation_message not between", value1, value2, "operationMessage");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerIsNull() {
            addCriterion("operation_brower is null");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerIsNotNull() {
            addCriterion("operation_brower is not null");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerEqualTo(String value) {
            addCriterion("operation_brower =", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerNotEqualTo(String value) {
            addCriterion("operation_brower <>", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerGreaterThan(String value) {
            addCriterion("operation_brower >", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerGreaterThanOrEqualTo(String value) {
            addCriterion("operation_brower >=", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerLessThan(String value) {
            addCriterion("operation_brower <", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerLessThanOrEqualTo(String value) {
            addCriterion("operation_brower <=", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerLike(String value) {
            addCriterion("operation_brower like", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerNotLike(String value) {
            addCriterion("operation_brower not like", value, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerIn(List<String> values) {
            addCriterion("operation_brower in", values, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerNotIn(List<String> values) {
            addCriterion("operation_brower not in", values, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerBetween(String value1, String value2) {
            addCriterion("operation_brower between", value1, value2, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationBrowerNotBetween(String value1, String value2) {
            addCriterion("operation_brower not between", value1, value2, "operationBrower");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionIsNull() {
            addCriterion("operation_os_version is null");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionIsNotNull() {
            addCriterion("operation_os_version is not null");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionEqualTo(String value) {
            addCriterion("operation_os_version =", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionNotEqualTo(String value) {
            addCriterion("operation_os_version <>", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionGreaterThan(String value) {
            addCriterion("operation_os_version >", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionGreaterThanOrEqualTo(String value) {
            addCriterion("operation_os_version >=", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionLessThan(String value) {
            addCriterion("operation_os_version <", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionLessThanOrEqualTo(String value) {
            addCriterion("operation_os_version <=", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionLike(String value) {
            addCriterion("operation_os_version like", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionNotLike(String value) {
            addCriterion("operation_os_version not like", value, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionIn(List<String> values) {
            addCriterion("operation_os_version in", values, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionNotIn(List<String> values) {
            addCriterion("operation_os_version not in", values, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionBetween(String value1, String value2) {
            addCriterion("operation_os_version between", value1, value2, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationOsVersionNotBetween(String value1, String value2) {
            addCriterion("operation_os_version not between", value1, value2, "operationOsVersion");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentIsNull() {
            addCriterion("operation_user_agent is null");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentIsNotNull() {
            addCriterion("operation_user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentEqualTo(String value) {
            addCriterion("operation_user_agent =", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentNotEqualTo(String value) {
            addCriterion("operation_user_agent <>", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentGreaterThan(String value) {
            addCriterion("operation_user_agent >", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("operation_user_agent >=", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentLessThan(String value) {
            addCriterion("operation_user_agent <", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentLessThanOrEqualTo(String value) {
            addCriterion("operation_user_agent <=", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentLike(String value) {
            addCriterion("operation_user_agent like", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentNotLike(String value) {
            addCriterion("operation_user_agent not like", value, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentIn(List<String> values) {
            addCriterion("operation_user_agent in", values, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentNotIn(List<String> values) {
            addCriterion("operation_user_agent not in", values, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentBetween(String value1, String value2) {
            addCriterion("operation_user_agent between", value1, value2, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationUserAgentNotBetween(String value1, String value2) {
            addCriterion("operation_user_agent not between", value1, value2, "operationUserAgent");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlIsNull() {
            addCriterion("operation_request_url is null");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlIsNotNull() {
            addCriterion("operation_request_url is not null");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlEqualTo(String value) {
            addCriterion("operation_request_url =", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlNotEqualTo(String value) {
            addCriterion("operation_request_url <>", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlGreaterThan(String value) {
            addCriterion("operation_request_url >", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("operation_request_url >=", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlLessThan(String value) {
            addCriterion("operation_request_url <", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlLessThanOrEqualTo(String value) {
            addCriterion("operation_request_url <=", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlLike(String value) {
            addCriterion("operation_request_url like", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlNotLike(String value) {
            addCriterion("operation_request_url not like", value, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlIn(List<String> values) {
            addCriterion("operation_request_url in", values, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlNotIn(List<String> values) {
            addCriterion("operation_request_url not in", values, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlBetween(String value1, String value2) {
            addCriterion("operation_request_url between", value1, value2, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationRequestUrlNotBetween(String value1, String value2) {
            addCriterion("operation_request_url not between", value1, value2, "operationRequestUrl");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdIsNull() {
            addCriterion("operation_account_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdIsNotNull() {
            addCriterion("operation_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdEqualTo(Long value) {
            addCriterion("operation_account_id =", value, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdNotEqualTo(Long value) {
            addCriterion("operation_account_id <>", value, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdGreaterThan(Long value) {
            addCriterion("operation_account_id >", value, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_account_id >=", value, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdLessThan(Long value) {
            addCriterion("operation_account_id <", value, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("operation_account_id <=", value, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdIn(List<Long> values) {
            addCriterion("operation_account_id in", values, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdNotIn(List<Long> values) {
            addCriterion("operation_account_id not in", values, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdBetween(Long value1, Long value2) {
            addCriterion("operation_account_id between", value1, value2, "operationAccountId");
            return (Criteria) this;
        }

        public Criteria andOperationAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("operation_account_id not between", value1, value2, "operationAccountId");
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