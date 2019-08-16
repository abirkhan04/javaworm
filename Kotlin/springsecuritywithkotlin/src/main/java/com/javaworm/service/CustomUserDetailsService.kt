package com.javaworm.service

import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UserDetailsService
import com.javaworm.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import com.javaworm.service.CustomUserDetails
import javax.transaction.Transactional


@Service
@Transactional
open class CustomUserDetailsService (private val userRepository: UserRepository) : UserDetailsService {

	override fun loadUserByUsername(username: String): UserDetails {
		return CustomUserDetails(userRepository.findOneByUserName(username)!!)
	}

}