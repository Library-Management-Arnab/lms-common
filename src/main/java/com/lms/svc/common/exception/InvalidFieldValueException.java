package com.lms.svc.common.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lms.svc.common.constants.ApplicationCommonConstants;

public class InvalidFieldValueException extends ApplicationError {
	private static final long serialVersionUID = -7712267841607454496L;

	private final String message;
	private final int errorCode;
	private final HttpStatus httpStatus;
	private final String errorTime;

	public InvalidFieldValueException(String fieldName, String providedValue, List<String> values) {
		super(String.format("Invalid %s [%s]. Valid values are [%s]", fieldName, providedValue, String.join(", ", values)));
		this.message = super.getMessage();
		this.errorCode = ApplicationCommonConstants.INVALID_FIELD_VALUE_ERROR_CODE;
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.errorTime = ApplicationCommonConstants.getCurrentDateAsString();
	}

	public InvalidFieldValueException(String fieldName) {
		super(String.format("No %s was provided.", fieldName));
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.message = super.getMessage();
		this.errorCode = ApplicationCommonConstants.INVALID_FIELD_VALUE_ERROR_CODE;
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
