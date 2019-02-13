package com.example.paintmyactivity

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.Button

class ColoredButton(context : Context, val colorId : String) : Button(context) {

}

class MainActivity : AppCompatActivity() {

    companion object {
        const val CLICKED_COLOR_ID : String = "clickedColorID"
        const val CLICKED_COLOR_NAME : String = "clickedColorName"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonIDs = listOf(R.id.redBtn, R.id.greenBtn, R.id.orangeBtn, R.id.purpleBtn, R.id.yellowBtn, R.id.blueBtn)
        val buttonColors = listOf(Color.RED, Color.GREEN, Color.rgb(255,165,0), Color.rgb(128,0,128), Color.YELLOW, Color.BLUE)
        val colorNames = listOf("Red", "Green", "Orange", "Purple", "Yellow", "Blue")

        val buttons : List<Button> = buttonIDs.map { findViewById<Button>(it) }

        buttons.forEachIndexed { index, button ->  button.setBackgroundColor(buttonColors[index])}
        for (button in buttons) {
            button.setTextColor(Color.WHITE)
        }

        //textColor for button with yellow bg color
        buttons[4].setTextColor(Color.BLACK)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                val intent = Intent(this, ShowMyColor::class.java)
                intent.putExtra(CLICKED_COLOR_ID, buttonColors[index])
                intent.putExtra(CLICKED_COLOR_NAME, colorNames[index])
                startActivity(intent)
            }
        }
    }
}
