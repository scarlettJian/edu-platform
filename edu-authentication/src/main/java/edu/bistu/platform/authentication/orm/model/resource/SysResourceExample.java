package edu.bistu.platform.authentication.orm.model.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int count = -1;

    public SysResourceExample() {
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

        public Criteria andResourceIdIsNull() {
            addCriterion("resourceId is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resourceId is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(Integer value) {
            addCriterion("resourceId =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(Integer value) {
            addCriterion("resourceId <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(Integer value) {
            addCriterion("resourceId >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resourceId >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(Integer value) {
            addCriterion("resourceId <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("resourceId <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<Integer> values) {
            addCriterion("resourceId in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<Integer> values) {
            addCriterion("resourceId not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(Integer value1, Integer value2) {
            addCriterion("resourceId between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resourceId not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resourceName is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resourceName is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resourceName =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resourceName <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resourceName >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resourceName >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resourceName <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resourceName <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resourceName like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resourceName not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resourceName in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resourceName not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resourceName between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resourceName not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdIsNull() {
            addCriterion("parentResourceId is null");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdIsNotNull() {
            addCriterion("parentResourceId is not null");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdEqualTo(Integer value) {
            addCriterion("parentResourceId =", value, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdNotEqualTo(Integer value) {
            addCriterion("parentResourceId <>", value, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdGreaterThan(Integer value) {
            addCriterion("parentResourceId >", value, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentResourceId >=", value, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdLessThan(Integer value) {
            addCriterion("parentResourceId <", value, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("parentResourceId <=", value, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdIn(List<Integer> values) {
            addCriterion("parentResourceId in", values, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdNotIn(List<Integer> values) {
            addCriterion("parentResourceId not in", values, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdBetween(Integer value1, Integer value2) {
            addCriterion("parentResourceId between", value1, value2, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andParentResourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parentResourceId not between", value1, value2, "parentResourceId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceIsNull() {
            addCriterion("isCommResource is null");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceIsNotNull() {
            addCriterion("isCommResource is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceEqualTo(Integer value) {
            addCriterion("isCommResource =", value, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceNotEqualTo(Integer value) {
            addCriterion("isCommResource <>", value, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceGreaterThan(Integer value) {
            addCriterion("isCommResource >", value, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("isCommResource >=", value, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceLessThan(Integer value) {
            addCriterion("isCommResource <", value, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceLessThanOrEqualTo(Integer value) {
            addCriterion("isCommResource <=", value, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceIn(List<Integer> values) {
            addCriterion("isCommResource in", values, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceNotIn(List<Integer> values) {
            addCriterion("isCommResource not in", values, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceBetween(Integer value1, Integer value2) {
            addCriterion("isCommResource between", value1, value2, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsCommResourceNotBetween(Integer value1, Integer value2) {
            addCriterion("isCommResource not between", value1, value2, "isCommResource");
            return (Criteria) this;
        }

        public Criteria andIsButtonIsNull() {
            addCriterion("isButton is null");
            return (Criteria) this;
        }

        public Criteria andIsButtonIsNotNull() {
            addCriterion("isButton is not null");
            return (Criteria) this;
        }

        public Criteria andIsButtonEqualTo(Integer value) {
            addCriterion("isButton =", value, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonNotEqualTo(Integer value) {
            addCriterion("isButton <>", value, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonGreaterThan(Integer value) {
            addCriterion("isButton >", value, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonGreaterThanOrEqualTo(Integer value) {
            addCriterion("isButton >=", value, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonLessThan(Integer value) {
            addCriterion("isButton <", value, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonLessThanOrEqualTo(Integer value) {
            addCriterion("isButton <=", value, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonIn(List<Integer> values) {
            addCriterion("isButton in", values, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonNotIn(List<Integer> values) {
            addCriterion("isButton not in", values, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonBetween(Integer value1, Integer value2) {
            addCriterion("isButton between", value1, value2, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsButtonNotBetween(Integer value1, Integer value2) {
            addCriterion("isButton not between", value1, value2, "isButton");
            return (Criteria) this;
        }

        public Criteria andIsNavbarIsNull() {
            addCriterion("isNavbar is null");
            return (Criteria) this;
        }

        public Criteria andIsNavbarIsNotNull() {
            addCriterion("isNavbar is not null");
            return (Criteria) this;
        }

        public Criteria andIsNavbarEqualTo(Integer value) {
            addCriterion("isNavbar =", value, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarNotEqualTo(Integer value) {
            addCriterion("isNavbar <>", value, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarGreaterThan(Integer value) {
            addCriterion("isNavbar >", value, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarGreaterThanOrEqualTo(Integer value) {
            addCriterion("isNavbar >=", value, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarLessThan(Integer value) {
            addCriterion("isNavbar <", value, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarLessThanOrEqualTo(Integer value) {
            addCriterion("isNavbar <=", value, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarIn(List<Integer> values) {
            addCriterion("isNavbar in", values, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarNotIn(List<Integer> values) {
            addCriterion("isNavbar not in", values, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarBetween(Integer value1, Integer value2) {
            addCriterion("isNavbar between", value1, value2, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andIsNavbarNotBetween(Integer value1, Integer value2) {
            addCriterion("isNavbar not between", value1, value2, "isNavbar");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNull() {
            addCriterion("seqNo is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("seqNo is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(Integer value) {
            addCriterion("seqNo =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Integer value) {
            addCriterion("seqNo <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Integer value) {
            addCriterion("seqNo >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("seqNo >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Integer value) {
            addCriterion("seqNo <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
            addCriterion("seqNo <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Integer> values) {
            addCriterion("seqNo in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Integer> values) {
            addCriterion("seqNo not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Integer value1, Integer value2) {
            addCriterion("seqNo between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
            addCriterion("seqNo not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andInnerCodeIsNull() {
            addCriterion("innerCode is null");
            return (Criteria) this;
        }

        public Criteria andInnerCodeIsNotNull() {
            addCriterion("innerCode is not null");
            return (Criteria) this;
        }

        public Criteria andInnerCodeEqualTo(String value) {
            addCriterion("innerCode =", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeNotEqualTo(String value) {
            addCriterion("innerCode <>", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeGreaterThan(String value) {
            addCriterion("innerCode >", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("innerCode >=", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeLessThan(String value) {
            addCriterion("innerCode <", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeLessThanOrEqualTo(String value) {
            addCriterion("innerCode <=", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeLike(String value) {
            addCriterion("innerCode like", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeNotLike(String value) {
            addCriterion("innerCode not like", value, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeIn(List<String> values) {
            addCriterion("innerCode in", values, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeNotIn(List<String> values) {
            addCriterion("innerCode not in", values, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeBetween(String value1, String value2) {
            addCriterion("innerCode between", value1, value2, "innerCode");
            return (Criteria) this;
        }

        public Criteria andInnerCodeNotBetween(String value1, String value2) {
            addCriterion("innerCode not between", value1, value2, "innerCode");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("updateDate =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("updateDate <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("updateDate >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDate >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("updateDate <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("updateDate <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("updateDate in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("updateDate not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("updateDate between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("updateDate not between", value1, value2, "updateDate");
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