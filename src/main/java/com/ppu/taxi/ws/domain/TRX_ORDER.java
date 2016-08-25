package com.ppu.taxi.ws.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ppu.taxi.ws.common.JsonDateSerializer;
import com.ppu.taxi.ws.common.JsonDateTimeSerializer;

@Table(name = "TRX_ORDER")
public class TRX_ORDER implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1436180182365252386L;

	private String order_id;
	private String cust_id;
	private String driver_id;
	private String pick_loc;
	private String drop_loc;
	private String urgency;
	private String status;
	private Double est_price_low;
	private Double est_price_high;
	private Double real_price;
	private Date order_date;
	private Date acquired_date;
	private Date cancel_date;
	private Date delivered_date;
	private String cancel_by;
	private Long distance;
	private Date pick_date;
	private String order_name;
	private String order_phone;
	private String pick_lat;
	private String pick_lon;
	private String drop_lat;
	private String drop_lon;
	private Date real_pick_date;
	private String payment_type;
	
	private String driver_name;
	private String vehicle_id;
	
	@Column(length = 50)
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Column(length = 20)
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	@Column(length = 20)
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

	@Column(length = 100)
	public String getPick_loc() {
		return pick_loc;
	}
	public void setPick_loc(String pick_loc) {
		this.pick_loc = pick_loc;
	}
	
	@Column(length = 100)
	public String getDrop_loc() {
		return drop_loc;
	}
	public void setDrop_loc(String drop_loc) {
		this.drop_loc = drop_loc;
	}
	
	@Column(length = 10)	
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	@Column(length = 1)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getEst_price_low() {
		return est_price_low;
	}
	public void setEst_price_low(Double est_price_low) {
		this.est_price_low = est_price_low;
	}
	public Double getEst_price_high() {
		return est_price_high;
	}
	public void setEst_price_high(Double est_price_high) {
		this.est_price_high = est_price_high;
	}
	public Double getReal_price() {
		return real_price;
	}
	public void setReal_price(Double real_price) {
		this.real_price = real_price;
	}
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAcquired_date() {
		return acquired_date;
	}
	public void setAcquired_date(Date acquired_date) {
		this.acquired_date = acquired_date;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}
	public Date getDelivered_date() {
		return delivered_date;
	}
	public void setDelivered_date(Date delivered_date) {
		this.delivered_date = delivered_date;
	}

	@Column(length = 20)
	public String getCancel_by() {
		return cancel_by;
	}
	public void setCancel_by(String cancel_by) {
		this.cancel_by = cancel_by;
	}
	public Long getDistance() {
		return distance;
	}
	public void setDistance(Long distance) {
		this.distance = distance;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
//	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getPick_date() {
		return pick_date;
	}
	public void setPick_date(Date pick_date) {
		this.pick_date = pick_date;
	}
	
	@Column(length = 100)
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	@Column(length = 50)
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	
	@Column(length = 20)
	public String getPick_lat() {
		return pick_lat;
	}
	public void setPick_lat(String pick_lat) {
		this.pick_lat = pick_lat;
	}
	
	@Column(length = 20)
	public String getPick_lon() {
		return pick_lon;
	}
	public void setPick_lon(String pick_lon) {
		this.pick_lon = pick_lon;
	}
	
	@Column(length = 20)
	public String getDrop_lat() {
		return drop_lat;
	}
	public void setDrop_lat(String drop_lat) {
		this.drop_lat = drop_lat;
	}
	@Column(length = 20)
	public String getDrop_lon() {
		return drop_lon;
	}
	public void setDrop_lon(String drop_lon) {
		this.drop_lon = drop_lon;
	}

	@Column(length = 1)
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	
	public Date getReal_pick_date() {
		return real_pick_date;
	}
	public void setReal_pick_date(Date real_pick_date) {
		this.real_pick_date = real_pick_date;
	}
	@Transient
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	
	@Transient
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
	@Override
	public String toString() {
		return "TRX_ORDER [order_id=" + order_id + ", cust_id=" + cust_id + ", driver_id=" + driver_id + ", pick_loc="
				+ pick_loc + ", drop_loc=" + drop_loc + ", urgency=" + urgency + ", status=" + status
				+ ", est_price_low=" + est_price_low + ", est_price_high=" + est_price_high + ", real_price="
				+ real_price + ", order_date=" + order_date + ", acquired_date=" + acquired_date + ", cancel_date="
				+ cancel_date + ", delivered_date=" + delivered_date + ", cancel_by=" + cancel_by + ", distance="
				+ distance + ", pick_date=" + pick_date + ", order_name=" + order_name + ", order_phone=" + order_phone
				+ ", pick_lat=" + pick_lat + ", pick_lon=" + pick_lon + ", drop_lat=" + drop_lat + ", drop_lon="
				+ drop_lon + ", real_pick_date=" + real_pick_date + ", payment_type=" + payment_type + ", driver_name="
				+ driver_name + ", vehicle_id=" + vehicle_id + "]";
	}
	
	
}
