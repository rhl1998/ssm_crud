package com.oracle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.bean.Monster;
import com.oracle.bean.SubMonster;

public interface MonsterService {

	List<SubMonster> list();

	int addMonster(SubMonster monster);

	void deleteMonster(Integer monsterId);

	SubMonster QueryOneMonster(Integer monsterId);

	void updateMonster(SubMonster monster);

}
