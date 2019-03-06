package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HelpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HelpExample() {
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

        public Criteria andPullerIsNull() {
            addCriterion("puller is null");
            return (Criteria) this;
        }

        public Criteria andPullerIsNotNull() {
            addCriterion("puller is not null");
            return (Criteria) this;
        }

        public Criteria andPullerEqualTo(String value) {
            addCriterion("puller =", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerNotEqualTo(String value) {
            addCriterion("puller <>", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerGreaterThan(String value) {
            addCriterion("puller >", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerGreaterThanOrEqualTo(String value) {
            addCriterion("puller >=", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerLessThan(String value) {
            addCriterion("puller <", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerLessThanOrEqualTo(String value) {
            addCriterion("puller <=", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerLike(String value) {
            addCriterion("puller like", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerNotLike(String value) {
            addCriterion("puller not like", value, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerIn(List<String> values) {
            addCriterion("puller in", values, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerNotIn(List<String> values) {
            addCriterion("puller not in", values, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerBetween(String value1, String value2) {
            addCriterion("puller between", value1, value2, "puller");
            return (Criteria) this;
        }

        public Criteria andPullerNotBetween(String value1, String value2) {
            addCriterion("puller not between", value1, value2, "puller");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Timestamp value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Timestamp value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Timestamp value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Timestamp value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Timestamp> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Timestamp> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Timestamp value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Timestamp value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Timestamp value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Timestamp value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Timestamp> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Timestamp> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneIsNull() {
            addCriterion("pusher_phone is null");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneIsNotNull() {
            addCriterion("pusher_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneEqualTo(String value) {
            addCriterion("pusher_phone =", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneNotEqualTo(String value) {
            addCriterion("pusher_phone <>", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneGreaterThan(String value) {
            addCriterion("pusher_phone >", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pusher_phone >=", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneLessThan(String value) {
            addCriterion("pusher_phone <", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneLessThanOrEqualTo(String value) {
            addCriterion("pusher_phone <=", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneLike(String value) {
            addCriterion("pusher_phone like", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneNotLike(String value) {
            addCriterion("pusher_phone not like", value, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneIn(List<String> values) {
            addCriterion("pusher_phone in", values, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneNotIn(List<String> values) {
            addCriterion("pusher_phone not in", values, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneBetween(String value1, String value2) {
            addCriterion("pusher_phone between", value1, value2, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andPusherPhoneNotBetween(String value1, String value2) {
            addCriterion("pusher_phone not between", value1, value2, "pusherPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andOthersIsNull() {
            addCriterion("others is null");
            return (Criteria) this;
        }

        public Criteria andOthersIsNotNull() {
            addCriterion("others is not null");
            return (Criteria) this;
        }

        public Criteria andOthersEqualTo(String value) {
            addCriterion("others =", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotEqualTo(String value) {
            addCriterion("others <>", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersGreaterThan(String value) {
            addCriterion("others >", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersGreaterThanOrEqualTo(String value) {
            addCriterion("others >=", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersLessThan(String value) {
            addCriterion("others <", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersLessThanOrEqualTo(String value) {
            addCriterion("others <=", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersLike(String value) {
            addCriterion("others like", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotLike(String value) {
            addCriterion("others not like", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersIn(List<String> values) {
            addCriterion("others in", values, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotIn(List<String> values) {
            addCriterion("others not in", values, "others");
            return (Criteria) this;
        }

        public Criteria andOthersBetween(String value1, String value2) {
            addCriterion("others between", value1, value2, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotBetween(String value1, String value2) {
            addCriterion("others not between", value1, value2, "others");
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