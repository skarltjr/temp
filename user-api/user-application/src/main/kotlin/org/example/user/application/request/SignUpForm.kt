package org.example.user.application.request

import org.example.user.domain.commands.CreateUserCommand
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

class SignUpForm(
    @NotEmpty
    val name: String,
    @NotEmpty
    val password: String
){
    fun toCommand(): CreateUserCommand {
        return CreateUserCommand(
            name = this.name,
            password = this.password,
            createdAt = LocalDateTime.now()
        )
    }
}