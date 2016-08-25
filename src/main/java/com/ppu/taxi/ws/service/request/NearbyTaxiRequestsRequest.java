package com.ppu.taxi.ws.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.pojo.Coordinate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nearbyTaxiequest")
public class NearbyTaxiRequestsRequest extends BasicRequest {

	private Coordinate coordinate;

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	
}
