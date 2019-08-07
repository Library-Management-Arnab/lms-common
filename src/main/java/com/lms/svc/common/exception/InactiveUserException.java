package com.lms.svc.common.exception;

import org.springframework.http.HttpStatus;

import com.lms.svc.common.constants.ApplicationCommonConstants;

public class InactiveUserException  extends ApplicationError {
	private static final long serialVersionUID = 8870064712780345339L;

	private final String message;
	private final int errorCode;
	private final HttpStatus httpStatus;
	private final String errorTime;
	
	public InactiveUserException() {
		super(ApplicationCommonConstants.INSUFFICIENT_PRIVILAGE_ERROR_MESSAGE);
		this.message = super.getMessage();
		this.errorCode = ApplicationCommonConstants.INSUFFICIENT_PRIVILAGE_ERROR_CODE;
		this.httpStatus = HttpStatus.FORBIDDEN;
		this.errorTime = ApplicationCommonConstants.getCurrentDateAsString();
		
	}
	@Override
	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String getErrorTime() {
		return errorTime;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
