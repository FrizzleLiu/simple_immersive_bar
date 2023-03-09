package com.frizzle.immersivebar

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.children
import com.frizzle.immersivebar.utils.BarUtils

/**
 * Created by Frizzle
 * on 2023/03/09
 * 底部弹窗统一处理沉浸式导航栏
 */
open class ImmersiveBottomBarDialog : AlertDialog {
    constructor(context: Context) : super(context, R.style.ImmersiveBarBottomDialog)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window?.attributes?.run {
            height = ViewGroup.LayoutParams.WRAP_CONTENT
        }
        fitImmersiveBar()
    }

    /**
     * 处理沉浸式导航栏
     * 默认增加 paddingBottom
     */
    protected open fun fitImmersiveBar() {
        immersiveNavigationBar()
        val contentView = window?.findViewById<ViewGroup>(android.R.id.content)
        contentView?.let {
            val child = it.children.firstOrNull()
            val navigationBarHeight = BarUtils.getNavigationBarHeight(context)
            val childPaddingBottom = child?.paddingBottom ?: 0
            val paddingBottom =
                if (childPaddingBottom > navigationBarHeight) childPaddingBottom else navigationBarHeight + childPaddingBottom
            child?.setPadding(child.paddingLeft, child.paddingTop, child.paddingRight, paddingBottom)
        }
    }
}