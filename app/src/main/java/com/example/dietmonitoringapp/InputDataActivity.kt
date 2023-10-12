package com.example.dietmonitoringapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.dietmonitoringapp.databinding.ActivityInputDataBinding
import com.example.dietmonitoringapp.databinding.ActivityWelcomeBinding

class InputDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInputDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            backButton.setOnClickListener{
                val intent = Intent( this@InputDataActivity, HomeActivity::class.java )
                startActivity(intent)

            }
        }
    }
}


