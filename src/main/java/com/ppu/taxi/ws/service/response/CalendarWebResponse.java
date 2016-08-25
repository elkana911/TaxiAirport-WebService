package com.ppu.taxi.ws.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ppu.taxi.ws.pojo.CalendarInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "calendar")
@XmlType(name = "", propOrder = {"ip", "error", "data"})
public class CalendarWebResponse {

	@XmlElement(name = "data", required = true)
	private List<CalendarInfo> data;

	@XmlElement(name = "error", required = true)
	private ErrorResponse error;

	@XmlElement(name = "ip", required = true)
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

	public List<CalendarInfo> getData() {
		return data;
	}

	public void setData(List<CalendarInfo> data) {
		this.data = data;
	}

}
