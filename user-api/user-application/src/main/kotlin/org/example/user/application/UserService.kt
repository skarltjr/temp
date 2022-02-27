package org.example.user.application

import org.example.user.application.request.SignUpForm
import org.example.user.application.request.UserInfo
import org.example.user.application.response.GetUser
import org.example.user.domain.commanHandler.UserCommandHandler
import org.example.user.domain.processor.UserQueryProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional



@Service
class UserService(
    private val userCommandHandler: UserCommandHandler,
    private val userQueryProcessor: UserQueryProcessor
){
    @Transactional
    fun save(form: SignUpForm) {
        // 1. 각 crud와 같은 행위는 command로 다룬다
        // 이를위해 request -> command
        // 2.service는 화합의 공간으로 사용
        // 도메인 모듈로 책임을 위임 - 이를위한 도메인의 commandHandler
        userCommandHandler.save(form.toCommand())
    }

    @Transactional
    fun delete(userName: UserInfo) {
        userCommandHandler.delete(userName.toCommand())
    }

    @Transactional(readOnly = true)
    fun getUser(userId: Long): GetUser {
        val userQuery = userQueryProcessor.findByUserId(userId)
        return GetUser(
            userId = userQuery.userId,
            name = userQuery.name,
            createdAt = userQuery.createdAt
        )
    }
}