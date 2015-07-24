package com.cjp.utility;

import java.util.Calendar;

public class Utility {
	public static class KeyValue {
		long year;
		int month;
		int day;
		float value;

		public KeyValue(long mili, float value) {
			this.year = mili;
			this.value = value;
		}

		public long getYear() {
			return year;
		}

		public void setYear(long year) {
			this.year = year;
		}

		public float getValue() {
			return value;
		}

		public void setValue(float value) {
			this.value = value;
		}

	}

	public static enum CalendarEnum {

		TWODAYS(Calendar.DATE, -2), WEEK(Calendar.DATE, -7), MONTH(
				Calendar.MONTH, -1);

		Calendar calendar;

		private CalendarEnum(int date, int numberOfDays) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(date, numberOfDays);
			this.calendar = calendar;
		}

		public Calendar getCalendar() {
			return calendar;
		}
	}
}