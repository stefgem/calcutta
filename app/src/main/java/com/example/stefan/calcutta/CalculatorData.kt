package com.example.stefan.calcutta

import android.arch.lifecycle.MutableLiveData
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.sqrt

class CalculatorData {

    var firstOperand: Double = 0.0
    var secondOperand: Double = 0.0
    var result: Double = 0.0
    var operator: String = ""
    var displayedText = MutableLiveData<StringBuilder>()


    fun clearDisplay() {
        displayedText.postValue(null)
        firstOperand = 0.0
        secondOperand = 0.0
        result = 0.0
    }

    fun updateDisplay(str: String) {
        displayedText.postValue(StringBuilder(str))
    }

    fun appendDisplay(str: String) {
        displayedText.value?.let {
            displayedText.value = it.append(str)
        } ?: run {
            displayedText.value = StringBuilder(str)
        }
    }

    fun squareRoot() {
        firstOperand = displayedText.value?.toString()?.toDouble() ?: 0.0
        result = sqrt(firstOperand)
    }

    fun negate() {
        firstOperand = displayedText.value?.toString()?.toDouble() ?: 0.0
        result = firstOperand * -1
    }

    fun equals() {
        val decimalFormat = DecimalFormat("#.######")
        decimalFormat.roundingMode = RoundingMode.HALF_UP
        displayedText.postValue(StringBuilder(decimalFormat.format(result)))
    }
}
