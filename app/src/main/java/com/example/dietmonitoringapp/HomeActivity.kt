package com.example.dietmonitoringapp

import android.app.Activity
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dietmonitoringapp.GetStartedActivity.Companion.EXTRA_BERAT_TARGET
import com.example.dietmonitoringapp.GetStartedActivity.Companion.EXTRA_NAMA
import com.example.dietmonitoringapp.GetStartedActivity.Companion.EXTRA_TANGGAL_TARGET
import com.example.dietmonitoringapp.databinding.ActivityHomeBinding
import java.text.SimpleDateFormat
import java.util.Locale


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private var txttanggalisi : String? = null

    private  val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data
            if(data != null){
                val receivedData = data.getStringExtra("key_name")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = Calendar.getInstance()
        val dateFormat =SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)
        txttanggalisi = currentDate

        val nama = intent.getStringExtra(EXTRA_NAMA)
        val beratTarget =intent.getStringExtra(EXTRA_BERAT_TARGET)
        val tanggalTarget = intent.getStringExtra(EXTRA_TANGGAL_TARGET)

        with(binding){

            namaIsi.text = nama
            beratTargetIsi.text = beratTarget
            tanggalTargetIsi.text = tanggalTarget
            txtTanggalIsi2.text = txttanggalisi

            inputData.setOnClickListener{
                val intentToDataActivity = Intent( this@HomeActivity, InputDataActivity::class.java )
                startActivity(intentToDataActivity)
                intent.putExtra("key_name", "data_to_send")
                launcher.launch(intentToDataActivity)

            }
        }
    }
}