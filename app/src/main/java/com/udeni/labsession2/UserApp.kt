package com.udeni.labsession2

import android.app.Application
import com.udeni.labsession2.local.UserDatabase
import com.udeni.labsession2.remote.RetrofitClient
import retrofit2.Retrofit

class UserApp:Application() {
    companion object {
        // Retrofit
        lateinit var retrofit: Retrofit
        // Room
        lateinit var userDatabase: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()

        // Retrofit
        retrofit = RetrofitClient.getInstance()
        // Room
        userDatabase = UserDatabase.getInstance(applicationContext)
    }

}