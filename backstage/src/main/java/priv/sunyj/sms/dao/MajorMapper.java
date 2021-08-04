package priv.sunyj.sms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.sunyj.sms.bean.Major;
import priv.sunyj.sms.bean.MajorExample;

public interface MajorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    long countByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int deleteByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int deleteByPrimaryKey(String mNum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int insert(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int insertSelective(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    List<Major> selectByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    Major selectByPrimaryKey(String mNum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int updateByPrimaryKeySelective(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbg.generated Wed May 19 15:50:21 CST 2021
     */
    int updateByPrimaryKey(Major record);
}