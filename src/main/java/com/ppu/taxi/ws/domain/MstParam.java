package com.ppu.taxi.ws.domain;

import java.io.Serializable;

import javax.persistence.Table;

@Table(name = "MstParam")
public class MstParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5553174504041456099L;

	private String par_id;
	private String par_desc;
	private String par_group;
	private String par_value;
	
	public String getPar_id() {
		return par_id;
	}
	public void setPar_id(String par_id) {
		this.par_id = par_id;
	}
	public String getPar_desc() {
		return par_desc;
	}
	public void setPar_desc(String par_desc) {
		this.par_desc = par_desc;
	}
	public String getPar_group() {
		return par_group;
	}
	public void setPar_group(String par_group) {
		this.par_group = par_group;
	}
	
	public String getPar_value() {
		return par_value;
	}
	public void setPar_value(String par_value) {
		this.par_value = par_value;
	}
	@Override
	public String toString() {
		return "MstParam [par_id=" + par_id + ", par_desc=" + par_desc + ", par_group=" + par_group + ", par_value="
				+ par_value + "]";
	}
	
}
