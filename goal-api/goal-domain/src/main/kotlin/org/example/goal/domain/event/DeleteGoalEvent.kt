package org.example.goal.domain.event

import org.example.common.DomainEvent

class DeleteGoalEvent(
    val userName: String
) : DomainEvent {

}