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
open class ImmersiveBottomDialogFragment(@LayoutRes contentLayoutId: Int) : DialogFragment(contentLayoutId) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val attributes = dialog?.window?.attributes
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes?.run {
            windowAnimations = R.style.BottomDialog
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            gravity = Gravity.BOTTOM
        }

        immersiveNavigationBar()
    }
}