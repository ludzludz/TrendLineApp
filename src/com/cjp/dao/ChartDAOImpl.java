package com.cjp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cjp.dao.ChartData.KeyValue;

@Repository
public class ChartDAOImpl implements ChartDAO {

	@Override
	public List<KeyValue> getChartData() {
		return ChartData.getDataList();
	}

}
