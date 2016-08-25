package com.ppu.taxi.ws.pojo;

public class ParkingMap {
	private String parking_id;
	private Long seq_no;
	private String latitude;
	private String longitude;
	private String parking_name;
	private String lat_marker;
	private String lng_marker;
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public Long getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(Long seq_no) {
		this.seq_no = seq_no;
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
	public String getParking_name() {
		return parking_name;
	}
	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}
	public String getLat_marker() {
		return lat_marker;
	}
	public void setLat_marker(String lat_marker) {
		this.lat_marker = lat_marker;
	}
	public String getLng_marker() {
		return lng_marker;
	}
	public void setLng_marker(String lng_marker) {
		this.lng_marker = lng_marker;
	}
	@Override
	public String toString() {
		return "ParkingMap [parking_id=" + parking_id + ", seq_no=" + seq_no + ", latitude=" + latitude + ", longitude="
				+ longitude + ", parking_name=" + parking_name + ", lat_marker=" + lat_marker + ", lng_marker="
				+ lng_marker + "]";
	}
	
}
