package com.lms.svc.common.model;

import com.lms.svc.common.constants.ApplicationCommonConstants;

import lombok.Data;

@Data
public class AuthenticatedUser {
	private String userName;
	private String userRight;
	private String userStatus;
	
	public boolean isAdmin() {
		return ApplicationCommonConstants.USER_RIGHT_A.equalsIgnoreCase(userRight);
	}
	public boolean isActive() {
		return ApplicationCommonConstants.USER_STATUS_CODE_ACTIVE.equalsIgnoreCase(userStatus);
	}
}
