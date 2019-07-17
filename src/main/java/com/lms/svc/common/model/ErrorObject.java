package com.lms.svc.common.model;

import java.io.Serializable;

public class ErrorObject implements Serializable {

	private static final long serialVersionUID = 6596361310526524560L;

	private String message;
	private int errorCode;
	private String errorTime;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(String errorTime) {
		this.errorTime = errorTime;
	}

}
