package priv.sunyj.sms.bean;

public class InsMaj {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ins_maj.ins_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    private String insNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ins_maj.maj_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    private String majNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ins_maj.ins_num
     *
     * @return the value of t_ins_maj.ins_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public String getInsNum() {
        return insNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ins_maj.ins_num
     *
     * @param insNum the value for t_ins_maj.ins_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public void setInsNum(String insNum) {
        this.insNum = insNum == null ? null : insNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ins_maj.maj_num
     *
     * @return the value of t_ins_maj.maj_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public String getMajNum() {
        return majNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ins_maj.maj_num
     *
     * @param majNum the value for t_ins_maj.maj_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public void setMajNum(String majNum) {
        this.majNum = majNum == null ? null : majNum.trim();
    }
}