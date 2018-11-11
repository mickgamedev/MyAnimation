package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator

class LaunchRocketObjectAnimatorAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val animator = ObjectAnimator.ofFloat(binding.rocket, "translationY", 0f, -screenHeight)
        animator.duration = DEFAULT_ANIMATION_DURATION
        animator.interpolator = AccelerateInterpolator(1.5f)

        animator.start()
    }
}