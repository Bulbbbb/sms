package priv.sunyj.sms.bean;

public class UserCour {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_cour.user_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    private String userNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_cour.cour_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    private String courNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_cour.user_num
     *
     * @return the value of t_user_cour.user_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public String getUserNum() {
        return userNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_cour.user_num
     *
     * @param userNum the value for t_user_cour.user_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_cour.cour_num
     *
     * @return the value of t_user_cour.cour_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public String getCourNum() {
        return courNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_cour.cour_num
     *
     * @param courNum the value for t_user_cour.cour_num
     *
     * @mbg.generated Tue Apr 27 19:50:03 CST 2021
     */
    public void setCourNum(String courNum) {
        this.courNum = courNum == null ? null : courNum.trim();
    }
}