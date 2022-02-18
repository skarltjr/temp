package org.example.goal.application

import org.example.goal.application.request.CreateGoalRequest
import org.example.goal.domain.handler.GoalCommandHandler
import org.springframework.stereotype.Service

@Service
class GoalService(
    private val goalCommandHandler: GoalCommandHandler
) {
    fun save(request: CreateGoalRequest) {
        val goal = goalCommandHandler.save(request.toCommand())
    }
}