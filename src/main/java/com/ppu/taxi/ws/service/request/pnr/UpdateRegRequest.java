package com.ppu.taxi.ws.service.request.pnr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ppu.taxi.ws.service.request.BasicRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UpdateReg")
public class UpdateRegRequest extends BasicRequest{
	
	private String p_cust_id;
	private String p_reg_id;
	public String getP_cust_id() {
		return p_cust_id;
	}
	public void setP_cust_id(String p_cust_id) {
		this.p_cust_id = p_cust_id;
	}
	public String getP_reg_id() {
		return p_reg_id;
	}
	public void setP_reg_id(String p_reg_id) {
		this.p_reg_id = p_reg_id;
	}

	
}
