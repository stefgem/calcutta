package com.example.stefan.calcutta

import android.arch.lifecycle.ViewModel
import com.example.stefan.calcutta.CalculatorData.Operator

class CalculatorViewModel : ViewModel() {

    val data: CalculatorData = CalculatorData()

    fun clearDisplay() {
        data.clearDisplay()
    }

    fun enterDigit(digit: String) {
        if (digit == "0"
                && data.displayedText.value == null
                && data.displayedText.value.toString() != "0") {
            // do nothing - this prevents leading zeros
        } else {
            data.appendDisplay(digit)
        }
    }

    fun startAddition() = startBinaryOperation(Operator.ADDITION)
    fun startSubtraction() = startBinaryOperation(Operator.SUBTRACTION)
    fun startMultiplication() = startBinaryOperation(Operator.MULTIPLICATION)
    fun startDivision() = startBinaryOperation(Operator.DIVISION)

    fun squareRoot() {
        data.squareRoot()
        data.equals()
    }

    fun negate() {
        data.negate()
        data.equals()
    }

    fun equals() {
        if (!data.displayedText.value.isNullOrEmpty()) {
            data.secondOperand = data.displayedText.value?.toString()?.toDouble() ?: 0.0
        } else {
            data.secondOperand = 0.0
        }
        data.operator?.let { operator ->
            when (operator) {
                Operator.ADDITION -> data.add()
                Operator.SUBTRACTION -> data.subtract()
                Operator.MULTIPLICATION -> data.multiply()
                Operator.DIVISION -> data.divide()
            }
            data.equals()
            data.operator = null
        }
    }

    private fun startBinaryOperation(operator: Operator) {
        data.operator = operator
        data.firstOperand = data.displayedText.value?.toString()?.toDouble() ?: 0.0
        data.displayedText.value = StringBuilder("")
    }

}