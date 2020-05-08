package org.jude.manageBack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUseracountIsNull() {
            addCriterion("userAcount is null");
            return (Criteria) this;
        }

        public Criteria andUseracountIsNotNull() {
            addCriterion("userAcount is not null");
            return (Criteria) this;
        }

        public Criteria andUseracountEqualTo(String value) {
            addCriterion("userAcount =", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountNotEqualTo(String value) {
            addCriterion("userAcount <>", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountGreaterThan(String value) {
            addCriterion("userAcount >", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountGreaterThanOrEqualTo(String value) {
            addCriterion("userAcount >=", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountLessThan(String value) {
            addCriterion("userAcount <", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountLessThanOrEqualTo(String value) {
            addCriterion("userAcount <=", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountLike(String value) {
            addCriterion("userAcount like", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountNotLike(String value) {
            addCriterion("userAcount not like", value, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountIn(List<String> values) {
            addCriterion("userAcount in", values, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountNotIn(List<String> values) {
            addCriterion("userAcount not in", values, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountBetween(String value1, String value2) {
            addCriterion("userAcount between", value1, value2, "useracount");
            return (Criteria) this;
        }

        public Criteria andUseracountNotBetween(String value1, String value2) {
            addCriterion("userAcount not between", value1, value2, "useracount");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNull() {
            addCriterion("userPassword is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNotNull() {
            addCriterion("userPassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordEqualTo(String value) {
            addCriterion("userPassword =", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotEqualTo(String value) {
            addCriterion("userPassword <>", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThan(String value) {
            addCriterion("userPassword >", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userPassword >=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThan(String value) {
            addCriterion("userPassword <", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThanOrEqualTo(String value) {
            addCriterion("userPassword <=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLike(String value) {
            addCriterion("userPassword like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotLike(String value) {
            addCriterion("userPassword not like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIn(List<String> values) {
            addCriterion("userPassword in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotIn(List<String> values) {
            addCriterion("userPassword not in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordBetween(String value1, String value2) {
            addCriterion("userPassword between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotBetween(String value1, String value2) {
            addCriterion("userPassword not between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("userType is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("userType is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(String value) {
            addCriterion("userType =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(String value) {
            addCriterion("userType <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(String value) {
            addCriterion("userType >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(String value) {
            addCriterion("userType >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(String value) {
            addCriterion("userType <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(String value) {
            addCriterion("userType <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLike(String value) {
            addCriterion("userType like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotLike(String value) {
            addCriterion("userType not like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<String> values) {
            addCriterion("userType in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<String> values) {
            addCriterion("userType not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(String value1, String value2) {
            addCriterion("userType between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(String value1, String value2) {
            addCriterion("userType not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNull() {
            addCriterion("userSex is null");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNotNull() {
            addCriterion("userSex is not null");
            return (Criteria) this;
        }

        public Criteria andUsersexEqualTo(String value) {
            addCriterion("userSex =", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotEqualTo(String value) {
            addCriterion("userSex <>", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThan(String value) {
            addCriterion("userSex >", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThanOrEqualTo(String value) {
            addCriterion("userSex >=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThan(String value) {
            addCriterion("userSex <", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThanOrEqualTo(String value) {
            addCriterion("userSex <=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLike(String value) {
            addCriterion("userSex like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotLike(String value) {
            addCriterion("userSex not like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexIn(List<String> values) {
            addCriterion("userSex in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotIn(List<String> values) {
            addCriterion("userSex not in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexBetween(String value1, String value2) {
            addCriterion("userSex between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotBetween(String value1, String value2) {
            addCriterion("userSex not between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNull() {
            addCriterion("userPhone is null");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNotNull() {
            addCriterion("userPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUserphoneEqualTo(String value) {
            addCriterion("userPhone =", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotEqualTo(String value) {
            addCriterion("userPhone <>", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThan(String value) {
            addCriterion("userPhone >", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userPhone >=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThan(String value) {
            addCriterion("userPhone <", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThanOrEqualTo(String value) {
            addCriterion("userPhone <=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLike(String value) {
            addCriterion("userPhone like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotLike(String value) {
            addCriterion("userPhone not like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneIn(List<String> values) {
            addCriterion("userPhone in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotIn(List<String> values) {
            addCriterion("userPhone not in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneBetween(String value1, String value2) {
            addCriterion("userPhone between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotBetween(String value1, String value2) {
            addCriterion("userPhone not between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUsernumberIsNull() {
            addCriterion("userNumber is null");
            return (Criteria) this;
        }

        public Criteria andUsernumberIsNotNull() {
            addCriterion("userNumber is not null");
            return (Criteria) this;
        }

        public Criteria andUsernumberEqualTo(String value) {
            addCriterion("userNumber =", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotEqualTo(String value) {
            addCriterion("userNumber <>", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberGreaterThan(String value) {
            addCriterion("userNumber >", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberGreaterThanOrEqualTo(String value) {
            addCriterion("userNumber >=", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLessThan(String value) {
            addCriterion("userNumber <", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLessThanOrEqualTo(String value) {
            addCriterion("userNumber <=", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLike(String value) {
            addCriterion("userNumber like", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotLike(String value) {
            addCriterion("userNumber not like", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberIn(List<String> values) {
            addCriterion("userNumber in", values, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotIn(List<String> values) {
            addCriterion("userNumber not in", values, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberBetween(String value1, String value2) {
            addCriterion("userNumber between", value1, value2, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotBetween(String value1, String value2) {
            addCriterion("userNumber not between", value1, value2, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUseracademyIsNull() {
            addCriterion("userAcademy is null");
            return (Criteria) this;
        }

        public Criteria andUseracademyIsNotNull() {
            addCriterion("userAcademy is not null");
            return (Criteria) this;
        }

        public Criteria andUseracademyEqualTo(String value) {
            addCriterion("userAcademy =", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyNotEqualTo(String value) {
            addCriterion("userAcademy <>", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyGreaterThan(String value) {
            addCriterion("userAcademy >", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyGreaterThanOrEqualTo(String value) {
            addCriterion("userAcademy >=", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyLessThan(String value) {
            addCriterion("userAcademy <", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyLessThanOrEqualTo(String value) {
            addCriterion("userAcademy <=", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyLike(String value) {
            addCriterion("userAcademy like", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyNotLike(String value) {
            addCriterion("userAcademy not like", value, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyIn(List<String> values) {
            addCriterion("userAcademy in", values, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyNotIn(List<String> values) {
            addCriterion("userAcademy not in", values, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyBetween(String value1, String value2) {
            addCriterion("userAcademy between", value1, value2, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUseracademyNotBetween(String value1, String value2) {
            addCriterion("userAcademy not between", value1, value2, "useracademy");
            return (Criteria) this;
        }

        public Criteria andUserclassIsNull() {
            addCriterion("userClass is null");
            return (Criteria) this;
        }

        public Criteria andUserclassIsNotNull() {
            addCriterion("userClass is not null");
            return (Criteria) this;
        }

        public Criteria andUserclassEqualTo(String value) {
            addCriterion("userClass =", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotEqualTo(String value) {
            addCriterion("userClass <>", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassGreaterThan(String value) {
            addCriterion("userClass >", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassGreaterThanOrEqualTo(String value) {
            addCriterion("userClass >=", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassLessThan(String value) {
            addCriterion("userClass <", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassLessThanOrEqualTo(String value) {
            addCriterion("userClass <=", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassLike(String value) {
            addCriterion("userClass like", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotLike(String value) {
            addCriterion("userClass not like", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassIn(List<String> values) {
            addCriterion("userClass in", values, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotIn(List<String> values) {
            addCriterion("userClass not in", values, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassBetween(String value1, String value2) {
            addCriterion("userClass between", value1, value2, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotBetween(String value1, String value2) {
            addCriterion("userClass not between", value1, value2, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserhobbyIsNull() {
            addCriterion("userHobby is null");
            return (Criteria) this;
        }

        public Criteria andUserhobbyIsNotNull() {
            addCriterion("userHobby is not null");
            return (Criteria) this;
        }

        public Criteria andUserhobbyEqualTo(String value) {
            addCriterion("userHobby =", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyNotEqualTo(String value) {
            addCriterion("userHobby <>", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyGreaterThan(String value) {
            addCriterion("userHobby >", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyGreaterThanOrEqualTo(String value) {
            addCriterion("userHobby >=", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyLessThan(String value) {
            addCriterion("userHobby <", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyLessThanOrEqualTo(String value) {
            addCriterion("userHobby <=", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyLike(String value) {
            addCriterion("userHobby like", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyNotLike(String value) {
            addCriterion("userHobby not like", value, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyIn(List<String> values) {
            addCriterion("userHobby in", values, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyNotIn(List<String> values) {
            addCriterion("userHobby not in", values, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyBetween(String value1, String value2) {
            addCriterion("userHobby between", value1, value2, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUserhobbyNotBetween(String value1, String value2) {
            addCriterion("userHobby not between", value1, value2, "userhobby");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNull() {
            addCriterion("userEmail is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("userEmail is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("userEmail =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("userEmail <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("userEmail >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("userEmail >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("userEmail <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("userEmail <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("userEmail like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("userEmail not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("userEmail in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("userEmail not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("userEmail between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("userEmail not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUserqqIsNull() {
            addCriterion("userQQ is null");
            return (Criteria) this;
        }

        public Criteria andUserqqIsNotNull() {
            addCriterion("userQQ is not null");
            return (Criteria) this;
        }

        public Criteria andUserqqEqualTo(String value) {
            addCriterion("userQQ =", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotEqualTo(String value) {
            addCriterion("userQQ <>", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqGreaterThan(String value) {
            addCriterion("userQQ >", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqGreaterThanOrEqualTo(String value) {
            addCriterion("userQQ >=", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqLessThan(String value) {
            addCriterion("userQQ <", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqLessThanOrEqualTo(String value) {
            addCriterion("userQQ <=", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqLike(String value) {
            addCriterion("userQQ like", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotLike(String value) {
            addCriterion("userQQ not like", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqIn(List<String> values) {
            addCriterion("userQQ in", values, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotIn(List<String> values) {
            addCriterion("userQQ not in", values, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqBetween(String value1, String value2) {
            addCriterion("userQQ between", value1, value2, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotBetween(String value1, String value2) {
            addCriterion("userQQ not between", value1, value2, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserwechatIsNull() {
            addCriterion("userWeChat is null");
            return (Criteria) this;
        }

        public Criteria andUserwechatIsNotNull() {
            addCriterion("userWeChat is not null");
            return (Criteria) this;
        }

        public Criteria andUserwechatEqualTo(String value) {
            addCriterion("userWeChat =", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatNotEqualTo(String value) {
            addCriterion("userWeChat <>", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatGreaterThan(String value) {
            addCriterion("userWeChat >", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatGreaterThanOrEqualTo(String value) {
            addCriterion("userWeChat >=", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatLessThan(String value) {
            addCriterion("userWeChat <", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatLessThanOrEqualTo(String value) {
            addCriterion("userWeChat <=", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatLike(String value) {
            addCriterion("userWeChat like", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatNotLike(String value) {
            addCriterion("userWeChat not like", value, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatIn(List<String> values) {
            addCriterion("userWeChat in", values, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatNotIn(List<String> values) {
            addCriterion("userWeChat not in", values, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatBetween(String value1, String value2) {
            addCriterion("userWeChat between", value1, value2, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserwechatNotBetween(String value1, String value2) {
            addCriterion("userWeChat not between", value1, value2, "userwechat");
            return (Criteria) this;
        }

        public Criteria andUserphotoIsNull() {
            addCriterion("userPhoto is null");
            return (Criteria) this;
        }

        public Criteria andUserphotoIsNotNull() {
            addCriterion("userPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andUserphotoEqualTo(String value) {
            addCriterion("userPhoto =", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoNotEqualTo(String value) {
            addCriterion("userPhoto <>", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoGreaterThan(String value) {
            addCriterion("userPhoto >", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoGreaterThanOrEqualTo(String value) {
            addCriterion("userPhoto >=", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoLessThan(String value) {
            addCriterion("userPhoto <", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoLessThanOrEqualTo(String value) {
            addCriterion("userPhoto <=", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoLike(String value) {
            addCriterion("userPhoto like", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoNotLike(String value) {
            addCriterion("userPhoto not like", value, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoIn(List<String> values) {
            addCriterion("userPhoto in", values, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoNotIn(List<String> values) {
            addCriterion("userPhoto not in", values, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoBetween(String value1, String value2) {
            addCriterion("userPhoto between", value1, value2, "userphoto");
            return (Criteria) this;
        }

        public Criteria andUserphotoNotBetween(String value1, String value2) {
            addCriterion("userPhoto not between", value1, value2, "userphoto");
            return (Criteria) this;
        }

        public Criteria andDefultorgIsNull() {
            addCriterion("defultOrg is null");
            return (Criteria) this;
        }

        public Criteria andDefultorgIsNotNull() {
            addCriterion("defultOrg is not null");
            return (Criteria) this;
        }

        public Criteria andDefultorgEqualTo(String value) {
            addCriterion("defultOrg =", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgNotEqualTo(String value) {
            addCriterion("defultOrg <>", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgGreaterThan(String value) {
            addCriterion("defultOrg >", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgGreaterThanOrEqualTo(String value) {
            addCriterion("defultOrg >=", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgLessThan(String value) {
            addCriterion("defultOrg <", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgLessThanOrEqualTo(String value) {
            addCriterion("defultOrg <=", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgLike(String value) {
            addCriterion("defultOrg like", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgNotLike(String value) {
            addCriterion("defultOrg not like", value, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgIn(List<String> values) {
            addCriterion("defultOrg in", values, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgNotIn(List<String> values) {
            addCriterion("defultOrg not in", values, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgBetween(String value1, String value2) {
            addCriterion("defultOrg between", value1, value2, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDefultorgNotBetween(String value1, String value2) {
            addCriterion("defultOrg not between", value1, value2, "defultorg");
            return (Criteria) this;
        }

        public Criteria andDormitoryIsNull() {
            addCriterion("dormitory is null");
            return (Criteria) this;
        }

        public Criteria andDormitoryIsNotNull() {
            addCriterion("dormitory is not null");
            return (Criteria) this;
        }

        public Criteria andDormitoryEqualTo(String value) {
            addCriterion("dormitory =", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotEqualTo(String value) {
            addCriterion("dormitory <>", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryGreaterThan(String value) {
            addCriterion("dormitory >", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryGreaterThanOrEqualTo(String value) {
            addCriterion("dormitory >=", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryLessThan(String value) {
            addCriterion("dormitory <", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryLessThanOrEqualTo(String value) {
            addCriterion("dormitory <=", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryLike(String value) {
            addCriterion("dormitory like", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotLike(String value) {
            addCriterion("dormitory not like", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryIn(List<String> values) {
            addCriterion("dormitory in", values, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotIn(List<String> values) {
            addCriterion("dormitory not in", values, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryBetween(String value1, String value2) {
            addCriterion("dormitory between", value1, value2, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotBetween(String value1, String value2) {
            addCriterion("dormitory not between", value1, value2, "dormitory");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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