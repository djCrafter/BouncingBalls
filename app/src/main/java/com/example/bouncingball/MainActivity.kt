package com.example.bouncingball

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_button.setOnClickListener { playButtonClick(play_button) }
        stop_button.setOnClickListener { stopButtonClick(stop_button) }
    }

    fun playButtonClick(view: View) {
        bouncingball.play()
    }

    fun stopButtonClick(view: View) {
        bouncingball.stop()
    }


}
