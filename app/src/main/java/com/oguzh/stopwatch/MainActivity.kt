package com.oguzh.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var zamanidurdur:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start (view : View){
        kronometre.base=SystemClock.elapsedRealtime()+zamanidurdur
        kronometre.start()
        start.visibility=View.GONE
        stop.visibility=View.VISIBLE
        imagebasla.setImageDrawable(getDrawable(R.drawable.pause))

    }
    fun stop(view : View){
        zamanidurdur=kronometre.base-SystemClock.elapsedRealtime()
        kronometre.stop()
        start.visibility=View.VISIBLE
        stop.visibility=View.GONE
        imagebasla.setImageDrawable(getDrawable(R.drawable.start))
    }
    fun restart(view : View){
        kronometre.base=SystemClock.elapsedRealtime()
        kronometre.stop()
        zamanidurdur=0
        start.visibility=View.VISIBLE
        stop.visibility=View.GONE
        imagebasla.setImageDrawable(getDrawable(R.drawable.start))
    }



}