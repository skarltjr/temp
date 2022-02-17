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


    override fun save(user: User): User {
        return jpaUserRepository.save(user)
    }
}