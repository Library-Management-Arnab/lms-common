package com.lms.svc.common.exception;

import com.lms.svc.common.constants.ApplicationCommonConstants;
import com.lms.svc.common.model.ErrorObject;
import com.lms.svc.common.util.CommonUtil;
import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -8066458944260533648L;

	private final ErrorObject errorObject;
	
	public ServiceException(String message) {
		this(new ErrorObject(message, ApplicationCommonConstants.ENDPOINT_NOT_AVAILABLE_ERROR_CODE, 
				CommonUtil.getCurrentDateAsString(), HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	public ServiceException(ErrorObject errorObject) {
		super(errorObject.getMessage());
		this.errorObject = errorObject;
	}

	public ErrorObject getErrorObject() {
		return errorObject;
	}
}
