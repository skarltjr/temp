package org.example.goal.domain.commands

import org.example.goal.domain.event.DeleteGoalEvent

class DeleteGoalWithUserCommand(
    val userName:String
){
    companion object {
        fun toCommand(event: DeleteGoalEvent):DeleteGoalWithUserCommand {
            return DeleteGoalWithUserCommand(
                userName = event.userName
            )
        }
    }
}