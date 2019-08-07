package com.lms.svc.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LMSResponseModel implements Serializable {
    private Object body;
    private ErrorObject error;
    private String finalStatus;
    private int recordReturned;

}
