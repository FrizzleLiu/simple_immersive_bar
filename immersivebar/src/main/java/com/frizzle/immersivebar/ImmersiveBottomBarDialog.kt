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
 * 底部弹窗统一处理沉浸式导航栏
 */
open class ImmersiveBottomBarDialog : AlertDialog {
    constructor(context: Context) : super(context, R.style.ImmersiveBarDialog)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.attributes?.run {
            windowAnimations = R.style.BottomDialog
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            gravity = Gravity.BOTTOM
        }
        fitImmersiveBar()
    }

    /**
     * 处理沉浸式导航栏
     */
    protected open fun fitImmersiveBar() {
        immersiveNavigationBar()
        // 如需要可以增加默认的bottom padding值
//        val contentView = window?.findViewById<ViewGroup>(android.R.id.content)
//        contentView?.let {
//            val child = it.children.firstOrNull()
//            val navigationBarHeight = BarUtils.getNavigationBarHeight(context)
//            val childPaddingBottom = child?.paddingBottom ?: 0
//            val paddingBottom =
//                if (childPaddingBottom > navigationBarHeight) childPaddingBottom else navigationBarHeight + childPaddingBottom
//            child?.setPadding(child.paddingLeft, child.paddingTop, child.paddingRight, paddingBottom)
//        }
    }
}