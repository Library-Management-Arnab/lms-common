package com.lms.svc.common.model;

import java.util.List;

import com.lms.svc.common.constants.ApplicationCommonConstants;

import lombok.Data;

@Data
public class AuthenticatedUser {
	private String userName;
	private String fullName;
	private List<String> userRights;
	private String userStatus;
	
	public boolean isActive() {
		return ApplicationCommonConstants.USER_STATUS_CODE_ACTIVE.equalsIgnoreCase(userStatus);
	}
}
