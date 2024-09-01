package com.bytecode.jobportal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bytecode.jobportal.entity.Users;
import com.bytecode.jobportal.entity.UsersType;

public class CustomUserDetails implements UserDetails {

	private final Users user;
	
	
	
	public CustomUserDetails(Users user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		UsersType usersType=user.getUserTypeId();
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(usersType.getUserTypeName()));
		
		return authorities;
	}

	
	public String getPassword() {
		
		return user.getPassword();
	}


	public String getUsername() {
		
		return user.getEmail();
	}
	
	public boolean isAccountNonExpired() {
		return true;
	}
	
	public boolean isAccountNonLocked() {
		return true;
	}
	
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	public boolean isEnabled() {
		return true;
	}

}
