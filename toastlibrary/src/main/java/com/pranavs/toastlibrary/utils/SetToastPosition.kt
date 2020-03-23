package com.pranavs.toastlibrary.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.pranavs.toastlibrary.CustomGravity

class SetToastPosition(
    private val mToast: Toast, private val mContext: Context,
    private val mCustomGravity: CustomGravity,private val mView: View
) : Toast(mContext) {

    fun setToastMessegeGravity(): Toast {
        val displayMatrics: DisplayMetrics = AppUtils(mContext).getDisplayMatrics()
        when (mCustomGravity) {
            CustomGravity.GRAVITY_NORMAL->{
                return mToast
            }
            CustomGravity.GRAVITY_TOP -> {
                mToast.setGravity(Gravity.TOP, 0, 0)
                return mToast
            }
            CustomGravity.GRAVITY_BOTTOM -> {
                mToast.setGravity(Gravity.BOTTOM, 0, 0)
                return mToast
            }
            CustomGravity.GRAVITY_CENTER -> {
                mToast.setGravity(Gravity.CENTER, 0, 0)
                return mToast
            }
            CustomGravity.GRAVITY_TOP_LEFT -> {
                mToast.setGravity(Gravity.BOTTOM, -displayMatrics.widthPixels, 0)
                return mToast
            }
            CustomGravity.GRAVITY_TOP_FULL -> {
                mToast.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK, 0, -displayMatrics.heightPixels)
                return mToast
            }
            CustomGravity.GRAVITY_BOTTOM_LEFT -> {
                mToast.setGravity(Gravity.BOTTOM, -displayMatrics.widthPixels, 0)
                return mToast
            }
            CustomGravity.GRAVITY_BOTTOM_FULL -> {
                mToast.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK, 0, displayMatrics.widthPixels)
                return mToast
            }
            CustomGravity.GRAVITY_TOP_RIGHT -> {
                mToast.setGravity(Gravity.TOP, displayMatrics.widthPixels, 0)
                return mToast
            }
            CustomGravity.GRAVITY_BOTTOM_RIGHT -> {
                mToast.setGravity(Gravity.BOTTOM, displayMatrics.widthPixels, 0)
                return mToast
            }
            CustomGravity.GRAVITY_CENTER_FULL -> {
                mToast.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK, 0, 0)
            }
        }
        return mToast
    }

}