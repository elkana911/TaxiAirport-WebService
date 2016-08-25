package com.ppu.taxi.ws.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.pojo.Coordinate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "notifyDriver")
public class NotifyDriverRequest extends BasicRequest {

	//registration id from gcm
	private String id;
	private String order_id;
	private String message;
	private Coordinate coordinate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
}
