package org.example.user.domain.handler

import org.example.user.domain.User
import org.example.user.domain.UserRepository
import org.example.user.domain.commands.CreateUserCommand
import org.example.user.domain.commands.DeleteUserCommand
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component


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
            name = command.name,
            password = command.password
        )
        userRepository.save(user)
    }

    fun delete(command: DeleteUserCommand) {
        val userName = command.name
        val user = userRepository.findByName(userName) // null 예외처리 추가
        user!!.deleteUser()
        user.pollAllEvent().forEach(publisher::publishEvent)

        //여기서 이벤트를 던진 후 문제가 생기면??? -> 확인해보니 트랜잭션 보장이 됐다.
        //지금은 같은 데이터베이스를 사용해서 하나의 트랜잭션으로 관리되는
        userRepository.delete(user!!)
    }
}