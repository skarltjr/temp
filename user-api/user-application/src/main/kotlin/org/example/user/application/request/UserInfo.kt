package org.example.user.application.request


import org.example.user.domain.commands.DeleteUserCommand
import javax.validation.constraints.NotEmpty

class UserInfo(
    @NotEmpty
    val name:String
){
    fun toCommand(): DeleteUserCommand {
        return DeleteUserCommand(
            name = this.name
        )
    }
}