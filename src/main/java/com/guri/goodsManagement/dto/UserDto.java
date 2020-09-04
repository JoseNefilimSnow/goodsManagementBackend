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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EnumPermission getPermission() {
		return permission;
	}

	public void setPermission(EnumPermission permission) {
		this.permission = permission;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<GrantedAuthority> getPermissions() {
		return permissions;
	}

	public void setPermissions(EnumPermission enumPermission) {
		this.permissions.add(new SimpleGrantedAuthority(permission.toString()));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissions;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

}