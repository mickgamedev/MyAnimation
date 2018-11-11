package ru.yandex.dunaev.mick.myanimation.animations

import android.view.View

class LaunchAndSpinViewPropertyAnimatorAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        binding.rocket.animate()
            .translationY(-screenHeight)
            .rotationBy(360f)
            .setDuration(DEFAULT_ANIMATION_DURATION)
            .start()
    }

}