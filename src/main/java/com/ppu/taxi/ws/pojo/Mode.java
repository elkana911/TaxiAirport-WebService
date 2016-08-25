package com.ppu.taxi.ws.pojo;

public enum Mode {
	GET_ROUTES("getroutes"),
	GET_SCHEDULE("getschedule"),
	BOOKING("booking"),
	ISSUED("issued"),
	
	FARMING_SEAT("farmseat"),
	FARMING_PRICE("farmprice"),
	MUTASI("mutasi"),
	UNKNOWN("");

	private String processName;
	
	private Mode(String processName) {
		this.processName = processName;
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public static Mode get(String processName) {
		for (Mode m : Mode.values()) {
			if (processName.equals(m.getProcessName()))
				return m;
		}
		
		return UNKNOWN;
	}

	public static String printAvailModes() {
		StringBuffer sb = new StringBuffer();
		
		for (Mode m : Mode.values()) {
			sb.append(m.getProcessName()).append("\n");
		}
		
		return sb.toString();
	}
}
