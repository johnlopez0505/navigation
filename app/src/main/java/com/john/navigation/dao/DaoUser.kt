package com.john.navigation.dao

import com.john.navigation.interfaceDao.DaoUserInterface
import com.john.navigation.models.User
import com.john.navigation.object_model.UserRepository


class DaoUser private constructor(): DaoUserInterface {
    companion object {
        val myDao: DaoUser by lazy{ //lazy delega a un primer acceso
            DaoUser() //Me creo sólo este objeto una vez.
        }
    }
    //Método que accede a la BBDD y devuelve todos los datos

    override fun getDataUser(): List<User> = UserRepository.listUser

    fun addUser(user: User) {
        UserRepository.listUser.add(user)
    }
}

