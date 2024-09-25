package com.example.myapplication

import android.app.AlertDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.dialog.DatePicker
import com.example.myapplication.dialog.TimePicker as timePickerBuatan
import java.util.Locale

class MainActivity : AppCompatActivity() , OnDateSetListener, OnTimeSetListener {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        val stringCountry = resources.getStringArray(R.array.country);
        val stringProvince = listOf(
            "DKI Jakarta",
            "Jawa Timur",
            "Jawa Tengah",
            "Jawir"
        )

        with(binding){
            val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, stringProvince);
            spinnerProvince.adapter = adapter;
            spinnerCountry.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, stringCountry)

            spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity, stringCountry.get(position), Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }

//            datePicker.init(
//                datePicker.year,
//                datePicker.month,
//                datePicker.dayOfMonth
//            ){ _, year, month, day ->
//                val selectedDate = "$day / ${month +1}/ $year"
//                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
//            }

            timePicker.setOnTimeChangedListener{
                    _, hour, minute ->
                val selectedTime = String.format(
                    Locale.getDefault(),
                    "%02d:%02d", hour,minute)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()

            }

        }
    }
//    fun showCalender(view: View){
//        DatePicker().show(supportFragmentManager, "datePicker")
//    }
    fun showTime(view: View){
        timePickerBuatan().show(supportFragmentManager,"timePicker")
    }
//    override fun onDateSet(
//        view: android.widget.DatePicker?,
//        year: Int,
//        month: Int,
//        dayOfMonth: Int
//    ) {
//        Toast.makeText(this, "$dayOfMonth/ ${month +1}/$year", Toast.LENGTH_SHORT).show()
//    }

    override fun onTimeSet(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(this@MainActivity,String.format(
            Locale.getDefault(),
            "%02d:%02d", hourOfDay,minute) , Toast.LENGTH_SHORT).show()
    }

    override fun onDateSet(
        view: android.widget.DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {

    }

    fun showAlert(view: View){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure to exit?")
        builder.setPositiveButton("Yes"){ dialog, which ->
            finish()
        }
        builder.setNegativeButton("No"){ dialog, which ->
            dialog.dismiss()
        }
        val  alertDialog = builder.create()
        alertDialog.show()

    }
}