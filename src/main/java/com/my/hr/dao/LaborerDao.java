package com.my.hr.dao;

import java.util.List;

import com.my.hr.domain.Laborer;



public interface LaborerDao {
	List<Laborer> selectLaborers();
	int insertLaborer(Laborer laborer);
	int updateLaborer(Laborer laborer);
	int deleteLaborer(int laborerId);
	
}
