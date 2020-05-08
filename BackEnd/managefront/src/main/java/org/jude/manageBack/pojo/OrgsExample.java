package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgsExample() {
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

        public Criteria andOrgidIsNull() {
            addCriterion("orgId is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgId is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("orgId =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("orgId <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("orgId >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orgId >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("orgId <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("orgId <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("orgId in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("orgId not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("orgId between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("orgId not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgName is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgName is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgName =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgName <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgName >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgName >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgName <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgName <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgName like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgName not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("orgName in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("orgName not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgName between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgName not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeIsNull() {
            addCriterion("orgCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeIsNotNull() {
            addCriterion("orgCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeEqualTo(Date value) {
            addCriterion("orgCreateTime =", value, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeNotEqualTo(Date value) {
            addCriterion("orgCreateTime <>", value, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeGreaterThan(Date value) {
            addCriterion("orgCreateTime >", value, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orgCreateTime >=", value, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeLessThan(Date value) {
            addCriterion("orgCreateTime <", value, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("orgCreateTime <=", value, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeIn(List<Date> values) {
            addCriterion("orgCreateTime in", values, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeNotIn(List<Date> values) {
            addCriterion("orgCreateTime not in", values, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeBetween(Date value1, Date value2) {
            addCriterion("orgCreateTime between", value1, value2, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("orgCreateTime not between", value1, value2, "orgcreatetime");
            return (Criteria) this;
        }

        public Criteria andOrgleaderIsNull() {
            addCriterion("orgLeader is null");
            return (Criteria) this;
        }

        public Criteria andOrgleaderIsNotNull() {
            addCriterion("orgLeader is not null");
            return (Criteria) this;
        }

        public Criteria andOrgleaderEqualTo(String value) {
            addCriterion("orgLeader =", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderNotEqualTo(String value) {
            addCriterion("orgLeader <>", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderGreaterThan(String value) {
            addCriterion("orgLeader >", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderGreaterThanOrEqualTo(String value) {
            addCriterion("orgLeader >=", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderLessThan(String value) {
            addCriterion("orgLeader <", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderLessThanOrEqualTo(String value) {
            addCriterion("orgLeader <=", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderLike(String value) {
            addCriterion("orgLeader like", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderNotLike(String value) {
            addCriterion("orgLeader not like", value, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderIn(List<String> values) {
            addCriterion("orgLeader in", values, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderNotIn(List<String> values) {
            addCriterion("orgLeader not in", values, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderBetween(String value1, String value2) {
            addCriterion("orgLeader between", value1, value2, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgleaderNotBetween(String value1, String value2) {
            addCriterion("orgLeader not between", value1, value2, "orgleader");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIsNull() {
            addCriterion("orgType is null");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIsNotNull() {
            addCriterion("orgType is not null");
            return (Criteria) this;
        }

        public Criteria andOrgtypeEqualTo(String value) {
            addCriterion("orgType =", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotEqualTo(String value) {
            addCriterion("orgType <>", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeGreaterThan(String value) {
            addCriterion("orgType >", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("orgType >=", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLessThan(String value) {
            addCriterion("orgType <", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLessThanOrEqualTo(String value) {
            addCriterion("orgType <=", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLike(String value) {
            addCriterion("orgType like", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotLike(String value) {
            addCriterion("orgType not like", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIn(List<String> values) {
            addCriterion("orgType in", values, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotIn(List<String> values) {
            addCriterion("orgType not in", values, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeBetween(String value1, String value2) {
            addCriterion("orgType between", value1, value2, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotBetween(String value1, String value2) {
            addCriterion("orgType not between", value1, value2, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgsloganIsNull() {
            addCriterion("orgSlogan is null");
            return (Criteria) this;
        }

        public Criteria andOrgsloganIsNotNull() {
            addCriterion("orgSlogan is not null");
            return (Criteria) this;
        }

        public Criteria andOrgsloganEqualTo(String value) {
            addCriterion("orgSlogan =", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganNotEqualTo(String value) {
            addCriterion("orgSlogan <>", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganGreaterThan(String value) {
            addCriterion("orgSlogan >", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganGreaterThanOrEqualTo(String value) {
            addCriterion("orgSlogan >=", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganLessThan(String value) {
            addCriterion("orgSlogan <", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganLessThanOrEqualTo(String value) {
            addCriterion("orgSlogan <=", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganLike(String value) {
            addCriterion("orgSlogan like", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganNotLike(String value) {
            addCriterion("orgSlogan not like", value, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganIn(List<String> values) {
            addCriterion("orgSlogan in", values, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganNotIn(List<String> values) {
            addCriterion("orgSlogan not in", values, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganBetween(String value1, String value2) {
            addCriterion("orgSlogan between", value1, value2, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgsloganNotBetween(String value1, String value2) {
            addCriterion("orgSlogan not between", value1, value2, "orgslogan");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceIsNull() {
            addCriterion("orgIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceIsNotNull() {
            addCriterion("orgIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceEqualTo(String value) {
            addCriterion("orgIntroduce =", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceNotEqualTo(String value) {
            addCriterion("orgIntroduce <>", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceGreaterThan(String value) {
            addCriterion("orgIntroduce >", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceGreaterThanOrEqualTo(String value) {
            addCriterion("orgIntroduce >=", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceLessThan(String value) {
            addCriterion("orgIntroduce <", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceLessThanOrEqualTo(String value) {
            addCriterion("orgIntroduce <=", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceLike(String value) {
            addCriterion("orgIntroduce like", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceNotLike(String value) {
            addCriterion("orgIntroduce not like", value, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceIn(List<String> values) {
            addCriterion("orgIntroduce in", values, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceNotIn(List<String> values) {
            addCriterion("orgIntroduce not in", values, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceBetween(String value1, String value2) {
            addCriterion("orgIntroduce between", value1, value2, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrgintroduceNotBetween(String value1, String value2) {
            addCriterion("orgIntroduce not between", value1, value2, "orgintroduce");
            return (Criteria) this;
        }

        public Criteria andOrghistoryIsNull() {
            addCriterion("orgHistory is null");
            return (Criteria) this;
        }

        public Criteria andOrghistoryIsNotNull() {
            addCriterion("orgHistory is not null");
            return (Criteria) this;
        }

        public Criteria andOrghistoryEqualTo(String value) {
            addCriterion("orgHistory =", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryNotEqualTo(String value) {
            addCriterion("orgHistory <>", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryGreaterThan(String value) {
            addCriterion("orgHistory >", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryGreaterThanOrEqualTo(String value) {
            addCriterion("orgHistory >=", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryLessThan(String value) {
            addCriterion("orgHistory <", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryLessThanOrEqualTo(String value) {
            addCriterion("orgHistory <=", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryLike(String value) {
            addCriterion("orgHistory like", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryNotLike(String value) {
            addCriterion("orgHistory not like", value, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryIn(List<String> values) {
            addCriterion("orgHistory in", values, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryNotIn(List<String> values) {
            addCriterion("orgHistory not in", values, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryBetween(String value1, String value2) {
            addCriterion("orgHistory between", value1, value2, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrghistoryNotBetween(String value1, String value2) {
            addCriterion("orgHistory not between", value1, value2, "orghistory");
            return (Criteria) this;
        }

        public Criteria andOrgcampusIsNull() {
            addCriterion("orgCampus is null");
            return (Criteria) this;
        }

        public Criteria andOrgcampusIsNotNull() {
            addCriterion("orgCampus is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcampusEqualTo(String value) {
            addCriterion("orgCampus =", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusNotEqualTo(String value) {
            addCriterion("orgCampus <>", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusGreaterThan(String value) {
            addCriterion("orgCampus >", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusGreaterThanOrEqualTo(String value) {
            addCriterion("orgCampus >=", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusLessThan(String value) {
            addCriterion("orgCampus <", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusLessThanOrEqualTo(String value) {
            addCriterion("orgCampus <=", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusLike(String value) {
            addCriterion("orgCampus like", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusNotLike(String value) {
            addCriterion("orgCampus not like", value, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusIn(List<String> values) {
            addCriterion("orgCampus in", values, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusNotIn(List<String> values) {
            addCriterion("orgCampus not in", values, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusBetween(String value1, String value2) {
            addCriterion("orgCampus between", value1, value2, "orgcampus");
            return (Criteria) this;
        }

        public Criteria andOrgcampusNotBetween(String value1, String value2) {
            addCriterion("orgCampus not between", value1, value2, "orgcampus");
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