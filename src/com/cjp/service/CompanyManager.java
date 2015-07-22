package com.cjp.service;

import java.util.List;

import com.cjp.dao.ChartData.KeyValue;
import com.cjp.model.Company;

public interface CompanyManager {
	public List<Company> getAllCompanies();

	List<KeyValue> getChartData();
}
