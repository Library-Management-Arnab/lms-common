package com.lms.svc.common.exception;

import org.springframework.http.HttpStatus;

public abstract class ApplicationError extends RuntimeException {
	private static final long serialVersionUID = 2340263939737135927L;
	
	public abstract String getMessage();
	public abstract int getErrorCode();
	public abstract String getErrorTime();
	public abstract HttpStatus getHttpStatus();
}
