package com.my.hr.dao.map;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerMap {
	List<Laborer> selectLaborers();
	int updateLaborer(Laborer laborer);
	int deleteLaborer(int laborerId);
	int insertLaborer(String laborerName, LocalDate hireDate);
}
