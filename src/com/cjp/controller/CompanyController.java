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

@Controller
public class CompanyController {

	@Autowired
	CompanyManager manager;

	FinanceYahooService finance;

	@RequestMapping(value = "/")
	public String displayInformationCompany(Model model) throws IOException {
		
		finance = new FinanceYahooService("LXFT");
		model.addAttribute("companies", manager.getAllCompanies());
		model.addAttribute("finance", finance);
		List<KeyValue> dataList = finance.dateAndQuoteForWeek();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

	@RequestMapping(value = "{ticker}")
	public String display(@PathVariable("ticker") String ticker, Model model) throws IOException {

		finance = new FinanceYahooService(ticker);
		model.addAttribute("companies", manager.getAllCompanies());
		model.addAttribute("finance", finance);
		List<KeyValue> dataList = finance.dateAndQuoteForTwoDays();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

}
