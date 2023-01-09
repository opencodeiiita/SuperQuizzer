package com.example.superquizzer

object GKQuestions{
    fun getQuestions():ArrayList<Question> {
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1, "Entomology is the science that studies",
            "Fishes", "Animals", "Insects", "Lizards", 3)

        questionsArray.add(question1)

        val question2 =
            Question(2,
                    "Eritrea, which became the 182nd member of the UN in 1993, is in the continent of",
                "Europe", "Africa", "Asia", "south America", 2)

        questionsArray.add(question2)

        val question3 = Question(3, "World’s highest Hockey ground is located in:",
            "Chail", "Delhi", "Shilaroo", "parwanoo", 3)

        questionsArray.add(question3)

        val question4 = Question(4,
            "Garampani sanctuary is located at",
            " Assam",
            "West Bengal",
            "Madhya Pradesh",
            "Arunachal Pradesh",
            1)

        questionsArray.add(question4)

        val question5 =
            Question(5,
                    "For which of the following disciplines is Nobel Prize awarded?",
                " Physics & Chemistry", "Physiology or Medicine", "Literature, Peace and Economics", "All of these", 4)

        questionsArray.add(question5)

        val question6 = Question(6, "On which among the following courts, Chennai Open is played ?",
            "Hard Court", "Clay court", "Carpet Court", "Grass Court", 1)

        questionsArray.add(question6)

        val question7 = Question(7, "Where are the headquarters of Swimming Federation of India?",
            "Kolkata", "Ahmedabad", "Chandigarh", "New Delhi", 2)

        questionsArray.add(question7)

        val question8 = Question(8,
            "Which is the governing body Chess in the world?",
            "World Chess Association",
            "World Chess Organisation",
            "World Chess Federation",
            " Association of World Chess Champions",
            3)

        questionsArray.add(question8)

        val question9 = Question(9, "Hitler party which came into power in 1933 is known as",
            "Nazi", "Labour", "Duru", "None of these", 1)

        questionsArray.add(question9)

        val question10 = Question(10,
            "Kazakhstan is a part of which of the following continental confederations recognized by FIFA?",
            "Asian Football Confederation",
            "Union of European Football Associations",
            "Confederation Africaine de Football",
            "Fifa",
            2)

        questionsArray.add(question10)

        return questionsArray
    }

}
