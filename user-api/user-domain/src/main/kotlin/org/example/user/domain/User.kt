package org.example.user.domain

import org.example.common.AbstractAggregateRoot
import org.example.user.domain.event.UserCreatedEvent
import java.time.LocalDateTime

class User(
    val name:String,
    val password:String,
    val createdAt:LocalDateTime
) : AbstractAggregateRoot() {
    constructor(name: String, password: String) : this(name=name,password=password, LocalDateTime.now()){
        registerEvent(UserCreatedEvent(this))
    }
}