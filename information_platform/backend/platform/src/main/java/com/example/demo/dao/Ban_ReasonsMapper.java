package com.example.demo.dao;

import com.example.demo.model.entity.Ban_Reasons;
import com.example.demo.model.entity.Ban_ReasonsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Ban_ReasonsMapper {
    int countByExample(Ban_ReasonsExample example);

    int deleteByExample(Ban_ReasonsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ban_Reasons record);

    int insertSelective(Ban_Reasons record);

    List<Ban_Reasons> selectByExample(Ban_ReasonsExample example);

    Ban_Reasons selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ban_Reasons record, @Param("example") Ban_ReasonsExample example);

    int updateByExample(@Param("record") Ban_Reasons record, @Param("example") Ban_ReasonsExample example);

    int updateByPrimaryKeySelective(Ban_Reasons record);

    int updateByPrimaryKey(Ban_Reasons record);
}