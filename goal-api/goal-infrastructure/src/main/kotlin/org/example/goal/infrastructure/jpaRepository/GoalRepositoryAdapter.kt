package org.example.goal.infrastructure.jpaRepository

import org.example.goal.domain.Goal
import org.example.goal.domain.GoalRepository
import org.springframework.stereotype.Component
import vo.User

@Component
class GoalRepositoryAdapter(
    private val jpaGoalRepository: JpaGoalRepository
) : GoalRepository {
    override fun save(goal: Goal): Goal {
        return jpaGoalRepository.save(goal)
    }

    override fun deleteByUser(user: User) {
        return jpaGoalRepository.deleteByUser(user)
    }
}