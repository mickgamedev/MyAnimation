package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import ru.yandex.dunaev.mick.myanimation.R

class ColorAnimationActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.layout.setBackgroundColor(ContextCompat.getColor(this, R.color.background_from))
    }

    override fun onStartAnimation(view: View) {
        val animator = ObjectAnimator.ofObject(binding.layout,
            "backgroundColor",
            ArgbEvaluator(),
            ContextCompat.getColor(this, R.color.background_from),
            ContextCompat.getColor(this,R.color.background_to))

        animator.duration = DEFAULT_ANIMATION_DURATION

        animator.repeatCount = 1
        animator.repeatMode = ValueAnimator.REVERSE

        animator.start()
    }

}