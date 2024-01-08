package com.john.navigation.interfaceDao

import com.john.navigation.models.User

interface DaoUserInterface {
    fun getDataUser(): List<User>
}