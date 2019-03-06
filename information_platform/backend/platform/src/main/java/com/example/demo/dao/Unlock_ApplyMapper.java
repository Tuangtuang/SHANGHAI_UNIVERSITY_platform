package com.example.demo.dao;

import com.example.demo.model.entity.Unlock_Apply;
import com.example.demo.model.entity.Unlock_ApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Unlock_ApplyMapper {
    int countByExample(Unlock_ApplyExample example);

    int deleteByExample(Unlock_ApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Unlock_Apply record);

    int insertSelective(Unlock_Apply record);

    List<Unlock_Apply> selectByExample(Unlock_ApplyExample example);

    Unlock_Apply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Unlock_Apply record, @Param("example") Unlock_ApplyExample example);

    int updateByExample(@Param("record") Unlock_Apply record, @Param("example") Unlock_ApplyExample example);

    int updateByPrimaryKeySelective(Unlock_Apply record);

    int updateByPrimaryKey(Unlock_Apply record);
}