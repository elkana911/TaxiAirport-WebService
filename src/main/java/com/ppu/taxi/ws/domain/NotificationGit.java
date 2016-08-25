package com.ppu.taxi.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATION_GIT")
public class NotificationGit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String order_id;
	private String cust_id;
	private String cust_reg_id;
	
	private String driver_id;
	private String vehicle_id;
	private String cust_name;
	private String driver_name;
	private String driver_reg_id;
	
	@Id
	@Column(length = 50)
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Column(length = 250)
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	@Column(length = 250)
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	
	@Column(length = 20)
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	@Column(length = 250)
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	@Column(length = 100)
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	
	@Column(length = 500)
	public String getCust_reg_id() {
		return cust_reg_id;
	}
	public void setCust_reg_id(String cust_reg_id) {
		this.cust_reg_id = cust_reg_id;
	}
	
	@Column(length = 500)
	public String getDriver_reg_id() {
		return driver_reg_id;
	}
	public void setDriver_reg_id(String driver_reg_id) {
		this.driver_reg_id = driver_reg_id;
	}
	
	@Override
	public String toString() {
		return "NotificationGit [order_id=" + order_id + ", cust_id=" + cust_id + ", cust_reg_id=" + cust_reg_id
				+ ", driver_id=" + driver_id + ", vehicle_id=" + vehicle_id + ", cust_name=" + cust_name
				+ ", driver_name=" + driver_name + ", driver_reg_id=" + driver_reg_id + "]";
	}
	
}
