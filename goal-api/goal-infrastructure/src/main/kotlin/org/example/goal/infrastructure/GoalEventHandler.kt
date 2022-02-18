package org.example.goal.infrastructure


import org.example.goal.domain.event.DeleteGoalEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class GoalEventHandler() {

    @EventListener
    fun deleteGoal(event: DeleteGoalEvent) {

    }
}