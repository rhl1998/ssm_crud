package com.oracle.bean;

import java.io.Serializable;

public class SubMonster extends Monster implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private School school;

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	

}
