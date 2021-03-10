package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDialNumber:Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener (this)
        val btnWithData:Button  = findViewById(R.id.btn_move_with_data)
        btnWithData.setOnClickListener (this)
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveActivity = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_with_data ->{
                val MoveDataIntent = Intent(this@MainActivity,MoveWithDataActivity::class.java)
                MoveDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"DicodingAcademy yan")
                MoveDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,12)
                startActivity(MoveDataIntent)
            }

            R.id.btn_dial_number ->{
                val phoneNumber = "083147779266"
                val dialPhoneTest = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(dialPhoneTest)
            }
        }
    }
}