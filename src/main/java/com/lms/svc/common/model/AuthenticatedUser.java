package com.lms.svc.common.model;

import lombok.Data;

import java.util.Set;

@Data
public class AuthenticatedUser {
	private String userName;
	private String fullName;
	private Set<String> userRoles;
	private Set<String> scopes;
	private String userStatus;
	
}
