package com.frizzle.bar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.frizzle.immersivebar.immersiveNavigationBar

/**
 * Created by Frizzle
 * on 2023/3/9
 */
class BottomDialogFragment: DialogFragment(R.layout.layout_dialog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val attributes = dialog?.window?.attributes
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes?.run {
            windowAnimations = R.style.BottomDialog
            width = ViewGroup.LayoutParams.MATCH_PARENT
            gravity = Gravity.BOTTOM
        }

        immersiveNavigationBar()
    }
}