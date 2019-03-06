package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

public class BlacklistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlacklistExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseraIsNull() {
            addCriterion("userA is null");
            return (Criteria) this;
        }

        public Criteria andUseraIsNotNull() {
            addCriterion("userA is not null");
            return (Criteria) this;
        }

        public Criteria andUseraEqualTo(String value) {
            addCriterion("userA =", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraNotEqualTo(String value) {
            addCriterion("userA <>", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraGreaterThan(String value) {
            addCriterion("userA >", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraGreaterThanOrEqualTo(String value) {
            addCriterion("userA >=", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraLessThan(String value) {
            addCriterion("userA <", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraLessThanOrEqualTo(String value) {
            addCriterion("userA <=", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraLike(String value) {
            addCriterion("userA like", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraNotLike(String value) {
            addCriterion("userA not like", value, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraIn(List<String> values) {
            addCriterion("userA in", values, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraNotIn(List<String> values) {
            addCriterion("userA not in", values, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraBetween(String value1, String value2) {
            addCriterion("userA between", value1, value2, "usera");
            return (Criteria) this;
        }

        public Criteria andUseraNotBetween(String value1, String value2) {
            addCriterion("userA not between", value1, value2, "usera");
            return (Criteria) this;
        }

        public Criteria andUserbIsNull() {
            addCriterion("userB is null");
            return (Criteria) this;
        }

        public Criteria andUserbIsNotNull() {
            addCriterion("userB is not null");
            return (Criteria) this;
        }

        public Criteria andUserbEqualTo(String value) {
            addCriterion("userB =", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbNotEqualTo(String value) {
            addCriterion("userB <>", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbGreaterThan(String value) {
            addCriterion("userB >", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbGreaterThanOrEqualTo(String value) {
            addCriterion("userB >=", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbLessThan(String value) {
            addCriterion("userB <", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbLessThanOrEqualTo(String value) {
            addCriterion("userB <=", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbLike(String value) {
            addCriterion("userB like", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbNotLike(String value) {
            addCriterion("userB not like", value, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbIn(List<String> values) {
            addCriterion("userB in", values, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbNotIn(List<String> values) {
            addCriterion("userB not in", values, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbBetween(String value1, String value2) {
            addCriterion("userB between", value1, value2, "userb");
            return (Criteria) this;
        }

        public Criteria andUserbNotBetween(String value1, String value2) {
            addCriterion("userB not between", value1, value2, "userb");
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