package com.example.stefan.calcutta

import android.arch.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    val data: CalculatorData = CalculatorData()

    fun enter1() {
        data.updateDisplay("1")
    }
}