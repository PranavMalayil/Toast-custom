package com.pranavs.toastlibrary

import android.content.Context
import android.graphics.drawable.Drawable
import com.pranavs.toastlibrary.utils.AppUtils

class CreateDrawbleWithBlendMode(
    private val mCustomStyles: CustomStyles,
    private val mContext: Context
) {
    internal var mAppUtils: AppUtils? = null

    init {
        mAppUtils = AppUtils(mContext)
    }

    fun createDrawbleBlendMode(): Drawable {
        when (mCustomStyles) {
            CustomStyles.STYLE_CONFUSE_CURVED ->
                return mAppUtils!!.getDrawableWithBlendMode(R.color.materialConfuse)!!
            CustomStyles.STYLE_ERROR_CURVED -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialOrange)!!
            CustomStyles.STYLE_INFO_CURVED -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialInfo)!!
            CustomStyles.STYLE_MESSEGE_CURVED -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialBlue)!!
            CustomStyles.STYLE_NORMAL_CURVED -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialWhite)!!
            CustomStyles.STYLE_WARNING_CURVED -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialWarning)!!
            CustomStyles.STYLE_SUCCESS_CURVED -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialGreen)!!
            else -> return mAppUtils!!.getDrawableWithBlendMode(R.color.materialWhite)!!
        }
    }
}