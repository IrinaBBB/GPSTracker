package ru.aurorahost.utils

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import ru.aurorahost.R

object DialogManager {
    fun showLocationEnabledDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context).create()
        builder.setTitle(R.string.location_disabled_title)
        builder.setMessage(context.getString(R.string.location_disabled_message))
        builder.setButton(AlertDialog.BUTTON_POSITIVE, "Yes") { _, _ ->
            listener.onClick()
        }
        builder.setButton(AlertDialog.BUTTON_NEGATIVE, "No") { _, _ ->
            builder.dismiss()
        }
        builder.show()
    }

    interface Listener {
        fun onClick()
    }
}