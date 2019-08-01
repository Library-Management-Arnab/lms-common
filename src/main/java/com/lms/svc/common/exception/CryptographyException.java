package com.lms.svc.common.exception;

import org.springframework.http.HttpStatus;

import com.lms.svc.common.constants.ApplicationCommonConstants;

public final class CryptographyException extends ApplicationError {

	private static final long serialVersionUID = 3219597143587913853L;
	private final String errorTime;
	private final HttpStatus httpStatus;
	private final String message;
	private final int errorCode;

	public CryptographyException(Exception e) {
		this.httpStatus = HttpStatus.FORBIDDEN;
		this.message = String.format("Error occurred with message [%s] and type [%s]", e.getMessage(), e.getClass().getSimpleName());
		this.errorCode = ApplicationCommonConstants.CRYPTOGRAPHY_EXCEPTION_ERROR_CODE;
		this.errorTime = ApplicationCommonConstants.getCurrentDateAsString();
	}

	@Override
	public int getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorTime() {
		return this.errorTime;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
