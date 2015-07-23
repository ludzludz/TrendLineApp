package com.cjp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjp.dao.ChartData.KeyValue;
import com.cjp.service.CompanyManager;
import com.cjp.service.FinanceYahooService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {

	@Autowired
	CompanyManager manager;

	FinanceYahooService finance;

	@RequestMapping(value = "{ticker}")
	public String display(@PathVariable("ticker") String ticker, Model model) throws IOException {
		finance = new FinanceYahooService("LXFT");
		model.addAttribute("companies", manager.getAllCompanies());
		model.addAttribute("finance", finance);
		List<KeyValue> dataList = finance.dateAndQuoteForTwoDays();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

	@RequestMapping(value = "/")
	public String displaySelectedCompany(@RequestParam(value = "search", required = false) String search,  Model model) throws IOException {
		if(search==null) {
			finance = new FinanceYahooService("LXFT");
			model.addAttribute("companies", manager.getAllCompanies());
		} else if(!manager.getSelectedCompanies(search).isEmpty()){
			finance = new FinanceYahooService("LXFT");
			model.addAttribute("companies", manager.getSelectedCompanies(search));
		} else {
			//throw new IncorrectCompanyNameException();
		}

		model.addAttribute("finance", finance);
		List<KeyValue> dataList = finance.dateAndQuoteForTwoDays();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

}
