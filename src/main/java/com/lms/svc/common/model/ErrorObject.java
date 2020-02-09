package com.lms.svc.common.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorObject implements Serializable {

	private static final long serialVersionUID = 6596361310526524560L;

	public ErrorObject() {

	}

	public ErrorObject(String message, int errorCode, String errorTime, HttpStatus httpStatus) {
		this.message = message;
		this.errorCode = errorCode;
		this.errorTime = errorTime;
		this.httpStatus = httpStatus;
	}

	private String message;
	private int errorCode;
	private String errorTime;
	private HttpStatus httpStatus;

}
