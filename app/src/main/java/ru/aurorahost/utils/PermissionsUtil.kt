package ru.aurorahost.utils

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun registerPermissions(
    fragment: Fragment,
    initOSM: () -> Unit,
): ActivityResultLauncher<Array<String>> {
    return fragment.registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (it[Manifest.permission.ACCESS_FINE_LOCATION] == true) {
            initOSM()
        } else {
            fragment.showToast("Location access denied. Enable for full map features.")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
fun checkLocationPermission(
    context: FragmentActivity,
    initOSM: () -> Unit,
    locationPermissionRequest: ActivityResultLauncher<Array<String>>
) {
    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
        checkPermissionsVersionQ(context, initOSM, locationPermissionRequest)
    } else {
        checkPermissions(context, initOSM, locationPermissionRequest)
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
private fun checkPermissionsVersionQ(
    context: FragmentActivity,
    initOSM: () -> Unit,
    locationPermissionRequest: ActivityResultLauncher<Array<String>>
) {
    if (checkPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) && checkPermission(
            context,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
    ) {
        initOSM()
    } else {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        )
    }
}

private fun checkPermissions(
    context: FragmentActivity,
    initOSM: () -> Unit,
    locationPermissionRequest: ActivityResultLauncher<Array<String>>
) {
    if (checkPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) && checkPermission(
            context,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
    ) {
        initOSM()
    } else {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
            )
        )
    }
}

private fun checkPermission(context: FragmentActivity, permission: String): Boolean {
    return when (PackageManager.PERMISSION_GRANTED) {
        ContextCompat.checkSelfPermission(context, permission) -> true
        else -> false
    }
}
