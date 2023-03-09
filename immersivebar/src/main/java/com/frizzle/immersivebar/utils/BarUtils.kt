package com.frizzle.immersivebar.utils

import android.content.Context

/**
 * Created by Frizzle
 * on 2023/03/09
 */
object BarUtils {
    fun getNavigationBarHeight(context: Context): Int{
        val resources = context.resources
        val resourcesId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourcesId)
    }
}