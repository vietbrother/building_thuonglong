package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class ChartDataBricksDaily {
	private String name;
	private Integer value;
	private String type;

	public ChartDataBricksDaily() {
		super();
	}

	public ChartDataBricksDaily(String name, Integer value, String type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ChartDataDailyBricks [name=" + name + ", value=" + value + ", type=" + type + "]";
	}

}
