package org.example.user.presentation

import org.example.user.application.UserService
import org.example.user.application.request.SignUpForm
import org.example.user.application.request.UserInfo
import org.springframework.web.bind.annotation.*
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

    @DeleteMapping
    fun deleteUser(@RequestBody @Valid userInfo: UserInfo) {
        userService.delete(userInfo)
    }
}