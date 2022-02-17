package org.example.user.domain.handler

import org.example.user.domain.User
import org.example.user.domain.UserRepository
import org.example.user.domain.commands.CreateUserCommand
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class UserCommandHandler(
    private val userRepository: UserRepository,
    private val publisher: ApplicationEventPublisher
) {
    // user application -> user domain  -> user infra Dip를 지키기위해
    // application에서 바로 infra모듈에 접근하지않고 domain을 통해 처리
    fun save(command:CreateUserCommand) {
        val user = User(
            name = command.name,
            password = command.password,
            createdAt = command.createdAt
        )
        userRepository.save(user)
        user.pollAllEvent().forEach(publisher::publishEvent)
    }

}