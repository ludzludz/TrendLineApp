package com.cjp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjp.dao.ChartDAO;
import com.cjp.dao.ChartData.KeyValue;
import com.cjp.dao.CompanyDAO;
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

	@Override
	public List<KeyValue> getChartData() {
		return chartDao.getChartData();
	}

	@Override
	public List<Company> getSelectedCompanies(String selectedCompanyName) {
		List<Company> selectedCompany = new ArrayList<>();
		for(Company company : dao.getAllCompanies()){
			if(company.getName().toLowerCase().contains(selectedCompanyName.toLowerCase()))
				selectedCompany.add(company);
		}
		return selectedCompany;
	}
}
