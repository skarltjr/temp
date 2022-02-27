package org.example.user.domain.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_api_query_user")
class UserQuery(
    @field:Id
    val userId:Long,
    val name:String,
    val createdAt:LocalDateTime
)