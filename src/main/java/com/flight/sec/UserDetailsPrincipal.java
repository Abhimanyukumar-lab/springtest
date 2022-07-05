package com.flight.sec;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.flight.entity.AuthGroup;
import com.flight.entity.User;

public class UserDetailsPrincipal implements UserDetails {

	private User user;

	private List<AuthGroup> authGroups;

	public UserDetailsPrincipal(User user, List<AuthGroup> authGroups) {
		super();
		this.user = user;
		this.authGroups = authGroups;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		if (null == authGroups) {
			return Collections.EMPTY_SET;
		}
		Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<SimpleGrantedAuthority>();

		authGroups.forEach(group -> grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup())));

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
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
		return true;
	}
}
