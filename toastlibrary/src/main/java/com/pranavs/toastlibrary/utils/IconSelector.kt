package com.pranavs.toastlibrary.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.pranavs.toastlibrary.CustomStyles
import com.pranavs.toastlibrary.R

class IconSelector(
    private val mContext: Context,
    private val mCustomStyles: CustomStyles
) {

    fun getIconObject(): Drawable {
        when (mCustomStyles) {
            CustomStyles.STYLE_SUCCESS,
            CustomStyles.STYLE_SUCCESS_CURVED ->
                return ContextCompat.getDrawable(mContext, R.drawable.ic_tick)!!
            CustomStyles.STYLE_WARNING_CURVED,
            CustomStyles.STYLE_WARNING -> return ContextCompat.getDrawable(
                mContext,
                R.drawable.ic_alert
            )!!
            CustomStyles.STYLE_MESSEGE_CURVED,
            CustomStyles.STYLE_MESSEGE -> return ContextCompat.getDrawable(
                mContext,
                R.drawable.ic_mail
            )!!
            CustomStyles.STYLE_ERROR_CURVED,
            CustomStyles.STYLE_ERROR -> return ContextCompat.getDrawable(
                mContext,
                R.drawable.ic_error
            )!!
            CustomStyles.STYLE_CONFUSE_CURVED,
            CustomStyles.STYLE_CONFUSE -> return ContextCompat.getDrawable(
                mContext,
                R.drawable.ic_confusion
            )!!
            CustomStyles.STYLE_INFO_CURVED,
            CustomStyles.STYLE_INFO -> return ContextCompat.getDrawable(
                mContext,
                R.drawable.ic_info
            )!!
            CustomStyles.STYLE_NORMAL_CURVED,
            CustomStyles.STYLE_NORMAL -> return ContextCompat.getDrawable(
                mContext,
                R.drawable.ic_alert
            )!!
        }
    }
}