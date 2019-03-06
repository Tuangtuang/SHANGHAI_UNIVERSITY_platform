package com.example.demo.dao;

import com.example.demo.model.entity.Managers;
import com.example.demo.model.entity.ManagersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagersMapper {
    int countByExample(ManagersExample example);

    int deleteByExample(ManagersExample example);

    int insert(Managers record);

    int insertSelective(Managers record);

    List<Managers> selectByExample(ManagersExample example);

    int updateByExampleSelective(@Param("record") Managers record, @Param("example") ManagersExample example);

    int updateByExample(@Param("record") Managers record, @Param("example") ManagersExample example);
}