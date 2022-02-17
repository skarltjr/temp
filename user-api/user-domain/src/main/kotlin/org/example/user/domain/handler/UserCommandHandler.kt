package org.example.user.domain.handler

import org.example.user.domain.User
import org.example.user.domain.UserRepository
import org.example.user.domain.commands.CreateUserCommand
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserCommandHandler(
    private val userRepository: UserRepository,
    private val publisher: ApplicationEventPublisher
) {
    // user application -> user domain  -> user infra Dip
    // application에서 바로 infra모듈에 접근하지x domain레이어에서 처리

    //command를 통해 핸들러에서 처리할 때 우리가 "무엇을" 처리해야하는지 명확히 알 수 있다
    fun save(command:CreateUserCommand) {
        val user = User(
            userId = null,
            name = command.name,
            password = command.password,
            createdAt = LocalDateTime.now()
        )
        userRepository.save(user)
        user.pollAllEvent().forEach(publisher::publishEvent)
    }
}