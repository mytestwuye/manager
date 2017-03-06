package com.suny.association.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoginHistoryExample() {
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

        public Criteria andLoginHistoryIdIsNull() {
            addCriterion("login_history_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdIsNotNull() {
            addCriterion("login_history_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdEqualTo(Long value) {
            addCriterion("login_history_id =", value, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdNotEqualTo(Long value) {
            addCriterion("login_history_id <>", value, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdGreaterThan(Long value) {
            addCriterion("login_history_id >", value, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("login_history_id >=", value, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdLessThan(Long value) {
            addCriterion("login_history_id <", value, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdLessThanOrEqualTo(Long value) {
            addCriterion("login_history_id <=", value, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdIn(List<Long> values) {
            addCriterion("login_history_id in", values, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdNotIn(List<Long> values) {
            addCriterion("login_history_id not in", values, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdBetween(Long value1, Long value2) {
            addCriterion("login_history_id between", value1, value2, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andLoginHistoryIdNotBetween(Long value1, Long value2) {
            addCriterion("login_history_id not between", value1, value2, "loginHistoryId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdIsNull() {
            addCriterion("history_account_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdIsNotNull() {
            addCriterion("history_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdEqualTo(Integer value) {
            addCriterion("history_account_id =", value, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdNotEqualTo(Integer value) {
            addCriterion("history_account_id <>", value, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdGreaterThan(Integer value) {
            addCriterion("history_account_id >", value, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_account_id >=", value, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdLessThan(Integer value) {
            addCriterion("history_account_id <", value, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("history_account_id <=", value, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdIn(List<Integer> values) {
            addCriterion("history_account_id in", values, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdNotIn(List<Integer> values) {
            addCriterion("history_account_id not in", values, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("history_account_id between", value1, value2, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andHistoryAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("history_account_id not between", value1, value2, "historyAccountId");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last-login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last-login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last-login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last-login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last-login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last-login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last-login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last-login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last-login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last-login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last-login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last-login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserIsNull() {
            addCriterion("login_browser is null");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserIsNotNull() {
            addCriterion("login_browser is not null");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserEqualTo(String value) {
            addCriterion("login_browser =", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotEqualTo(String value) {
            addCriterion("login_browser <>", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserGreaterThan(String value) {
            addCriterion("login_browser >", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("login_browser >=", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserLessThan(String value) {
            addCriterion("login_browser <", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserLessThanOrEqualTo(String value) {
            addCriterion("login_browser <=", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserLike(String value) {
            addCriterion("login_browser like", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotLike(String value) {
            addCriterion("login_browser not like", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserIn(List<String> values) {
            addCriterion("login_browser in", values, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotIn(List<String> values) {
            addCriterion("login_browser not in", values, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserBetween(String value1, String value2) {
            addCriterion("login_browser between", value1, value2, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotBetween(String value1, String value2) {
            addCriterion("login_browser not between", value1, value2, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionIsNull() {
            addCriterion("login_os_version is null");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionIsNotNull() {
            addCriterion("login_os_version is not null");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionEqualTo(String value) {
            addCriterion("login_os_version =", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionNotEqualTo(String value) {
            addCriterion("login_os_version <>", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionGreaterThan(String value) {
            addCriterion("login_os_version >", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionGreaterThanOrEqualTo(String value) {
            addCriterion("login_os_version >=", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionLessThan(String value) {
            addCriterion("login_os_version <", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionLessThanOrEqualTo(String value) {
            addCriterion("login_os_version <=", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionLike(String value) {
            addCriterion("login_os_version like", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionNotLike(String value) {
            addCriterion("login_os_version not like", value, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionIn(List<String> values) {
            addCriterion("login_os_version in", values, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionNotIn(List<String> values) {
            addCriterion("login_os_version not in", values, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionBetween(String value1, String value2) {
            addCriterion("login_os_version between", value1, value2, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginOsVersionNotBetween(String value1, String value2) {
            addCriterion("login_os_version not between", value1, value2, "loginOsVersion");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentIsNull() {
            addCriterion("login_user_agent is null");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentIsNotNull() {
            addCriterion("login_user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentEqualTo(String value) {
            addCriterion("login_user_agent =", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentNotEqualTo(String value) {
            addCriterion("login_user_agent <>", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentGreaterThan(String value) {
            addCriterion("login_user_agent >", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("login_user_agent >=", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentLessThan(String value) {
            addCriterion("login_user_agent <", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentLessThanOrEqualTo(String value) {
            addCriterion("login_user_agent <=", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentLike(String value) {
            addCriterion("login_user_agent like", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentNotLike(String value) {
            addCriterion("login_user_agent not like", value, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentIn(List<String> values) {
            addCriterion("login_user_agent in", values, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentNotIn(List<String> values) {
            addCriterion("login_user_agent not in", values, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentBetween(String value1, String value2) {
            addCriterion("login_user_agent between", value1, value2, "loginUserAgent");
            return (Criteria) this;
        }

        public Criteria andLoginUserAgentNotBetween(String value1, String value2) {
            addCriterion("login_user_agent not between", value1, value2, "loginUserAgent");
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