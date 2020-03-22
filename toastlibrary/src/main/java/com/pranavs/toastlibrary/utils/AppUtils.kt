package com.pranavs.toastlibrary.utils

import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.content.ContextCompat
import com.pranavs.toastlibrary.R

class AppUtils(private val mContext: Context) {

    /**
     * Retrns the drawble with passed param color
     *
     * @param drawable
     * @param green
     * @return
     */
    fun getDrawableWithBlendMode(green: Int): Drawable? {
        val mDrawable = ContextCompat.getDrawable(mContext, R.drawable.rect_shape_curved)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            mDrawable!!.colorFilter = BlendModeColorFilter(green, BlendMode.SRC_ATOP)
            mDrawable
        } else {
            mDrawable!!.setColorFilter(
                green,
                PorterDuff.Mode.SRC_ATOP
            )
            mDrawable
        }
    }
}