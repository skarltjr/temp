package org.example.goal.infrastructure


import org.example.goal.domain.eventProcessor.DeleteGoalEventProcessor
import org.example.goal.domain.event.DeleteGoalEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class GoalEventHandler(
    private val processor: DeleteGoalEventProcessor
) {

    @EventListener
    fun handleDeleteGoalEvent(event: DeleteGoalEvent) {
        processor.deleteGoalWithUser(event)
    }
}