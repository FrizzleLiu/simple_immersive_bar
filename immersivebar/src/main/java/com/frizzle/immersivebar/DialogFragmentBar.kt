package com.frizzle.immersivebar

import android.graphics.Color
import android.os.Build
import android.view.*
import androidx.core.view.ViewCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

/**
 * 获取状态栏高度
 */
val Fragment.statusHeight: Int
    get() {
        val resourceId =
            resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId)
        }
        return 0
    }


fun DialogFragment.setStatusBarColor(color: Int) {
    val window = this.dialog?.window ?: return
    val statusBarView = window.decorView.findViewById<View?>(R.id.status_bar_view)
    if (color == 0 && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        statusBarView?.setBackgroundColor(BAR_TRANSPARENT_COLOR)
    } else {
        statusBarView?.setBackgroundColor(color)
    }
}

/**
 * 隐藏导航栏
 */
fun DialogFragment.immersiveNavigationBar(navigationBarColor: Int = Color.WHITE) {
    val window = dialog?.window ?: return
    //防止系统栏隐藏时内容区域大小发生变化
    var uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //需要设置这个才能设置状态栏和导航栏颜色
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isStatusBarContrastEnforced = false
    }
    window.navigationBarColor = navigationBarColor
    window.decorView.systemUiVisibility = uiFlags

    // Android 11及以上版本
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val contentView = window.decorView.findViewById<View>(android.R.id.content)
        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetsController?.isAppearanceLightNavigationBars = true
        val insetsController = (contentView as ViewGroup).windowInsetsController
        insetsController?.show(WindowInsets.Type.navigationBars())
        insetsController?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}


/**
 * 隐藏状态栏
 */
fun DialogFragment.immersiveStatusBar(statusBarColor: Int = Color.WHITE) {
    val window = dialog?.window ?: return
    //防止系统栏隐藏时内容区域大小发生变化
    var uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //需要设置这个才能设置状态栏和导航栏颜色
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isStatusBarContrastEnforced = false
    }
    window.statusBarColor = statusBarColor
    window.decorView.systemUiVisibility = uiFlags

    // Android 11及以上版本
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val contentView = window.decorView.findViewById<View>(android.R.id.content)
        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetsController?.isAppearanceLightStatusBars = true
        val insetsController = (contentView as ViewGroup).windowInsetsController
        insetsController?.show(WindowInsets.Type.statusBars())
        insetsController?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}