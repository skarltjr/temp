package org.example.goal.domain.handler

import org.example.goal.domain.Goal
import org.example.goal.domain.GoalRepository
import org.example.goal.domain.commands.CreateGoalCommand
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import vo.User

@Component
class GoalCommandHandler(
    private val goalRepository: GoalRepository,
    private val publisher: ApplicationEventPublisher
){
    fun save(command: CreateGoalCommand):Goal {
        return goalRepository.save(Goal(
            goalId = null,
            title = command.title,
            user = User(command.userName),
            goalType = command.goalType
        ))
    }
}