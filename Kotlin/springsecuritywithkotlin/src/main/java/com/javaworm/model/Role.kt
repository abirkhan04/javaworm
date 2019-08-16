package com.javaworm.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue

@Entity
data class Role(var rolename: String = "") {
	@Id
	@GeneratedValue
	val id: Long? = null
}
