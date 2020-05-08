package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentsExample() {
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

        public Criteria andDocumentidIsNull() {
            addCriterion("documentId is null");
            return (Criteria) this;
        }

        public Criteria andDocumentidIsNotNull() {
            addCriterion("documentId is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentidEqualTo(Integer value) {
            addCriterion("documentId =", value, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidNotEqualTo(Integer value) {
            addCriterion("documentId <>", value, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidGreaterThan(Integer value) {
            addCriterion("documentId >", value, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("documentId >=", value, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidLessThan(Integer value) {
            addCriterion("documentId <", value, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidLessThanOrEqualTo(Integer value) {
            addCriterion("documentId <=", value, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidIn(List<Integer> values) {
            addCriterion("documentId in", values, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidNotIn(List<Integer> values) {
            addCriterion("documentId not in", values, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidBetween(Integer value1, Integer value2) {
            addCriterion("documentId between", value1, value2, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentidNotBetween(Integer value1, Integer value2) {
            addCriterion("documentId not between", value1, value2, "documentid");
            return (Criteria) this;
        }

        public Criteria andDocumentnameIsNull() {
            addCriterion("documentName is null");
            return (Criteria) this;
        }

        public Criteria andDocumentnameIsNotNull() {
            addCriterion("documentName is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentnameEqualTo(String value) {
            addCriterion("documentName =", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameNotEqualTo(String value) {
            addCriterion("documentName <>", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameGreaterThan(String value) {
            addCriterion("documentName >", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameGreaterThanOrEqualTo(String value) {
            addCriterion("documentName >=", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameLessThan(String value) {
            addCriterion("documentName <", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameLessThanOrEqualTo(String value) {
            addCriterion("documentName <=", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameLike(String value) {
            addCriterion("documentName like", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameNotLike(String value) {
            addCriterion("documentName not like", value, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameIn(List<String> values) {
            addCriterion("documentName in", values, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameNotIn(List<String> values) {
            addCriterion("documentName not in", values, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameBetween(String value1, String value2) {
            addCriterion("documentName between", value1, value2, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentnameNotBetween(String value1, String value2) {
            addCriterion("documentName not between", value1, value2, "documentname");
            return (Criteria) this;
        }

        public Criteria andDocumentownerIsNull() {
            addCriterion("documentOwner is null");
            return (Criteria) this;
        }

        public Criteria andDocumentownerIsNotNull() {
            addCriterion("documentOwner is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentownerEqualTo(String value) {
            addCriterion("documentOwner =", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerNotEqualTo(String value) {
            addCriterion("documentOwner <>", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerGreaterThan(String value) {
            addCriterion("documentOwner >", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerGreaterThanOrEqualTo(String value) {
            addCriterion("documentOwner >=", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerLessThan(String value) {
            addCriterion("documentOwner <", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerLessThanOrEqualTo(String value) {
            addCriterion("documentOwner <=", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerLike(String value) {
            addCriterion("documentOwner like", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerNotLike(String value) {
            addCriterion("documentOwner not like", value, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerIn(List<String> values) {
            addCriterion("documentOwner in", values, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerNotIn(List<String> values) {
            addCriterion("documentOwner not in", values, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerBetween(String value1, String value2) {
            addCriterion("documentOwner between", value1, value2, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumentownerNotBetween(String value1, String value2) {
            addCriterion("documentOwner not between", value1, value2, "documentowner");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsNull() {
            addCriterion("documentType is null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsNotNull() {
            addCriterion("documentType is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeEqualTo(String value) {
            addCriterion("documentType =", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotEqualTo(String value) {
            addCriterion("documentType <>", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeGreaterThan(String value) {
            addCriterion("documentType >", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("documentType >=", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeLessThan(String value) {
            addCriterion("documentType <", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeLessThanOrEqualTo(String value) {
            addCriterion("documentType <=", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeLike(String value) {
            addCriterion("documentType like", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotLike(String value) {
            addCriterion("documentType not like", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIn(List<String> values) {
            addCriterion("documentType in", values, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotIn(List<String> values) {
            addCriterion("documentType not in", values, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeBetween(String value1, String value2) {
            addCriterion("documentType between", value1, value2, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotBetween(String value1, String value2) {
            addCriterion("documentType not between", value1, value2, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeIsNull() {
            addCriterion("documentUploadTime is null");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeIsNotNull() {
            addCriterion("documentUploadTime is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeEqualTo(Date value) {
            addCriterion("documentUploadTime =", value, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeNotEqualTo(Date value) {
            addCriterion("documentUploadTime <>", value, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeGreaterThan(Date value) {
            addCriterion("documentUploadTime >", value, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("documentUploadTime >=", value, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeLessThan(Date value) {
            addCriterion("documentUploadTime <", value, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("documentUploadTime <=", value, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeIn(List<Date> values) {
            addCriterion("documentUploadTime in", values, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeNotIn(List<Date> values) {
            addCriterion("documentUploadTime not in", values, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeBetween(Date value1, Date value2) {
            addCriterion("documentUploadTime between", value1, value2, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDocumentuploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("documentUploadTime not between", value1, value2, "documentuploadtime");
            return (Criteria) this;
        }

        public Criteria andDownloadcountIsNull() {
            addCriterion("DownloadCount is null");
            return (Criteria) this;
        }

        public Criteria andDownloadcountIsNotNull() {
            addCriterion("DownloadCount is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadcountEqualTo(Integer value) {
            addCriterion("DownloadCount =", value, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountNotEqualTo(Integer value) {
            addCriterion("DownloadCount <>", value, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountGreaterThan(Integer value) {
            addCriterion("DownloadCount >", value, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("DownloadCount >=", value, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountLessThan(Integer value) {
            addCriterion("DownloadCount <", value, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountLessThanOrEqualTo(Integer value) {
            addCriterion("DownloadCount <=", value, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountIn(List<Integer> values) {
            addCriterion("DownloadCount in", values, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountNotIn(List<Integer> values) {
            addCriterion("DownloadCount not in", values, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountBetween(Integer value1, Integer value2) {
            addCriterion("DownloadCount between", value1, value2, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDownloadcountNotBetween(Integer value1, Integer value2) {
            addCriterion("DownloadCount not between", value1, value2, "downloadcount");
            return (Criteria) this;
        }

        public Criteria andDocumenturlIsNull() {
            addCriterion("documentUrl is null");
            return (Criteria) this;
        }

        public Criteria andDocumenturlIsNotNull() {
            addCriterion("documentUrl is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenturlEqualTo(String value) {
            addCriterion("documentUrl =", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlNotEqualTo(String value) {
            addCriterion("documentUrl <>", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlGreaterThan(String value) {
            addCriterion("documentUrl >", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlGreaterThanOrEqualTo(String value) {
            addCriterion("documentUrl >=", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlLessThan(String value) {
            addCriterion("documentUrl <", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlLessThanOrEqualTo(String value) {
            addCriterion("documentUrl <=", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlLike(String value) {
            addCriterion("documentUrl like", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlNotLike(String value) {
            addCriterion("documentUrl not like", value, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlIn(List<String> values) {
            addCriterion("documentUrl in", values, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlNotIn(List<String> values) {
            addCriterion("documentUrl not in", values, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlBetween(String value1, String value2) {
            addCriterion("documentUrl between", value1, value2, "documenturl");
            return (Criteria) this;
        }

        public Criteria andDocumenturlNotBetween(String value1, String value2) {
            addCriterion("documentUrl not between", value1, value2, "documenturl");
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