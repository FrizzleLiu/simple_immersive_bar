package com.frizzle.bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.frizzle.immersivebar.immersiveBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersiveBar()
        setContentView(R.layout.activity_main)
        // 底部AlertDialog
        findViewById<Button>(R.id.bottom_dialog).setOnClickListener { BottomDialog(this@MainActivity).show() }
        // 顶部AlertDialog
        findViewById<Button>(R.id.top_dialog).setOnClickListener { TopDialog(this@MainActivity).show() }
        // 底部 DialogFragment
        findViewById<Button>(R.id.bottom_fragment_dialog).setOnClickListener {
            val bottomDialogFragment = BottomDialogFragment()
            bottomDialogFragment.show(supportFragmentManager, bottomDialogFragment.javaClass.simpleName)
        }
        // 顶部 DialogFragment
        findViewById<Button>(R.id.top_fragment_dialog).setOnClickListener {
            val topDialogFragment = TopDialogFragment()
            topDialogFragment.show(supportFragmentManager, topDialogFragment.javaClass.simpleName)
        }
    }
}