package com.usecase.DEMOLogoff;

public class LogoffResponse {
	private String loginStatus;

	public LogoffResponse(String loginStatus) {
		super();
		this.loginStatus = loginStatus;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
}
