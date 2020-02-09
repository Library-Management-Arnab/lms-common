package com.lms.svc.common.exception;

import com.lms.svc.common.util.CommonUtil;
import org.springframework.http.HttpStatus;

import com.lms.svc.common.constants.ApplicationCommonConstants;

public class NotImplementedException extends ApplicationError {

	private static final long serialVersionUID = 5445277604967202095L;
	
	private final String message;
	private final int errorCode;
	private final HttpStatus httpStatus;

	public NotImplementedException() {
		super(ApplicationCommonConstants.NOT_IMPLEMENTED_ERROR_MESSAGE);
		this.message = super.getMessage();
		this.errorCode = ApplicationCommonConstants.NOT_IMPLEMENTED_ERROR_CODE;
		this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}

}
