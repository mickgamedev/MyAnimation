package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator

class RotateRocketAnimatioinActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val animator = ValueAnimator.ofFloat(0f,360f)
        animator.interpolator = LinearInterpolator()
        animator.duration = DEFAULT_ANIMATION_DURATION

        animator.addUpdateListener {
            val value = it.animatedValue as Float
            binding.apply {
                rocket.rotation = value
                info.text = "rotation = %.0f".format(value)
                time.text = "current time = ${it.currentPlayTime} mils"
            }
        }

        animator.start()
    }

}