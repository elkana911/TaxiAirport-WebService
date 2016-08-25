package com.ppu.taxi.ws.util;

import java.math.BigDecimal;

public class SimpleMoney {
	private String currency;
	private BigDecimal nominal;
	
	
	public SimpleMoney(String currency, BigDecimal nominal) {
		super();
		this.currency = currency;
		this.nominal = nominal;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getNominal() {
		return nominal;
	}
	public void setNominal(BigDecimal nominal) {
		this.nominal = nominal;
	}
	@Override
	public String toString() {
		return "SimpleMoney [currency=" + currency + ", nominal=" + nominal
				+ "]";
	}
	
	
}
