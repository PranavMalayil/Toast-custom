package com.pranavs.customtoastmessege

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.pranavs.toastlibrary.Ctoast
import com.pranavs.toastlibrary.CustomGravity
import com.pranavs.toastlibrary.CustomStyles

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mCtoast = Ctoast(this)
        mCtoast.title("check")
            .setBackGroundColor(R.color.materialRed)
            .textColor(R.color.materialWhite)
            .setBoldText(true)
            .setCustomStyle(CustomStyles.STYLE_ERROR_CURVED)
            .showToast()

    }
}
