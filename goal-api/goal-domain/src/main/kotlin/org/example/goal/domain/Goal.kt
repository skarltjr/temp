package org.example.goal.domain

import org.example.common.AbstractAggregateRoot
import vo.User
import javax.persistence.*

@Entity
class Goal(
    @field:Id
    @GeneratedValue
    val goalId: Long?,

    val title: String,

    @field:Embedded
    val user: User,

    @field:Enumerated(EnumType.STRING)
    val goalType: GoalType

) : AbstractAggregateRoot() {
    enum class GoalType {
        MONEY,HONOR,FREE
    }
    // test
}