package com.ppu.taxi.ws.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "updatePosition")
public class UpdatePositionRequest extends BasicRequest {
//	http://203.128.70.66:6060/taxi-ws/taxi/updatepos.json?p_parking_id=park123&userid=eric123&lat=123&lng=456&acc=123&dur=10&remarks=blabla&pos_id=park&avail=Y
		
	private String p_parking_id;
	private String user_id;
	private String latitude;
	private String longitude;
	private String accuracy;
	private String duration;
	private String remarks;
	private String pos_id;
	private String avail;
	public String getP_parking_id() {
		return p_parking_id;
	}
	public void setP_parking_id(String p_parking_id) {
		this.p_parking_id = p_parking_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@XmlElement(name = "lat")
	@JsonProperty("lat")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@XmlElement(name = "lng")
	@JsonProperty("lng")
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@XmlElement(name = "acc")
	@JsonProperty("acc")
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	
	@XmlElement(name = "dur")
	@JsonProperty("dur")
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPos_id() {
		return pos_id;
	}
	public void setPos_id(String pos_id) {
		this.pos_id = pos_id;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	@Override
	public String toString() {
		return "UpdatePositionRequest [p_parking_id=" + p_parking_id + ", user_id=" + user_id + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", accuracy=" + accuracy + ", duration=" + duration + ", remarks="
				+ remarks + ", pos_id=" + pos_id + ", avail=" + avail + "]";
	}
	
	
}
