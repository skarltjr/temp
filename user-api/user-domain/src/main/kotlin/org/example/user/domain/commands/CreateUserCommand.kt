package org.example.user.domain.commands

import java.time.LocalDateTime

/**
 * 사용자의 행위가 Command가 됩니다. Command는 일반적으로 '무엇을 CRUD 요청한다." 또는 "무엇을 XX한다.'의 형태가 됩니다. (CURD란 Create Update Read Delete의 약자입니다.)
 * */
class CreateUserCommand(
    val name:String,
    val password:String,
    val createdAt:LocalDateTime
)