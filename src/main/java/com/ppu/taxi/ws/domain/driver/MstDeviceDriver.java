package com.ppu.taxi.ws.domain.driver;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ppu.taxi.ws.domain.BaseTable;
@Entity
@Table(name = "D_MST_DEVICE")
public class MstDeviceDriver extends BaseTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4874993805536734403L;
	
	private String id;
	private String phone;
	private String imei;
	private String email;
	
	@Id
	@Column(length = 256)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(length = 20)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 40)
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Column(length = 40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
