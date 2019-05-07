package com.oracle.mapper;

import com.oracle.bean.Monster;
import com.oracle.bean.SubMonster;

import java.util.List;

public interface MonsterMapper {
	
    int deleteByPrimaryKey(Integer monsterId);

    int insert(SubMonster record);

    SubMonster selectByPrimaryKey(Integer monsterId);

    List<SubMonster> selectAll();

    int updateByPrimaryKey(SubMonster monster);
}