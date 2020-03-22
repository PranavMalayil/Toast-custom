package com.pranavs.toastlibrary

import android.app.Activity
import android.content.Context
import androidx.core.content.ContextCompat

class ReturnCustomStyleColor(
    private val mCustomStyles: CustomStyles,
    private val mContext: Context
) {


    fun isNormalDrawble(): Boolean {
        when (mCustomStyles) {
            CustomStyles.STYLE_CONFUSE_CURVED,
            CustomStyles.STYLE_ERROR_CURVED,
            CustomStyles.STYLE_INFO_CURVED,
            CustomStyles.STYLE_MESSEGE_CURVED,
            CustomStyles.STYLE_SUCCESS_CURVED,
            CustomStyles.STYLE_NORMAL_CURVED,
            CustomStyles.STYLE_WARNING_CURVED -> {
                return false
            }
            else -> return true
        }
    }

    fun setNormalDrawbleColor(): Int {
        when (mCustomStyles) {
            CustomStyles.STYLE_MESSEGE -> {
                return ContextCompat.getColor(
                    mContext,
                    R.color.materialBlue
                )
            }
            CustomStyles.STYLE_ERROR -> return ContextCompat.getColor(
                mContext,
                R.color.materialOrange
            )
            CustomStyles.STYLE_NORMAL -> return ContextCompat.getColor(
                mContext,
                R.color.materialWhite
            )
            CustomStyles.STYLE_CONFUSE -> return ContextCompat.getColor(
                mContext,
                R.color.materialConfuse
            )
            CustomStyles.STYLE_WARNING ->
                return ContextCompat.getColor(
                    mContext,
                    R.color.materialWarning
                )
            CustomStyles.STYLE_SUCCESS ->
                return ContextCompat.getColor(
                    mContext,
                    R.color.materialGreen
                )
            CustomStyles.STYLE_INFO ->
                return ContextCompat.getColor(
                    mContext,
                    R.color.materialInfo
                )
            else -> return ContextCompat.getColor(
                mContext, R.color.materialWhite
            )
        }

    }
}