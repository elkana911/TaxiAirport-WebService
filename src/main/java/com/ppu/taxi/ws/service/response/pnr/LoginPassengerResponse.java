package com.ppu.taxi.ws.service.response.pnr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ppu.taxi.ws.domain.pnr.MstUserPassenger;
import com.ppu.taxi.ws.service.response.ErrorResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "login")
@XmlType(name = "", propOrder = {"ip", "error", "data"})
public class LoginPassengerResponse {

	@XmlElement(name = "data", required = true)
	private MstUserPassenger data;

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

	public MstUserPassenger getData() {
		return data;
	}

	public void setData(MstUserPassenger data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "LoginPassengerResponse [data=" + data + ", error=" + error + ", ip=" + ip + "]";
	}
	
}
