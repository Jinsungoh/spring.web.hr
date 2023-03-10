package com.my.hr.dao.map;

import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerMap {
	List<Laborer> selectlaborers();
	int insertLaborer(Laborer laborer);
	int updateLaborer(Laborer laborer);
	int deleteLaborer(int laborerId);
}
