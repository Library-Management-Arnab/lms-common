package com.lms.svc.common.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface ApplicationCommonConstants {
	String DATE_FORMAT = "dd-MMM-yyyy '@' HH:mm:ss";
	SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);
	
	static String getCurrentDateAsString() {
		return DATE_FORMATTER.format(new Date());
	}
	
	String NOT_IMPLEMENTED_ERROR_MESSAGE = "This functionality has not been implemented yet.";
	int NOT_IMPLEMENTED_ERROR_CODE = 1000;
	
	int CRYPTOGRAPHY_EXCEPTION_ERROR_CODE = 1004;
	
	String INVALID_CREDENTIALS_ERROR_MESSAGE = "Invalid Credentials!!";
	int INVALID_CREDENTIALS_ERROR_CODE = 1006;
	
	String NO_SUCH_USER_ERROR_MESSAGE = "No such user was found based on the search criteria.";
	int NO_SUCH_USER_ERROR_CODE = 1008;
}
