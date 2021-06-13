package com.example.signuploginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validate(v: View?) {
        var u = findViewById<View>(R.id.userName) as EditText
        var p = findViewById<View>(R.id.passWord) as EditText
        if(validatePassword(p.text.toString())) {
//            Toast.makeText(this,"Successful Login", Toast.LENGTH_LONG).show()
            var i = Intent(this, LoginActivity::class.java)
            var b = Bundle()
            var userinfo = UserInfo(u.text.toString(),p.text.toString())
            b.putSerializable("userinfo",userinfo)
            i.putExtras(b)
            startActivity(i)

        } else {
            Toast.makeText(this,"Login Failure", Toast.LENGTH_LONG).show()
        }
    }

    fun validatePassword(s:String):Boolean {
        var upperChar = 0
        var lowerChar = 0
        var specialChar = 0
        var digits = 0
        for(c in s){
            if(c.isLowerCase()){
                lowerChar++
                continue
            }
            if(c.isUpperCase()){
                upperChar++
                continue
            }
            if(c.isDigit()){
                digits++
                continue
            }
            specialChar++
        }

        if(upperChar == 0 || lowerChar ==0 || digits == 0 || specialChar == 0 || s.length < 8){
            return false
        }
        return true
    }
}

data class UserInfo(val uname:String, val pwd:String):Serializable