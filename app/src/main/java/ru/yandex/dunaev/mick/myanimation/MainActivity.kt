package ru.yandex.dunaev.mick.myanimation

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.yandex.dunaev.mick.myanimation.animations.NoAnimation
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
            Item("No animation", Intent(this, NoAnimation::class.java))
        )
        model.setItems(items)
    }

}
