package com.ydw.myspider.view.activity

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.ydw.base.ext.checkSelfPermissionCompat
import com.ydw.base.ext.requestPermissionsCompat
import com.ydw.base.ext.shouldShowRequestPermissionRationaleCompat
import com.ydw.base.ext.showSnackbar
import com.ydw.myspider.R
import com.ydw.myspider.presenter.MainPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

const val PERMISSION_REQUEST_STORAGE = 0
class MainActivity : AppCompatActivity() , MainView{
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        checkPermission()
        presenter.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
            permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_STORAGE) {
            // Request for camera permission.
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start camera preview Activity.
                main_layout.showSnackbar(R.string.storage_permission_granted, Snackbar.LENGTH_SHORT)
//                startCamera()
            } else {
                // Permission request was denied.
                main_layout.showSnackbar(R.string.storage_permission_denied, Snackbar.LENGTH_SHORT)
            }
        }
    }

    private fun checkPermission() {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            // Permission is already available, start camera preview
            main_layout.showSnackbar(R.string.storage_permission_available, Snackbar.LENGTH_SHORT)
//            startCamera()
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
            main_layout.showSnackbar(R.string.storage_access_required,
                    Snackbar.LENGTH_INDEFINITE, R.string.ok) {
                requestPermissionsCompat(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        PERMISSION_REQUEST_STORAGE)
            }

        } else {
            main_layout.showSnackbar(R.string.storage_permission_not_available, Snackbar.LENGTH_SHORT)

            // Request the permission. The result will be received in onRequestPermissionResult().
            requestPermissionsCompat(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST_STORAGE)
        }
    }
}
