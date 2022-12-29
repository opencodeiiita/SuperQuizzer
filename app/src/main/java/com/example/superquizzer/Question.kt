package com.example.superquizzer

data class Question(
    val id :Int?=null,
    val  question: String?,
    val optionOne:  String?,
    val optionTwo: String?,
    val optionThree: String?,
    val optionFour: String?,
    val correctOption: String?
)
