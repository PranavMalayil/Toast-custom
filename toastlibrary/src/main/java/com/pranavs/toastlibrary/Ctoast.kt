package com.pranavs.toastlibrary

import android.app.Activity
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.pranavs.toastlibrary.utils.AppUtils
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
    internal var mToastMessege: String? = null
    internal var mBackGroundColor: Int? = null
    internal var mTextColor: Int? = null
    internal var mIsImageVisible: Boolean = false
    var mCustomStyleIsCalled: Boolean = false
    internal var isBoldText: Boolean = false
    internal var mCustomStyles: CustomStyles? = null

    init {
        this.mContext = WeakReference(getMContext)
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
        val textView =
            layouttoast.findViewById<View>(R.id.texttoast) as TextView
        val textViewRoot =
            layouttoast.findViewById<View>(R.id.toastcustom) as LinearLayout
        mToastMessege!!.let {
            textView.text = mToastMessege!!
        }

        if (mCustomStyleIsCalled) {
            mTextColor = ContextCompat.getColor(mContext!!.get()!!, R.color.materialWhite)
            textView.setTextColor(mTextColor!!)
            val mDrawbleSelection = DrawbleSelection(
                mContext = mContext!!.get()!!,
                mCustomStyles = mCustomStyles!!
            ).drawItem()
            textViewRoot.background = mDrawbleSelection
        } else {
            mBackGroundColor!!.let {
                textViewRoot.background =
                    AppUtils(mContext = mContext!!.get()!!).getDrawableWithBlendMode(
                        mBackGroundColor!!
                    )
            }
            mTextColor!!.let {
                textView.setTextColor(mTextColor!!)
            }
        }

        isBoldText.let {
            if (isBoldText)
                textView.setTypeface(Typeface.DEFAULT_BOLD)
            else textView.setTypeface(Typeface.DEFAULT)
        }

        val mytoastView = Toast(mContext!!.get())
        mytoastView.view = layouttoast
        mytoastView.duration = Toast.LENGTH_LONG
        mytoastView.show()
        return this
    }


}