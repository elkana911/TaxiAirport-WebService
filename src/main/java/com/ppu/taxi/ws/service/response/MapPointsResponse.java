package com.ppu.taxi.ws.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.pojo.ParkingMap;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mapPoints")
public class MapPointsResponse {
	
	@XmlElement(name = "data", required = true)
	private List<ParkingMap> data;
	
	@XmlElement(name = "error", required = true)
	private ErrorResponse error;

	@XmlElement(name = "ip", required = true)
	private String ip;

	public List<ParkingMap> getData() {
		return data;
	}

	public void setData(List<ParkingMap> data) {
		this.data = data;
	}

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
	
	
}
