package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordIsNull() {
            addCriterion("account_password is null");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordIsNotNull() {
            addCriterion("account_password is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordEqualTo(String value) {
            addCriterion("account_password =", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotEqualTo(String value) {
            addCriterion("account_password <>", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordGreaterThan(String value) {
            addCriterion("account_password >", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("account_password >=", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordLessThan(String value) {
            addCriterion("account_password <", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordLessThanOrEqualTo(String value) {
            addCriterion("account_password <=", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordLike(String value) {
            addCriterion("account_password like", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotLike(String value) {
            addCriterion("account_password not like", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordIn(List<String> values) {
            addCriterion("account_password in", values, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotIn(List<String> values) {
            addCriterion("account_password not in", values, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordBetween(String value1, String value2) {
            addCriterion("account_password between", value1, value2, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotBetween(String value1, String value2) {
            addCriterion("account_password not between", value1, value2, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneIsNull() {
            addCriterion("account_phone is null");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneIsNotNull() {
            addCriterion("account_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneEqualTo(Integer value) {
            addCriterion("account_phone =", value, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneNotEqualTo(Integer value) {
            addCriterion("account_phone <>", value, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneGreaterThan(Integer value) {
            addCriterion("account_phone >", value, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_phone >=", value, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneLessThan(Integer value) {
            addCriterion("account_phone <", value, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("account_phone <=", value, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneIn(List<Integer> values) {
            addCriterion("account_phone in", values, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneNotIn(List<Integer> values) {
            addCriterion("account_phone not in", values, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneBetween(Integer value1, Integer value2) {
            addCriterion("account_phone between", value1, value2, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("account_phone not between", value1, value2, "accountPhone");
            return (Criteria) this;
        }

        public Criteria andAccountEmailIsNull() {
            addCriterion("account_email is null");
            return (Criteria) this;
        }

        public Criteria andAccountEmailIsNotNull() {
            addCriterion("account_email is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEmailEqualTo(String value) {
            addCriterion("account_email =", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailNotEqualTo(String value) {
            addCriterion("account_email <>", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailGreaterThan(String value) {
            addCriterion("account_email >", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailGreaterThanOrEqualTo(String value) {
            addCriterion("account_email >=", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailLessThan(String value) {
            addCriterion("account_email <", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailLessThanOrEqualTo(String value) {
            addCriterion("account_email <=", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailLike(String value) {
            addCriterion("account_email like", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailNotLike(String value) {
            addCriterion("account_email not like", value, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailIn(List<String> values) {
            addCriterion("account_email in", values, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailNotIn(List<String> values) {
            addCriterion("account_email not in", values, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailBetween(String value1, String value2) {
            addCriterion("account_email between", value1, value2, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountEmailNotBetween(String value1, String value2) {
            addCriterion("account_email not between", value1, value2, "accountEmail");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(Boolean value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(Boolean value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(Boolean value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(Boolean value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<Boolean> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<Boolean> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdIsNull() {
            addCriterion("account_role_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdIsNotNull() {
            addCriterion("account_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdEqualTo(Integer value) {
            addCriterion("account_role_id =", value, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdNotEqualTo(Integer value) {
            addCriterion("account_role_id <>", value, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdGreaterThan(Integer value) {
            addCriterion("account_role_id >", value, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_role_id >=", value, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdLessThan(Integer value) {
            addCriterion("account_role_id <", value, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_role_id <=", value, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdIn(List<Integer> values) {
            addCriterion("account_role_id in", values, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdNotIn(List<Integer> values) {
            addCriterion("account_role_id not in", values, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("account_role_id between", value1, value2, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_role_id not between", value1, value2, "accountRoleId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdIsNull() {
            addCriterion("account_member_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdIsNotNull() {
            addCriterion("account_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdEqualTo(Integer value) {
            addCriterion("account_member_id =", value, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdNotEqualTo(Integer value) {
            addCriterion("account_member_id <>", value, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdGreaterThan(Integer value) {
            addCriterion("account_member_id >", value, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_member_id >=", value, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdLessThan(Integer value) {
            addCriterion("account_member_id <", value, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_member_id <=", value, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdIn(List<Integer> values) {
            addCriterion("account_member_id in", values, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdNotIn(List<Integer> values) {
            addCriterion("account_member_id not in", values, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("account_member_id between", value1, value2, "accountMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_member_id not between", value1, value2, "accountMemberId");
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