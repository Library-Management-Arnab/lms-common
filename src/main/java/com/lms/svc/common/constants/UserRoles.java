package com.lms.svc.common.constants;

public enum UserRoles {
	BASIC_USER("U", "Basic User", "Basic Users have access to their own profile. They can update their own info only."),
	SYSTEM_ADMINISTRATOR("A", "System Administrator", "System Administrators have full access to the system. They can view of modify any resource.");

	private String accessType;
	private String description;
	private String dbCode;

	private UserRoles(String dbCode, String accessType, String description) {
		this.dbCode = dbCode;
		this.accessType = accessType;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getAccessType() {
		return accessType;
	}
	
	public String getAccessCode() {
		return dbCode;
	}
	
	public static UserRoles getByDBCode(String dbCode) {
		for(UserRoles u : UserRoles.values()) {
			if(dbCode.equals(u.dbCode)) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("{")
				.append("\"")
				.append("accessType")
				.append("\"")
				.append(":")
				.append("\"")
				.append(accessType)
				.append("\"")
				.append(",")
				.append("\"")
				.append("description")
				.append("\"")
				.append(":")
				.append("\"")
				.append(description)
				.append("\"")
				.append("}")
				.toString();
	}
}
