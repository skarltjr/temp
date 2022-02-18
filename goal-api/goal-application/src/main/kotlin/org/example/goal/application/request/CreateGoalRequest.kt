package org.example.goal.application.request

import org.example.goal.domain.Goal
import org.example.goal.domain.commands.CreateGoalCommand

class CreateGoalRequest(
    val username: String,
    val title: String,
    val goalType: Goal.GoalType
){
    fun toCommand(): CreateGoalCommand {
        return CreateGoalCommand(
            title = this.title,
            userName = this.username,
            goalType = this.goalType
        )
    }
}