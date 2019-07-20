package com.lms.svc.common.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.lms.svc.common.exception.InvalidCredentialsException;
import com.lms.svc.common.model.LoginResponse;
import com.lms.svc.common.model.UserData;

@Repository
public class UserServiceRepository {
	private static final String USER_SERVICE_BASE_URL = "http://localhost:8081/api/us";

	private RestTemplate restTemplate;

	public UserServiceRepository(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public LoginResponse authenticate(UserData userData) {
		ResponseEntity<LoginResponse> response = restTemplate.postForEntity(USER_SERVICE_BASE_URL + "/login", userData,
				LoginResponse.class);
		HttpStatus statusCode = response.getStatusCode();

		if (statusCode.isError()) {
			throw new InvalidCredentialsException();
		}
		LoginResponse body = response.getBody();
		
		return body;
	}
}
