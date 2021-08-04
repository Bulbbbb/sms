package priv.sunyj.sms.bean;

import java.util.ArrayList;
import java.util.List;

public class AuthPowerExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public AuthPowerExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
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
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andAuthNumIsNull() {
            addCriterion("auth_num is null");
            return (Criteria) this;
        }

        public Criteria andAuthNumIsNotNull() {
            addCriterion("auth_num is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNumEqualTo(String value) {
            addCriterion("auth_num =", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumNotEqualTo(String value) {
            addCriterion("auth_num <>", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumGreaterThan(String value) {
            addCriterion("auth_num >", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumGreaterThanOrEqualTo(String value) {
            addCriterion("auth_num >=", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumLessThan(String value) {
            addCriterion("auth_num <", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumLessThanOrEqualTo(String value) {
            addCriterion("auth_num <=", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumLike(String value) {
            addCriterion("auth_num like", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumNotLike(String value) {
            addCriterion("auth_num not like", value, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumIn(List<String> values) {
            addCriterion("auth_num in", values, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumNotIn(List<String> values) {
            addCriterion("auth_num not in", values, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumBetween(String value1, String value2) {
            addCriterion("auth_num between", value1, value2, "authNum");
            return (Criteria) this;
        }

        public Criteria andAuthNumNotBetween(String value1, String value2) {
            addCriterion("auth_num not between", value1, value2, "authNum");
            return (Criteria) this;
        }

        public Criteria andPowNumIsNull() {
            addCriterion("pow_num is null");
            return (Criteria) this;
        }

        public Criteria andPowNumIsNotNull() {
            addCriterion("pow_num is not null");
            return (Criteria) this;
        }

        public Criteria andPowNumEqualTo(String value) {
            addCriterion("pow_num =", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumNotEqualTo(String value) {
            addCriterion("pow_num <>", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumGreaterThan(String value) {
            addCriterion("pow_num >", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumGreaterThanOrEqualTo(String value) {
            addCriterion("pow_num >=", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumLessThan(String value) {
            addCriterion("pow_num <", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumLessThanOrEqualTo(String value) {
            addCriterion("pow_num <=", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumLike(String value) {
            addCriterion("pow_num like", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumNotLike(String value) {
            addCriterion("pow_num not like", value, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumIn(List<String> values) {
            addCriterion("pow_num in", values, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumNotIn(List<String> values) {
            addCriterion("pow_num not in", values, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumBetween(String value1, String value2) {
            addCriterion("pow_num between", value1, value2, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNumNotBetween(String value1, String value2) {
            addCriterion("pow_num not between", value1, value2, "powNum");
            return (Criteria) this;
        }

        public Criteria andPowNameIsNull() {
            addCriterion("pow_name is null");
            return (Criteria) this;
        }

        public Criteria andPowNameIsNotNull() {
            addCriterion("pow_name is not null");
            return (Criteria) this;
        }

        public Criteria andPowNameEqualTo(String value) {
            addCriterion("pow_name =", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameNotEqualTo(String value) {
            addCriterion("pow_name <>", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameGreaterThan(String value) {
            addCriterion("pow_name >", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameGreaterThanOrEqualTo(String value) {
            addCriterion("pow_name >=", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameLessThan(String value) {
            addCriterion("pow_name <", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameLessThanOrEqualTo(String value) {
            addCriterion("pow_name <=", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameLike(String value) {
            addCriterion("pow_name like", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameNotLike(String value) {
            addCriterion("pow_name not like", value, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameIn(List<String> values) {
            addCriterion("pow_name in", values, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameNotIn(List<String> values) {
            addCriterion("pow_name not in", values, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameBetween(String value1, String value2) {
            addCriterion("pow_name between", value1, value2, "powName");
            return (Criteria) this;
        }

        public Criteria andPowNameNotBetween(String value1, String value2) {
            addCriterion("pow_name not between", value1, value2, "powName");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNull() {
            addCriterion("auth_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNotNull() {
            addCriterion("auth_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNameEqualTo(String value) {
            addCriterion("auth_name =", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotEqualTo(String value) {
            addCriterion("auth_name <>", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThan(String value) {
            addCriterion("auth_name >", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThanOrEqualTo(String value) {
            addCriterion("auth_name >=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThan(String value) {
            addCriterion("auth_name <", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThanOrEqualTo(String value) {
            addCriterion("auth_name <=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLike(String value) {
            addCriterion("auth_name like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotLike(String value) {
            addCriterion("auth_name not like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameIn(List<String> values) {
            addCriterion("auth_name in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotIn(List<String> values) {
            addCriterion("auth_name not in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameBetween(String value1, String value2) {
            addCriterion("auth_name between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotBetween(String value1, String value2) {
            addCriterion("auth_name not between", value1, value2, "authName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_auth_power
     *
     * @mbg.generated do_not_delete_during_merge Wed May 19 15:50:21 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_auth_power
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
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