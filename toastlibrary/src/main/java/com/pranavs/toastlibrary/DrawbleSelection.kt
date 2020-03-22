package com.pranavs.toastlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat

class DrawbleSelection(
    private val mContext: Context,
    private val mCustomStyles: CustomStyles
) : View(mContext) {

    var drawbleGet: GradientDrawable = GradientDrawable()
    fun drawItem(): Drawable {

        val mReturnCustomStyleColor = ReturnCustomStyleColor(mCustomStyles, mContext = mContext)
        if (mReturnCustomStyleColor.isNormalDrawble()) {
            drawbleGet.shape = GradientDrawable.RECTANGLE
            var mFloat: FloatArray = FloatArray(8)
            mFloat[0] = 36f
            mFloat[1] = 36f
            mFloat[2] = 36f
            mFloat[3] = 36f
            mFloat[4] = 36f
            mFloat[5] = 36f
            mFloat[6] = 36f
            mFloat[7] = 36f
            drawbleGet.cornerRadii = mFloat
            drawbleGet.setColor(mReturnCustomStyleColor.setNormalDrawbleColor())
            return drawbleGet
        } else {
            val mCreateDrawbleWithBlendMode = CreateDrawbleWithBlendMode(mCustomStyles, mContext)
            return mCreateDrawbleWithBlendMode.createDrawbleBlendMode()
        }
    }

}