package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivitiesExample() {
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

        public Criteria andActivitityidIsNull() {
            addCriterion("activitityId is null");
            return (Criteria) this;
        }

        public Criteria andActivitityidIsNotNull() {
            addCriterion("activitityId is not null");
            return (Criteria) this;
        }

        public Criteria andActivitityidEqualTo(Integer value) {
            addCriterion("activitityId =", value, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidNotEqualTo(Integer value) {
            addCriterion("activitityId <>", value, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidGreaterThan(Integer value) {
            addCriterion("activitityId >", value, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("activitityId >=", value, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidLessThan(Integer value) {
            addCriterion("activitityId <", value, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidLessThanOrEqualTo(Integer value) {
            addCriterion("activitityId <=", value, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidIn(List<Integer> values) {
            addCriterion("activitityId in", values, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidNotIn(List<Integer> values) {
            addCriterion("activitityId not in", values, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidBetween(Integer value1, Integer value2) {
            addCriterion("activitityId between", value1, value2, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivitityidNotBetween(Integer value1, Integer value2) {
            addCriterion("activitityId not between", value1, value2, "activitityid");
            return (Criteria) this;
        }

        public Criteria andActivititynameIsNull() {
            addCriterion("activitityName is null");
            return (Criteria) this;
        }

        public Criteria andActivititynameIsNotNull() {
            addCriterion("activitityName is not null");
            return (Criteria) this;
        }

        public Criteria andActivititynameEqualTo(String value) {
            addCriterion("activitityName =", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameNotEqualTo(String value) {
            addCriterion("activitityName <>", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameGreaterThan(String value) {
            addCriterion("activitityName >", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameGreaterThanOrEqualTo(String value) {
            addCriterion("activitityName >=", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameLessThan(String value) {
            addCriterion("activitityName <", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameLessThanOrEqualTo(String value) {
            addCriterion("activitityName <=", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameLike(String value) {
            addCriterion("activitityName like", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameNotLike(String value) {
            addCriterion("activitityName not like", value, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameIn(List<String> values) {
            addCriterion("activitityName in", values, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameNotIn(List<String> values) {
            addCriterion("activitityName not in", values, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameBetween(String value1, String value2) {
            addCriterion("activitityName between", value1, value2, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititynameNotBetween(String value1, String value2) {
            addCriterion("activitityName not between", value1, value2, "activitityname");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeIsNull() {
            addCriterion("activitityStartTime is null");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeIsNotNull() {
            addCriterion("activitityStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeEqualTo(Date value) {
            addCriterion("activitityStartTime =", value, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeNotEqualTo(Date value) {
            addCriterion("activitityStartTime <>", value, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeGreaterThan(Date value) {
            addCriterion("activitityStartTime >", value, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activitityStartTime >=", value, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeLessThan(Date value) {
            addCriterion("activitityStartTime <", value, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeLessThanOrEqualTo(Date value) {
            addCriterion("activitityStartTime <=", value, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeIn(List<Date> values) {
            addCriterion("activitityStartTime in", values, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeNotIn(List<Date> values) {
            addCriterion("activitityStartTime not in", values, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeBetween(Date value1, Date value2) {
            addCriterion("activitityStartTime between", value1, value2, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivititystarttimeNotBetween(Date value1, Date value2) {
            addCriterion("activitityStartTime not between", value1, value2, "activititystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeIsNull() {
            addCriterion("activitityEndTime is null");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeIsNotNull() {
            addCriterion("activitityEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeEqualTo(Date value) {
            addCriterion("activitityEndTime =", value, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeNotEqualTo(Date value) {
            addCriterion("activitityEndTime <>", value, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeGreaterThan(Date value) {
            addCriterion("activitityEndTime >", value, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activitityEndTime >=", value, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeLessThan(Date value) {
            addCriterion("activitityEndTime <", value, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeLessThanOrEqualTo(Date value) {
            addCriterion("activitityEndTime <=", value, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeIn(List<Date> values) {
            addCriterion("activitityEndTime in", values, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeNotIn(List<Date> values) {
            addCriterion("activitityEndTime not in", values, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeBetween(Date value1, Date value2) {
            addCriterion("activitityEndTime between", value1, value2, "activitityendtime");
            return (Criteria) this;
        }

        public Criteria andActivitityendtimeNotBetween(Date value1, Date value2) {
            addCriterion("activitityEndTime not between", value1, value2, "activitityendtime");
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

        public Criteria andActivitityscountIsNull() {
            addCriterion("activititysCount is null");
            return (Criteria) this;
        }

        public Criteria andActivitityscountIsNotNull() {
            addCriterion("activititysCount is not null");
            return (Criteria) this;
        }

        public Criteria andActivitityscountEqualTo(Integer value) {
            addCriterion("activititysCount =", value, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountNotEqualTo(Integer value) {
            addCriterion("activititysCount <>", value, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountGreaterThan(Integer value) {
            addCriterion("activititysCount >", value, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("activititysCount >=", value, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountLessThan(Integer value) {
            addCriterion("activititysCount <", value, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountLessThanOrEqualTo(Integer value) {
            addCriterion("activititysCount <=", value, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountIn(List<Integer> values) {
            addCriterion("activititysCount in", values, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountNotIn(List<Integer> values) {
            addCriterion("activititysCount not in", values, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountBetween(Integer value1, Integer value2) {
            addCriterion("activititysCount between", value1, value2, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivitityscountNotBetween(Integer value1, Integer value2) {
            addCriterion("activititysCount not between", value1, value2, "activitityscount");
            return (Criteria) this;
        }

        public Criteria andActivititytypeIsNull() {
            addCriterion("activitityType is null");
            return (Criteria) this;
        }

        public Criteria andActivititytypeIsNotNull() {
            addCriterion("activitityType is not null");
            return (Criteria) this;
        }

        public Criteria andActivititytypeEqualTo(String value) {
            addCriterion("activitityType =", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeNotEqualTo(String value) {
            addCriterion("activitityType <>", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeGreaterThan(String value) {
            addCriterion("activitityType >", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeGreaterThanOrEqualTo(String value) {
            addCriterion("activitityType >=", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeLessThan(String value) {
            addCriterion("activitityType <", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeLessThanOrEqualTo(String value) {
            addCriterion("activitityType <=", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeLike(String value) {
            addCriterion("activitityType like", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeNotLike(String value) {
            addCriterion("activitityType not like", value, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeIn(List<String> values) {
            addCriterion("activitityType in", values, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeNotIn(List<String> values) {
            addCriterion("activitityType not in", values, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeBetween(String value1, String value2) {
            addCriterion("activitityType between", value1, value2, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititytypeNotBetween(String value1, String value2) {
            addCriterion("activitityType not between", value1, value2, "activititytype");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeIsNull() {
            addCriterion("activitityDescribe is null");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeIsNotNull() {
            addCriterion("activitityDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeEqualTo(String value) {
            addCriterion("activitityDescribe =", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeNotEqualTo(String value) {
            addCriterion("activitityDescribe <>", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeGreaterThan(String value) {
            addCriterion("activitityDescribe >", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeGreaterThanOrEqualTo(String value) {
            addCriterion("activitityDescribe >=", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeLessThan(String value) {
            addCriterion("activitityDescribe <", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeLessThanOrEqualTo(String value) {
            addCriterion("activitityDescribe <=", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeLike(String value) {
            addCriterion("activitityDescribe like", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeNotLike(String value) {
            addCriterion("activitityDescribe not like", value, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeIn(List<String> values) {
            addCriterion("activitityDescribe in", values, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeNotIn(List<String> values) {
            addCriterion("activitityDescribe not in", values, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeBetween(String value1, String value2) {
            addCriterion("activitityDescribe between", value1, value2, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivititydescribeNotBetween(String value1, String value2) {
            addCriterion("activitityDescribe not between", value1, value2, "activititydescribe");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceIsNull() {
            addCriterion("activitityPlace is null");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceIsNotNull() {
            addCriterion("activitityPlace is not null");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceEqualTo(String value) {
            addCriterion("activitityPlace =", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceNotEqualTo(String value) {
            addCriterion("activitityPlace <>", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceGreaterThan(String value) {
            addCriterion("activitityPlace >", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceGreaterThanOrEqualTo(String value) {
            addCriterion("activitityPlace >=", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceLessThan(String value) {
            addCriterion("activitityPlace <", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceLessThanOrEqualTo(String value) {
            addCriterion("activitityPlace <=", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceLike(String value) {
            addCriterion("activitityPlace like", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceNotLike(String value) {
            addCriterion("activitityPlace not like", value, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceIn(List<String> values) {
            addCriterion("activitityPlace in", values, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceNotIn(List<String> values) {
            addCriterion("activitityPlace not in", values, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceBetween(String value1, String value2) {
            addCriterion("activitityPlace between", value1, value2, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivitityplaceNotBetween(String value1, String value2) {
            addCriterion("activitityPlace not between", value1, value2, "activitityplace");
            return (Criteria) this;
        }

        public Criteria andActivititystatusIsNull() {
            addCriterion("activitityStatus is null");
            return (Criteria) this;
        }

        public Criteria andActivititystatusIsNotNull() {
            addCriterion("activitityStatus is not null");
            return (Criteria) this;
        }

        public Criteria andActivititystatusEqualTo(String value) {
            addCriterion("activitityStatus =", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusNotEqualTo(String value) {
            addCriterion("activitityStatus <>", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusGreaterThan(String value) {
            addCriterion("activitityStatus >", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusGreaterThanOrEqualTo(String value) {
            addCriterion("activitityStatus >=", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusLessThan(String value) {
            addCriterion("activitityStatus <", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusLessThanOrEqualTo(String value) {
            addCriterion("activitityStatus <=", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusLike(String value) {
            addCriterion("activitityStatus like", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusNotLike(String value) {
            addCriterion("activitityStatus not like", value, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusIn(List<String> values) {
            addCriterion("activitityStatus in", values, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusNotIn(List<String> values) {
            addCriterion("activitityStatus not in", values, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusBetween(String value1, String value2) {
            addCriterion("activitityStatus between", value1, value2, "activititystatus");
            return (Criteria) this;
        }

        public Criteria andActivititystatusNotBetween(String value1, String value2) {
            addCriterion("activitityStatus not between", value1, value2, "activititystatus");
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

        public Criteria andSignuptimeIsNull() {
            addCriterion("signupTime is null");
            return (Criteria) this;
        }

        public Criteria andSignuptimeIsNotNull() {
            addCriterion("signupTime is not null");
            return (Criteria) this;
        }

        public Criteria andSignuptimeEqualTo(Date value) {
            addCriterion("signupTime =", value, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeNotEqualTo(Date value) {
            addCriterion("signupTime <>", value, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeGreaterThan(Date value) {
            addCriterion("signupTime >", value, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("signupTime >=", value, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeLessThan(Date value) {
            addCriterion("signupTime <", value, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeLessThanOrEqualTo(Date value) {
            addCriterion("signupTime <=", value, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeIn(List<Date> values) {
            addCriterion("signupTime in", values, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeNotIn(List<Date> values) {
            addCriterion("signupTime not in", values, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeBetween(Date value1, Date value2) {
            addCriterion("signupTime between", value1, value2, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignuptimeNotBetween(Date value1, Date value2) {
            addCriterion("signupTime not between", value1, value2, "signuptime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeIsNull() {
            addCriterion("signupEndTime is null");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeIsNotNull() {
            addCriterion("signupEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeEqualTo(Date value) {
            addCriterion("signupEndTime =", value, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeNotEqualTo(Date value) {
            addCriterion("signupEndTime <>", value, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeGreaterThan(Date value) {
            addCriterion("signupEndTime >", value, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("signupEndTime >=", value, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeLessThan(Date value) {
            addCriterion("signupEndTime <", value, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeLessThanOrEqualTo(Date value) {
            addCriterion("signupEndTime <=", value, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeIn(List<Date> values) {
            addCriterion("signupEndTime in", values, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeNotIn(List<Date> values) {
            addCriterion("signupEndTime not in", values, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeBetween(Date value1, Date value2) {
            addCriterion("signupEndTime between", value1, value2, "signupendtime");
            return (Criteria) this;
        }

        public Criteria andSignupendtimeNotBetween(Date value1, Date value2) {
            addCriterion("signupEndTime not between", value1, value2, "signupendtime");
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