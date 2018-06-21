package com.example.edward.motiondemonstrations

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.TextView
import android.view.animation.LinearInterpolator
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.annotation.SuppressLint
import android.view.MotionEvent
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainCircleAnimation()

        //The following lines allow the moving background gradient using the two gradient color xml drawable
        // files and the moving gradient background drawable file.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.mainConstraintLayout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(5500)
        animationDrawable.start()

        //Instantiate all the buttons
        val treesButton = findViewById<Button>(R.id.treesButton)
        val queuesButton = findViewById<Button>(R.id.queuesButton)
        val circularArrayButton = findViewById<Button>(R.id.circularArrayButton)
        val dictionaryButton = findViewById<Button>(R.id.dictionaryButton)
        val stacksButton = findViewById<Button>(R.id.stacksButton)
        val linkedListsButton = findViewById<Button>(R.id.linkedListsButton)



        treesButton.setOnClickListener({

            val bundle: Bundle = ActivityOptions.makeSceneTransitionAnimation(this, treesButton, treesButton.transitionName).toBundle()
            val intent = Intent(this, TreeActivity::class.java)
            startActivity(intent, bundle)
        })

        //The following onTouchListener enlarges the hexagon button when pressed.
        hexButtonEnlarger(treesButton)

        //Handle the slide button
        queuesButton.setOnClickListener({

            val bundle2: Bundle = ActivityOptions.makeSceneTransitionAnimation(this, queuesButton, queuesButton.transitionName).toBundle()
            val intent2 = Intent(this, QueueActivity::class.java)
            startActivity(intent2, bundle2)
        })

        hexButtonEnlarger(queuesButton)


        //handle the vector button
        circularArrayButton.setOnClickListener({

            val bundle3: Bundle = ActivityOptions.makeSceneTransitionAnimation(this, circularArrayButton, circularArrayButton.transitionName).toBundle()
            val intent3 = Intent(this, CircularArrayActivity::class.java)
            startActivity(intent3, bundle3)
        })

       hexButtonEnlarger(circularArrayButton)

         //handle the other button
        dictionaryButton.setOnClickListener({

            val bundle4: Bundle = ActivityOptions.makeSceneTransitionAnimation(this, dictionaryButton, dictionaryButton.transitionName).toBundle()
            val intent4 = Intent(this, DictionaryActivity::class.java)
            startActivity(intent4, bundle4)
        })

       hexButtonEnlarger(dictionaryButton)

        //handle the explode button
        stacksButton.setOnClickListener({

            val bundle5: Bundle = ActivityOptions.makeSceneTransitionAnimation(this, stacksButton, stacksButton.transitionName).toBundle()
            val intent5 = Intent(this, StacksActivity::class.java)
            startActivity(intent5, bundle5)
        })

        hexButtonEnlarger(stacksButton)


        //handle the parallax button
        linkedListsButton.setOnClickListener({

            val bundle6: Bundle = ActivityOptions.makeSceneTransitionAnimation(this, linkedListsButton, linkedListsButton.transitionName).toBundle()
            val intent6 = Intent(this, LinkedListsActivity::class.java)
            startActivity(intent6, bundle6)
        })

        hexButtonEnlarger(linkedListsButton)

    }


    //The code in this method enlarges the hexagon button when it is pressed on.
    @SuppressLint("ClickableViewAccessibility")
    private fun hexButtonEnlarger(whichButton: Button) {

        whichButton.setOnTouchListener({ _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val x = 1.25.toFloat()
                val y = 1.25.toFloat()

                whichButton.scaleX= x
                whichButton.scaleY = y
            } else if (event.action == MotionEvent.ACTION_UP) {
                val x = 1f
                val y = 1f

                whichButton.scaleX= x
                whichButton.scaleY = y
            }
            false


        })

    }

    private fun mainCircleAnimation() {
        //The following 11 lines make the title text view fade in when the app starts
        val title = findViewById<TextView>(R.id.mainActivityTitle)
        val titleAnim = AlphaAnimation(0.0f, 1.0f)
        titleAnim.duration = 1000
        titleAnim.startOffset = 800
        title.startAnimation(titleAnim)

        val title2 = findViewById<TextView>(R.id.mainActivityTitle2)
        val title2Anim = AlphaAnimation(0.0f, 1.0f)
        title2Anim.duration = 1000
        title2Anim.startOffset = 800
        title2.startAnimation(title2Anim)

        //The following 6 lines create the blinking effect of the textView
        val instructions = findViewById<TextView>(R.id.instructions)
        val instructionsAnim = AlphaAnimation(0.0f, 1.0f)
        instructionsAnim.repeatMode = ObjectAnimator.REVERSE
        instructionsAnim.repeatCount = ObjectAnimator.INFINITE
        instructionsAnim.duration = 200
        instructionsAnim.startOffset = 800
        instructions.startAnimation(instructionsAnim)

        val treesButton = findViewById<Button>(R.id.treesButton)
        val queuesButton = findViewById<Button>(R.id.queuesButton)
        val circularArrayButton = findViewById<Button>(R.id.circularArrayButton)
        val dictionaryButton = findViewById<Button>(R.id.dictionaryButton)
        val stacksButton = findViewById<Button>(R.id.stacksButton)
        val linkedListsButton = findViewById<Button>(R.id.linkedListsButton)

        val treesAnim = AlphaAnimation(0.0f, 1.0f)
        treesAnim.duration = 100
        treesAnim.startOffset = 100
        treesButton.startAnimation(treesAnim)

        val queuesAnim = AlphaAnimation(0.0f, 1.0f)
        queuesAnim.duration = 100
        queuesAnim.startOffset = 200
        queuesButton.startAnimation(queuesAnim)

        val circularArrayAnim = AlphaAnimation(0.0f, 1.0f)
        circularArrayAnim.duration = 100
        circularArrayAnim.startOffset = 300
        circularArrayButton.startAnimation(circularArrayAnim)

        val dictionaryAnim = AlphaAnimation(0.0f, 1.0f)
        dictionaryAnim.duration = 100
        dictionaryAnim.startOffset = 400
        dictionaryButton.startAnimation(dictionaryAnim)

        val stacksAnim = AlphaAnimation(0.0f, 1.0f)
        stacksAnim.duration = 100
        stacksAnim.startOffset = 500
        stacksButton.startAnimation(stacksAnim)

        val linkedListsAnim = AlphaAnimation(0.0f, 1.0f)
        linkedListsAnim.duration = 100
        linkedListsAnim.startOffset = 600
        linkedListsButton.startAnimation(linkedListsAnim)

        //The following lines create a rotation animation
        val centerIcon = findViewById<ImageView>(R.id.centerView)
        val rotateAnimation = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.interpolator = LinearInterpolator()
        rotateAnimation.duration = 250
        rotateAnimation.startOffset = 700
        centerIcon.startAnimation(rotateAnimation)
    }

}
