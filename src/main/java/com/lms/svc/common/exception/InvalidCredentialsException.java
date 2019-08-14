package com.lms.svc.common.exception;

import com.lms.svc.common.util.CommonUtil;
import org.springframework.http.HttpStatus;

import com.lms.svc.common.constants.ApplicationCommonConstants;

public class InvalidCredentialsException extends ApplicationError {
	private static final long serialVersionUID = -7712267841607454496L;

	private final String message;
	private final int errorCode;
	private final HttpStatus httpStatus;

	public InvalidCredentialsException() {
		super(ApplicationCommonConstants.INVALID_CREDENTIALS_ERROR_MESSAGE);
		this.message = super.getMessage();
		this.errorCode = ApplicationCommonConstants.INVALID_CREDENTIALS_ERROR_CODE;
		this.httpStatus = HttpStatus.FORBIDDEN;
	}

	@Override
	public int getErrorCode() {
		return errorCode;
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
