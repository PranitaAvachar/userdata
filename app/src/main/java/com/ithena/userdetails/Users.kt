package com.ithena.userdetails

data class Users(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)