package org.example.user.domain

import org.example.common.DomainEvent
import java.time.LocalDateTime

class UserCreatedEvent(
    val userName:String,
    val password:String,
    val createdAt:LocalDateTime
) : DomainEvent {
    constructor(user:User) : this(
        userName = user.name,
        password = user.password,
        createdAt = user.createdAt
    )
}