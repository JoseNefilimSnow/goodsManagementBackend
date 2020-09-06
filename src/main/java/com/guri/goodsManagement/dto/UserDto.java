package com.guri.goodsManagement.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.guri.goodsManagement.entities.User;
import com.guri.goodsManagement.enums.EnumPermission;

import lombok.Data;

@SuppressWarnings("serial")// Don't want to fill unwanted data like a serial code
@Data
public class UserDto implements UserDetails {
	
	private Long id;

	private String username;

	private String password;
	
	private EnumPermission permission;

	private boolean enabled;

	public UserDto(User user) {
		id=user.getId();
		username=user.getUsername();
		password=user.getPassword();
		permission=user.getPermission();
		getAuthorities();
		enabled=user.getEnabled();
	}
	
	public UserDto() {}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
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
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(permission.toString()));
		return authorities;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", permission=" + permission
				+ ", enabled=" + enabled + ", getAuthorities()=" + getAuthorities() + "]";
	}
	
	
}