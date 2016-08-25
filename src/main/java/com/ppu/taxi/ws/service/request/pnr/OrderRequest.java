package com.ppu.taxi.ws.service.request.pnr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.service.request.BasicRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OrderRequest")
public class OrderRequest extends BasicRequest {
	private String cust_id;
	private String driver_id;
	private String pick_loc;
	private String drop_loc;
	private String urgency;
	private String status;
	private String est_price_low;
	private String est_price_high;
	private String real_price;
	private String order_date;
	private String acquired_date;
	private String cancel_date;
	private String delivered_date;
	private String cancel_by;
	private String distance;
	private String pick_date;
	private String order_name;
	private String order_phone;
	private String pick_lat;
	private String pick_lon;
	private String drop_lat;
	private String drop_lon;
	private String payment_type;
	
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	public String getPick_loc() {
		return pick_loc;
	}
	public void setPick_loc(String pick_loc) {
		this.pick_loc = pick_loc;
	}
	public String getDrop_loc() {
		return drop_loc;
	}
	public void setDrop_loc(String drop_loc) {
		this.drop_loc = drop_loc;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEst_price_low() {
		return est_price_low;
	}
	public void setEst_price_low(String est_price_low) {
		this.est_price_low = est_price_low;
	}
	public String getEst_price_high() {
		return est_price_high;
	}
	public void setEst_price_high(String est_price_high) {
		this.est_price_high = est_price_high;
	}
	public String getReal_price() {
		return real_price;
	}
	public void setReal_price(String real_price) {
		this.real_price = real_price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getAcquired_date() {
		return acquired_date;
	}
	public void setAcquired_date(String acquired_date) {
		this.acquired_date = acquired_date;
	}
	public String getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(String cancel_date) {
		this.cancel_date = cancel_date;
	}
	public String getDelivered_date() {
		return delivered_date;
	}
	public void setDelivered_date(String delivered_date) {
		this.delivered_date = delivered_date;
	}
	public String getCancel_by() {
		return cancel_by;
	}
	public void setCancel_by(String cancel_by) {
		this.cancel_by = cancel_by;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getPick_date() {
		return pick_date;
	}
	public void setPick_date(String pick_date) {
		this.pick_date = pick_date;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getPick_lat() {
		return pick_lat;
	}
	public void setPick_lat(String pick_lat) {
		this.pick_lat = pick_lat;
	}
	public String getPick_lon() {
		return pick_lon;
	}
	public void setPick_lon(String pick_lon) {
		this.pick_lon = pick_lon;
	}
	public String getDrop_lat() {
		return drop_lat;
	}
	public void setDrop_lat(String drop_lat) {
		this.drop_lat = drop_lat;
	}
	public String getDrop_lon() {
		return drop_lon;
	}
	public void setDrop_lon(String drop_lon) {
		this.drop_lon = drop_lon;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	
}
