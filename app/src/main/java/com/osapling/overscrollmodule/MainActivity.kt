package com.osapling.overscrollmodule

import android.os.Bundle
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scrollView = findViewById<ScrollView>(R.id.sv_main_root)
        OverScrollDecoratorHelper.setUpOverScroll(scrollView)

        btn_main_vp.setOnClickListener { PagerActivity.start(it.context) }
    }
}
