package com.udeni.labsession2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.udeni.labsession2.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel: UserViewModel by lazy {
            val viewModelProviderFactory = UserViewModelProviderFactory()
            ViewModelProvider(this, viewModelProviderFactory)[UserViewModel::class.java]
        }

        binding.userVM = viewModel
        binding.lifecycleOwner = this

        binding.btnServiceCall.setOnClickListener {
            viewModel.getUsers()
        }

    }
}