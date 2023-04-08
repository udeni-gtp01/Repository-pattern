package com.udeni.labsession2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udeni.labsession2.local.UserDatabase
import com.udeni.labsession2.repository.UserRepository
import com.udeni.labsession2.repository.UserRepositoryImpl
import kotlinx.coroutines.launch

class UserViewModel(private val userRepo: UserRepository) : ViewModel(){

    //private val userRepo : UserRepositoryImpl

    private val _usersData = MutableLiveData<String>(null)
    val usersData: LiveData<String>
        get() = _usersData

    init {
       // val userDao = UserDatabase.getInstance(application).userDao()
      //  userRepo = UserRepositoryImpl(userDao)
    }

    fun getUsers() {
        viewModelScope.launch {
            val users = userRepo.getUsers()

            var strUser: String? = null
            var userRecord = ""
            for (user in users)
                strUser = "${user.id} \n$user.firstName \n$user.lastName \n$user.email\n\n"

            userRecord += strUser

            _usersData.value = userRecord
        }


    }

}