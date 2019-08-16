package com.javaworm.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.javaworm.model.User

@Repository
interface UserRepository : JpaRepository<User, Long> {
	fun findOneByUserName(userName: String): User?
}
