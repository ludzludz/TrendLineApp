package com.cjp.dao;

import java.util.List;

import com.cjp.dao.ChartData.KeyValue;

public interface ChartDAO {
	List<KeyValue> getChartData();
}
