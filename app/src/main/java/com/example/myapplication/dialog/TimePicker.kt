package com.example.myapplication.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.DialogFragment

class TimePicker:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calender = Calendar.getInstance();
        val hour = calender.get(Calendar.HOUR)
        val minute = calender.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireActivity(),
            activity as OnTimeSetListener,
            hour, minute, DateFormat.is24HourFormat(activity)
        )
    }
}