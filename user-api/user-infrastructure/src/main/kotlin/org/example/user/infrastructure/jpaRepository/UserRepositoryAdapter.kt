package org.example.user.infrastructure.jpaRepository

import org.example.user.domain.User
import org.example.user.domain.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(
    private val jpaUserRepository: JpaUserRepository
) : UserRepository {
    // 제 3자에게 어떤 레포지토리를 사용할지 책임을 위임
    // IoC
    // userRepository 구현체로 지금은 jpaRepository를 주입받아활용
    // userRepository인터페이스가 사용될 때 의존관계 자동주입으로 userRepository에 이 UserRepositoryAdapter가 주입된다


    override fun save(user: User): User {
        return jpaUserRepository.save(user)
    }

    override fun findByName(userName: String): User? {
        return jpaUserRepository.findByName(userName)
    }

    override fun delete(user: User) {
        return jpaUserRepository.delete(user)
    }
}