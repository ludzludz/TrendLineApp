package com.cjp.service;

import java.util.List;

import com.cjp.model.Company;

public interface CompanyManager {
	public List<Company> getAllCompanies();
	
	public void setStock(String companyShortcut);
	
	public String getPrice();
}
