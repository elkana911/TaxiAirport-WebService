package com.ppu.taxi.ws.service.response.driver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ppu.taxi.ws.domain.driver.MstUserDriver;
import com.ppu.taxi.ws.service.response.ErrorResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "login")
@XmlType(name = "", propOrder = {"ip", "error", "data"})
public class LoginDriverResponse {

	@XmlElement(name = "data", required = true)
	private MstUserDriver data;

	@XmlElement(name = "error")
	private ErrorResponse error;

	@XmlElement(name = "ip")
	private String ip;

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public MstUserDriver getData() {
		return data;
	}

	public void setData(MstUserDriver data) {
		this.data = data;
	}
	
}
