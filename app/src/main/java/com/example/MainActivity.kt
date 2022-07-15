package com.example


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.R
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        Next.setOnClickListener{
            if(input.text.toString().isEmpty()){
                Toast.makeText(this, "Enter your Name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this , QuestionActivity:: class.java)
                var name_input = input.editableText.toString()
                intent.putExtra(setData.name,name_input)
                startActivity(intent)
                finish()
            }
        }
    }
}