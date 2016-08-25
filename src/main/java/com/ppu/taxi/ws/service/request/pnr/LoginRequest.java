package com.ppu.taxi.ws.service.request.pnr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.ppu.taxi.ws.service.request.BasicRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Login")
public class LoginRequest extends BasicRequest{
	
	private String id;
	private String email;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "pwd", required = true)
	@JsonProperty("pwd")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
