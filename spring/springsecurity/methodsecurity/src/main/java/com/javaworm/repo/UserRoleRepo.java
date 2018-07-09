package com.javaworm.repo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.javaworm.exception.UserNotFoundException;
import com.javaworm.model.SiteUser;

@Component
public class UserRoleRepo {
	static Map<String, SiteUser> USER_MAP = new LinkedHashMap<String, SiteUser>();

	static {
		USER_MAP.put("Abir Khan", new SiteUser("abirkhan", "1234",
				collectGrantedAuthorities("ROLE_USER", "ROLE_VIEWER")));
		USER_MAP.put("Nazrul Islam", new SiteUser("nazrul", "1342",
				collectGrantedAuthorities("ROLE_USER", "ROLE_VIEWER")));
	}

	private static List<GrantedAuthority> collectGrantedAuthorities(
			String... grantedRoles) {
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : grantedRoles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public SiteUser loadUserWithUserName(String username) {
		if (USER_MAP.containsKey(username)) {
			return USER_MAP.get(username);
		} else {
			throw new UserNotFoundException("User Cannot be found");
		}
	}

	public boolean isValidUsername(String username) {
		return USER_MAP.containsKey(username);
	}

	public boolean isValidRole(String roleName) {
		return roleName.startsWith("ROLE_");
	}

}