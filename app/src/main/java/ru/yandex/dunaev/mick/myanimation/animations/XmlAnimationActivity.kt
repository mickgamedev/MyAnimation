package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.view.View
import ru.yandex.dunaev.mick.myanimation.R

class XmlAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val rocketAnimator = AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink)
        rocketAnimator.setTarget(binding.rocket)
        val dogeAnimator = AnimatorInflater.loadAnimator(this,R.animator.jump_and_blink)
        dogeAnimator.setTarget(binding.doge)
        val bothAnimatorSet = AnimatorSet()
        bothAnimatorSet.playTogether(rocketAnimator,dogeAnimator)
        bothAnimatorSet.duration = DEFAULT_ANIMATION_DURATION

        bothAnimatorSet.start()
    }

}