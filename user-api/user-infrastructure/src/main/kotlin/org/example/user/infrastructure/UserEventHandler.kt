package org.example.user.infrastructure

import org.example.user.domain.event.CreateUserQueryEvent
import org.example.user.domain.event.DeleteUserQueryEvent
import org.example.user.domain.processor.UserQueryProcessor
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UserEventHandler(
    private val queryProcessor: UserQueryProcessor
){
    @EventListener
    fun handleCreateUserQueryEvent(event: CreateUserQueryEvent) {
        queryProcessor.createUserQuery(event)
    }

    @EventListener
    fun handlerDeleteUserQueryEvent(event: DeleteUserQueryEvent) {
        queryProcessor.deleteUserQuery(event)
    }
}