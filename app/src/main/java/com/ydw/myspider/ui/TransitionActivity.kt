package com.ydw.myspider.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ydw.base.ext.checkSelfPermissionCompat
import com.ydw.base.ext.requestPermissionsCompat
import com.ydw.base.ext.shouldShowRequestPermissionRationaleCompat
import com.ydw.base.ext.showSnackbar
import com.ydw.base.utils.CommonUtils
import com.ydw.myspider.R
import com.ydw.myspider.app.ConstantsImageUrl
import com.ydw.myspider.ui.activity.MainActivity
import kotlinx.android.synthetic.main.activity_transition.*
import java.util.*

/**
 * Created by Administrator on 2018/3/22 0022.
 */
class TransitionActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_STORAGE = 0
    private var isIn: Boolean = false
    private var animationEnd: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)
    }

    override fun onResume() {
        super.onResume()
        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0) {
            finish()
            return
        }

        val i=Random().nextInt(ConstantsImageUrl().TRANSITION_URLS.size)
        // 先显示默认图
        iv_defult_pic.setImageDrawable(resources.getDrawable(R.drawable.img_transition_default))
        val options = RequestOptions()
                .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)
        Glide.with(this)
                .load(ConstantsImageUrl().TRANSITION_URLS[i])
                .apply(options)
                .into(iv_pic)
        checkPermission()

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_STORAGE) {
            // Request for camera permission.
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start camera preview Activity.
                transition.showSnackbar(R.string.storage_permission_granted, Snackbar.LENGTH_SHORT)

                Handler().postDelayed({ iv_defult_pic.visibility = View.GONE }, 1500)
                Handler().postDelayed({ toMainActivity() }, 3500)
//                tv_jump.setOnClickListener({toMainActivity()})
            } else {
                // Permission request was denied.
                transition.showSnackbar(R.string.storage_permission_denied, Snackbar.LENGTH_SHORT)
            }
        }
    }

    private fun checkPermission() {
        // Check if the Camera permission has been granted
        tv_jump.setOnClickListener({toMainActivity()})
        if (checkSelfPermissionCompat(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            // Permission is already available, start camera preview
            transition.showSnackbar(R.string.storage_permission_available, Snackbar.LENGTH_SHORT)

            Handler().postDelayed({ iv_defult_pic.visibility = View.GONE }, 1500)
            Handler().postDelayed({ toMainActivity() }, 3500)

        } else {
            // Permission is missing and must be requested.
            requestCameraPermission()
        }
    }

    private fun requestCameraPermission() {
        // Permission has not been granted and must be requested.
        if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.
            transition.showSnackbar(R.string.storage_access_required,
                    Snackbar.LENGTH_INDEFINITE, R.string.ok) {
                requestPermissionsCompat(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        PERMISSION_REQUEST_STORAGE)
            }

        } else {
            transition.showSnackbar(R.string.storage_permission_not_available, Snackbar.LENGTH_SHORT)

            // Request the permission. The result will be received in onRequestPermissionResult().
            requestPermissionsCompat(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST_STORAGE)
        }
    }

    private fun animationEnd() {
        synchronized(this@TransitionActivity) {
            if (!animationEnd) {
                animationEnd = true
                iv_pic.clearAnimation()
                toMainActivity()
            }
        }
    }

    private fun toMainActivity() {
        if (isIn) {
            return
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out)
        finish()
        isIn = true
    }
}