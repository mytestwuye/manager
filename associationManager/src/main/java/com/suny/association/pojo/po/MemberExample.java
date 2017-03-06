package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameIsNull() {
            addCriterion("member_class_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameIsNotNull() {
            addCriterion("member_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameEqualTo(String value) {
            addCriterion("member_class_name =", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameNotEqualTo(String value) {
            addCriterion("member_class_name <>", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameGreaterThan(String value) {
            addCriterion("member_class_name >", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_class_name >=", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameLessThan(String value) {
            addCriterion("member_class_name <", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameLessThanOrEqualTo(String value) {
            addCriterion("member_class_name <=", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameLike(String value) {
            addCriterion("member_class_name like", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameNotLike(String value) {
            addCriterion("member_class_name not like", value, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameIn(List<String> values) {
            addCriterion("member_class_name in", values, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameNotIn(List<String> values) {
            addCriterion("member_class_name not in", values, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameBetween(String value1, String value2) {
            addCriterion("member_class_name between", value1, value2, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberClassNameNotBetween(String value1, String value2) {
            addCriterion("member_class_name not between", value1, value2, "memberClassName");
            return (Criteria) this;
        }

        public Criteria andMemberSexIsNull() {
            addCriterion("member_sex is null");
            return (Criteria) this;
        }

        public Criteria andMemberSexIsNotNull() {
            addCriterion("member_sex is not null");
            return (Criteria) this;
        }

        public Criteria andMemberSexEqualTo(Boolean value) {
            addCriterion("member_sex =", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotEqualTo(Boolean value) {
            addCriterion("member_sex <>", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThan(Boolean value) {
            addCriterion("member_sex >", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("member_sex >=", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThan(Boolean value) {
            addCriterion("member_sex <", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThanOrEqualTo(Boolean value) {
            addCriterion("member_sex <=", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexIn(List<Boolean> values) {
            addCriterion("member_sex in", values, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotIn(List<Boolean> values) {
            addCriterion("member_sex not in", values, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexBetween(Boolean value1, Boolean value2) {
            addCriterion("member_sex between", value1, value2, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("member_sex not between", value1, value2, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberIsNull() {
            addCriterion("memver_grade_number is null");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberIsNotNull() {
            addCriterion("memver_grade_number is not null");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberEqualTo(Integer value) {
            addCriterion("memver_grade_number =", value, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberNotEqualTo(Integer value) {
            addCriterion("memver_grade_number <>", value, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberGreaterThan(Integer value) {
            addCriterion("memver_grade_number >", value, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("memver_grade_number >=", value, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberLessThan(Integer value) {
            addCriterion("memver_grade_number <", value, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("memver_grade_number <=", value, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberIn(List<Integer> values) {
            addCriterion("memver_grade_number in", values, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberNotIn(List<Integer> values) {
            addCriterion("memver_grade_number not in", values, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberBetween(Integer value1, Integer value2) {
            addCriterion("memver_grade_number between", value1, value2, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemverGradeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("memver_grade_number not between", value1, value2, "memverGradeNumber");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdIsNull() {
            addCriterion("member_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdIsNotNull() {
            addCriterion("member_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdEqualTo(Integer value) {
            addCriterion("member_manager_id =", value, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdNotEqualTo(Integer value) {
            addCriterion("member_manager_id <>", value, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdGreaterThan(Integer value) {
            addCriterion("member_manager_id >", value, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_manager_id >=", value, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdLessThan(Integer value) {
            addCriterion("member_manager_id <", value, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_manager_id <=", value, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdIn(List<Integer> values) {
            addCriterion("member_manager_id in", values, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdNotIn(List<Integer> values) {
            addCriterion("member_manager_id not in", values, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("member_manager_id between", value1, value2, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_manager_id not between", value1, value2, "memberManagerId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdIsNull() {
            addCriterion("member_department_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdIsNotNull() {
            addCriterion("member_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdEqualTo(Integer value) {
            addCriterion("member_department_id =", value, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdNotEqualTo(Integer value) {
            addCriterion("member_department_id <>", value, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdGreaterThan(Integer value) {
            addCriterion("member_department_id >", value, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_department_id >=", value, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdLessThan(Integer value) {
            addCriterion("member_department_id <", value, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_department_id <=", value, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdIn(List<Integer> values) {
            addCriterion("member_department_id in", values, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdNotIn(List<Integer> values) {
            addCriterion("member_department_id not in", values, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("member_department_id between", value1, value2, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_department_id not between", value1, value2, "memberDepartmentId");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIsNull() {
            addCriterion("member_status is null");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIsNotNull() {
            addCriterion("member_status is not null");
            return (Criteria) this;
        }

        public Criteria andMemberStatusEqualTo(Boolean value) {
            addCriterion("member_status =", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotEqualTo(Boolean value) {
            addCriterion("member_status <>", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusGreaterThan(Boolean value) {
            addCriterion("member_status >", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("member_status >=", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLessThan(Boolean value) {
            addCriterion("member_status <", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("member_status <=", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIn(List<Boolean> values) {
            addCriterion("member_status in", values, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotIn(List<Boolean> values) {
            addCriterion("member_status not in", values, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("member_status between", value1, value2, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("member_status not between", value1, value2, "memberStatus");
            return (Criteria) this;
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