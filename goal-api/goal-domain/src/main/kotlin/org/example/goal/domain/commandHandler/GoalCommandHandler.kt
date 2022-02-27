package org.example.goal.domain.commandHandler

import org.example.goal.domain.Goal
import org.example.goal.domain.GoalRepository
import org.example.goal.domain.commands.CreateGoalCommand
import org.example.goal.domain.commands.DeleteGoalWithUserCommand
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import vo.User
import java.lang.RuntimeException

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

    fun deleteGoalWithUser(command: DeleteGoalWithUserCommand) {
        val user = User(command.userName)
        goalRepository.deleteByUser(user)
        throw RuntimeException()
    }
    // Service제외한 다른곳에선 트랜잭션이 보장되는가? - > 모든 동작이 서비스를 거치고 서비스에서 트랜잭션 열어주니까 보장
}