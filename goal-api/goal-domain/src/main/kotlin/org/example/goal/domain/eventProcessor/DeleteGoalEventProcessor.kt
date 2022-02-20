package org.example.goal.domain.eventProcessor

import org.example.goal.domain.GoalRepository
import org.example.goal.domain.event.DeleteGoalEvent
import org.springframework.stereotype.Component
import vo.User


@Component
class DeleteGoalEventProcessor(
    private val goalRepository: GoalRepository
) {
    // domain모듈에 존재하는 event를 infra단에서 처리x 도메인에서 처리하도록 프로세서 활용
    fun deleteGoalWithUser(event: DeleteGoalEvent) {
        val user = User(event.userName)
        goalRepository.deleteByUser(user)
    }
}