package com.example.edward.motiondemonstrations

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.Button

class CircularArrayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circulararray)

        //The following lines allow the moving background gradient using the two gradient color xml drawable
        // files and the moving gradient background drawable file.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.circularArrayConstraintLayout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(5500)
        animationDrawable.start()

        val caGithubButton = findViewById<Button>(R.id.circularArrayGithubButton)

        caGithubButton.setOnClickListener({
            val webPage: Uri = Uri.parse("https://github.com/EdwardL89/DataStructuresImplementation/blob/master/CircularArray.java")

            val intent = Intent(Intent.ACTION_VIEW, webPage)

            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        })
    }
}
