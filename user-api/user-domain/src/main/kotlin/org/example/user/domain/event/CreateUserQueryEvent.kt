package org.example.user.domain.event

import org.example.common.DomainEvent
import java.time.LocalDateTime

class CreateUserQueryEvent(
    val userId: Long,
    val username: String,
    val createdAt: LocalDateTime
) : DomainEvent {

}
