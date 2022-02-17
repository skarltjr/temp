package org.example.user.domain.handler

import org.example.user.domain.User
import org.example.user.domain.UserRepository
import org.springframework.stereotype.Component

@Component
class UserCommandHandler(
    private val userRepository: UserRepository
) {
    // user application -> user domain  -> user infra Dip를 지키기위해
    // application에서 바로 infra모듈에 접근하지않고 domain을 통해 처리
    fun save(user: User) {
        userRepository.save(user)
    }

}