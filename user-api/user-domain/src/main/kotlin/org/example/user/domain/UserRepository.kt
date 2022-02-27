package org.example.user.domain

import org.example.user.domain.model.User


interface UserRepository{

    fun save(user: User): User
    fun findByName(userName: String): User?
    fun delete(user: User)
}