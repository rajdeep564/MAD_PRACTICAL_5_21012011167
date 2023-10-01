package com.example.mad_practical_5_21012011167

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edit_text : EditText = findViewById(R.id.editTextText2)
        val browse : Button = findViewById(R.id.button)

        browse.setOnClickListener(){
            OpenUrl(edit_text.text.toString())
        }
        val callButton : Button = findViewById(R.id.button3)
        callButton.setOnClickListener() {
            val phoneNumber =  "9571355543"
            PhoneCall(phoneNumber)
        }

        val gallery : Button = findViewById(R.id.button5)

        gallery.setOnClickListener(){
            OpenGallery()
        }

        val camera : Button = findViewById(R.id.button6)

        camera.setOnClickListener(){
            OpenCamera()
        }

        val alarm : Button = findViewById(R.id.button7)

        alarm.setOnClickListener(){
            OpenAlarm()
        }

        val Calllog1 : Button = findViewById(R.id.button4)

        Calllog1.setOnClickListener(){
            PhoneCallLog()
        }
    }
    fun OpenUrl(url : String){
        Intent(Intent.ACTION_VIEW , Uri.parse(url)).also { startActivity(it) }

    }
    fun PhoneCall(number: String){
        val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $number"))
        startActivity(callIntent)

    }
    fun PhoneCallLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }



    }
    fun OpenGallery(){
        Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI).also { startActivity(it) }

    }
    fun OpenCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }

    }
    fun OpenAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }

    }
}