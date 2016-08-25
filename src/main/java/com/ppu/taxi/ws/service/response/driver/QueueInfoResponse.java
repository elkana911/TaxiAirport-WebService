package com.ppu.taxi.ws.service.response.driver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ppu.taxi.ws.pojo.QueueInfo;
import com.ppu.taxi.ws.service.response.ErrorResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "QueueInfo")
@XmlType(name = "", propOrder = {"ip", "error", "data"})
public class QueueInfoResponse {

	@XmlElement(name = "data", required = true)
	private QueueInfo data;

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

	public QueueInfo getData() {
		return data;
	}

	public void setData(QueueInfo data) {
		this.data = data;
	}
	
}
