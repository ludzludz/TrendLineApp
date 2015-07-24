package com.cjp.service;

import java.util.List;

import com.cjp.utility.Utility.CalendarEnum;
import com.cjp.utility.Utility.KeyValue;

public interface FinanceYahooService {

	public abstract CalendarEnum checkPeriodOfQuotes(String periodOfQuotes);

	public abstract List<KeyValue> quotesForLastMont();

}