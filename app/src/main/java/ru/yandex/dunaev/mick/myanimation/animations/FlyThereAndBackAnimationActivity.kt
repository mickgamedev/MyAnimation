package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationSet

class FlyThereAndBackAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val rocket = ObjectAnimator.ofFloat(binding.rocket,"translationY",0f,-screenHeight)
        val doge = ObjectAnimator.ofFloat(binding.doge,"translationY",0f,-screenHeight)
        val animator = AnimatorSet()
        animator.play(rocket).with(doge)
        animator.interpolator = AccelerateInterpolator(1.5f)
        animator.duration = 500L
        rocket.repeatMode = ValueAnimator.REVERSE
        doge.repeatMode = ValueAnimator.REVERSE
        rocket.repeatCount = 3
        doge.repeatCount = 3

        animator.start()

    }

}