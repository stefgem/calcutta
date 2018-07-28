package com.example.stefan.calcutta

import android.arch.lifecycle.MutableLiveData

class CalculatorData {

    var firstOperand = StringBuilder("")
    var secondOperand = StringBuilder("")
    var operator: String = ""
    var displayedText = MutableLiveData<String>()



    fun updateDisplay(str: String) {
        displayedText.postValue(str)
    }
}