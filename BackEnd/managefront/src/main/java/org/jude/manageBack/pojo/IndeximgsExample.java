package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndeximgsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndeximgsExample() {
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

        public Criteria andIndeximgidIsNull() {
            addCriterion("indeximgId is null");
            return (Criteria) this;
        }

        public Criteria andIndeximgidIsNotNull() {
            addCriterion("indeximgId is not null");
            return (Criteria) this;
        }

        public Criteria andIndeximgidEqualTo(Integer value) {
            addCriterion("indeximgId =", value, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidNotEqualTo(Integer value) {
            addCriterion("indeximgId <>", value, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidGreaterThan(Integer value) {
            addCriterion("indeximgId >", value, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("indeximgId >=", value, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidLessThan(Integer value) {
            addCriterion("indeximgId <", value, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidLessThanOrEqualTo(Integer value) {
            addCriterion("indeximgId <=", value, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidIn(List<Integer> values) {
            addCriterion("indeximgId in", values, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidNotIn(List<Integer> values) {
            addCriterion("indeximgId not in", values, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidBetween(Integer value1, Integer value2) {
            addCriterion("indeximgId between", value1, value2, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgidNotBetween(Integer value1, Integer value2) {
            addCriterion("indeximgId not between", value1, value2, "indeximgid");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlIsNull() {
            addCriterion("indeximgUrl is null");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlIsNotNull() {
            addCriterion("indeximgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlEqualTo(String value) {
            addCriterion("indeximgUrl =", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlNotEqualTo(String value) {
            addCriterion("indeximgUrl <>", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlGreaterThan(String value) {
            addCriterion("indeximgUrl >", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlGreaterThanOrEqualTo(String value) {
            addCriterion("indeximgUrl >=", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlLessThan(String value) {
            addCriterion("indeximgUrl <", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlLessThanOrEqualTo(String value) {
            addCriterion("indeximgUrl <=", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlLike(String value) {
            addCriterion("indeximgUrl like", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlNotLike(String value) {
            addCriterion("indeximgUrl not like", value, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlIn(List<String> values) {
            addCriterion("indeximgUrl in", values, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlNotIn(List<String> values) {
            addCriterion("indeximgUrl not in", values, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlBetween(String value1, String value2) {
            addCriterion("indeximgUrl between", value1, value2, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgurlNotBetween(String value1, String value2) {
            addCriterion("indeximgUrl not between", value1, value2, "indeximgurl");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeIsNull() {
            addCriterion("indeximgCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeIsNotNull() {
            addCriterion("indeximgCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeEqualTo(Date value) {
            addCriterion("indeximgCreateTime =", value, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeNotEqualTo(Date value) {
            addCriterion("indeximgCreateTime <>", value, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeGreaterThan(Date value) {
            addCriterion("indeximgCreateTime >", value, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indeximgCreateTime >=", value, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeLessThan(Date value) {
            addCriterion("indeximgCreateTime <", value, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("indeximgCreateTime <=", value, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeIn(List<Date> values) {
            addCriterion("indeximgCreateTime in", values, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeNotIn(List<Date> values) {
            addCriterion("indeximgCreateTime not in", values, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeBetween(Date value1, Date value2) {
            addCriterion("indeximgCreateTime between", value1, value2, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("indeximgCreateTime not between", value1, value2, "indeximgcreatetime");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgIsNull() {
            addCriterion("indeximgOwnerOrg is null");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgIsNotNull() {
            addCriterion("indeximgOwnerOrg is not null");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgEqualTo(Integer value) {
            addCriterion("indeximgOwnerOrg =", value, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgNotEqualTo(Integer value) {
            addCriterion("indeximgOwnerOrg <>", value, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgGreaterThan(Integer value) {
            addCriterion("indeximgOwnerOrg >", value, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgGreaterThanOrEqualTo(Integer value) {
            addCriterion("indeximgOwnerOrg >=", value, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgLessThan(Integer value) {
            addCriterion("indeximgOwnerOrg <", value, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgLessThanOrEqualTo(Integer value) {
            addCriterion("indeximgOwnerOrg <=", value, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgIn(List<Integer> values) {
            addCriterion("indeximgOwnerOrg in", values, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgNotIn(List<Integer> values) {
            addCriterion("indeximgOwnerOrg not in", values, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgBetween(Integer value1, Integer value2) {
            addCriterion("indeximgOwnerOrg between", value1, value2, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerorgNotBetween(Integer value1, Integer value2) {
            addCriterion("indeximgOwnerOrg not between", value1, value2, "indeximgownerorg");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerIsNull() {
            addCriterion("indeximgOwner is null");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerIsNotNull() {
            addCriterion("indeximgOwner is not null");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerEqualTo(String value) {
            addCriterion("indeximgOwner =", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerNotEqualTo(String value) {
            addCriterion("indeximgOwner <>", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerGreaterThan(String value) {
            addCriterion("indeximgOwner >", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerGreaterThanOrEqualTo(String value) {
            addCriterion("indeximgOwner >=", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerLessThan(String value) {
            addCriterion("indeximgOwner <", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerLessThanOrEqualTo(String value) {
            addCriterion("indeximgOwner <=", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerLike(String value) {
            addCriterion("indeximgOwner like", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerNotLike(String value) {
            addCriterion("indeximgOwner not like", value, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerIn(List<String> values) {
            addCriterion("indeximgOwner in", values, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerNotIn(List<String> values) {
            addCriterion("indeximgOwner not in", values, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerBetween(String value1, String value2) {
            addCriterion("indeximgOwner between", value1, value2, "indeximgowner");
            return (Criteria) this;
        }

        public Criteria andIndeximgownerNotBetween(String value1, String value2) {
            addCriterion("indeximgOwner not between", value1, value2, "indeximgowner");
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