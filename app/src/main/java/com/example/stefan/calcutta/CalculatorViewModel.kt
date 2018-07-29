package com.example.stefan.calcutta

import android.arch.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    val data: CalculatorData = CalculatorData()

    fun clearDisplay() {
        data.clearDisplay()
    }

    fun enterDigit(digit: String) {
        if (digit == "0" && data.displayedText.value == null) {
            // do nothing - this prevents leading zeros
        } else {
            data.appendDisplay(digit)
        }
    }

    fun squareRoot() {
        data.squareRoot()
    }

}