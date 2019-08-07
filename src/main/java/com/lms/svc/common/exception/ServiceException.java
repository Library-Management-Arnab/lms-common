package com.lms.svc.common.exception;

import com.lms.svc.common.model.ErrorObject;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -8066458944260533648L;

	private final ErrorObject errorObject;

	public ServiceException(ErrorObject errorObject) {
		super(errorObject.getMessage());
		this.errorObject = errorObject;
	}

	public ErrorObject getErrorObject() {
		return errorObject;
	}
}
