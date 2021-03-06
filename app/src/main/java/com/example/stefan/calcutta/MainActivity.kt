package com.example.stefan.calcutta

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val EMPTY_DISPLAY_STRING = "0"
    lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        viewModel.data.displayedText.observe(this, Observer { newDisplay ->
            newDisplay?.run { textView.text = newDisplay.toString() }
                    ?: run { textView.text = EMPTY_DISPLAY_STRING }
        })


        viewModel.clearDisplay()
    }

    override fun onStart() {
        super.onStart()

        clear_button.setOnClickListener {
            viewModel.clearDisplay()
        }
        button0.setOnClickListener {
            viewModel.enterDigit("0")
        }
        button1.setOnClickListener {
            viewModel.enterDigit("1")
        }
        button2.setOnClickListener {
            viewModel.enterDigit("2")
        }
        button3.setOnClickListener {
            viewModel.enterDigit("3")
        }
        button4.setOnClickListener {
            viewModel.enterDigit("4")
        }
        button5.setOnClickListener {
            viewModel.enterDigit("5")
        }
        button6.setOnClickListener {
            viewModel.enterDigit("6")
        }
        button7.setOnClickListener {
            viewModel.enterDigit("7")
        }
        button8.setOnClickListener {
            viewModel.enterDigit("8")
        }
        button9.setOnClickListener {
            viewModel.enterDigit("9")
        }

        decimal_button.setOnClickListener {
            viewModel.enterDecimal()
        }
        square_root_button.setOnClickListener {
            viewModel.squareRoot()
        }

        plus_minus_button.setOnClickListener {
            viewModel.negate()
        }
        addition_button.setOnClickListener {
            val display = textView.text
            viewModel.startAddition()
            textView.text = display
        }
        subtraction_button.setOnClickListener {
            val display = textView.text
            viewModel.startSubtraction()
            textView.text = display
        }
        multiplication_button.setOnClickListener {
            val display = textView.text
            viewModel.startMultiplication()
            textView.text = display
        }
        division_button.setOnClickListener {
            val display = textView.text
            viewModel.startDivision()
            textView.text = display
        }

        equals_button.setOnClickListener {
            viewModel.equals()

        }


    }
}
