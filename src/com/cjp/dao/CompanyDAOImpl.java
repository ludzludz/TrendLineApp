package com.cjp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cjp.model.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	@Override
	public List<Company> getAllCompanies() {
		List<Company> companies = new ArrayList<Company>();

		Company company1 = new Company();
		company1.setShortcut("AAPL");
		company1.setName("Apple Inc.");
		companies.add(company1);

		Company company2 = new Company();
		company2.setShortcut("GOOGL");
		company2.setName("Google Inc.");
		companies.add(company2);

		return companies;
	}	
	
}
