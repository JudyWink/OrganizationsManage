package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessagesBackupsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessagesBackupsExample() {
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

        public Criteria andMessageidIsNull() {
            addCriterion("messageId is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("messageId is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(Integer value) {
            addCriterion("messageId =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(Integer value) {
            addCriterion("messageId <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(Integer value) {
            addCriterion("messageId >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageId >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(Integer value) {
            addCriterion("messageId <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(Integer value) {
            addCriterion("messageId <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<Integer> values) {
            addCriterion("messageId in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<Integer> values) {
            addCriterion("messageId not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(Integer value1, Integer value2) {
            addCriterion("messageId between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("messageId not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessagetextIsNull() {
            addCriterion("messageText is null");
            return (Criteria) this;
        }

        public Criteria andMessagetextIsNotNull() {
            addCriterion("messageText is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetextEqualTo(String value) {
            addCriterion("messageText =", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotEqualTo(String value) {
            addCriterion("messageText <>", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextGreaterThan(String value) {
            addCriterion("messageText >", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextGreaterThanOrEqualTo(String value) {
            addCriterion("messageText >=", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextLessThan(String value) {
            addCriterion("messageText <", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextLessThanOrEqualTo(String value) {
            addCriterion("messageText <=", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextLike(String value) {
            addCriterion("messageText like", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotLike(String value) {
            addCriterion("messageText not like", value, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextIn(List<String> values) {
            addCriterion("messageText in", values, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotIn(List<String> values) {
            addCriterion("messageText not in", values, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextBetween(String value1, String value2) {
            addCriterion("messageText between", value1, value2, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetextNotBetween(String value1, String value2) {
            addCriterion("messageText not between", value1, value2, "messagetext");
            return (Criteria) this;
        }

        public Criteria andMessagetitleIsNull() {
            addCriterion("messageTitle is null");
            return (Criteria) this;
        }

        public Criteria andMessagetitleIsNotNull() {
            addCriterion("messageTitle is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetitleEqualTo(String value) {
            addCriterion("messageTitle =", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleNotEqualTo(String value) {
            addCriterion("messageTitle <>", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleGreaterThan(String value) {
            addCriterion("messageTitle >", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleGreaterThanOrEqualTo(String value) {
            addCriterion("messageTitle >=", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleLessThan(String value) {
            addCriterion("messageTitle <", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleLessThanOrEqualTo(String value) {
            addCriterion("messageTitle <=", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleLike(String value) {
            addCriterion("messageTitle like", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleNotLike(String value) {
            addCriterion("messageTitle not like", value, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleIn(List<String> values) {
            addCriterion("messageTitle in", values, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleNotIn(List<String> values) {
            addCriterion("messageTitle not in", values, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleBetween(String value1, String value2) {
            addCriterion("messageTitle between", value1, value2, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagetitleNotBetween(String value1, String value2) {
            addCriterion("messageTitle not between", value1, value2, "messagetitle");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchIsNull() {
            addCriterion("messageLaunch is null");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchIsNotNull() {
            addCriterion("messageLaunch is not null");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchEqualTo(Integer value) {
            addCriterion("messageLaunch =", value, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchNotEqualTo(Integer value) {
            addCriterion("messageLaunch <>", value, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchGreaterThan(Integer value) {
            addCriterion("messageLaunch >", value, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageLaunch >=", value, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchLessThan(Integer value) {
            addCriterion("messageLaunch <", value, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchLessThanOrEqualTo(Integer value) {
            addCriterion("messageLaunch <=", value, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchIn(List<Integer> values) {
            addCriterion("messageLaunch in", values, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchNotIn(List<Integer> values) {
            addCriterion("messageLaunch not in", values, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchBetween(Integer value1, Integer value2) {
            addCriterion("messageLaunch between", value1, value2, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchNotBetween(Integer value1, Integer value2) {
            addCriterion("messageLaunch not between", value1, value2, "messagelaunch");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveIsNull() {
            addCriterion("messageReceive is null");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveIsNotNull() {
            addCriterion("messageReceive is not null");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveEqualTo(String value) {
            addCriterion("messageReceive =", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveNotEqualTo(String value) {
            addCriterion("messageReceive <>", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveGreaterThan(String value) {
            addCriterion("messageReceive >", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveGreaterThanOrEqualTo(String value) {
            addCriterion("messageReceive >=", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveLessThan(String value) {
            addCriterion("messageReceive <", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveLessThanOrEqualTo(String value) {
            addCriterion("messageReceive <=", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveLike(String value) {
            addCriterion("messageReceive like", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveNotLike(String value) {
            addCriterion("messageReceive not like", value, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveIn(List<String> values) {
            addCriterion("messageReceive in", values, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveNotIn(List<String> values) {
            addCriterion("messageReceive not in", values, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveBetween(String value1, String value2) {
            addCriterion("messageReceive between", value1, value2, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagereceiveNotBetween(String value1, String value2) {
            addCriterion("messageReceive not between", value1, value2, "messagereceive");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIsNull() {
            addCriterion("messageStatus is null");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIsNotNull() {
            addCriterion("messageStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMessagestatusEqualTo(String value) {
            addCriterion("messageStatus =", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotEqualTo(String value) {
            addCriterion("messageStatus <>", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusGreaterThan(String value) {
            addCriterion("messageStatus >", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusGreaterThanOrEqualTo(String value) {
            addCriterion("messageStatus >=", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLessThan(String value) {
            addCriterion("messageStatus <", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLessThanOrEqualTo(String value) {
            addCriterion("messageStatus <=", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLike(String value) {
            addCriterion("messageStatus like", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotLike(String value) {
            addCriterion("messageStatus not like", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIn(List<String> values) {
            addCriterion("messageStatus in", values, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotIn(List<String> values) {
            addCriterion("messageStatus not in", values, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusBetween(String value1, String value2) {
            addCriterion("messageStatus between", value1, value2, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotBetween(String value1, String value2) {
            addCriterion("messageStatus not between", value1, value2, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNull() {
            addCriterion("messageType is null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNotNull() {
            addCriterion("messageType is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeEqualTo(String value) {
            addCriterion("messageType =", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotEqualTo(String value) {
            addCriterion("messageType <>", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThan(String value) {
            addCriterion("messageType >", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThanOrEqualTo(String value) {
            addCriterion("messageType >=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThan(String value) {
            addCriterion("messageType <", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThanOrEqualTo(String value) {
            addCriterion("messageType <=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLike(String value) {
            addCriterion("messageType like", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotLike(String value) {
            addCriterion("messageType not like", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIn(List<String> values) {
            addCriterion("messageType in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotIn(List<String> values) {
            addCriterion("messageType not in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeBetween(String value1, String value2) {
            addCriterion("messageType between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotBetween(String value1, String value2) {
            addCriterion("messageType not between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeIsNull() {
            addCriterion("messageCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeIsNotNull() {
            addCriterion("messageCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeEqualTo(Date value) {
            addCriterion("messageCreateTime =", value, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeNotEqualTo(Date value) {
            addCriterion("messageCreateTime <>", value, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeGreaterThan(Date value) {
            addCriterion("messageCreateTime >", value, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("messageCreateTime >=", value, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeLessThan(Date value) {
            addCriterion("messageCreateTime <", value, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("messageCreateTime <=", value, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeIn(List<Date> values) {
            addCriterion("messageCreateTime in", values, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeNotIn(List<Date> values) {
            addCriterion("messageCreateTime not in", values, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeBetween(Date value1, Date value2) {
            addCriterion("messageCreateTime between", value1, value2, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagecreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("messageCreateTime not between", value1, value2, "messagecreatetime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeIsNull() {
            addCriterion("messageReadTime is null");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeIsNotNull() {
            addCriterion("messageReadTime is not null");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeEqualTo(Date value) {
            addCriterion("messageReadTime =", value, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeNotEqualTo(Date value) {
            addCriterion("messageReadTime <>", value, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeGreaterThan(Date value) {
            addCriterion("messageReadTime >", value, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("messageReadTime >=", value, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeLessThan(Date value) {
            addCriterion("messageReadTime <", value, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeLessThanOrEqualTo(Date value) {
            addCriterion("messageReadTime <=", value, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeIn(List<Date> values) {
            addCriterion("messageReadTime in", values, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeNotIn(List<Date> values) {
            addCriterion("messageReadTime not in", values, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeBetween(Date value1, Date value2) {
            addCriterion("messageReadTime between", value1, value2, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagereadtimeNotBetween(Date value1, Date value2) {
            addCriterion("messageReadTime not between", value1, value2, "messagereadtime");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameIsNull() {
            addCriterion("messageLaunchName is null");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameIsNotNull() {
            addCriterion("messageLaunchName is not null");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameEqualTo(String value) {
            addCriterion("messageLaunchName =", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameNotEqualTo(String value) {
            addCriterion("messageLaunchName <>", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameGreaterThan(String value) {
            addCriterion("messageLaunchName >", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameGreaterThanOrEqualTo(String value) {
            addCriterion("messageLaunchName >=", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameLessThan(String value) {
            addCriterion("messageLaunchName <", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameLessThanOrEqualTo(String value) {
            addCriterion("messageLaunchName <=", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameLike(String value) {
            addCriterion("messageLaunchName like", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameNotLike(String value) {
            addCriterion("messageLaunchName not like", value, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameIn(List<String> values) {
            addCriterion("messageLaunchName in", values, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameNotIn(List<String> values) {
            addCriterion("messageLaunchName not in", values, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameBetween(String value1, String value2) {
            addCriterion("messageLaunchName between", value1, value2, "messagelaunchname");
            return (Criteria) this;
        }

        public Criteria andMessagelaunchnameNotBetween(String value1, String value2) {
            addCriterion("messageLaunchName not between", value1, value2, "messagelaunchname");
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