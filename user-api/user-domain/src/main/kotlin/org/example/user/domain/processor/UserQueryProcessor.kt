package org.example.user.domain.processor

import org.example.user.domain.UserQueryRepository
import org.example.user.domain.UserRepository
import org.example.user.domain.event.CreateUserQueryEvent
import org.example.user.domain.model.UserQuery
import org.springframework.stereotype.Component

@Component
class UserQueryProcessor(
    private val userRepository: UserRepository,
    private val userQueryRepository: UserQueryRepository
){
    fun createUserQuery(event: CreateUserQueryEvent) {
        userQueryRepository.save(UserQuery(
            userId = event.userId,
            name = event.username,
            createdAt = event.createdAt
        ))
    }

    fun findByUserId(userId: Long):UserQuery {
        return userQueryRepository.findById(userId)
    }

}