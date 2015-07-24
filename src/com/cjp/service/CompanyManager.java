package com.cjp.service;

import java.util.List;

import com.cjp.model.Company;

public interface CompanyManager {
	public List<Company> getAllCompanies();
	public List<Company> getSelectedCompanies (String selectedCompanyName);
}
