package com.ppu.taxi.ws.domain.pnr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ppu.taxi.ws.domain.BaseTable;

@Entity
@Table(name = "P_MST_CUST")
public class MstUserPassenger extends BaseTable implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2747718512712032723L;
	private String cust_id;
	private String cust_name;
	private String cust_pwd;
	private String phone_no;
	private String device_id;
	private String gender;
	private Date birthDate;
	private String location;
	private String status;
	private String reg_id;
	private String facebook_id;
	private String google_id;
	
	public MstUserPassenger() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(length = 250)
	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	@Column(length = 250)
	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	@Column(length = 250)
	public String getCust_pwd() {
		return cust_pwd;
	}

	public void setCust_pwd(String cust_pwd) {
		this.cust_pwd = cust_pwd;
	}

	@Column(length = 20)
	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	@Column(length = 250)
	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	@Column(length = 20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(length = 250)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(length = 2)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(String facebook_id) {
		this.facebook_id = facebook_id;
	}

	public String getGoogle_id() {
		return google_id;
	}

	public void setGoogle_id(String google_id) {
		this.google_id = google_id;
	}

	@Override
	public String toString() {
		return "MstUserPassenger [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_pwd=" + cust_pwd
				+ ", phone_no=" + phone_no + ", device_id=" + device_id + ", gender=" + gender + ", birthDate="
				+ birthDate + ", location=" + location + ", status=" + status + ", reg_id=" + reg_id + ", facebook_id="
				+ facebook_id + ", google_id=" + google_id + "]";
	}

	
}
