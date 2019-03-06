package com.example.demo.dao;

import com.example.demo.model.entity.Alarm;
import com.example.demo.model.entity.AlarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmMapper {
    int countByExample(AlarmExample example);

    int deleteByExample(AlarmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    List<Alarm> selectByExample(AlarmExample example);

    Alarm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Alarm record, @Param("example") AlarmExample example);

    int updateByExample(@Param("record") Alarm record, @Param("example") AlarmExample example);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);
}