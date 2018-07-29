package com.example.stefan.calcutta

import android.arch.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    val data: CalculatorData = CalculatorData()


    fun clearDisplay() {
        data.clearDisplay()
    }

    fun enterDigit(digit: String) {
        data.appendDisplay(digit)
    }
}