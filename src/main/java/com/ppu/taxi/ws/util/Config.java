package com.ppu.taxi.ws.util;

public final class Config {
//	public static final String KEY_HOMEURL = "HOME_URL";
//	public static final String KEY_TIMEOUT_SECONDS = "TIMEOUT_SECONDS";
//	public static final String KEY_SHOW_IMAGE = "SHOW_IMAGE";
	
	private String homeUrl;
	private long timeOutSeconds;
	private boolean showImage;
	private long sleepWhenRetry;
	private int maxRetry;
	private boolean reuseInstance;
	private boolean bypassLogin;
	private String username;
	private String password;
	
	public Config() {
		super();
		
		reset();
	}

	public void reset() {
		timeOutSeconds = 55;
		showImage = true;
		sleepWhenRetry = 1000;
		maxRetry = 3;
		reuseInstance = false;
		bypassLogin = false;
		username = null;
		password = null;
	}
	
	public String getHomeUrl() {
		return homeUrl;
	}
	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}
	public long getTimeOutSeconds() {
		return timeOutSeconds;
	}
	public void setTimeOutSeconds(long timeOutSeconds) {
		this.timeOutSeconds = timeOutSeconds;
	}
	public boolean isShowImage() {
		return showImage;
	}
	public void setShowImage(boolean showImage) {
		this.showImage = showImage;
	}

	public long getSleepWhenRetry() {
		return sleepWhenRetry;
	}

	public void setSleepWhenRetry(long sleepWhenRetry) {
		this.sleepWhenRetry = sleepWhenRetry;
	}

	public int getMaxRetry() {
		return maxRetry;
	}

	public void setMaxRetry(int maxRetry) {
		this.maxRetry = maxRetry;
	}

	public boolean isReuseInstance() {
		return reuseInstance;
	}

	public void setReuseInstance(boolean reuseInstance) {
		this.reuseInstance = reuseInstance;
	}

	public boolean isBypassLogin() {
		return bypassLogin;
	}

	public void setBypassLogin(boolean bypassLogin) {
		this.bypassLogin = bypassLogin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Config [homeUrl=" + homeUrl + ", timeOutSeconds="
				+ timeOutSeconds + ", showImage=" + showImage
				+ ", sleepWhenRetry=" + sleepWhenRetry + ", maxRetry="
				+ maxRetry + ", reuseInstance=" + reuseInstance
				+ ", bypassLogin=" + bypassLogin + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
