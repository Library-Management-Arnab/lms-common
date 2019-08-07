package com.lms.svc.common.util;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.lms.svc.common.model.LMSResponseModel;
import com.lms.svc.common.model.RequestMetaData;

public class LMSResponseUtil {
    private LMSResponseUtil() {}

    @SuppressWarnings("rawtypes")
	public static ResponseEntity<Object> returnResponse(Object body, HttpStatus status) {
        LMSResponseModel<Object> response = new LMSResponseModel<>();
        response.setBody(body);
        RequestMetaData metaData = new RequestMetaData();
        metaData.setRequestedBy("APPLICATION");
        metaData.setRequestTimestamp(new Date());
        response.setMetaData(metaData);
        response.setFinalStatus(status.isError() ? "FAILURE" : "Success");
        if(body instanceof List) {
            response.setRecordReturned(((List)body).size());
        } else {
            response.setRecordReturned(status.isError() ? 0 : 1);
        }
        return new ResponseEntity<>(response, defaultHeaders(), status);
    }
    
    private static HttpHeaders defaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        headers.add(HttpHeaders.CACHE_CONTROL, "No-Cache");
        return headers;
    }
}
