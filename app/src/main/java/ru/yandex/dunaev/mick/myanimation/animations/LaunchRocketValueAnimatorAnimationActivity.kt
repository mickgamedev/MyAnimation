package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator

class LaunchRocketValueAnimatorAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val valueAnimator = ValueAnimator.ofFloat(0f, -screenHeight)
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = DEFAULT_ANIMATION_DURATION
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            binding.apply {
                rocket.translationY = value
                info.text = "translationY = %.0f".format(value)
                time.text = "current time = ${it.currentPlayTime} mils"
            }

        }


        valueAnimator.start()
    }

}