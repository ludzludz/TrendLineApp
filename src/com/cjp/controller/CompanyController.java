package com.cjp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjp.dao.ChartData.KeyValue;
import com.cjp.service.CompanyManager;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Controller
public class CompanyController {

	@Autowired
	CompanyManager manager;

	@RequestMapping(value = "basicData", method = RequestMethod.GET)
	public String getAllCompanies(Model model) {
		model.addAttribute("companies", manager.getAllCompanies());
		return "basicData";
	}

	@RequestMapping(value = "/")
	public String getCalc(Model model) {
		return "getValue";
	}

	@RequestMapping(value = "displayName")
	public String displayInformationCompany(@RequestParam("companyShortcut") String companyShortcut, Model model) {
		Stock stock = null;
		try {
			stock = YahooFinance.get(companyShortcut);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("companies", manager.getAllCompanies());
		model.addAttribute("name", stock.getName());
		model.addAttribute("price", stock.getQuote().getPrice().toString());
		model.addAttribute("change", stock.getQuote().getChangeInPercent().toString());
		model.addAttribute("peg", stock.getStats().getPeg().toString());
		model.addAttribute("dividend", stock.getDividend().getAnnualYieldPercent().toString());
		List<KeyValue> dataList = manager.getChartData();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

	@RequestMapping(value = "{ticker}")
	public String display(@PathVariable("ticker") String ticker, Model model) {
		Stock stock = null;
		try {
			stock = YahooFinance.get(ticker);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("companies", manager.getAllCompanies());
		model.addAttribute("name", stock.getName());
		model.addAttribute("price", stock.getQuote().getPrice().toString());
		model.addAttribute("change", stock.getQuote().getChangeInPercent().toString());
		model.addAttribute("peg", stock.getStats().getPeg().toString());
		model.addAttribute("dividend", stock.getDividend().getAnnualYieldPercent().toString());
		List<KeyValue> dataList = manager.getChartData();
		model.addAttribute("dataList", dataList);
		return "basicData";
	}

}
