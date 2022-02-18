package org.example.user.domain.event

import org.example.common.DomainEvent

class DeleteGoalEvent(
    val userName: String
) : DomainEvent {

}