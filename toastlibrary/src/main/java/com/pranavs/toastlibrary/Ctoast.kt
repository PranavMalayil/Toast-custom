package com.pranavs.toastlibrary

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import java.lang.ref.WeakReference

class Ctoast {

    var SUCCESS = 1
    var WARNING = 2
    var ERROR = 3
    var INFO = 4
    var DEFAULT = 5
    var CONFUSING = 6

    internal var mContext: WeakReference<Activity>? = null
    internal var mDuration: Int = 0
    internal var mToastMessege: String? = null
    internal var mBackGroundColor: Int? = null
    internal var mTextColor: Int? = null
    internal var mIsImageVisible: Boolean = false


    constructor(mContext: Activity) {
        this.mContext = WeakReference(mContext)
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


    fun showToast(): Ctoast {
        val inflater: LayoutInflater = mContext!!.get()!!.layoutInflater
        val layouttoast: View = inflater.inflate(
            R.layout.toast_layout, mContext!!.get()!!.findViewById(R.id.toastcustom)
        )
        val textView =
            layouttoast.findViewById<View>(R.id.texttoast) as TextView
        val textViewRoot =
            layouttoast.findViewById<View>(R.id.toastcustom) as ConstraintLayout
        mTextColor!!.let {
            textView.setTextColor(mTextColor!!)
        }
        mToastMessege!!.let {
            textView.text = mToastMessege!!
        }

        mBackGroundColor!!.let {
            textViewRoot.setBackgroundColor(mBackGroundColor!!)
        }

        val mytoastView = Toast(mContext!!.get())
        mytoastView.view = layouttoast
        mDuration!!.let {
            mytoastView.duration = mDuration
        }
        mytoastView.show()
        return this
    }


}