package com.frizzle.bar

import android.content.Context
import android.os.Bundle
import com.frizzle.immersivebar.ImmersiveBottomBarDialog

/**
 * Created by liuweijun
 * on 2023/3/9
 */
class BottomDialog(mContext: Context): ImmersiveBottomBarDialog(mContext) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog)
    }
}