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
	
	String NO_SUCH_BOOK_ERROR_MESSAGE = "No such book was found based on the search criteria.";
	int NO_SUCH_BOOK_ERROR_CODE = 1009;
	
	String INSUFFICIENT_PRIVILAGE_ERROR_MESSAGE = "You do not have appropriate right to perform this operation.";
	int INSUFFICIENT_PRIVILAGE_ERROR_CODE = 1010;
	
	String INACTIVE_USER_ERROR_MESSAGE = "Either this user is inactive or has been deleted.";
	int INACTIVE_USER_ERROR_CODE = 1012;
	
	String STATUS_CODE_ACTIVE = "A";
	String STATUS_CODE_DELETED = "D";
	String STATUS_CODE_INACTIVE = "T";
	String STATUS_CODE_TEMP_INACTIVE = "I";
	String STATUS_CODE_SUSPENDED = "S";
	
	String USER_RIGHT_U = "U";
	String USER_RIGHT_A = "A";
}
