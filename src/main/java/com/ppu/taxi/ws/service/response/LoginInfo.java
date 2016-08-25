package com.ppu.taxi.ws.service.response;

import java.io.Serializable;
import java.util.Date;

public class LoginInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 120818208077259396L;
	private String id;
	private String username;
	private String token;
	private Date lastLogin;
	private boolean isSubAgency;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public boolean isSubAgency() {
		return isSubAgency;
	}
	public void setSubAgency(boolean isSubAgency) {
		this.isSubAgency = isSubAgency;
	}
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", username=" + username + ", token="
				+ token + ", lastLogin=" + lastLogin + ", isSubAgency="
				+ isSubAgency + "]";
	}
	
	
	
}
