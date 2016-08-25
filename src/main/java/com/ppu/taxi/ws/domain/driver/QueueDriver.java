package com.ppu.taxi.ws.domain.driver;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ppu.taxi.ws.common.JsonDateTimeSerializer;

@Table(name = "D_QUEUE")
public class QueueDriver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String driver_id;
	private String location;
	private Date check_in_time;
	private Long queue_no;
	
	@Column(length = 20)
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

	@Column(length = 50)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCheck_in_time() {
		return check_in_time;
	}
	public void setCheck_in_time(Date check_in_time) {
		this.check_in_time = check_in_time;
	}
	public Long getQueue_no() {
		return queue_no;
	}
	public void setQueue_no(Long queue_no) {
		this.queue_no = queue_no;
	}
	@Override
	public String toString() {
		return "QueueDriver [driver_id=" + driver_id + ", location=" + location + ", check_in_time=" + check_in_time
				+ ", queue_no=" + queue_no + "]";
	}

	
}
