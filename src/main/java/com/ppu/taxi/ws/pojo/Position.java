package com.ppu.taxi.ws.pojo;

import java.util.Date;

public class Position {

	private String parking_id;
	private String user_id;
	private String latitude;
	private String longitude;
	private String accuracy;
	private String duration;
	private String remarks;
	private String pos_id;
	private Date created_date;
	private String created_by;
	private Date updated_date;
	private String updated_by;
	private String parking_name;
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
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
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public String getParking_name() {
		return parking_name;
	}
	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}
	@Override
	public String toString() {
		return "Position [parking_id=" + parking_id + ", user_id=" + user_id + ", latitude=" + latitude + ", longitude="
				+ longitude + ", accuracy=" + accuracy + ", duration=" + duration + ", remarks=" + remarks + ", pos_id="
				+ pos_id + ", created_date=" + created_date + ", created_by=" + created_by + ", updated_date="
				+ updated_date + ", updated_by=" + updated_by + ", parking_name=" + parking_name + "]";
	}
	
	
    
}
