package com.example.demo.dao;

import com.example.demo.model.entity.Tags;
import com.example.demo.model.entity.TagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagsMapper {
    int countByExample(TagsExample example);

    int deleteByExample(TagsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tags record);

    int insertSelective(Tags record);

    List<Tags> selectByExample(TagsExample example);

    Tags selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tags record, @Param("example") TagsExample example);

    int updateByExample(@Param("record") Tags record, @Param("example") TagsExample example);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}