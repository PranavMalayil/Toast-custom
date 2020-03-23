package com.pranavs.toastlibrary

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View

class DrawbleSelection(
    private val mContext: Context,
    private val mCustomStyles: CustomStyles,
    private val isRemoveCurveEnabled: Boolean,
    private val mCustomStyleIsCalled: Boolean
) : View(mContext) {

    var drawbleGet: GradientDrawable = GradientDrawable()
    fun drawItem(): Drawable {

        val mReturnCustomStyleColor = ReturnCustomStyleColor(mCustomStyles, mContext = mContext)
        if (mReturnCustomStyleColor.isNormalDrawble()) {
            drawbleGet.shape = GradientDrawable.RECTANGLE
            var mFloat: FloatArray = FloatArray(8)
            if (isRemoveCurveEnabled) {
                mFloat[0] = 36f
                mFloat[1] = 36f
                mFloat[2] = 36f
                mFloat[3] = 36f
                mFloat[4] = 36f
                mFloat[5] = 36f
                mFloat[6] = 36f
                mFloat[7] = 36f
            } else {
                if (mCustomStyleIsCalled && isRemoveCurveEnabled) {
                    mFloat[0] = 36f
                    mFloat[1] = 36f
                    mFloat[2] = 36f
                    mFloat[3] = 36f
                    mFloat[4] = 36f
                    mFloat[5] = 36f
                    mFloat[6] = 36f
                    mFloat[7] = 36f
                } else {
                    mFloat[0] = 0f
                    mFloat[1] = 0f
                    mFloat[2] = 0f
                    mFloat[3] = 0f
                    mFloat[4] = 0f
                    mFloat[5] = 0f
                    mFloat[6] = 0f
                    mFloat[7] = 0f
                }
            }
            drawbleGet.cornerRadii = mFloat
            drawbleGet.setColor(mReturnCustomStyleColor.setNormalDrawbleColor())
            return drawbleGet
        } else {
            val mCreateDrawbleWithBlendMode = CreateDrawbleWithBlendMode(
                mCustomStyles, mContext,
                isRemoveCurveEnabled
            )
            return mCreateDrawbleWithBlendMode.createDrawbleBlendMode()
        }
    }

}