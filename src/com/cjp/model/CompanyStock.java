package com.cjp.model;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class CompanyStock {

	Stock stock = null;

	public void setCompany(String companyShortcut) {
		try {
			stock = YahooFinance.get(companyShortcut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BigDecimal getPrice() {
		return stock.getQuote().getPrice();
	}

	public BigDecimal getChange() {
		return stock.getQuote().getChangeInPercent();
	}

	public BigDecimal getPeg() {
		return stock.getStats().getPeg();
	}

	public BigDecimal getDividend() {
		return stock.getDividend().getAnnualYieldPercent();
	}

}
