package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationMessageExample() {
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

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdIsNull() {
            addCriterion("punch_record_id is null");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdIsNotNull() {
            addCriterion("punch_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdEqualTo(Long value) {
            addCriterion("punch_record_id =", value, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdNotEqualTo(Long value) {
            addCriterion("punch_record_id <>", value, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdGreaterThan(Long value) {
            addCriterion("punch_record_id >", value, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("punch_record_id >=", value, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdLessThan(Long value) {
            addCriterion("punch_record_id <", value, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("punch_record_id <=", value, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdIn(List<Long> values) {
            addCriterion("punch_record_id in", values, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdNotIn(List<Long> values) {
            addCriterion("punch_record_id not in", values, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdBetween(Long value1, Long value2) {
            addCriterion("punch_record_id between", value1, value2, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("punch_record_id not between", value1, value2, "punchRecordId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdIsNull() {
            addCriterion("punch_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdIsNotNull() {
            addCriterion("punch_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdEqualTo(Integer value) {
            addCriterion("punch_type_id =", value, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdNotEqualTo(Integer value) {
            addCriterion("punch_type_id <>", value, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdGreaterThan(Integer value) {
            addCriterion("punch_type_id >", value, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("punch_type_id >=", value, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdLessThan(Integer value) {
            addCriterion("punch_type_id <", value, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("punch_type_id <=", value, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdIn(List<Integer> values) {
            addCriterion("punch_type_id in", values, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdNotIn(List<Integer> values) {
            addCriterion("punch_type_id not in", values, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("punch_type_id between", value1, value2, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andPunchTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("punch_type_id not between", value1, value2, "punchTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicationResonIsNull() {
            addCriterion("application_reson is null");
            return (Criteria) this;
        }

        public Criteria andApplicationResonIsNotNull() {
            addCriterion("application_reson is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationResonEqualTo(String value) {
            addCriterion("application_reson =", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonNotEqualTo(String value) {
            addCriterion("application_reson <>", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonGreaterThan(String value) {
            addCriterion("application_reson >", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonGreaterThanOrEqualTo(String value) {
            addCriterion("application_reson >=", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonLessThan(String value) {
            addCriterion("application_reson <", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonLessThanOrEqualTo(String value) {
            addCriterion("application_reson <=", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonLike(String value) {
            addCriterion("application_reson like", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonNotLike(String value) {
            addCriterion("application_reson not like", value, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonIn(List<String> values) {
            addCriterion("application_reson in", values, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonNotIn(List<String> values) {
            addCriterion("application_reson not in", values, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonBetween(String value1, String value2) {
            addCriterion("application_reson between", value1, value2, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResonNotBetween(String value1, String value2) {
            addCriterion("application_reson not between", value1, value2, "applicationReson");
            return (Criteria) this;
        }

        public Criteria andApplicationResultIsNull() {
            addCriterion("application_result is null");
            return (Criteria) this;
        }

        public Criteria andApplicationResultIsNotNull() {
            addCriterion("application_result is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationResultEqualTo(Boolean value) {
            addCriterion("application_result =", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultNotEqualTo(Boolean value) {
            addCriterion("application_result <>", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultGreaterThan(Boolean value) {
            addCriterion("application_result >", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("application_result >=", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultLessThan(Boolean value) {
            addCriterion("application_result <", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultLessThanOrEqualTo(Boolean value) {
            addCriterion("application_result <=", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultIn(List<Boolean> values) {
            addCriterion("application_result in", values, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultNotIn(List<Boolean> values) {
            addCriterion("application_result not in", values, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultBetween(Boolean value1, Boolean value2) {
            addCriterion("application_result between", value1, value2, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("application_result not between", value1, value2, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeIsNull() {
            addCriterion("change_punch_type is null");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeIsNotNull() {
            addCriterion("change_punch_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeEqualTo(Integer value) {
            addCriterion("change_punch_type =", value, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeNotEqualTo(Integer value) {
            addCriterion("change_punch_type <>", value, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeGreaterThan(Integer value) {
            addCriterion("change_punch_type >", value, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_punch_type >=", value, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeLessThan(Integer value) {
            addCriterion("change_punch_type <", value, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeLessThanOrEqualTo(Integer value) {
            addCriterion("change_punch_type <=", value, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeIn(List<Integer> values) {
            addCriterion("change_punch_type in", values, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeNotIn(List<Integer> values) {
            addCriterion("change_punch_type not in", values, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeBetween(Integer value1, Integer value2) {
            addCriterion("change_punch_type between", value1, value2, "changePunchType");
            return (Criteria) this;
        }

        public Criteria andChangePunchTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("change_punch_type not between", value1, value2, "changePunchType");
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