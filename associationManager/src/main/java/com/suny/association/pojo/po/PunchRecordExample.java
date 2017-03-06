package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PunchRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PunchRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andPunchDatetimeIsNull() {
            addCriterion("punch_datetime is null");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeIsNotNull() {
            addCriterion("punch_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeEqualTo(Date value) {
            addCriterion("punch_datetime =", value, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeNotEqualTo(Date value) {
            addCriterion("punch_datetime <>", value, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeGreaterThan(Date value) {
            addCriterion("punch_datetime >", value, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("punch_datetime >=", value, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeLessThan(Date value) {
            addCriterion("punch_datetime <", value, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("punch_datetime <=", value, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeIn(List<Date> values) {
            addCriterion("punch_datetime in", values, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeNotIn(List<Date> values) {
            addCriterion("punch_datetime not in", values, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeBetween(Date value1, Date value2) {
            addCriterion("punch_datetime between", value1, value2, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("punch_datetime not between", value1, value2, "punchDatetime");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateIsNull() {
            addCriterion("punch_today_date is null");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateIsNotNull() {
            addCriterion("punch_today_date is not null");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateEqualTo(Date value) {
            addCriterionForJDBCDate("punch_today_date =", value, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("punch_today_date <>", value, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("punch_today_date >", value, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("punch_today_date >=", value, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateLessThan(Date value) {
            addCriterionForJDBCDate("punch_today_date <", value, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("punch_today_date <=", value, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateIn(List<Date> values) {
            addCriterionForJDBCDate("punch_today_date in", values, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("punch_today_date not in", values, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("punch_today_date between", value1, value2, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchTodayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("punch_today_date not between", value1, value2, "punchTodayDate");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeIsNull() {
            addCriterion("punch_is_come is null");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeIsNotNull() {
            addCriterion("punch_is_come is not null");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeEqualTo(Boolean value) {
            addCriterion("punch_is_come =", value, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeNotEqualTo(Boolean value) {
            addCriterion("punch_is_come <>", value, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeGreaterThan(Boolean value) {
            addCriterion("punch_is_come >", value, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("punch_is_come >=", value, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeLessThan(Boolean value) {
            addCriterion("punch_is_come <", value, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeLessThanOrEqualTo(Boolean value) {
            addCriterion("punch_is_come <=", value, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeIn(List<Boolean> values) {
            addCriterion("punch_is_come in", values, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeNotIn(List<Boolean> values) {
            addCriterion("punch_is_come not in", values, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeBetween(Boolean value1, Boolean value2) {
            addCriterion("punch_is_come between", value1, value2, "punchIsCome");
            return (Criteria) this;
        }

        public Criteria andPunchIsComeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("punch_is_come not between", value1, value2, "punchIsCome");
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

        public Criteria andPunchMemberIdIsNull() {
            addCriterion("punch_member_id is null");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdIsNotNull() {
            addCriterion("punch_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdEqualTo(Integer value) {
            addCriterion("punch_member_id =", value, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdNotEqualTo(Integer value) {
            addCriterion("punch_member_id <>", value, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdGreaterThan(Integer value) {
            addCriterion("punch_member_id >", value, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("punch_member_id >=", value, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdLessThan(Integer value) {
            addCriterion("punch_member_id <", value, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("punch_member_id <=", value, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdIn(List<Integer> values) {
            addCriterion("punch_member_id in", values, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdNotIn(List<Integer> values) {
            addCriterion("punch_member_id not in", values, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("punch_member_id between", value1, value2, "punchMemberId");
            return (Criteria) this;
        }

        public Criteria andPunchMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("punch_member_id not between", value1, value2, "punchMemberId");
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