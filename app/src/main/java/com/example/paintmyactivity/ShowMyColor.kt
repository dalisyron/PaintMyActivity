package com.example.paintmyactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.paintmyactivity.MainActivity.Companion.CLICKED_COLOR_ID
import com.example.paintmyactivity.MainActivity.Companion.CLICKED_COLOR_NAME
import org.w3c.dom.Text

class ShowMyColor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_my_color)
        val layout = findViewById<RelativeLayout>(R.id.rootLinearLayout)
        val colorID = intent?.extras?.getInt(CLICKED_COLOR_ID)
        val colorName = intent?.extras?.getString(CLICKED_COLOR_NAME)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        if (colorID != null) {
            layout.setBackgroundColor(colorID)
            resultTextView.setText("$colorName is selected")
        }
    }
}
