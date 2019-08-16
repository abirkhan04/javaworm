package com.javaworm.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder



@Configuration
open class PasswordEncoderAndMatcherConfiguration {

	@Bean
	open fun passwordEncoderAndMatcher(): PasswordEncoder {
		return object : PasswordEncoder {
			override fun encode(rawPassword: CharSequence?): String {
				return BCryptPasswordEncoder().encode(rawPassword)
			}
			override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
				return BCryptPasswordEncoder().matches(rawPassword, encodedPassword)
			}
		}
	}
}
