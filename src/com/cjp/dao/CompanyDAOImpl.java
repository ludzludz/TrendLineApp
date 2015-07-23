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

		Company company3 = new Company();
		company3.setShortcut("MSFT");
		company3.setName("Microsoft Corporation");
		companies.add(company3);

		Company company4 = new Company();
		company4.setShortcut("ORCL");
		company4.setName("Oracle Corporation");
		companies.add(company4);

		Company company5 = new Company();
		company5.setShortcut("IBM");
		company5.setName("International Business Machines Corporation");
		companies.add(company5);

		Company company6 = new Company();
		company6.setShortcut("AAPLEEEEE");
		company6.setName("Apple Inc. TO KUPA ");
		companies.add(company6);

		return companies;
	}

}
