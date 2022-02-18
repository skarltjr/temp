package org.example

import org.example.user.domain.event.DeleteGoalEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class DomainEventTranslator(
    private val publisher: ApplicationEventPublisher
) {
    // user모듈에서 던진 이벤트 -> app 모듈 -> goal모듈 전달
    // 즉 app 모듈을 통해, app 모듈이 모듈간 소통을 컨트롤
    // 파라미터로 들어온 event는 user의 DeleteGoalEvent
    // 새로 publishg하는 event는 goal의 DeleteGoalEvent을 하여 전달하는 방식
    @EventListener
    fun handleDeleteGoalEvent(event: DeleteGoalEvent) {
        publisher.publishEvent(
            org.example.goal.domain.event.DeleteGoalEvent(
                userName = event.userName
            )
        )
    }
}