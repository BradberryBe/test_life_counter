package com.allmycode.test_life_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var lifeVal: Int = 0

    // Background color values
    private val WHITE: String = "#EBF5D1"
    private val BLUE: String = "#135E6E"
    private val BLACK: String = "#2F3B32"
    private val RED: String = "#B80000"
    private val GREEN: String = "#326611"

    companion object {
        const val P1_LIFE_KEY = "P1_LIFE"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Instance State Values

        lifeVal = if (savedInstanceState != null) savedInstanceState.getInt(P1_LIFE_KEY) else 20
        lifeGain.setOnClickListener {lifeVal = boostLife(lifeVal)
            lifeTotalView.setText(lifeVal.toString())}
        lifeLoss.setOnClickListener {lifeVal = lowerLife(lifeVal)
            lifeTotalView.setText(lifeVal.toString())}
        lifeResetNorm.setOnClickListener {lifeVal = resetNorm()
            lifeTotalView.setText(lifeVal.toString())}
        lifeResetEDH.setOnClickListener {lifeVal = resetEDH()
            lifeTotalView.setText(lifeVal.toString())}


        lifeTotalView.setText(lifeVal.toString())

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(P1_LIFE_KEY, lifeVal)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        //lifeTotalView.setText(savedInstanceState.getString("life_total"))
        super.onRestoreInstanceState(savedInstanceState)

        //lifeVal = savedInstanceState.getInt(P1_LIFE_KEY)
    }
}