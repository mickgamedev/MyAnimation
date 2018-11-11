package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator

class AccelerateRocketAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val animator = ValueAnimator.ofFloat(0f,-screenHeight)
        animator.interpolator = AccelerateInterpolator(1.5f)
        animator.duration = DEFAULT_ANIMATION_DURATION

        animator.addUpdateListener {
            val value = it.animatedValue as Float

            binding.apply {
                rocket.translationY = value
                info.text = "translationY = %.0f".format(value)
                time.text = "current time = ${it.currentPlayTime} mils"
            }
        }

        animator.start()
    }

}