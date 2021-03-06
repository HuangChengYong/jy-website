package com.jyinfo.jy_domain.Entity.mybatisEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserEntityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public UserEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
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

        public Criteria andFUserIdIsNull() {
            addCriterion("F_User_ID is null");
            return (Criteria) this;
        }

        public Criteria andFUserIdIsNotNull() {
            addCriterion("F_User_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFUserIdEqualTo(Integer value) {
            addCriterion("F_User_ID =", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotEqualTo(Integer value) {
            addCriterion("F_User_ID <>", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdGreaterThan(Integer value) {
            addCriterion("F_User_ID >", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("F_User_ID >=", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdLessThan(Integer value) {
            addCriterion("F_User_ID <", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("F_User_ID <=", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdIn(List<Integer> values) {
            addCriterion("F_User_ID in", values, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotIn(List<Integer> values) {
            addCriterion("F_User_ID not in", values, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdBetween(Integer value1, Integer value2) {
            addCriterion("F_User_ID between", value1, value2, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("F_User_ID not between", value1, value2, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserNameIsNull() {
            addCriterion("F_User_Name is null");
            return (Criteria) this;
        }

        public Criteria andFUserNameIsNotNull() {
            addCriterion("F_User_Name is not null");
            return (Criteria) this;
        }

        public Criteria andFUserNameEqualTo(String value) {
            addCriterion("F_User_Name =", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameNotEqualTo(String value) {
            addCriterion("F_User_Name <>", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameGreaterThan(String value) {
            addCriterion("F_User_Name >", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("F_User_Name >=", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameLessThan(String value) {
            addCriterion("F_User_Name <", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameLessThanOrEqualTo(String value) {
            addCriterion("F_User_Name <=", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameLike(String value) {
            addCriterion("F_User_Name like", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameNotLike(String value) {
            addCriterion("F_User_Name not like", value, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameIn(List<String> values) {
            addCriterion("F_User_Name in", values, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameNotIn(List<String> values) {
            addCriterion("F_User_Name not in", values, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameBetween(String value1, String value2) {
            addCriterion("F_User_Name between", value1, value2, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFUserNameNotBetween(String value1, String value2) {
            addCriterion("F_User_Name not between", value1, value2, "fUserName");
            return (Criteria) this;
        }

        public Criteria andFProfileIsNull() {
            addCriterion("F_Profile is null");
            return (Criteria) this;
        }

        public Criteria andFProfileIsNotNull() {
            addCriterion("F_Profile is not null");
            return (Criteria) this;
        }

        public Criteria andFProfileEqualTo(String value) {
            addCriterion("F_Profile =", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileNotEqualTo(String value) {
            addCriterion("F_Profile <>", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileGreaterThan(String value) {
            addCriterion("F_Profile >", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileGreaterThanOrEqualTo(String value) {
            addCriterion("F_Profile >=", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileLessThan(String value) {
            addCriterion("F_Profile <", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileLessThanOrEqualTo(String value) {
            addCriterion("F_Profile <=", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileLike(String value) {
            addCriterion("F_Profile like", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileNotLike(String value) {
            addCriterion("F_Profile not like", value, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileIn(List<String> values) {
            addCriterion("F_Profile in", values, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileNotIn(List<String> values) {
            addCriterion("F_Profile not in", values, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileBetween(String value1, String value2) {
            addCriterion("F_Profile between", value1, value2, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFProfileNotBetween(String value1, String value2) {
            addCriterion("F_Profile not between", value1, value2, "fProfile");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordIsNull() {
            addCriterion("F_User_Password is null");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordIsNotNull() {
            addCriterion("F_User_Password is not null");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordEqualTo(String value) {
            addCriterion("F_User_Password =", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordNotEqualTo(String value) {
            addCriterion("F_User_Password <>", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordGreaterThan(String value) {
            addCriterion("F_User_Password >", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("F_User_Password >=", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordLessThan(String value) {
            addCriterion("F_User_Password <", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("F_User_Password <=", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordLike(String value) {
            addCriterion("F_User_Password like", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordNotLike(String value) {
            addCriterion("F_User_Password not like", value, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordIn(List<String> values) {
            addCriterion("F_User_Password in", values, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordNotIn(List<String> values) {
            addCriterion("F_User_Password not in", values, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordBetween(String value1, String value2) {
            addCriterion("F_User_Password between", value1, value2, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFUserPasswordNotBetween(String value1, String value2) {
            addCriterion("F_User_Password not between", value1, value2, "fUserPassword");
            return (Criteria) this;
        }

        public Criteria andFSaltIsNull() {
            addCriterion("F_Salt is null");
            return (Criteria) this;
        }

        public Criteria andFSaltIsNotNull() {
            addCriterion("F_Salt is not null");
            return (Criteria) this;
        }

        public Criteria andFSaltEqualTo(String value) {
            addCriterion("F_Salt =", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltNotEqualTo(String value) {
            addCriterion("F_Salt <>", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltGreaterThan(String value) {
            addCriterion("F_Salt >", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltGreaterThanOrEqualTo(String value) {
            addCriterion("F_Salt >=", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltLessThan(String value) {
            addCriterion("F_Salt <", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltLessThanOrEqualTo(String value) {
            addCriterion("F_Salt <=", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltLike(String value) {
            addCriterion("F_Salt like", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltNotLike(String value) {
            addCriterion("F_Salt not like", value, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltIn(List<String> values) {
            addCriterion("F_Salt in", values, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltNotIn(List<String> values) {
            addCriterion("F_Salt not in", values, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltBetween(String value1, String value2) {
            addCriterion("F_Salt between", value1, value2, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFSaltNotBetween(String value1, String value2) {
            addCriterion("F_Salt not between", value1, value2, "fSalt");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNull() {
            addCriterion("F_Create_Time is null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNotNull() {
            addCriterion("F_Create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeEqualTo(Date value) {
            addCriterion("F_Create_Time =", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotEqualTo(Date value) {
            addCriterion("F_Create_Time <>", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThan(Date value) {
            addCriterion("F_Create_Time >", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("F_Create_Time >=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThan(Date value) {
            addCriterion("F_Create_Time <", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("F_Create_Time <=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIn(List<Date> values) {
            addCriterion("F_Create_Time in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotIn(List<Date> values) {
            addCriterion("F_Create_Time not in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeBetween(Date value1, Date value2) {
            addCriterion("F_Create_Time between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("F_Create_Time not between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFMobileIsNull() {
            addCriterion("F_Mobile is null");
            return (Criteria) this;
        }

        public Criteria andFMobileIsNotNull() {
            addCriterion("F_Mobile is not null");
            return (Criteria) this;
        }

        public Criteria andFMobileEqualTo(String value) {
            addCriterion("F_Mobile =", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileNotEqualTo(String value) {
            addCriterion("F_Mobile <>", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileGreaterThan(String value) {
            addCriterion("F_Mobile >", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileGreaterThanOrEqualTo(String value) {
            addCriterion("F_Mobile >=", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileLessThan(String value) {
            addCriterion("F_Mobile <", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileLessThanOrEqualTo(String value) {
            addCriterion("F_Mobile <=", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileLike(String value) {
            addCriterion("F_Mobile like", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileNotLike(String value) {
            addCriterion("F_Mobile not like", value, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileIn(List<String> values) {
            addCriterion("F_Mobile in", values, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileNotIn(List<String> values) {
            addCriterion("F_Mobile not in", values, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileBetween(String value1, String value2) {
            addCriterion("F_Mobile between", value1, value2, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFMobileNotBetween(String value1, String value2) {
            addCriterion("F_Mobile not between", value1, value2, "fMobile");
            return (Criteria) this;
        }

        public Criteria andFEmailIsNull() {
            addCriterion("F_Email is null");
            return (Criteria) this;
        }

        public Criteria andFEmailIsNotNull() {
            addCriterion("F_Email is not null");
            return (Criteria) this;
        }

        public Criteria andFEmailEqualTo(String value) {
            addCriterion("F_Email =", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailNotEqualTo(String value) {
            addCriterion("F_Email <>", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailGreaterThan(String value) {
            addCriterion("F_Email >", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailGreaterThanOrEqualTo(String value) {
            addCriterion("F_Email >=", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailLessThan(String value) {
            addCriterion("F_Email <", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailLessThanOrEqualTo(String value) {
            addCriterion("F_Email <=", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailLike(String value) {
            addCriterion("F_Email like", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailNotLike(String value) {
            addCriterion("F_Email not like", value, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailIn(List<String> values) {
            addCriterion("F_Email in", values, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailNotIn(List<String> values) {
            addCriterion("F_Email not in", values, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailBetween(String value1, String value2) {
            addCriterion("F_Email between", value1, value2, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFEmailNotBetween(String value1, String value2) {
            addCriterion("F_Email not between", value1, value2, "fEmail");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNull() {
            addCriterion("F_Update_Time is null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNotNull() {
            addCriterion("F_Update_Time is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeEqualTo(Date value) {
            addCriterion("F_Update_Time =", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotEqualTo(Date value) {
            addCriterion("F_Update_Time <>", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThan(Date value) {
            addCriterion("F_Update_Time >", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("F_Update_Time >=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThan(Date value) {
            addCriterion("F_Update_Time <", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("F_Update_Time <=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIn(List<Date> values) {
            addCriterion("F_Update_Time in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotIn(List<Date> values) {
            addCriterion("F_Update_Time not in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("F_Update_Time between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("F_Update_Time not between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_user
     *
     * @mbggenerated do_not_delete_during_merge Mon Sep 14 21:59:23 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
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