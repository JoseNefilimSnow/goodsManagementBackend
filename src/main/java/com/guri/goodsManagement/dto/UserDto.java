package com.guri.goodsManagement.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.guri.goodsManagement.enums.EnumPermission;

import lombok.Data;

@Data
public class UserDto implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String username;

	private String password;
	
	
	private EnumPermission permission;

	private boolean enabled;
	

	private List<GrantedAuthority> permissions = new ArrayList<GrantedAuthority>();

//	public UserDto(User user) {
//		this.username = user.getUsername();
//		this.password = user.getPassword();
//		this.permission=user.getPermission();
//		this.enabled=user.getIsEnabled();
//		this.permissions.add(new SimpleGrantedAuthority(permission.toString()));
//		
//	}

	public UserDto() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissions;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setPermissions(EnumPermission permission) {
		this.permissions.add(new SimpleGrantedAuthority(permission.toString()));
		
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}



}