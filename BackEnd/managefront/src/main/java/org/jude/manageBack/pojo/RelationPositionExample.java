package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelationPositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelationPositionExample() {
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

        public Criteria andRelationPositionIdIsNull() {
            addCriterion("relation_position_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdIsNotNull() {
            addCriterion("relation_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdEqualTo(Integer value) {
            addCriterion("relation_position_id =", value, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdNotEqualTo(Integer value) {
            addCriterion("relation_position_id <>", value, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdGreaterThan(Integer value) {
            addCriterion("relation_position_id >", value, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("relation_position_id >=", value, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdLessThan(Integer value) {
            addCriterion("relation_position_id <", value, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("relation_position_id <=", value, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdIn(List<Integer> values) {
            addCriterion("relation_position_id in", values, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdNotIn(List<Integer> values) {
            addCriterion("relation_position_id not in", values, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("relation_position_id between", value1, value2, "relationPositionId");
            return (Criteria) this;
        }

        public Criteria andRelationPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("relation_position_id not between", value1, value2, "relationPositionId");
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

        public Criteria andOrgpositionIsNull() {
            addCriterion("orgPosition is null");
            return (Criteria) this;
        }

        public Criteria andOrgpositionIsNotNull() {
            addCriterion("orgPosition is not null");
            return (Criteria) this;
        }

        public Criteria andOrgpositionEqualTo(String value) {
            addCriterion("orgPosition =", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionNotEqualTo(String value) {
            addCriterion("orgPosition <>", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionGreaterThan(String value) {
            addCriterion("orgPosition >", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionGreaterThanOrEqualTo(String value) {
            addCriterion("orgPosition >=", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionLessThan(String value) {
            addCriterion("orgPosition <", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionLessThanOrEqualTo(String value) {
            addCriterion("orgPosition <=", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionLike(String value) {
            addCriterion("orgPosition like", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionNotLike(String value) {
            addCriterion("orgPosition not like", value, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionIn(List<String> values) {
            addCriterion("orgPosition in", values, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionNotIn(List<String> values) {
            addCriterion("orgPosition not in", values, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionBetween(String value1, String value2) {
            addCriterion("orgPosition between", value1, value2, "orgposition");
            return (Criteria) this;
        }

        public Criteria andOrgpositionNotBetween(String value1, String value2) {
            addCriterion("orgPosition not between", value1, value2, "orgposition");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeIsNull() {
            addCriterion("joinPositionTime is null");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeIsNotNull() {
            addCriterion("joinPositionTime is not null");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeEqualTo(Date value) {
            addCriterion("joinPositionTime =", value, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeNotEqualTo(Date value) {
            addCriterion("joinPositionTime <>", value, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeGreaterThan(Date value) {
            addCriterion("joinPositionTime >", value, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("joinPositionTime >=", value, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeLessThan(Date value) {
            addCriterion("joinPositionTime <", value, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeLessThanOrEqualTo(Date value) {
            addCriterion("joinPositionTime <=", value, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeIn(List<Date> values) {
            addCriterion("joinPositionTime in", values, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeNotIn(List<Date> values) {
            addCriterion("joinPositionTime not in", values, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeBetween(Date value1, Date value2) {
            addCriterion("joinPositionTime between", value1, value2, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andJoinpositiontimeNotBetween(Date value1, Date value2) {
            addCriterion("joinPositionTime not between", value1, value2, "joinpositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeIsNull() {
            addCriterion("leavePositionTime is null");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeIsNotNull() {
            addCriterion("leavePositionTime is not null");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeEqualTo(Date value) {
            addCriterion("leavePositionTime =", value, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeNotEqualTo(Date value) {
            addCriterion("leavePositionTime <>", value, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeGreaterThan(Date value) {
            addCriterion("leavePositionTime >", value, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("leavePositionTime >=", value, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeLessThan(Date value) {
            addCriterion("leavePositionTime <", value, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeLessThanOrEqualTo(Date value) {
            addCriterion("leavePositionTime <=", value, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeIn(List<Date> values) {
            addCriterion("leavePositionTime in", values, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeNotIn(List<Date> values) {
            addCriterion("leavePositionTime not in", values, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeBetween(Date value1, Date value2) {
            addCriterion("leavePositionTime between", value1, value2, "leavepositiontime");
            return (Criteria) this;
        }

        public Criteria andLeavepositiontimeNotBetween(Date value1, Date value2) {
            addCriterion("leavePositionTime not between", value1, value2, "leavepositiontime");
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