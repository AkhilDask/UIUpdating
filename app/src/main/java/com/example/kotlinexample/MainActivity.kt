package com.example.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initial = textidforprogress.translationY
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textidforprogress.text = p1.toString()

                val translationdistance = (initial+ p1*resources.getDimension(R.dimen.text_anim) *-1) //the negative y  is  upwards
            //animstep is resolutiondependent

                textidforprogress.animate().translationY(translationdistance)
                if(!p2){
                    textidforprogress.animate().setDuration(500).rotationBy(360f)
                        .translationY(initial)
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        } )

        button.setOnClickListener { v ->
            seekBar.progress =0

        }
    }
}