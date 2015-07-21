package com.cjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjp.dao.CompanyDAO;
import com.cjp.model.Company;
import com.cjp.model.CompanyStock;

@Service
public class CompanyManagerImpl implements CompanyManager {

	@Autowired
	CompanyDAO dao;

	CompanyStock stock;

	@Override
	public List<Company> getAllCompanies() {
		return dao.getAllCompanies();
	}
}
