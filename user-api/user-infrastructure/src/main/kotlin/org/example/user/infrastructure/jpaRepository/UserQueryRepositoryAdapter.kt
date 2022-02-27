package org.example.user.infrastructure.jpaRepository

import org.example.user.domain.UserQueryRepository
import org.example.user.domain.model.UserQuery
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class UserQueryRepositoryAdapter(
    private val jpaUserQueryRepository:JpaUserQueryRepository
):UserQueryRepository{
    override fun findByName(name: String): UserQuery {
        return jpaUserQueryRepository.findByName(name)
    }

    override fun save(userQuery: UserQuery): UserQuery {
        return jpaUserQueryRepository.save(userQuery)
    }

    override fun findById(userId: Long): UserQuery {
        return jpaUserQueryRepository.findByIdOrNull(userId)?: throw RuntimeException()
    }

    override fun deleteById(userId: Long) {
        jpaUserQueryRepository.deleteById(userId)
    }
}
