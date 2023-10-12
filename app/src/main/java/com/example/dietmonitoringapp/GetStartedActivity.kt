package com.example.dietmonitoringapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dietmonitoringapp.databinding.ActivityGetStartedBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class GetStartedActivity : AppCompatActivity() {
    private val tujuanDiet = arrayOf(
        "cutting",
        "bulking",
        "maintaining"
    )
    private val beratSaatIni = arrayOf(
        "kg",
        "pounds"
    )
    private val beratDiinginkan = arrayOf(
        "kg",
        "pounds"
    )

    private lateinit var binding: ActivityGetStartedBinding
    private var selectedDate: String? = null
    companion object{
        const val EXTRA_NAMA = "extra1"
        const val EXTRA_TANGGAL_TARGET = "extra2"
        const val EXTRA_BERAT_TARGET = "extra3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val adapterTujuanDietSpinner = ArrayAdapter(
                this@GetStartedActivity,
                android.R.layout.simple_spinner_item, tujuanDiet
            )
            adapterTujuanDietSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            tujuanDietSpinner.adapter = adapterTujuanDietSpinner

            val adapterBeratSaatIniSpinner = ArrayAdapter(
                this@GetStartedActivity,
                android.R.layout.simple_spinner_item, beratSaatIni
            )
            adapterBeratSaatIniSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            beratSaatIniSpinner.adapter = adapterBeratSaatIniSpinner

            val adapterBeratDiinginkanSpinner = ArrayAdapter(
                this@GetStartedActivity,
                android.R.layout.simple_spinner_item, beratDiinginkan
            )
            adapterBeratDiinginkanSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            beratDiinginkanSpinner.adapter = adapterBeratDiinginkanSpinner

            val tanggalTargetPicker = binding.tanggalTargetPicker
//
//                tanggalTargetPicker.init(
//                tanggalTargetPicker.year, tanggalTargetPicker.month, tanggalTargetPicker.dayOfMonth)
//                DatePicker
//
//            OnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
//                val calendar = Calendar.getInstance()
//                calendar.set(year, monthOfYear, dayOfMonth)
//                val dateFormat = SimpleDateFormat("dd-MM-yy")
//                selectedDate = dateFormat.format(calendar.time)
//                tanggalTarget.setText(selectedDate)
//


            tanggalTargetPicker.init(
                tanggalTargetPicker.year,
                tanggalTargetPicker.month,
                tanggalTargetPicker.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            }

            simpanButton.setOnClickListener {
                tanggalTarget.setText(selectedDate)

            }


            HitungButton.setOnClickListener {
                val nama = namaInput.text.toString()
                val jumlahKalori = jumlahKaloriInput.text.toString()
            }

            HitungButton.setOnClickListener {
                val intentToHome1 = Intent(this@GetStartedActivity, HomeActivity::class.java)
                    .apply {
                        putExtra(EXTRA_NAMA, namaInput.text.toString())
                        putExtra(EXTRA_BERAT_TARGET, beratDiinginkanInput.text.toString())
                        putExtra(EXTRA_TANGGAL_TARGET, tanggalTarget.text.toString())
                    }
                startActivity(intentToHome1)


            }

            val namaInput = findViewById<EditText>(R.id.namaInput)
            val jumlahKaloriInput = findViewById<EditText>(R.id.jumlahKaloriInput)
            val simpanButton = findViewById<Button>(R.id.simpanButton)


        }
    }
}

