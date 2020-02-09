package com.lms.svc.common.model;

import java.util.Date;

import lombok.Data;

@Data
public class RequestMetaData {
	private String requestedBy;
	private Date RequestTimestamp;
	private String userRight;
}
