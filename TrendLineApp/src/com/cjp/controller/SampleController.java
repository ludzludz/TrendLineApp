package com.cjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public final class SampleController {

	@Autowired
	private CompanyData companyData;
	
	String k; 

	@RequestMapping("calc")
	ModelMap say() {

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("companyList", companyData.getCompanies().keySet());

		return modelMap;
	}
	
	@RequestMapping("aa")
	ModelMap say(@RequestParam("say") String say) {

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("companyList", companyData.getCompanies().keySet());
		modelMap.addAttribute("aaa", say);
		return modelMap;
	}
	
}
