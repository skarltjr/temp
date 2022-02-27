package org.example.user.application.response

import java.time.LocalDateTime

class GetUser(
    val userId:Long,
    val name:String,
    val createdAt:LocalDateTime
)