package com.ppu.taxi.ws.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MapPoints")
public class MapPointsRequest extends BasicRequest {

	private String user_id;
	private String latitude;
	private String longitude;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "MapPointsRequest [user_id=" + user_id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
