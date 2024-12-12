package com.gehad.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
  lateinit var usernameEditText: EditText
   lateinit var passwordEditText: EditText
   lateinit var logInButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        logInButton = findViewById(R.id.button)
        fun performLogin(): Boolean {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "please enter user name and password", Toast.LENGTH_SHORT)
                    .show()
                return false
            } else if (password.length < 8) {
                Toast.makeText(
                    this,
                    "please enter password not less than 8 char",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }
            var hasletter = false
            for (char in password) {

                if (char.isLetter()) {
                    hasletter = true
                    break
                } else hasletter = false
            }
            if (!hasletter) {
                Toast.makeText(
                    this,
                    "password must contain at least one letter ",
                    Toast.LENGTH_SHORT
                ).show()
                  return false
            } else Toast.makeText(this, "successfully sign in ", Toast.LENGTH_SHORT).show()
            return true
        }

        logInButton.setOnClickListener {
           if (performLogin()){
               val username = usernameEditText.text.toString()
            val intent =Intent(applicationContext, MainActivity2::class.java)

               intent.putExtra("username","Welcome $username")

            startActivity(intent)}
        }


    }

}
