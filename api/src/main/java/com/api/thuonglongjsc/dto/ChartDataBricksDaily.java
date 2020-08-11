package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class ChartDataBricksDaily {
	private String name;
	private Double value;
	private String type;
	private String unit;

	public ChartDataBricksDaily() {
		super();
	}

	public ChartDataBricksDaily(String name, Double value, String type, String unit) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "ChartDataBricksDaily [name=" + name + ", value=" + value + ", type=" + type + ", unit=" + unit + "]";
	}

}
