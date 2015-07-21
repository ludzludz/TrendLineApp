package com.cjp.dao;

import java.util.ArrayList;
import java.util.List;

public class ChartData {
	private static final List<KeyValue> chartData;

	static {
		chartData = new ArrayList<ChartData.KeyValue>();
		chartData.add(new KeyValue("15.07", "11.10"));
		chartData.add(new KeyValue("16.07", "11.15"));
		chartData.add(new KeyValue("17.07", "11.20"));
		chartData.add(new KeyValue("18.07", "11.00"));
		chartData.add(new KeyValue("19.07", "10.50"));
		chartData.add(new KeyValue("20.07", "11.00"));
		chartData.add(new KeyValue("21.07", "12.34"));
	}

	public static List<KeyValue> getDataList() {
		return chartData;
	}

	public static class KeyValue {
		String key;
		String value;

		public KeyValue(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}
}
