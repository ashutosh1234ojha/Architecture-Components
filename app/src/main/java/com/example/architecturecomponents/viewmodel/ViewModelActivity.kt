package com.example.architecturecomponents.viewmodel

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.architecturecomponents.R
import com.example.architecturecomponents.Utility

class ViewModelActivity : AppCompatActivity(), View.OnClickListener {


    var ivFirstPlus: ImageView? = null
    var ivFirstMinus: ImageView? = null
    var ivSecondPlus: ImageView? = null
    var ivSecondMinus: ImageView? = null
    var tvScoreOne: TextView? = null
    var tvScoreSecond: TextView? = null
    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activit_view_model)

        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        init()

    }

    fun init() {
        ivFirstPlus = findViewById(R.id.ivFirstPlus)
        ivFirstMinus = findViewById(R.id.ivFirstMinus)
        ivSecondPlus = findViewById(R.id.ivSecondPlus)
        ivSecondMinus = findViewById(R.id.ivSecondMinus)
        tvScoreOne = findViewById(R.id.tvScoreOne)
        tvScoreSecond = findViewById(R.id.tvScoreSecond)

        Utility.setOnClickListener(this, ivFirstPlus!!, ivFirstMinus!!, ivSecondMinus!!, ivSecondPlus!!)

        setScoreOfTeamA()
        setScoreOfTeamB()
    }

    private fun setScoreOfTeamA() {
        tvScoreOne?.text = myViewModel.scoreTeamA.toString()
    }

    private fun setScoreOfTeamB() {
        tvScoreSecond?.text = myViewModel.scoreTeamB.toString()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            ivFirstPlus?.id -> {
                myViewModel.scoreTeamA++
                setScoreOfTeamA()
            }

            ivFirstMinus?.id -> {
                myViewModel.scoreTeamA--
                setScoreOfTeamA()
            }

            ivSecondPlus?.id -> {
                myViewModel.scoreTeamB++
                setScoreOfTeamB()
            }

            ivSecondMinus?.id -> {
                myViewModel.scoreTeamA--
                setScoreOfTeamB()

            }

        }
    }
}