package com.my.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.hr.dao.map.LaborerMap;
import com.my.hr.domain.Laborer;

@Repository("com.my.hr.laborerDao")
public class LaborerDaoImpl implements LaborerDao{
	@Autowired private LaborerMap laborerMap;
	
	@Override
	public List<Laborer> selectLaborers(){
		return laborerMap.selectlaborers();
	}
	@Override
	public int insertLaborer(Laborer laborer) {
		return laborerMap.insertLaborer(laborer);
	}
	@Override
	public int updateLaborer(Laborer laborer) {
		return laborerMap.updateLaborer(laborer);
	}
	@Override
	public int deleteLaborer(int laborerId) {
		return laborerMap.deleteLaborer(laborerId);
	}
}
