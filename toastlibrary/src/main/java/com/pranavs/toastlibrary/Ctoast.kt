package com.pranavs.toastlibrary

import android.app.Activity
import android.graphics.Typeface
import android.os.CountDownTimer
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.pranavs.toastlibrary.utils.AppUtils
import com.pranavs.toastlibrary.utils.GetToastIconImage
import com.pranavs.toastlibrary.utils.IconSelector
import com.pranavs.toastlibrary.utils.SetToastPosition
import java.lang.ref.WeakReference

class Ctoast(private val getMContext: Activity) {

    var SUCCESS = 1
    var WARNING = 2
    var ERROR = 3
    var INFO = 4
    var DEFAULT = 5
    var CONFUSING = 6
    //
    internal var mContext: WeakReference<Activity>? = null
    internal var mDuration: Int = 0
    internal var isRemoveCurveEnabled: Boolean = false
    internal var mToastMessege: String? = null
    internal var mBackGroundColor: Int? = null
    internal var mCustomGravity: CustomGravity? = null
    internal var mTextColor: Int? = null
    internal var mIsImageVisible: Boolean = false
    var mCustomStyleIsCalled: Boolean = false
    internal var isBoldText: Boolean = false
    internal var mCustomStyles: CustomStyles? = null
    internal var mToastIcon: Int? = null

    init {
        this.mContext = WeakReference(getMContext)
        mCustomGravity = CustomGravity.GRAVITY_NORMAL
        mBackGroundColor = ContextCompat.getColor(mContext!!.get()!!, R.color.materialBlue)
        mTextColor = ContextCompat.getColor(mContext!!.get()!!, R.color.materialWhite)
    }

    /**
     * set bold text
     */
    fun setBoldText(isBoldText: Boolean): Ctoast {
        this.isBoldText = isBoldText
        return this
    }

    /**
     * Title of toast Messege
     */

    fun title(title: String): Ctoast {
        mToastMessege = title
        return this
    }

    /**
     * Set duration
     */
    fun duration(duration: Int): Ctoast {
        mDuration = duration
        return this
    }


    /**
     * Remove drawble curve
     */
    fun setCurveOfToast(isCurveEnabled: Boolean): Ctoast {
        isRemoveCurveEnabled = isCurveEnabled
        return this
    }


    /**
     * Set user drawable
     */
    fun setToastImage(mToastIcon: Int): Ctoast {
        this.mToastIcon = mToastIcon
        return this
    }

    /**
     * Set text color
     */
    fun textColor(textColor: Int): Ctoast {
        mTextColor = ContextCompat.getColor(mContext!!.get()!!, textColor)
        return this
    }

    /**
     * set is imageViewVisible
     */
    fun showToastImage(showToastImage: Boolean): Ctoast {
        mIsImageVisible = showToastImage
        return this
    }

    /**
     * set Toast Item BackGround color
     */
    fun setBackGroundColor(mBackGroundColor: Int): Ctoast {
        this.mBackGroundColor = ContextCompat.getColor(mContext!!.get()!!, mBackGroundColor)
        return this
    }


    /**
     * set gravity of item
     */
    fun setGravity(mCustomGravity: CustomGravity): Ctoast {
        this.mCustomGravity = mCustomGravity
        return this
    }


    /**
     * This method will overide everything
     */
    fun setCustomStyle(mStyle: CustomStyles): Ctoast {
        mCustomStyleIsCalled = true
        mCustomStyles = mStyle
        return this
    }


    fun showToast(): Ctoast {
        val inflater: LayoutInflater = mContext!!.get()!!.layoutInflater
        val layouttoast: View = LayoutInflater.from(mContext!!.get()).inflate(
            R.layout.toast_layout, null, false
        )
        val imageView: ImageView = layouttoast.findViewById(R.id.imageView)
        val textView =
            layouttoast.findViewById<View>(R.id.texttoast) as TextView
        val textViewRoot =
            layouttoast.findViewById<View>(R.id.toastcustom) as LinearLayout
        mToastMessege!!.let {
            textView.text = mToastMessege!!
        }

        if (mCustomStyleIsCalled) {
            mTextColor?.let {
                textView.setTextColor(mTextColor!!)
            }
            textViewRoot.background = DrawbleSelection(
                mContext = mContext!!.get()!!,
                mCustomStyles = mCustomStyles!!,
                isRemoveCurveEnabled = isRemoveCurveEnabled,
                mCustomStyleIsCalled = mCustomStyleIsCalled
            ).drawItem()
            imageView.background = IconSelector(
                mContext = mContext!!.get()!!,
                mCustomStyles = mCustomStyles!!
            ).getIconObject()
            imageView.visibility = View.VISIBLE
        } else {
            if (isRemoveCurveEnabled)
                mBackGroundColor!!.let {
                    textViewRoot.background =
                        AppUtils(mContext = mContext!!.get()!!).getDrawableWithBlendMode(
                            R.drawable.rect_shape_normal,
                            mBackGroundColor!!
                        )
                }
            else mBackGroundColor!!.let {
                textViewRoot.background =
                    AppUtils(mContext = mContext!!.get()!!).getDrawableWithBlendMode(
                        R.drawable.rect_shape_curved,
                        mBackGroundColor!!
                    )
            }
            mTextColor?.let {
                textView.setTextColor(mTextColor!!)
            }
            mIsImageVisible.let {
                if (it) {
                    imageView.visibility = View.VISIBLE
                } else imageView.visibility = View.GONE
            }
            mToastIcon?.let {
                if (mToastIcon != null) imageView.background = ContextCompat.getDrawable(
                    mContext!!.get()!!,
                    mToastIcon!!
                )
            }
        }

        isBoldText.let {
            if (isBoldText)
                textView.setTypeface(Typeface.DEFAULT_BOLD)
            else textView.setTypeface(Typeface.DEFAULT)
        }

        val mytoastView = mCustomGravity!!.let {
            SetToastPosition(
                Toast(mContext!!.get()!!), mContext = mContext!!.get()!!,
                mCustomGravity = mCustomGravity!!, mView = textViewRoot
            ).setToastMessegeGravity()
        }
        mytoastView.view = layouttoast
        mytoastView.duration = Toast.LENGTH_LONG
        mytoastView.show()
        return this
    }
}