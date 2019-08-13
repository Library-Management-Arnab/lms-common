package com.lms.svc.common.constants;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface ApplicationCommonConstants {
    String DATE_FORMAT = "dd-MMM-yyyy '@' HH:mm:ss";
    SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    Random RANDOM = new Random();

    static String getCurrentDateAsString() {
        return DATE_FORMATTER.format(new Date());
    }

    static long generateId() {
        return (System.currentTimeMillis() + RANDOM.nextInt());
    }

    String NOT_IMPLEMENTED_ERROR_MESSAGE = "This functionality has not been implemented yet.";
    int NOT_IMPLEMENTED_ERROR_CODE = 1000;
    int ENDPOINT_NOT_AVAILABLE_ERROR_CODE = 1001;
    int CRYPTOGRAPHY_EXCEPTION_ERROR_CODE = 1004;

    String INVALID_CREDENTIALS_ERROR_MESSAGE = "Invalid Credentials!!";
    int INVALID_CREDENTIALS_ERROR_CODE = 1005;

    int INVALID_FIELD_VALUE_ERROR_CODE = 1006;

    String NO_SUCH_USER_ERROR_MESSAGE = "No such user was found based on the search criteria.";
    int NO_SUCH_USER_ERROR_CODE = 1007;
    
    String DUPLICATE_USER_ERROR_MESSAGE = "The user id %s is already taken. Please choose a different one.";
    int DUPLICATE_USER_ERROR_CODE = 1008;

    // 1009-1014
    String NO_SUCH_BOOK_ERROR_MESSAGE = "No such book was found based on the search criteria.";
    int NO_SUCH_BOOK_ERROR_CODE = 1009;
    int INVALID_BOOK_STATUS_ERROR_CODE = 1010;
    int DUPLICATE_BOOK_ERROR_CODE = 1011;
    int BOOK_SERVICE_EXCEPTION_FOR_CLIENT = 1012;
    //1015 - 1020
    String INSUFFICIENT_PRIVILAGE_ERROR_MESSAGE = "You do not have appropriate right to perform this operation.";
    int INSUFFICIENT_PRIVILAGE_ERROR_CODE = 1015;

    //1021-1025
    String INACTIVE_USER_ERROR_MESSAGE = "Either this user is inactive or has been deleted.";
    int INACTIVE_USER_ERROR_CODE = 1021;
    
    int USER_SERVICE_EXCEPTION_FOR_CLIENT = 1022;

    String USER_STATUS_CODE_ACTIVE = "A";
    String USER_STATUS_ACTIVE = "Active";

    String USER_STATUS_CODE_DELETED = "D";
    String USER_STATUS_DELETED = "Deleted";

    String USER_STATUS_CODE_INACTIVE = "T";
    String USER_STATUS_CODE_TEMP_INACTIVE = "I";
    String USER_STATUS_CODE_SUSPENDED = "S";

    String USER_RIGHT_U = "U";
    String USER_RIGHT_A = "A";

    String USER_ROLE_ADMIN = "FULL_ADMIN";
    String USER_ROLE_BASIC = "LIB_READ_ONLY";

    String BOOK_STATUS_CODE_AVAILABLE = "A";
    String BOOK_STATUS_CODE_DELETED = "D";
    String BOOK_STATUS_CODE_TEMP_UNAVAILABLE = "T";
    
    String BOOK_STATUS_AVAILABLE = "Available";
    String BOOK_STATUS_DELETED = "Deleted";
    String BOOK_STATUS_TEMP_UNABAILABLE = "Temporarily Unavailable";
    
    String USER_SERVICE_APP_ID = "user-service";
    String BOOK_SERVICE_APP_ID = "book-service";
    
    String BOOK_SERVICE_BASE_URI = "api/bs/books";
    String USER_SERVICE_BASE_URI = "api/us/users";
    String USER_SERVICE_URI_LOGIN = "login";

    int DEFAULT_ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
    int DEFAULT_REFRESH_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
    String SCOPE_READ_ONLY = "READ_ONLY";

    static <E, R> Collection<R> toCollection(Collection<E> items, Function<? super E, R> function) {
        return items.stream().map(function).collect(Collectors.toList());
    }
}
