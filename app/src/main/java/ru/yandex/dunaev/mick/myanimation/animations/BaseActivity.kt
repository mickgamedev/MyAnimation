package ru.yandex.dunaev.mick.myanimation.animations

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.yandex.dunaev.mick.myanimation.R
import ru.yandex.dunaev.mick.myanimation.databinding.ActivityBaseAnimationBinding

abstract class BaseActivity: AppCompatActivity() {
    lateinit var binding: ActivityBaseAnimationBinding
    protected var screenHeight = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_base_animation)
        binding.activity = this
    }

    abstract fun onStartAnimation(view: View)

    companion object {
        val DEFAULT_ANIMATION_DURATION = 2500L
    }

    override fun onResume() {
        super.onResume()

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels.toFloat()
    }
}