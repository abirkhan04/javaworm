package com.javaworm.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.javaworm.model.Role

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
	fun findByRolename(rolename: String): Role
}
