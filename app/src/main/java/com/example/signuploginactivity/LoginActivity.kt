package com.example.signuploginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    var cnt = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun authenticate(v: View?){
        var lu = findViewById<View>(R.id.userName) as EditText
        var lp = findViewById<View>(R.id.passWord) as EditText
        var i = intent
        var userinfo = i.getSerializableExtra("userinfo") as UserInfo
        var su = userinfo.uname
        var sp = userinfo.pwd

        if(lu.text.toString() == su && lp.text.toString() == sp) {
            Toast.makeText(this, "Authentication Successful", Toast.LENGTH_LONG).show()
        } else {
            cnt++
            if(cnt==2){
                var b = v as Button
                b.isEnabled = false // Disable the button after 3 tries
            }
            Toast.makeText(this, "Authentication Failed", Toast.LENGTH_LONG).show()
        }
    }
}
