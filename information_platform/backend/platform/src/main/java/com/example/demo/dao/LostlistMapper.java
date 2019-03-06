package com.example.demo.dao;

import com.example.demo.model.entity.Lostlist;
import com.example.demo.model.entity.LostlistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LostlistMapper {
    int countByExample(LostlistExample example);

    int deleteByExample(LostlistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lostlist record);

    int insertSelective(Lostlist record);

    List<Lostlist> selectByExampleWithBLOBs(LostlistExample example);

    List<Lostlist> selectByExample(LostlistExample example);

    Lostlist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lostlist record, @Param("example") LostlistExample example);

    int updateByExampleWithBLOBs(@Param("record") Lostlist record, @Param("example") LostlistExample example);

    int updateByExample(@Param("record") Lostlist record, @Param("example") LostlistExample example);

    int updateByPrimaryKeySelective(Lostlist record);

    int updateByPrimaryKeyWithBLOBs(Lostlist record);

    int updateByPrimaryKey(Lostlist record);
}