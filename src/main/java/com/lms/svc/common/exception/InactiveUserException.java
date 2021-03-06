package com.lms.svc.common.exception;

import com.lms.svc.common.constants.ApplicationCommonConstants;
import com.lms.svc.common.util.CommonUtil;
import org.springframework.http.HttpStatus;

public class InactiveUserException  extends ApplicationError {
	private static final long serialVersionUID = 8870064712780345339L;

	private final String message;
	private final int errorCode;
	private final HttpStatus httpStatus;

	public InactiveUserException() {
		super(ApplicationCommonConstants.INSUFFICIENT_PRIVILAGE_ERROR_MESSAGE);
		this.message = super.getMessage();
		this.errorCode = ApplicationCommonConstants.INSUFFICIENT_PRIVILAGE_ERROR_CODE;
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
