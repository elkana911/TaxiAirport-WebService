package com.ppu.taxi.ws.pojo;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

public class Coordinate {
	private String latitude;
	private String longitude;
	
	@XmlElement(name = "lat", required = true)
	@JsonProperty("lat")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@XmlElement(name = "lng", required = true)
	@JsonProperty("lng")
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Coordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
