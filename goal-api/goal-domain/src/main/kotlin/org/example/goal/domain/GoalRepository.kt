package org.example.goal.domain

import vo.User

interface GoalRepository {
    fun save(goal: Goal):Goal
    fun deleteByUser(user: User)
}
