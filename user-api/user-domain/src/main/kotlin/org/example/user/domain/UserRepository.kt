package org.example.user.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository{

    fun save(user:User):User
}