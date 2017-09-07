package edu.bistu.platform.authentication.orm.model.department;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysDepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int count = -1;

    public SysDepartmentExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setCount(int count) {
        this.count=count;
    }

    public int getCount() {
        return count;
    }

    public Criteria getCriteria() {
        if (oredCriteria.size() != 0) {return oredCriteria.get(0);}
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("departmentId is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("departmentId is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("departmentId =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("departmentId <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("departmentId >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentId >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("departmentId <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("departmentId <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("departmentId in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("departmentId not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("departmentId between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentId not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdIsNull() {
            addCriterion("parentDepartmentId is null");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdIsNotNull() {
            addCriterion("parentDepartmentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdEqualTo(Integer value) {
            addCriterion("parentDepartmentId =", value, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdNotEqualTo(Integer value) {
            addCriterion("parentDepartmentId <>", value, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdGreaterThan(Integer value) {
            addCriterion("parentDepartmentId >", value, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentDepartmentId >=", value, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdLessThan(Integer value) {
            addCriterion("parentDepartmentId <", value, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parentDepartmentId <=", value, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdIn(List<Integer> values) {
            addCriterion("parentDepartmentId in", values, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdNotIn(List<Integer> values) {
            addCriterion("parentDepartmentId not in", values, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("parentDepartmentId between", value1, value2, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parentDepartmentId not between", value1, value2, "parentDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("departmentName is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("departmentName is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("departmentName =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("departmentName <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("departmentName >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("departmentName >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("departmentName <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("departmentName <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("departmentName like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("departmentName not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("departmentName in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("departmentName not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("departmentName between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("departmentName not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIsNull() {
            addCriterion("departmentLevel is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIsNotNull() {
            addCriterion("departmentLevel is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelEqualTo(Integer value) {
            addCriterion("departmentLevel =", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotEqualTo(Integer value) {
            addCriterion("departmentLevel <>", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelGreaterThan(Integer value) {
            addCriterion("departmentLevel >", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentLevel >=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLessThan(Integer value) {
            addCriterion("departmentLevel <", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("departmentLevel <=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIn(List<Integer> values) {
            addCriterion("departmentLevel in", values, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotIn(List<Integer> values) {
            addCriterion("departmentLevel not in", values, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelBetween(Integer value1, Integer value2) {
            addCriterion("departmentLevel between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentLevel not between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinIsNull() {
            addCriterion("departmentPidJoin is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinIsNotNull() {
            addCriterion("departmentPidJoin is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinEqualTo(String value) {
            addCriterion("departmentPidJoin =", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinNotEqualTo(String value) {
            addCriterion("departmentPidJoin <>", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinGreaterThan(String value) {
            addCriterion("departmentPidJoin >", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinGreaterThanOrEqualTo(String value) {
            addCriterion("departmentPidJoin >=", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinLessThan(String value) {
            addCriterion("departmentPidJoin <", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinLessThanOrEqualTo(String value) {
            addCriterion("departmentPidJoin <=", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinLike(String value) {
            addCriterion("departmentPidJoin like", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinNotLike(String value) {
            addCriterion("departmentPidJoin not like", value, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinIn(List<String> values) {
            addCriterion("departmentPidJoin in", values, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinNotIn(List<String> values) {
            addCriterion("departmentPidJoin not in", values, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinBetween(String value1, String value2) {
            addCriterion("departmentPidJoin between", value1, value2, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentPidJoinNotBetween(String value1, String value2) {
            addCriterion("departmentPidJoin not between", value1, value2, "departmentPidJoin");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusIsNull() {
            addCriterion("departmentStatus is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusIsNotNull() {
            addCriterion("departmentStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusEqualTo(Integer value) {
            addCriterion("departmentStatus =", value, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusNotEqualTo(Integer value) {
            addCriterion("departmentStatus <>", value, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusGreaterThan(Integer value) {
            addCriterion("departmentStatus >", value, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentStatus >=", value, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusLessThan(Integer value) {
            addCriterion("departmentStatus <", value, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("departmentStatus <=", value, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusIn(List<Integer> values) {
            addCriterion("departmentStatus in", values, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusNotIn(List<Integer> values) {
            addCriterion("departmentStatus not in", values, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusBetween(Integer value1, Integer value2) {
            addCriterion("departmentStatus between", value1, value2, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andDepartmentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentStatus not between", value1, value2, "departmentStatus");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteIsNull() {
            addCriterion("isIllegalsite is null");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteIsNotNull() {
            addCriterion("isIllegalsite is not null");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteEqualTo(Integer value) {
            addCriterion("isIllegalsite =", value, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteNotEqualTo(Integer value) {
            addCriterion("isIllegalsite <>", value, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteGreaterThan(Integer value) {
            addCriterion("isIllegalsite >", value, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isIllegalsite >=", value, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteLessThan(Integer value) {
            addCriterion("isIllegalsite <", value, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteLessThanOrEqualTo(Integer value) {
            addCriterion("isIllegalsite <=", value, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteIn(List<Integer> values) {
            addCriterion("isIllegalsite in", values, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteNotIn(List<Integer> values) {
            addCriterion("isIllegalsite not in", values, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteBetween(Integer value1, Integer value2) {
            addCriterion("isIllegalsite between", value1, value2, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andIsIllegalsiteNotBetween(Integer value1, Integer value2) {
            addCriterion("isIllegalsite not between", value1, value2, "isIllegalsite");
            return (Criteria) this;
        }

        public Criteria andContactUserIsNull() {
            addCriterion("contactUser is null");
            return (Criteria) this;
        }

        public Criteria andContactUserIsNotNull() {
            addCriterion("contactUser is not null");
            return (Criteria) this;
        }

        public Criteria andContactUserEqualTo(String value) {
            addCriterion("contactUser =", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserNotEqualTo(String value) {
            addCriterion("contactUser <>", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserGreaterThan(String value) {
            addCriterion("contactUser >", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserGreaterThanOrEqualTo(String value) {
            addCriterion("contactUser >=", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserLessThan(String value) {
            addCriterion("contactUser <", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserLessThanOrEqualTo(String value) {
            addCriterion("contactUser <=", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserLike(String value) {
            addCriterion("contactUser like", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserNotLike(String value) {
            addCriterion("contactUser not like", value, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserIn(List<String> values) {
            addCriterion("contactUser in", values, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserNotIn(List<String> values) {
            addCriterion("contactUser not in", values, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserBetween(String value1, String value2) {
            addCriterion("contactUser between", value1, value2, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactUserNotBetween(String value1, String value2) {
            addCriterion("contactUser not between", value1, value2, "contactUser");
            return (Criteria) this;
        }

        public Criteria andContactTypeIsNull() {
            addCriterion("contactType is null");
            return (Criteria) this;
        }

        public Criteria andContactTypeIsNotNull() {
            addCriterion("contactType is not null");
            return (Criteria) this;
        }

        public Criteria andContactTypeEqualTo(String value) {
            addCriterion("contactType =", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeNotEqualTo(String value) {
            addCriterion("contactType <>", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeGreaterThan(String value) {
            addCriterion("contactType >", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contactType >=", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeLessThan(String value) {
            addCriterion("contactType <", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeLessThanOrEqualTo(String value) {
            addCriterion("contactType <=", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeLike(String value) {
            addCriterion("contactType like", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeNotLike(String value) {
            addCriterion("contactType not like", value, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeIn(List<String> values) {
            addCriterion("contactType in", values, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeNotIn(List<String> values) {
            addCriterion("contactType not in", values, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeBetween(String value1, String value2) {
            addCriterion("contactType between", value1, value2, "contactType");
            return (Criteria) this;
        }

        public Criteria andContactTypeNotBetween(String value1, String value2) {
            addCriterion("contactType not between", value1, value2, "contactType");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNull() {
            addCriterion("expiredDate is null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNotNull() {
            addCriterion("expiredDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateEqualTo(Date value) {
            addCriterionForJDBCDate("expiredDate =", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expiredDate <>", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expiredDate >", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expiredDate >=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThan(Date value) {
            addCriterionForJDBCDate("expiredDate <", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expiredDate <=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIn(List<Date> values) {
            addCriterionForJDBCDate("expiredDate in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expiredDate not in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expiredDate between", value1, value2, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expiredDate not between", value1, value2, "expiredDate");
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