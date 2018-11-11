package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

class LaunchAndSpinAnimatiorSetAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val position = ObjectAnimator.ofFloat(binding.rocket,"translationY",0f,-screenHeight)
        val rotation = ObjectAnimator.ofFloat(binding.rocket, "rotation",0f,360f)
        val animator = AnimatorSet()
        animator.play(position).with(rotation)
        animator.duration = DEFAULT_ANIMATION_DURATION

        animator.start()

    }

}