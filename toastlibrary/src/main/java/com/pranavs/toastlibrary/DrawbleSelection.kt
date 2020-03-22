package com.pranavs.toastlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat

class DrawbleSelection(private val mContext: Context,
                       private val mBackGroundColor:Int) : View(mContext) {

    var drawbleGet: GradientDrawable = GradientDrawable()
    fun drawItem(): Drawable {
        drawbleGet.shape = GradientDrawable.RECTANGLE
        var mFloat: FloatArray = FloatArray(8)
        mFloat[0] = 16f
        mFloat[1] = 16f
        mFloat[2] = 16f
        mFloat[3] = 16f
        mFloat[4] = 16f
        mFloat[5] = 16f
        mFloat[6] = 16f
        mFloat[7] = 16f
        drawbleGet.cornerRadii = mFloat
        drawbleGet.setColor(mBackGroundColor)
        return drawbleGet
    }

}