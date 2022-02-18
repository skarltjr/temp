package org.example.user.application

import org.example.user.application.request.SignUpForm
import org.example.user.application.request.UserInfo
import org.example.user.domain.handler.UserCommandHandler
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional



@Service
class UserService(
    private val userCommandHandler: UserCommandHandler
){
    @Transactional
    fun save(form: SignUpForm) {
        userCommandHandler.save(form.toCommand())
    }

    fun delete(userName: UserInfo) {
        userCommandHandler.delete(userName.toCommand())
    }
}