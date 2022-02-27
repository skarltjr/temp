package org.example.user.domain.model

import org.example.common.AbstractAggregateRoot
import org.example.user.domain.event.CreateUserQueryEvent
import org.example.user.domain.event.DeleteGoalEvent
import org.example.user.domain.event.DeleteUserQueryEvent
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_api_user")
class User(
    @field:Id
    @field:GeneratedValue
    val userId:Long?,
    val name: String,
    val password: String,
    val createdAt: LocalDateTime
) : AbstractAggregateRoot() {
    constructor(name: String, password: String) : this(
        userId = null,
        name = name,
        password = password,
        createdAt = LocalDateTime.now()
    )
    fun registerCreateUserQueryEvent() {
        registerEvent(CreateUserQueryEvent(
            userId = this.userId!!,
            username = this.name,
            createdAt = this.createdAt
        ))
    }

    fun deleteUser() {
        registerEvent(DeleteGoalEvent(this.name))
    }

    fun deleteUserQuery() {
        registerEvent(DeleteUserQueryEvent(this.userId!!))
    }
}