package com.example.demo.dao;

import com.example.demo.model.entity.Friends;
import com.example.demo.model.entity.FriendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendsMapper {
    int countByExample(FriendsExample example);

    int deleteByExample(FriendsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Friends record);

    int insertSelective(Friends record);

    List<Friends> selectByExample(FriendsExample example);

    Friends selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByExample(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
}