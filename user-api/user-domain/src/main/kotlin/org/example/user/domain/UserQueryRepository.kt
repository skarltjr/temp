package org.example.user.domain

import org.example.user.domain.model.UserQuery

interface UserQueryRepository {
    fun findByName(name:String):UserQuery
    fun save(userQuery: UserQuery):UserQuery
    fun findById(userId: Long): UserQuery
}