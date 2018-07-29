package com.example.stefan.calcutta

import android.arch.lifecycle.MutableLiveData

class CalculatorData {

    var firstOperand = StringBuilder("")
    var secondOperand = StringBuilder("")
    var operator: String = ""
    var displayedText = MutableLiveData<StringBuilder>()


    fun clearDisplay() {
        displayedText.postValue(null)
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
}
