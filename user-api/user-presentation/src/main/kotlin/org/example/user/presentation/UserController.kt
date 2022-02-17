package org.example.user.presentation

import org.example.user.application.UserService
import org.example.user.application.request.SignUpForm
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody @Valid request: SignUpForm) {
        userService.save(request)
    }
}