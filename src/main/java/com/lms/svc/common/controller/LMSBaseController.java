package com.lms.svc.common.controller;

import com.lms.svc.common.model.LMSResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class LMSBaseController {
    protected final ResponseEntity<Object> prepareResponse(Object body) {
        LMSResponseModel response = new LMSResponseModel();
        response.setBody(body);
        response.setFinalStatus("SUCCESS");
        response.setRecordReturned(body instanceof List ? ((List)body).size() : 1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
