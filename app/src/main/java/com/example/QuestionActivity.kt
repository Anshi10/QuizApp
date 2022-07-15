package com.example

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var Name :String? = null
    private var score:Int = 0


    private var currentPosition: Int = 1
    private var selectedOption: Int = 0
    private var questionlist: ArrayList<QuestionData> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name = intent.getStringExtra(setData.name)

        questionlist = setData.getQuestion()  //here we are fectching questions from set data class(object)

        setquestion()//this is the function which will set the question


        option1.setOnClickListener {
            selectedOptionStyle(option1, 1)
        }
        option2.setOnClickListener {
            selectedOptionStyle(option2, 2)
        }
        option3.setOnClickListener {
            selectedOptionStyle(option3, 3)
        }
        option4.setOnClickListener {
            selectedOptionStyle(option4, 4)
        }

        submit.setOnClickListener {
            submit.text = "Submit"
            if (selectedOption != 0) {
                val question =
                    questionlist[currentPosition - 1]//we are fetching question at this index
                if (selectedOption != question.correct_ans) {
                    setcolor(selectedOption, R.drawable.incorrect_question_option)
                }else{
                    score++
                }
                setcolor(question.correct_ans, R.drawable.correct_question_option)
                if (currentPosition == questionlist.size)
                    submit.text = "FINISH"
                else
                    submit.text = "NEXT QUESTION"
            } else {
                currentPosition++
                when {
                    currentPosition <= questionlist.size -> {
                        setquestion()
                    }
                    else -> {
                        val intent = Intent(this , ResultActivity::class.java)
                        intent.putExtra(setData.name, Name.toString())
                        intent.putExtra(setData.score,  score.toString())
                        intent.putExtra("total size" , questionlist.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setcolor(opt: Int, color: Int) {
        when (opt) {
            1 -> option1.background = ContextCompat.getDrawable(this, color)
            2 -> option2.background = ContextCompat.getDrawable(this, color)
            3 -> option3.background = ContextCompat.getDrawable(this, color)
            4 -> option4.background = ContextCompat.getDrawable(this, color)
        }
    }

    fun setoptionstyle() {
        var optionlist: ArrayList<TextView> = arrayListOf()
        optionlist.add(0, option1)
        optionlist.add(1, option2)
        optionlist.add(2, option3)
        optionlist.add(3, option4)

        for (op in optionlist) {
            op.setTextColor(Color.parseColor("Grey"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_options)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun setquestion() {

        val question = questionlist[currentPosition - 1]//we are fetching question at this index

        setoptionstyle()
        progress.progress = currentPosition
        progress.max = questionlist.size
        progress_int.text = "${currentPosition} / ${progress.max}"
        question_text.text = question.question
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
    }

    fun selectedOptionStyle(view: TextView, opt: Int) {

        setoptionstyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("Black"))
    }
}