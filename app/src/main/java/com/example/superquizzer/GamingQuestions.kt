package com.example.superquizzer

object GamingQuestions {
    fun getQuestions():ArrayList<Question>{
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1," What is wool that is 50 millimeters (2 in) or shorter from the first shearing of a sheep?",
            "Lambswool","wool","Cashmere","Merino",1)

        questionsArray.add(question1)

        val question2 = Question(2,"The term “Tee” is used commonly in which among the following sports?",
            "Racing","Golf","Polo","Tennis",2)

        questionsArray.add(question2)

        val question3 = Question(3,"World’s highest Hockey ground is located in:",
            "Chail","Delhi","Shilaroo","parwanoo",3)

        questionsArray.add(question3)

        val question4 = Question(4,"The “Marquess of Queensberry rules” is a code of generally accepted rules in which of the following sports?",
            " Boxing","Chess","Tennis","Badminton",
            1)

        questionsArray.add(question4)

        val question5 = Question(5,"With which of the following sports “Aga Khan trophy” is related to?",
            " Field Hockey","Horse Racing","Table Tennis","Show Jumping",4)

        questionsArray.add(question5)

        val question6 = Question(6,"On which among the following courts, Chennai Open is played ?",
            "Hard Court","Clay court","Carpet Court","Grass Court",1)

        questionsArray.add(question6)

        val question7 = Question(7,"Where are the headquarters of Swimming Federation of India?",
            "Kolkata","Ahmedabad","Chandigarh","New Delhi",2)

        questionsArray.add(question7)

        val question8 = Question(8,"Which is the governing body Chess in the world?",
            "World Chess Association","World Chess Organisation","World Chess Federation"," Association of World Chess Champions",3)

        questionsArray.add(question8)

        val question9 = Question(9,"When was the new name of Badminton World Federation adopted?",
            "2002","2006","1996","1986",2)

        questionsArray.add(question9)

        val question10 = Question(10,"L’Eachelle Castle is located in which country?",
            "America","France","China","Japan",2)

        questionsArray.add(question10)

        return questionsArray
    }
}
