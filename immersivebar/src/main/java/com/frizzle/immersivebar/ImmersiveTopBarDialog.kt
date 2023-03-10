package com.frizzle.immersivebar

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup

/**
 * Created by Frizzle
 * on 2023/03/09
 * 顶部弹窗统一处理沉浸式导状态
 */
open class ImmersiveTopBarDialog : AlertDialog {
    constructor(context: Context) : super(context, R.style.ImmersiveBarDialog)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.attributes?.run {
            windowAnimations = R.style.TopDialog
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            gravity = Gravity.TOP
        }
        fitImmersiveBar()
    }

    /**
     * 处理沉浸式导航栏
     */
    protected open fun fitImmersiveBar() {
        immersiveStatusBar()
    }
}