package org.example.user.domain


interface UserRepository{

    fun save(user:User):User
    fun findByName(userName: String):User?
    fun delete(user: User)
}