package com.lms.svc.common.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.lms.svc.common.model.AuthenticatedUser;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LmsAuthenticationProvider implements AuthenticationProvider {
	//private UserServiceRepositoryWillbedeleted userServiceRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		AuthenticatedUser authenticatedUser = null;//userServiceRepository.authenticate(userName, password);
		Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(authenticatedUser);
		
		User principal = new User(authenticatedUser.getUserName(), password, grantedAuthorities);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, password, grantedAuthorities);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(AuthenticatedUser user ) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRight()));
		
		return grantedAuthorities;
	}


}
