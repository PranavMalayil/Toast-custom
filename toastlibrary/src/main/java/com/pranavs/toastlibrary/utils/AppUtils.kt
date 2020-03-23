package com.pranavs.toastlibrary.utils

import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.pranavs.toastlibrary.R

class AppUtils(private val mContext: Context) {

    val TAG: String = AppUtils::class.simpleName.toString()
    /**
     * Retrns the drawble with passed param color
     *
     * @param drawable
     * @param green
     * @return
     */
    fun getDrawableWithBlendMode(mDrawbleGet: Int, green: Int): Drawable? {
        val mDrawable = ContextCompat.getDrawable(mContext, mDrawbleGet)!!.mutate()
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            mDrawable.colorFilter = BlendModeColorFilter(green, BlendMode.SRC_ATOP)
            mDrawable
        } else {
            mDrawable.setColorFilter(
                ContextCompat.getColor(mContext,green),
                PorterDuff.Mode.SRC_ATOP
            )
            mDrawable
        }
    }

    /**
     * Returns pixel to db
     */
    fun getDisplayMatrics(): DisplayMetrics {
        val displayMetrics: DisplayMetrics = mContext.resources.displayMetrics
        return displayMetrics
    }


}