package com.example

object setData {

    const val name : String = "name"
    const val score : String = "score"

    fun getQuestion(): ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = ArrayList()
        var q1 = QuestionData(
            "what is the full form of API",
            1,
            "Application Progress Index",
            "Application Programming Interface",
            "Apply problem Indices",
            "Application Princinples Indexing",
            2
        )
        que.add(q1)
        var q2 = QuestionData(
            "Which of the following virtual machine is used by the Android operating system?",
            2,
            "JVM",
            "Dalvik virtual machine",
            "Simple virtual machine",
            " None of the above",
            2
        )
        que.add(q2)
        var q3 = QuestionData(
            "APK stands for ",
            3,
            "Android Phone Kit",
            "Android Page Kit ",
            " Android Package Kit",
            " None of the above",
            3
        )
        que.add(q3)
        var q4 = QuestionData(
            "What is an activity in android?",
            4,
            "Android class",
            "Android package  ",
            " A single screen in an application with supporting java code",
            "  None of the above",
            3
        )
        que.add(q4)
        var q5 = QuestionData(
            "ADB stands for -",
            5,
            "Android debug bridge ",
            "Android delete bridge",
            "Android destroy bridge ",
            "None of the above",
            1
        )
        que.add(q5)
        return que
    }
}