package com.frizzle.bar

import android.content.Context
import android.os.Bundle
import com.frizzle.immersivebar.ImmersiveTopBarDialog

/**
 * Created by Frizzle
 * on 2023/3/9
 */
class TopDialog(mContext: Context) : ImmersiveTopBarDialog(mContext) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog)
    }
}