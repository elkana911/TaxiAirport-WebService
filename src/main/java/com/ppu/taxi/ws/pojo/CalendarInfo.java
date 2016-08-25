package com.ppu.taxi.ws.pojo;


public class CalendarInfo {
	private String date;
	private String rate;
	private String holiday;
	private String promo;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	@Override
	public String toString() {
		return "CalendarInfo [date=" + date + ", rate=" + rate + ", holiday="
				+ holiday + ", promo=" + promo + "]";
	}
	
}
