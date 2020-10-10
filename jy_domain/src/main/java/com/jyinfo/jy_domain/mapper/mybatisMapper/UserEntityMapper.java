package com.jyinfo.jy_domain.mapper.mybatisMapper;

import java.io.Serializable;
import java.util.List;

import com.jyinfo.jy_domain.Entity.mybatisEntity.UserEntity;
import com.jyinfo.jy_domain.Entity.mybatisEntity.UserEntityExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserEntityMapper extends Serializable {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    int countByExample(UserEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    int deleteByExample(UserEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    @Delete({
        "delete from f_user",
        "where F_User_ID = #{fUserId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer fUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    @Insert({
        "insert into f_user (F_User_Name, F_Profile, ",
        "F_User_Password, F_Salt, ",
        "F_Create_Time, F_Mobile, ",
        "F_Email, F_Update_Time)",
        "values (#{fUserName,jdbcType=VARCHAR}, #{fProfile,jdbcType=VARCHAR}, ",
        "#{fUserPassword,jdbcType=VARCHAR}, #{fSalt,jdbcType=VARCHAR}, ",
        "#{fCreateTime,jdbcType=TIMESTAMP}, #{fMobile,jdbcType=VARCHAR}, ",
        "#{fEmail,jdbcType=VARCHAR}, #{fUpdateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="fUserId", before=false, resultType=Integer.class)
    int insert(UserEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    int insertSelective(UserEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    List<UserEntity> selectByExample(UserEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    @Select({
        "select",
        "F_User_ID, F_User_Name, F_Profile, F_User_Password, F_Salt, F_Create_Time, F_Mobile, ",
        "F_Email, F_Update_Time",
        "from f_user",
        "where F_User_ID = #{fUserId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    UserEntity selectByPrimaryKey(Integer fUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    int updateByPrimaryKeySelective(UserEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_user
     *
     * @mbggenerated Mon Sep 14 21:59:23 CST 2020
     */
    @Update({
        "update f_user",
        "set F_User_Name = #{fUserName,jdbcType=VARCHAR},",
          "F_Profile = #{fProfile,jdbcType=VARCHAR},",
          "F_User_Password = #{fUserPassword,jdbcType=VARCHAR},",
          "F_Salt = #{fSalt,jdbcType=VARCHAR},",
          "F_Create_Time = #{fCreateTime,jdbcType=TIMESTAMP},",
          "F_Mobile = #{fMobile,jdbcType=VARCHAR},",
          "F_Email = #{fEmail,jdbcType=VARCHAR},",
          "F_Update_Time = #{fUpdateTime,jdbcType=TIMESTAMP}",
        "where F_User_ID = #{fUserId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserEntity record);
}