package org.example.user.application.request

import javax.validation.constraints.NotEmpty

class SignUpForm(
    @NotEmpty
    val name: String,
    @NotEmpty
    val password:String
)