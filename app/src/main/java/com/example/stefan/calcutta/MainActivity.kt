package com.example.stefan.calcutta

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        viewModel.data.displayedText.observe(this, Observer { newDisplay ->
            textView.text = newDisplay
        })

    }

    override fun onStart() {
        super.onStart()

        button1.setOnClickListener {
            viewModel.enter1()
        }
    }
}
