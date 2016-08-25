package com.ppu.taxi.ws.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "parkingLot")
public class ParkingLotRequest extends BasicRequest{

	private String parking_id;
	private String latitude;
	private String longitude;
	
	public String getParking_id() {
		return parking_id;
	}

	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}

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
		return "ParkingLotRequest [parking_id=" + parking_id + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
	
	
}
