package org.example.goal.infrastructure


import org.example.goal.domain.commandHandler.GoalCommandHandler
import org.example.goal.domain.commands.DeleteGoalWithUserCommand
import org.example.goal.domain.event.DeleteGoalEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class GoalEventHandler(
    private val commandHandler: GoalCommandHandler
) {

    @EventListener
    fun handleDeleteGoalEvent(event: DeleteGoalEvent) {
        commandHandler.deleteGoalWithUser(DeleteGoalWithUserCommand.toCommand(event))
    }
}