package org.example.goal.domain

interface GoalRepository {
    fun save(goal: Goal):Goal
}
