package com.john.navigation.dao

import com.john.navigation.interfaceDao.InterfaceDao
import com.john.navigation.models.Restaurant
import com.john.navigation.object_model.Repository


class DaoRestaurant private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoRestaurant by lazy{ //lazy delega a un primer acceso
            DaoRestaurant() //Me creo sólo este objeto una vez.
        }
    }
    //Método que accede a la BBDD y devuelve todos los datos
    override
    fun getDataRestaurant(): List<Restaurant> = Repository. listRestauran
}

object DaoHotels2 {
    val myDao by lazy {
        getDataRestaurant()
    }
    private fun getDataRestaurant() : List<Restaurant> = Repository. listRestauran
}