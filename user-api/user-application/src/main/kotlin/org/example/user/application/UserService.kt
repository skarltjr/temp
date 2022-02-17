package org.example.user.application

import org.example.user.domain.User
import org.example.user.domain.handler.UserCommandHandler
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime


@Service
class UserService(
    private val userCommandHandler: UserCommandHandler,
    private val publisher:ApplicationEventPublisher
){
    @Transactional
    fun save(name: String, password: String) {
        userCommandHandler.save(
            User(
            name = name,
            password = password,
            createdAt = LocalDateTime.now()
            )
        )
    }
}