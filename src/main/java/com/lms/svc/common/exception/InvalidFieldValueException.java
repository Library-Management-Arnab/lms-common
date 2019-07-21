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
		String validValues = String.join(", ", values);
		this.message = "Invalid " + fieldName + " [" + providedValue + "]. Valid statuses are [" + validValues + "].";
		this.errorCode = ApplicationCommonConstants.INVALID_FIELD_VALUE_ERROR_CODE;
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.errorTime = ApplicationCommonConstants.getCurrentDateAsString();
	}

	public InvalidFieldValueException(String fieldName) {
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.message = "No " + fieldName + " was provided.";
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
