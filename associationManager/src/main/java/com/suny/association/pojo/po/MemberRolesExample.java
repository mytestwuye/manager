package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class MemberRolesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberRolesExample() {
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

        public Criteria andMemberRoleIdIsNull() {
            addCriterion("member_role_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdIsNotNull() {
            addCriterion("member_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdEqualTo(Integer value) {
            addCriterion("member_role_id =", value, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdNotEqualTo(Integer value) {
            addCriterion("member_role_id <>", value, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdGreaterThan(Integer value) {
            addCriterion("member_role_id >", value, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_role_id >=", value, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdLessThan(Integer value) {
            addCriterion("member_role_id <", value, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_role_id <=", value, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdIn(List<Integer> values) {
            addCriterion("member_role_id in", values, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdNotIn(List<Integer> values) {
            addCriterion("member_role_id not in", values, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("member_role_id between", value1, value2, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_role_id not between", value1, value2, "memberRoleId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameIsNull() {
            addCriterion("member_role_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameIsNotNull() {
            addCriterion("member_role_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameEqualTo(String value) {
            addCriterion("member_role_name =", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameNotEqualTo(String value) {
            addCriterion("member_role_name <>", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameGreaterThan(String value) {
            addCriterion("member_role_name >", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_role_name >=", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameLessThan(String value) {
            addCriterion("member_role_name <", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameLessThanOrEqualTo(String value) {
            addCriterion("member_role_name <=", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameLike(String value) {
            addCriterion("member_role_name like", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameNotLike(String value) {
            addCriterion("member_role_name not like", value, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameIn(List<String> values) {
            addCriterion("member_role_name in", values, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameNotIn(List<String> values) {
            addCriterion("member_role_name not in", values, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameBetween(String value1, String value2) {
            addCriterion("member_role_name between", value1, value2, "memberRoleName");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNameNotBetween(String value1, String value2) {
            addCriterion("member_role_name not between", value1, value2, "memberRoleName");
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