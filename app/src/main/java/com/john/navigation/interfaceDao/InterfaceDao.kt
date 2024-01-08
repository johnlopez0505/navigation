package com.john.navigation.interfaceDao

import com.john.navigation.models.Restaurant

interface InterfaceDao {
    fun getDataRestaurant(): List<Restaurant>
}