package priv.sunyj.sms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.sunyj.sms.bean.MajCour;
import priv.sunyj.sms.bean.MajCourExample;

public interface MajCourMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    long countByExample(MajCourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int deleteByExample(MajCourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int insert(MajCour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int insertSelective(MajCour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    List<MajCour> selectByExample(MajCourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int updateByExampleSelective(@Param("record") MajCour record, @Param("example") MajCourExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_maj_cour
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int updateByExample(@Param("record") MajCour record, @Param("example") MajCourExample example);
}