package com.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myblog.dao.Impl.SortDaoImpl;

public class SortService {
	@Autowired
	private SortDaoImpl sortDaoImpl;
	public void setSortDaoImpl(SortDaoImpl sortDaoImpl) {
		this.sortDaoImpl=sortDaoImpl;
	}
    public List<String> getLeftSort(String headSort){
    	return sortDaoImpl.getLeftSort(headSort);
    }
}
