package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelationActivitiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelationActivitiesExample() {
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

        public Criteria andRelationActivitiesIdIsNull() {
            addCriterion("relation_activities_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdIsNotNull() {
            addCriterion("relation_activities_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdEqualTo(Integer value) {
            addCriterion("relation_activities_id =", value, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdNotEqualTo(Integer value) {
            addCriterion("relation_activities_id <>", value, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdGreaterThan(Integer value) {
            addCriterion("relation_activities_id >", value, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("relation_activities_id >=", value, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdLessThan(Integer value) {
            addCriterion("relation_activities_id <", value, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdLessThanOrEqualTo(Integer value) {
            addCriterion("relation_activities_id <=", value, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdIn(List<Integer> values) {
            addCriterion("relation_activities_id in", values, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdNotIn(List<Integer> values) {
            addCriterion("relation_activities_id not in", values, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdBetween(Integer value1, Integer value2) {
            addCriterion("relation_activities_id between", value1, value2, "relationActivitiesId");
            return (Criteria) this;
        }

        public Criteria andRelationActivitiesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("relation_activities_id not between", value1, value2, "relationActivitiesId");
            return (Criteria) this;
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSinuptimeIsNull() {
            addCriterion("sinUpTime is null");
            return (Criteria) this;
        }

        public Criteria andSinuptimeIsNotNull() {
            addCriterion("sinUpTime is not null");
            return (Criteria) this;
        }

        public Criteria andSinuptimeEqualTo(Date value) {
            addCriterion("sinUpTime =", value, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeNotEqualTo(Date value) {
            addCriterion("sinUpTime <>", value, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeGreaterThan(Date value) {
            addCriterion("sinUpTime >", value, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sinUpTime >=", value, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeLessThan(Date value) {
            addCriterion("sinUpTime <", value, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeLessThanOrEqualTo(Date value) {
            addCriterion("sinUpTime <=", value, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeIn(List<Date> values) {
            addCriterion("sinUpTime in", values, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeNotIn(List<Date> values) {
            addCriterion("sinUpTime not in", values, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeBetween(Date value1, Date value2) {
            addCriterion("sinUpTime between", value1, value2, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andSinuptimeNotBetween(Date value1, Date value2) {
            addCriterion("sinUpTime not between", value1, value2, "sinuptime");
            return (Criteria) this;
        }

        public Criteria andAdmissionIsNull() {
            addCriterion("Admission is null");
            return (Criteria) this;
        }

        public Criteria andAdmissionIsNotNull() {
            addCriterion("Admission is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissionEqualTo(String value) {
            addCriterion("Admission =", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionNotEqualTo(String value) {
            addCriterion("Admission <>", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionGreaterThan(String value) {
            addCriterion("Admission >", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionGreaterThanOrEqualTo(String value) {
            addCriterion("Admission >=", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionLessThan(String value) {
            addCriterion("Admission <", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionLessThanOrEqualTo(String value) {
            addCriterion("Admission <=", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionLike(String value) {
            addCriterion("Admission like", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionNotLike(String value) {
            addCriterion("Admission not like", value, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionIn(List<String> values) {
            addCriterion("Admission in", values, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionNotIn(List<String> values) {
            addCriterion("Admission not in", values, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionBetween(String value1, String value2) {
            addCriterion("Admission between", value1, value2, "admission");
            return (Criteria) this;
        }

        public Criteria andAdmissionNotBetween(String value1, String value2) {
            addCriterion("Admission not between", value1, value2, "admission");
            return (Criteria) this;
        }

        public Criteria andActivitiesidIsNull() {
            addCriterion("activitiesId is null");
            return (Criteria) this;
        }

        public Criteria andActivitiesidIsNotNull() {
            addCriterion("activitiesId is not null");
            return (Criteria) this;
        }

        public Criteria andActivitiesidEqualTo(Integer value) {
            addCriterion("activitiesId =", value, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidNotEqualTo(Integer value) {
            addCriterion("activitiesId <>", value, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidGreaterThan(Integer value) {
            addCriterion("activitiesId >", value, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("activitiesId >=", value, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidLessThan(Integer value) {
            addCriterion("activitiesId <", value, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidLessThanOrEqualTo(Integer value) {
            addCriterion("activitiesId <=", value, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidIn(List<Integer> values) {
            addCriterion("activitiesId in", values, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidNotIn(List<Integer> values) {
            addCriterion("activitiesId not in", values, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidBetween(Integer value1, Integer value2) {
            addCriterion("activitiesId between", value1, value2, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActivitiesidNotBetween(Integer value1, Integer value2) {
            addCriterion("activitiesId not between", value1, value2, "activitiesid");
            return (Criteria) this;
        }

        public Criteria andActnameIsNull() {
            addCriterion("actName is null");
            return (Criteria) this;
        }

        public Criteria andActnameIsNotNull() {
            addCriterion("actName is not null");
            return (Criteria) this;
        }

        public Criteria andActnameEqualTo(String value) {
            addCriterion("actName =", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameNotEqualTo(String value) {
            addCriterion("actName <>", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameGreaterThan(String value) {
            addCriterion("actName >", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameGreaterThanOrEqualTo(String value) {
            addCriterion("actName >=", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameLessThan(String value) {
            addCriterion("actName <", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameLessThanOrEqualTo(String value) {
            addCriterion("actName <=", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameLike(String value) {
            addCriterion("actName like", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameNotLike(String value) {
            addCriterion("actName not like", value, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameIn(List<String> values) {
            addCriterion("actName in", values, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameNotIn(List<String> values) {
            addCriterion("actName not in", values, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameBetween(String value1, String value2) {
            addCriterion("actName between", value1, value2, "actname");
            return (Criteria) this;
        }

        public Criteria andActnameNotBetween(String value1, String value2) {
            addCriterion("actName not between", value1, value2, "actname");
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