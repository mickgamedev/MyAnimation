package ru.yandex.dunaev.mick.myanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.yandex.dunaev.mick.myanimation.animations.*
import ru.yandex.dunaev.mick.myanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = model
        binding.layoutManager = LinearLayoutManager(this)

        model.showActivity = {startActivity(it)}

        val items = listOf<Item>(
            Item("No animation", Intent(this, NoAnimationActivity::class.java)),
            Item("Launch a rocket", Intent(this, LaunchRocketValueAnimatorAnimationActivity::class.java)),
            Item("Spin a rocket", Intent(this, RotateRocketAnimatioinActivity::class.java)),
            Item("Accelerate a rocket", Intent(this, AccelerateRocketAnimationActivity::class.java)),
            Item("Launch a rocket (ObjectAnimator)", Intent(this, LaunchRocketObjectAnimatorAnimationActivity::class.java)),
            Item("Background color", Intent(this, ColorAnimationActivity::class.java)),
            Item("Launch and spin (AnimatorSet)", Intent(this, LaunchAndSpinAnimatiorSetAnimationActivity::class.java)),
            Item("Launch and spin (ViewPropertyAnimator)", Intent(this, LaunchAndSpinViewPropertyAnimatorAnimationActivity::class.java)),
            Item("Don't leave Doge behind (Animating two objects)", Intent(this, FlyWithDogeAnimationActivity::class.java)),
            Item("Animation events (with listener)", Intent(this, WithListenerAnimationActivity::class.java)),
            Item("Fly there and back (Animation options)", Intent(this, FlyThereAndBackAnimationActivity::class.java)),
            Item("Jump and blink (Animation in XML)", Intent(this, XmlAnimationActivity::class.java))
        )
        model.setItems(items)
    }

}
