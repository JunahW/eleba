package com.eleba.dao;

import com.eleba.pojo.Town;
import com.eleba.pojo.TownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TownMapper {
    int countByExample(TownExample example);

    int deleteByExample(TownExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Town record);

    int insertSelective(Town record);

    List<Town> selectByExample(TownExample example);

    Town selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Town record, @Param("example") TownExample example);

    int updateByExample(@Param("record") Town record, @Param("example") TownExample example);

    int updateByPrimaryKeySelective(Town record);

    int updateByPrimaryKey(Town record);
}