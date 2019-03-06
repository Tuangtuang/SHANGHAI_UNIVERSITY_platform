package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmExample() {
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

        public Criteria andAlarmingUserIsNull() {
            addCriterion("alarming_user is null");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserIsNotNull() {
            addCriterion("alarming_user is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserEqualTo(String value) {
            addCriterion("alarming_user =", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserNotEqualTo(String value) {
            addCriterion("alarming_user <>", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserGreaterThan(String value) {
            addCriterion("alarming_user >", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserGreaterThanOrEqualTo(String value) {
            addCriterion("alarming_user >=", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserLessThan(String value) {
            addCriterion("alarming_user <", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserLessThanOrEqualTo(String value) {
            addCriterion("alarming_user <=", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserLike(String value) {
            addCriterion("alarming_user like", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserNotLike(String value) {
            addCriterion("alarming_user not like", value, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserIn(List<String> values) {
            addCriterion("alarming_user in", values, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserNotIn(List<String> values) {
            addCriterion("alarming_user not in", values, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserBetween(String value1, String value2) {
            addCriterion("alarming_user between", value1, value2, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmingUserNotBetween(String value1, String value2) {
            addCriterion("alarming_user not between", value1, value2, "alarmingUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserIsNull() {
            addCriterion("alarmed_user is null");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserIsNotNull() {
            addCriterion("alarmed_user is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserEqualTo(String value) {
            addCriterion("alarmed_user =", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserNotEqualTo(String value) {
            addCriterion("alarmed_user <>", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserGreaterThan(String value) {
            addCriterion("alarmed_user >", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserGreaterThanOrEqualTo(String value) {
            addCriterion("alarmed_user >=", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserLessThan(String value) {
            addCriterion("alarmed_user <", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserLessThanOrEqualTo(String value) {
            addCriterion("alarmed_user <=", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserLike(String value) {
            addCriterion("alarmed_user like", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserNotLike(String value) {
            addCriterion("alarmed_user not like", value, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserIn(List<String> values) {
            addCriterion("alarmed_user in", values, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserNotIn(List<String> values) {
            addCriterion("alarmed_user not in", values, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserBetween(String value1, String value2) {
            addCriterion("alarmed_user between", value1, value2, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmedUserNotBetween(String value1, String value2) {
            addCriterion("alarmed_user not between", value1, value2, "alarmedUser");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNull() {
            addCriterion("alarm_type is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNotNull() {
            addCriterion("alarm_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeEqualTo(Integer value) {
            addCriterion("alarm_type =", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotEqualTo(Integer value) {
            addCriterion("alarm_type <>", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThan(Integer value) {
            addCriterion("alarm_type >", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_type >=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThan(Integer value) {
            addCriterion("alarm_type <", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_type <=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIn(List<Integer> values) {
            addCriterion("alarm_type in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotIn(List<Integer> values) {
            addCriterion("alarm_type not in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeBetween(Integer value1, Integer value2) {
            addCriterion("alarm_type between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_type not between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Timestamp value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Timestamp value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Timestamp value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Timestamp value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Timestamp> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Timestamp> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andViewTypeIsNull() {
            addCriterion("view_type is null");
            return (Criteria) this;
        }

        public Criteria andViewTypeIsNotNull() {
            addCriterion("view_type is not null");
            return (Criteria) this;
        }

        public Criteria andViewTypeEqualTo(Integer value) {
            addCriterion("view_type =", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotEqualTo(Integer value) {
            addCriterion("view_type <>", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeGreaterThan(Integer value) {
            addCriterion("view_type >", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_type >=", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeLessThan(Integer value) {
            addCriterion("view_type <", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeLessThanOrEqualTo(Integer value) {
            addCriterion("view_type <=", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeIn(List<Integer> values) {
            addCriterion("view_type in", values, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotIn(List<Integer> values) {
            addCriterion("view_type not in", values, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeBetween(Integer value1, Integer value2) {
            addCriterion("view_type between", value1, value2, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("view_type not between", value1, value2, "viewType");
            return (Criteria) this;
        }

        public Criteria andCommendIdIsNull() {
            addCriterion("commend_id is null");
            return (Criteria) this;
        }

        public Criteria andCommendIdIsNotNull() {
            addCriterion("commend_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommendIdEqualTo(Integer value) {
            addCriterion("commend_id =", value, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdNotEqualTo(Integer value) {
            addCriterion("commend_id <>", value, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdGreaterThan(Integer value) {
            addCriterion("commend_id >", value, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commend_id >=", value, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdLessThan(Integer value) {
            addCriterion("commend_id <", value, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdLessThanOrEqualTo(Integer value) {
            addCriterion("commend_id <=", value, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdIn(List<Integer> values) {
            addCriterion("commend_id in", values, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdNotIn(List<Integer> values) {
            addCriterion("commend_id not in", values, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdBetween(Integer value1, Integer value2) {
            addCriterion("commend_id between", value1, value2, "commendId");
            return (Criteria) this;
        }

        public Criteria andCommendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commend_id not between", value1, value2, "commendId");
            return (Criteria) this;
        }

        public Criteria andViewIdIsNull() {
            addCriterion("view_id is null");
            return (Criteria) this;
        }

        public Criteria andViewIdIsNotNull() {
            addCriterion("view_id is not null");
            return (Criteria) this;
        }

        public Criteria andViewIdEqualTo(Integer value) {
            addCriterion("view_id =", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotEqualTo(Integer value) {
            addCriterion("view_id <>", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdGreaterThan(Integer value) {
            addCriterion("view_id >", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_id >=", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdLessThan(Integer value) {
            addCriterion("view_id <", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdLessThanOrEqualTo(Integer value) {
            addCriterion("view_id <=", value, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdIn(List<Integer> values) {
            addCriterion("view_id in", values, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotIn(List<Integer> values) {
            addCriterion("view_id not in", values, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdBetween(Integer value1, Integer value2) {
            addCriterion("view_id between", value1, value2, "viewId");
            return (Criteria) this;
        }

        public Criteria andViewIdNotBetween(Integer value1, Integer value2) {
            addCriterion("view_id not between", value1, value2, "viewId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
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