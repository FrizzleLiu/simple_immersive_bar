package com.frizzle.immersivebar

import android.app.Dialog
import android.graphics.Color
import android.os.Build
import android.view.*
import androidx.core.view.ViewCompat

/**
 * 隐藏导航栏
 */
fun Dialog.immersiveNavigationBar(navigationBarColor: Int = Color.TRANSPARENT) {
    val window = window ?: return
    //防止系统栏隐藏时内容区域大小发生变化
    var uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //需要设置这个才能设置状态栏和导航栏颜色
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = false
    }
    window.navigationBarColor = navigationBarColor
    uiFlags = initBarFlags(uiFlags, window)
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
fun Dialog.immersiveStatusBar(statusBarColor: Int = Color.TRANSPARENT) {
    val window = window ?: return
    //防止系统栏隐藏时内容区域大小发生变化
    var uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //需要设置这个才能设置状态栏和导航栏颜色
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isStatusBarContrastEnforced = false
    }
    window.statusBarColor = statusBarColor
    uiFlags = initBarFlags(uiFlags, window)
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

// 设置全屏显示的Flags
private fun initBarFlags(uiFlags: Int, window: Window): Int {
    //获得默认导航栏颜色
    var uiFlags = uiFlags
    //Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态栏遮住。
    uiFlags = uiFlags or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    //Activity全屏显示，但导航栏不会被隐藏覆盖，导航栏依然可见，Activity底部布局部分会被导航栏遮住。
    uiFlags = uiFlags or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //导航栏暗色图标
    uiFlags = uiFlags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    //需要设置这个才能设置状态栏和导航栏颜色
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    return uiFlags
}