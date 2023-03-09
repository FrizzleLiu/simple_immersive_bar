package com.frizzle.immersivebar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.frizzle.immersivebar.immersiveStatusBar

/**
 * Created by Frizzle
 * on 2023/3/9
 */
open class ImmersiveTopDialogFragment(@LayoutRes contentLayoutId: Int) : DialogFragment(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.ImmersiveBarDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val attributes = dialog?.window?.attributes
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes?.run {
            windowAnimations = R.style.TopDialog
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            gravity = Gravity.TOP
        }

        immersiveStatusBar()
    }
}