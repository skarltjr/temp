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
    constructor(name: String, password: String,createdAt:LocalDateTime) : this(userId =null,name = name,
        password = password,createdAt = createdAt) {
        // 생성자 변경해야할듯 event등록위해
        registerEvent(UserCreatedEvent(this))
    }
}