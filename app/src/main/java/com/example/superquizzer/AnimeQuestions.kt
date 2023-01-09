package com.example.superquizzer

object AnimeQuestions{
    fun getQuestions():ArrayList<Question>{
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1," From which country Anime has originated?",
            "China","Thailand","Japan","India",3)

        questionsArray.add(question1)

        val question2 = Question(2," Anime is the short form of what?",
            "Cartoons","Animation","Both option 1 and 2","none of these",2)

        questionsArray.add(question2)

        val question3 = Question(3," The first anime was recorded in which year?",
            "1937","1927","1917","1943",3)

        questionsArray.add(question3)

        val question4 = Question(4,"What year was “JoJo’s Bizarre Adventure: Phantom Blood” first released?",
            "1987","1957","1982","1923",
            1)

        questionsArray.add(question4)

        val question5 = Question(5,"In “One Piece”, what does “the Pirate King” mean to the captain of the Straw Hat Pirates?",
            "Honesty","Constant","Regularity","Freedom",4)

        questionsArray.add(question5)

        val question6 = Question(6,"What sport is being played in the Anime Eyeshield 21?",
            "American Football","Japan Baseball","Chinese Badminton","Indian Cricket",1)

        questionsArray.add(question6)

        val question7 = Question(7,"Which of the following manga have the most tankouban volumes?",
            "Golgo 12","Golgo 13","Golgo 15","Golgo 9",2)

        questionsArray.add(question7)

        val question8 = Question(8,"Who is the main character with yellow hair in the anime Naruto?",
            "Kakashi Hatake","Sasuke Uchiha","Naruto","Sakura Haruno",3)

        questionsArray.add(question8)

        val question9 = Question(9,"In the anime, “Full Metal Panel”, who is Kaname’s best friend?",
            "Kyoko luruno","Kyoko Tokiwa","Kyoko jhtiwa","Kyoko mutiwa",2)

        questionsArray.add(question9)

        val question10 = Question(10,"The manga JoJo’s Bizarre Adventure is split into how many parts?",
            "15","4","10","8",4)

        questionsArray.add(question10)

        return questionsArray
    }
}
