package com.ppu.taxi.ws.service.request.driver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.ppu.taxi.ws.service.request.BasicRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Login")
public class LoginDriverRequest extends BasicRequest{
	private String device_id;	// aka imei
	private String android_id;
	
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
	@Override
	public String toString() {
		return "LoginDriverRequest [device_id=" + device_id + ", android_id=" + android_id + "]";
	}

}
