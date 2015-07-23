package com.cjp.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cjp.dao.ChartData.KeyValue;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

public final class FinanceYahooService {

	public String name;
	public String price;
	public String quote;
	public String peg;
	public String currency;
	public List<HistoricalQuote> quotesFromTwoDays;
	public List<HistoricalQuote> quotesFromLastWeek;

	public FinanceYahooService(String ticker) throws IOException {
		Stock stock = YahooFinance.get(ticker, true);
		quotesFromTwoDays = stock.getHistory(getTwoDays(), Interval.DAILY);
		quotesFromLastWeek = stock.getHistory(getLastWeek(), Interval.DAILY);
		name = stock.getName().toString();
		price = stock.getQuote().getPrice().toString();
		quote = stock.getQuote().getOpen().toString();
		peg = stock.getStats().getPeg().toString();
		currency = stock.getCurrency().toString();
	}

	public Calendar getLastWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -7);
		return calendar;
	}

	public Calendar getTwoDays() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -2);
		return calendar;
	}

	public Calendar getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		return calendar;
	}

	public List<KeyValue> dateAndQuoteForTwoDays() {
		List<KeyValue> list = new ArrayList<>();
		for (HistoricalQuote o : quotesFromTwoDays) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
			sdf.setTimeZone(o.getDate().getTimeZone());
			list.add(new KeyValue(sdf.format(o.getDate().getTime()), o.getClose().toString()));
		}
		return list;
	}

	public List<KeyValue> dateAndQuoteForWeek() {
		List<KeyValue> list = new ArrayList<>();
		for (HistoricalQuote o : quotesFromLastWeek) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
			sdf.setTimeZone(o.getDate().getTimeZone());
			list.add(new KeyValue(sdf.format(o.getDate().getTime()), o.getClose().toString()));
		}
		return list;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getQuote() {
		return quote;
	}

	public String getCurrency() {
		return currency;
	}

	public String getPeg() {
		return peg;
	}

}
