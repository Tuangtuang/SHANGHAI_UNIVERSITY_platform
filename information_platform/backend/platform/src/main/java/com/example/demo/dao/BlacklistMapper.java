package com.example.demo.dao;

import com.example.demo.model.entity.Blacklist;
import com.example.demo.model.entity.BlacklistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlacklistMapper {
    int countByExample(BlacklistExample example);

    int deleteByExample(BlacklistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    List<Blacklist> selectByExample(BlacklistExample example);

    Blacklist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
}