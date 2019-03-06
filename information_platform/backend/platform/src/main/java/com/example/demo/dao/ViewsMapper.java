package com.example.demo.dao;

import com.example.demo.model.databaseResulttype.All;
import com.example.demo.model.databaseResulttype.Best;
import com.example.demo.model.databaseResulttype.NewPublish;
import com.example.demo.model.databaseResulttype.NewReply;
import com.example.demo.model.entity.Views;
import com.example.demo.model.entity.ViewsExample;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewsMapper {
    int countByExample(ViewsExample example);

    int deleteByExample(ViewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Views record);

    int insertSelective(Views record);

    List<Views> selectByExample(ViewsExample example);

    List<Views> getRecommend(Integer tags);

    List<NewReply> getNewReply(Integer tags);

    List<NewPublish> getNewPublish(Integer tags);

    List<Best> getBest(Integer tags);

    List<All> getAll(Integer tags);

    Integer getCommentNum(Integer id);

    Integer getLikeNum(Integer id);

    Views selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Views record, @Param("example") ViewsExample example);

    int updateByExample(@Param("record") Views record, @Param("example") ViewsExample example);

    int updateByPrimaryKeySelective(Views record);

    int updateByPrimaryKey(Views record);
}