package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator

class FlyWithDogeAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val position = ValueAnimator.ofFloat(0f,-screenHeight)
        position.addUpdateListener {
            val value = it.animatedValue as Float
            with(binding){
                rocket.translationY = value
                doge.translationY = value
            }
        }
        position.interpolator = AccelerateInterpolator(1.5f)

        val rotation = ObjectAnimator.ofFloat(binding.doge,"rotation",0f,360f)

        val animator = AnimatorSet()
        animator.play(position).with(rotation)
        animator.duration = DEFAULT_ANIMATION_DURATION

        animator.start()

    }

}