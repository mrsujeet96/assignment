package com.demo.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.demo.R
import android.widget.ProgressBar

object CommonProgressUtil {
    // progress bar handling
    fun showProgress(activity: Activity?): Dialog {
        val dialog = Dialog(activity!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(
            ColorDrawable(0))
        dialog.setContentView(R.layout.common_progress_bar)
        val progressBar = dialog.findViewById<ProgressBar>(R.id.progressBar)
        //        progressBar.getIndeterminateDrawable().setColorFilter(activity.getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        dialog.setCancelable(false)
        dialog.show()
        return dialog
    }
}