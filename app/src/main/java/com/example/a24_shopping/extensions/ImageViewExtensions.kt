package com.example.a24_shopping.extensions

import android.annotation.SuppressLint
import android.media.Image
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

internal fun Image.clear() = Glide.with(context).clear(this)

@SuppressLint("CheckResult")
internal fun ImageView.loadCenterCrop(url: String, corner: Float = 0f){
    Glide.with(this)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply {
            if (corner > 0) transforms(CenterCrop(), RoundedCorners(corner.fromDpToPx()))
        }
        .into(this)
}

@SuppressLint("CheckResult")
internal fun ImageView.load(url: String, corner: Float = 0f) {
    Glide.with(this)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply {
            if (corner > 0) transforms(RoundedCorners(corner.fromDpToPx()))
        }
        .into(this)
}