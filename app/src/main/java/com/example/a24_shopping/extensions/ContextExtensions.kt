package com.example.a24_shopping.extensions

import android.content.Context
import android.widget.Toast

internal fun Context.toast(message: String) {
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}