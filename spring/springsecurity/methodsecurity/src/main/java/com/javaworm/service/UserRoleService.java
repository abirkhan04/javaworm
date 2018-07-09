package com.javaworm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.javaworm.repo.UserRoleRepo;

@Service
public class UserRoleService {

	@Autowired
	UserRoleRepo userRoleRepo;


	@Secured("ROLE_VIEWER")
	public String getUsername() {
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    return securityContext.getAuthentication().getName();
	}


    @Secured({ "ROLE_VIEWER", "ROLE_USER" })
    public boolean isValidUsername(String username) {
        return userRoleRepo.isValidUsername(username);
    }

}