package com.lms.svc.common.advice;

import com.lms.svc.common.constants.ApplicationCommonConstants;
import com.lms.svc.common.exception.ApplicationError;
import com.lms.svc.common.exception.ServiceException;
import com.lms.svc.common.model.ErrorObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class LMSExceptionAdvice {
	private static final Logger LOG = LoggerFactory.getLogger(LMSExceptionAdvice.class);
	@ExceptionHandler(value = {
			ApplicationError.class
		})
	public ResponseEntity<Object> handleApplicationException(ApplicationError e) {
		LOG.error(String.format("ApplicationError occurred - %s", e.getLocalizedMessage()));
		ErrorObject eo = new ErrorObject();
		eo.setErrorCode(e.getErrorCode());
		String message = e.getMessage() == null ? String.format("Error occurred -[%s]", e.getClass().getSimpleName()) : e.getMessage();
		eo.setMessage(String.format("[%s] - %s",e.getClass().getSimpleName(), e.getMessage()));
		eo.setErrorTime(e.getErrorTime());
		eo.setHttpStatus(e.getHttpStatus());
		return createEntityWithStandardResponseHeaders(eo, e.getHttpStatus());
	}
	@ExceptionHandler(value = {
			ServiceException.class
	})
	public ResponseEntity<Object> handleServiceException(ServiceException e) {
		LOG.error(String.format("ServiceException occurred - %s", e.getLocalizedMessage()));
		return createEntityWithStandardResponseHeaders(e.getErrorObject(), e.getErrorObject().getHttpStatus());
	}
	@ExceptionHandler(value = {
			Exception.class
	})
	public ResponseEntity<Object> handleGenericException(Exception e) {
		LOG.error(String.format("Generic Exception occurred - %s", e.getLocalizedMessage()));
		ErrorObject eo = new ErrorObject();
		eo.setErrorCode(1010);
		eo.setMessage(String.format("Error occurred with message [%s] and type [%s]", e.getMessage(), e.getClass().getSimpleName()));
		eo.setErrorTime(ApplicationCommonConstants.getCurrentDateAsString());
		eo.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return createEntityWithStandardResponseHeaders(eo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	private ResponseEntity<Object> createEntityWithStandardResponseHeaders(Object body, HttpStatus httpStatus) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.put("Content-Type", Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
		return new ResponseEntity<>(body, headers, httpStatus);
	}
}
