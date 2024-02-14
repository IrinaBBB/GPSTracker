package ru.aurorahost.utils

import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import ru.aurorahost.R


// REPLACE FRAGMENTS //
fun Fragment.openFragment(fragment: Fragment) {
    if ((activity as AppCompatActivity).supportFragmentManager.fragments.isNotEmpty()) {
        if ((activity as AppCompatActivity).supportFragmentManager.fragments[0].javaClass == fragment.javaClass) return
    }
    (activity as AppCompatActivity).supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.placeHolder, fragment)
        .commit()
}

fun AppCompatActivity.openFragment(fragment: Fragment) {
    Log.d("MyLog", "Frag name: ${fragment.javaClass}")
    if (supportFragmentManager.fragments.isNotEmpty()) {
        if (supportFragmentManager.fragments[0].javaClass == fragment.javaClass) return
    }
    supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.placeHolder, fragment)
        .commit()
}

// SHOW TOASTS //

fun Fragment.showToast(text: String) {
    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

// CHECK PERMISSIONS //
















