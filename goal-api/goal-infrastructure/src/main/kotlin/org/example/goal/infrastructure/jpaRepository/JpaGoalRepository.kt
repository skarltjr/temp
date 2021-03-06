package org.example.goal.infrastructure.jpaRepository

import org.example.goal.domain.Goal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vo.User

@Repository
interface JpaGoalRepository:JpaRepository<Goal,Long> {
    fun deleteByUser(user: User)
}