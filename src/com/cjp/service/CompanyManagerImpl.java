package com.cjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjp.dao.ChartDAO;
import com.cjp.dao.CompanyDAO;
import com.cjp.dao.ChartData.KeyValue;
import com.cjp.model.Company;

@Service
public class CompanyManagerImpl implements CompanyManager {

	@Autowired
	CompanyDAO dao;

	@Autowired
	ChartDAO chartDao;

	@Override
	public List<Company> getAllCompanies() {
		return dao.getAllCompanies();
	}

	public void setPieChartDao(ChartDAO chartDao) {
		this.chartDao = chartDao;
	}

	@Override
	public List<KeyValue> getChartData() {
		return chartDao.getChartData();
	}
}
