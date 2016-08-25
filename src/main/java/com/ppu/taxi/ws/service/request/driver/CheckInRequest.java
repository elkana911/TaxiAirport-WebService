package com.ppu.taxi.ws.service.request.driver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.pojo.Coordinate;
import com.ppu.taxi.ws.service.request.BasicRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CheckIn")
public class CheckInRequest extends BasicRequest{
	
	private String driver_id;
	private Coordinate coordinate;
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

}
