package org.example.user.domain

import org.example.common.AbstractAggregateRoot
import org.example.user.domain.event.UserCreatedEvent
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    @field:Id
    @field:GeneratedValue
    val userId:Long?,
    val name: String,
    val password: String,
    val createdAt: LocalDateTime
) : AbstractAggregateRoot() {
    constructor(name: String, password: String) : this(userId =null,name = name, password = password, LocalDateTime.now()) {
        registerEvent(UserCreatedEvent(this))
    }
}