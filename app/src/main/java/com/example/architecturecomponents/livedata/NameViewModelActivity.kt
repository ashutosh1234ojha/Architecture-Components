package com.example.architecturecomponents.livedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.example.architecturecomponents.R
import android.text.Editable


class NameViewModelActivity : AppCompatActivity() {


    var etName: EditText? = null
    var tvName: TextView? = null
    lateinit var nameViewModel: NameViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.architecturecomponents.R.layout.activity_name_viewmodel)
        nameViewModel = ViewModelProviders.of(this).get(NameViewModel::class.java)

        init()
        setName()

        showName()


    }

    fun init() {
        etName = findViewById(R.id.etName)
        tvName = findViewById(R.id.tvName)
    }


    private fun setName() {

        etName?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                nameViewModel.setUserName(s.toString())


            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        })


    }

    private fun showName() {
        nameViewModel.getUserName().observe(this, Observer<String> {
            tvName?.text = "Your name is $it"
        }
        )
    }
}