package com.turek.blockanimations

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.turek.blockanimations.animations.AnimationManager

class MainActivity : AppCompatActivity() {

    lateinit var startButton: ImageView
    lateinit var viewToShow: View
    lateinit var fragment: View

    var extended = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.start_animation_button)
        viewToShow = findViewById(R.id.view_to_show)
        fragment = findViewById(R.id.fragment_container)

        startButton.setOnClickListener {
            extended = if( !extended ){
                AnimationManager.fragmentAnimationUp(fragment)!!.start()
                true
            } else {
                AnimationManager.fragmentAnimationDown(fragment)!!.start()
                false
            }


        }
    }
}

