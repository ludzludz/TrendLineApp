package com.cjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@Autowired
	private CompanyData companyData;

	@RequestMapping("calc")
	ModelMap say() {

		ModelMap modelMap = new ModelMap();

//		Stock stock = null;
//		try {
//			stock = YahooFinance.get("GOOGL");
//			String name = stock.getName();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		modelMap.addAttribute("googlePrice", stock.getQuote().getPrice());
		modelMap.addAttribute("companyList", companyData.getCompanies().keySet());
		return modelMap;
	}
}
