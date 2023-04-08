package com.udeni.labsession2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udeni.labsession2.remote.ApiInterface
import com.udeni.labsession2.repository.UserRepositoryImpl

class UserViewModelProviderFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val userDao = UserApp.userDatabase.userDao()
        val userService = UserApp.retrofit.create(ApiInterface::class.java)
        val userRepository = UserRepositoryImpl(userDao = userDao, userService = userService)

        val viewModel = UserViewModel(userRepository)

        return viewModel as T
    }
}
