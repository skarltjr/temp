package org.example.user.domain.event

import org.example.common.DomainEvent

class DeleteUserQueryEvent(
    val userId: Long
) : DomainEvent {

}