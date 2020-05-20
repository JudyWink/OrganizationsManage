package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignuporgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignuporgExample() {
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

        public Criteria andSignupidIsNull() {
            addCriterion("signupID is null");
            return (Criteria) this;
        }

        public Criteria andSignupidIsNotNull() {
            addCriterion("signupID is not null");
            return (Criteria) this;
        }

        public Criteria andSignupidEqualTo(Integer value) {
            addCriterion("signupID =", value, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidNotEqualTo(Integer value) {
            addCriterion("signupID <>", value, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidGreaterThan(Integer value) {
            addCriterion("signupID >", value, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidGreaterThanOrEqualTo(Integer value) {
            addCriterion("signupID >=", value, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidLessThan(Integer value) {
            addCriterion("signupID <", value, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidLessThanOrEqualTo(Integer value) {
            addCriterion("signupID <=", value, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidIn(List<Integer> values) {
            addCriterion("signupID in", values, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidNotIn(List<Integer> values) {
            addCriterion("signupID not in", values, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidBetween(Integer value1, Integer value2) {
            addCriterion("signupID between", value1, value2, "signupid");
            return (Criteria) this;
        }

        public Criteria andSignupidNotBetween(Integer value1, Integer value2) {
            addCriterion("signupID not between", value1, value2, "signupid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("orgID is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("orgID =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("orgID <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("orgID >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orgID >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("orgID <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("orgID <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("orgID in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("orgID not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("orgID between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("orgID not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeIsNull() {
            addCriterion("AdmissionTime is null");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeIsNotNull() {
            addCriterion("AdmissionTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeEqualTo(Date value) {
            addCriterion("AdmissionTime =", value, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeNotEqualTo(Date value) {
            addCriterion("AdmissionTime <>", value, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeGreaterThan(Date value) {
            addCriterion("AdmissionTime >", value, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AdmissionTime >=", value, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeLessThan(Date value) {
            addCriterion("AdmissionTime <", value, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeLessThanOrEqualTo(Date value) {
            addCriterion("AdmissionTime <=", value, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeIn(List<Date> values) {
            addCriterion("AdmissionTime in", values, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeNotIn(List<Date> values) {
            addCriterion("AdmissionTime not in", values, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeBetween(Date value1, Date value2) {
            addCriterion("AdmissionTime between", value1, value2, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andAdmissiontimeNotBetween(Date value1, Date value2) {
            addCriterion("AdmissionTime not between", value1, value2, "admissiontime");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionIsNull() {
            addCriterion("isNotAdmission is null");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionIsNotNull() {
            addCriterion("isNotAdmission is not null");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionEqualTo(String value) {
            addCriterion("isNotAdmission =", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionNotEqualTo(String value) {
            addCriterion("isNotAdmission <>", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionGreaterThan(String value) {
            addCriterion("isNotAdmission >", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionGreaterThanOrEqualTo(String value) {
            addCriterion("isNotAdmission >=", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionLessThan(String value) {
            addCriterion("isNotAdmission <", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionLessThanOrEqualTo(String value) {
            addCriterion("isNotAdmission <=", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionLike(String value) {
            addCriterion("isNotAdmission like", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionNotLike(String value) {
            addCriterion("isNotAdmission not like", value, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionIn(List<String> values) {
            addCriterion("isNotAdmission in", values, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionNotIn(List<String> values) {
            addCriterion("isNotAdmission not in", values, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionBetween(String value1, String value2) {
            addCriterion("isNotAdmission between", value1, value2, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andIsnotadmissionNotBetween(String value1, String value2) {
            addCriterion("isNotAdmission not between", value1, value2, "isnotadmission");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeIsNull() {
            addCriterion("signuporgTime is null");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeIsNotNull() {
            addCriterion("signuporgTime is not null");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeEqualTo(Date value) {
            addCriterion("signuporgTime =", value, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeNotEqualTo(Date value) {
            addCriterion("signuporgTime <>", value, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeGreaterThan(Date value) {
            addCriterion("signuporgTime >", value, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("signuporgTime >=", value, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeLessThan(Date value) {
            addCriterion("signuporgTime <", value, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeLessThanOrEqualTo(Date value) {
            addCriterion("signuporgTime <=", value, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeIn(List<Date> values) {
            addCriterion("signuporgTime in", values, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeNotIn(List<Date> values) {
            addCriterion("signuporgTime not in", values, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeBetween(Date value1, Date value2) {
            addCriterion("signuporgTime between", value1, value2, "signuporgtime");
            return (Criteria) this;
        }

        public Criteria andSignuporgtimeNotBetween(Date value1, Date value2) {
            addCriterion("signuporgTime not between", value1, value2, "signuporgtime");
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