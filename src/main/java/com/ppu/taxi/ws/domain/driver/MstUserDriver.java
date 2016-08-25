package com.ppu.taxi.ws.domain.driver;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ppu.taxi.ws.domain.BaseTable;

@Entity
@Table(name = "D_MST_USER")
public class MstUserDriver extends BaseTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3211759849718413763L;
	private String driver_id;
	private String password;
	private String company_id;
	private String full_name;
	private String email;
	private String phone;
	private String status;
	private String vehicle_id;
	private String billing_id;
	private String device_id;
	private String reg_id;
	private String android_id;
	
	@Id
	@Column(length = 20)
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	@Column(length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length = 20)
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	@Column(length = 100)
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	@Column(length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 20)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(length = 1)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Column(length = 20)
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	@Column(length = 20)
	public String getBilling_id() {
		return billing_id;
	}
	public void setBilling_id(String billing_id) {
		this.billing_id = billing_id;
	}

	@Column(length = 50)
	public String getAndroid_id() {
		return android_id;
	}
	public void setAndroid_id(String android_id) {
		this.android_id = android_id;
	}
	@Column(length = 500)
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	@Column(length = 50)
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	@Override
	public String toString() {
		return "MstUserDriver [driver_id=" + driver_id + ", password=" + password + ", company_id=" + company_id
				+ ", full_name=" + full_name + ", email=" + email + ", phone=" + phone + ", status=" + status
				+ ", vehicle_id=" + vehicle_id + ", billing_id=" + billing_id + ", device_id=" + device_id + ", reg_id="
				+ reg_id + ", android_id=" + android_id + "]";
	}
	
}
