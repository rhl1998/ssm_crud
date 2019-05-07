package com.oracle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.bean.School;
import com.oracle.mapper.SchoolMapper;
import com.oracle.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolMapper schoolMapper;

	@Override
	@Transactional
	public List<School> list() {
		// TODO Auto-generated method stub
		return this.schoolMapper.selectAll();
	}
}
