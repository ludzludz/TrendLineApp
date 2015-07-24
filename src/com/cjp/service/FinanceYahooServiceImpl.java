package com.cjp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import com.cjp.utility.Utility.CalendarEnum;
import com.cjp.utility.Utility.KeyValue;

public final class FinanceYahooServiceImpl implements FinanceYahooService {

	public String name;
	public String price;
	public String quote;
	public String peg;
	public String currency;
	public String symbol;
	private List<HistoricalQuote> historicalQuote;

	public FinanceYahooServiceImpl(String ticker, String periodOfQuotes)
			throws IOException {
		Stock stock = YahooFinance.get(ticker, true);
		CalendarEnum calendarEnum = checkPeriodOfQuotes(periodOfQuotes);

		historicalQuote = stock.getHistory(calendarEnum.getCalendar(),
				Interval.DAILY);
		name = stock.getName().toString();
		symbol = stock.getSymbol();
		price = stock.getQuote().getPrice().toString();
		quote = stock.getQuote().getOpen().toString();
		peg = stock.getStats().getPeg().toString();
		currency = stock.getCurrency().toString();
	}

	@Override
	public CalendarEnum checkPeriodOfQuotes(String periodOfQuotes) {
		CalendarEnum calendarEnum = CalendarEnum.WEEK;
		switch (periodOfQuotes) {
		case "twoDays":
			calendarEnum = CalendarEnum.TWODAYS;
			break;
		case "week":
			calendarEnum = CalendarEnum.WEEK;
			break;
		case "month":
			calendarEnum = CalendarEnum.MONTH;
			break;
		}
		return calendarEnum;
	}

	@Override
	public List<KeyValue> quotesForLastMont() {
		List<KeyValue> list = createListOfQuotes(historicalQuote);
		return list;
	}

	private List<KeyValue> createListOfQuotes(List<HistoricalQuote> quotesList) {
		List<KeyValue> list = new ArrayList<>();
		for (HistoricalQuote quote : quotesList) {
			long mili = quote.getDate().getTimeInMillis();
			list.add(new KeyValue(mili, quote.getOpen().floatValue()));
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

	public String getSymbol() {
		return symbol;
	}

}
