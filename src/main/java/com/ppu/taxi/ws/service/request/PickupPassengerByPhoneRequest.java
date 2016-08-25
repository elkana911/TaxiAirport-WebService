package com.ppu.taxi.ws.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PickupPassengerByPhone")
public class PickupPassengerByPhoneRequest extends BasicRequest{
	
	private String driverPhone;
	private String passengerPhone;
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public String getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}
	@Override
	public String toString() {
		return "PickupPassengerByPhoneRequest [driverPhone=" + driverPhone + ", passengerPhone=" + passengerPhone + "]";
	}

}
