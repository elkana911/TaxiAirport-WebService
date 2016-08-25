package com.ppu.taxi.ws.service.request.driver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.service.request.BasicRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RegistrationToken")
public class RegistrationTokenRequest extends BasicRequest{
	
	private String device_id;
	private String android_id;
	private String reg_token;
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getAndroid_id() {
		return android_id;
	}
	public void setAndroid_id(String android_id) {
		this.android_id = android_id;
	}
	public String getReg_token() {
		return reg_token;
	}
	public void setReg_token(String reg_token) {
		this.reg_token = reg_token;
	}

	
}
