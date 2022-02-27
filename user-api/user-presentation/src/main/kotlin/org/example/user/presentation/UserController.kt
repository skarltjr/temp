package org.example.user.presentation

import org.example.user.application.UserService
import org.example.user.application.request.SignUpForm
import org.example.user.application.request.UserInfo
import org.example.user.application.response.GetUser
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

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long):GetUser{
        return userService.getUser(userId)
    }
    @DeleteMapping
    fun deleteUser(@RequestBody @Valid userInfo: UserInfo) {
        userService.delete(userInfo)
    }
}