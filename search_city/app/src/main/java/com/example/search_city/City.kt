package com.example.search_city


class City{

    private var city: String?= null

    fun getCity() : String{
        return city.toString()
    }

    fun setCity(city: String){
        this.city = city
    }
}