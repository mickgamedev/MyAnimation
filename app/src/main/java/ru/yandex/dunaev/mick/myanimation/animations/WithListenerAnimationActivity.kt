package ru.yandex.dunaev.mick.myanimation.animations

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.Toast

class WithListenerAnimationActivity: BaseActivity() {
    override fun onStartAnimation(view: View) {
        val animator = ValueAnimator.ofFloat(0f,-screenHeight)
        animator.duration = 5000L
        animator.interpolator = AccelerateInterpolator(1.5f)
        animator.addUpdateListener {
            val value = it.animatedValue as Float
            binding.apply {
                rocket.translationY = value
                doge.translationY = value
            }
        }
        animator.addListener(object: Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                Toast.makeText(applicationContext,"Doge is on the moon",Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                Toast.makeText(applicationContext,"Doge took off", Toast.LENGTH_SHORT).show()
            }

        })

        animator.start()
    }

}