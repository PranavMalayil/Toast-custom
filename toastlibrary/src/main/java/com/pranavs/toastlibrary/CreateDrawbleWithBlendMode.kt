package com.pranavs.toastlibrary

import android.content.Context
import android.graphics.drawable.Drawable
import com.pranavs.toastlibrary.utils.AppUtils

class CreateDrawbleWithBlendMode(
    private val mCustomStyles: CustomStyles,
    private val mContext: Context,
    private val removeCurveEnabled: Boolean
) {
    internal var mAppUtils: AppUtils? = null

    init {
        mAppUtils = AppUtils(mContext)
    }

    fun createDrawbleBlendMode(): Drawable {
        when (mCustomStyles) {
            CustomStyles.STYLE_CONFUSE_CURVED -> return isCurveEnabled(R.color.materialConfuse)
            CustomStyles.STYLE_ERROR_CURVED -> return isCurveEnabled(R.color.materialOrange)
            CustomStyles.STYLE_INFO_CURVED -> return isCurveEnabled(R.color.materialInfo)
            CustomStyles.STYLE_MESSEGE_CURVED -> return isCurveEnabled(R.color.materialBlue)
            CustomStyles.STYLE_NORMAL_CURVED -> return isCurveEnabled(R.color.materialWhite)
            CustomStyles.STYLE_WARNING_CURVED -> return isCurveEnabled(R.color.materialWarning)
            CustomStyles.STYLE_SUCCESS_CURVED -> return isCurveEnabled(R.color.materialGreen)
            else -> return isCurveEnabled(R.color.materialWhite)
        }
    }

    fun isCurveEnabled(intColor: Int): Drawable {
        if (removeCurveEnabled)
            return mAppUtils!!.getDrawableWithBlendMode(
                R.drawable.rect_shape_normal,
                intColor
            )!!
        else return mAppUtils!!.getDrawableWithBlendMode(
            R.drawable.rect_shape_curved,
            intColor
        )!!
    }
}