package com.example.rikki.livedataviewmodeldemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rikki.livedataviewmodeldemo.databinding.ActivityKotlinBinding

class KotlinActivity : AppCompatActivity() {

    lateinit var binding : ActivityKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_kotlin)
        val viewModel = ViewModelProviders.of(this, null).get(UserViewModel::class.java)
        viewModel.validator.observe(this, Observer {
            binding.loginBtn.isEnabled = it
        })
        binding.viewModel = viewModel
        binding.loginBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        }
    }
}