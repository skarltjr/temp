package org.example.user.infrastructure.jpaRepository

import org.example.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserRepository : JpaRepository<User, Long> {
    fun findByName(userName: String): User?

}