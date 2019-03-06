package com.example.demo.dao;

import com.example.demo.model.databaseResulttype.GetAllComment;
import com.example.demo.model.databaseResulttype.GetHotComment;
import com.example.demo.model.entity.Comments;
import com.example.demo.model.entity.CommentsExample;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo.model.entity.Likes;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    int countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    List<Comments> selectByExample(CommentsExample example);

    Comments selectByPrimaryKey(Integer id);

    List<GetHotComment> getHotComment(Integer postid);

    List<GetAllComment> getAllComment(Integer postid);

    Likes getLikeStatus(Comments comments);

    Integer getLikeNum(Integer commentid);

    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}