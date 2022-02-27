package org.example.user.infrastructure.jpaRepository

import org.example.user.domain.model.UserQuery
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserQueryRepository:JpaRepository<UserQuery,Long>{
    fun findByName(name: String): UserQuery
}