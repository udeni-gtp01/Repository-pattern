package com.udeni.labsession2.repository

import com.udeni.labsession2.model.User

interface UserRepository {
    suspend fun getUsers() : List<User>
}