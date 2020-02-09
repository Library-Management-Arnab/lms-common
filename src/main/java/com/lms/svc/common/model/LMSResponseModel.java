package com.lms.svc.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LMSResponseModel<T> implements Serializable {
	private static final long serialVersionUID = 3891019634004996128L;
	
	private T body;
	private RequestMetaData metaData;
	private String finalStatus;
	private int recordReturned;

}
