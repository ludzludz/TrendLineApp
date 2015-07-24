package com.cjp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjp.service.CompanyManager;
import com.cjp.service.FinanceYahooService;
import com.cjp.service.FinanceYahooServiceImpl;
import com.cjp.utility.Utility.KeyValue;

@Controller
public class CompanyController {

	@Autowired
	CompanyManager manager;

	FinanceYahooService finance;

	@RequestMapping(value = "{ticker}")
	public String displayAllCompanyInformations(
			@PathVariable("ticker") String ticker,
			@RequestParam(value = "periodOfQuotes", required = false) String periodOfQuotes,
			Model model) throws IOException {
		if(periodOfQuotes!=null){
			finance = new FinanceYahooServiceImpl(ticker, periodOfQuotes);
		} else {
			finance = new FinanceYahooServiceImpl(ticker, "week");
		}
		model.addAttribute("companies", manager.getAllCompanies());
		model.addAttribute("finance", finance);
		List<KeyValue> dataList = finance.quotesForLastMont();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

	@RequestMapping(value = "/")
	public String displaySelectedCompany(
			@RequestParam(value = "search", required = false) String search,
			Model model) throws IOException {
		if (search == null) {
			model.addAttribute("companies", manager.getAllCompanies());
		} else if (!manager.getSelectedCompanies(search).isEmpty()) {
			model.addAttribute("companies",
					manager.getSelectedCompanies(search));
		} else {

		}
		return "basicData";
	}

}
