package com.example.demo.dao;

import com.example.demo.model.entity.Notices;
import com.example.demo.model.entity.NoticesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticesMapper {
    int countByExample(NoticesExample example);

    int deleteByExample(NoticesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notices record);

    int insertSelective(Notices record);

    int insertSelectiveAndGetId(Notices record);

    List<Notices> selectByExample(NoticesExample example);

    Notices selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notices record, @Param("example") NoticesExample example);

    int updateByExample(@Param("record") Notices record, @Param("example") NoticesExample example);

    int updateByPrimaryKeySelective(Notices record);

    int updateByPrimaryKey(Notices record);
}