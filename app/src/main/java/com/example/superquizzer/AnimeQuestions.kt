package com.example.superquizzer

object AnimeQuestions{
    fun getQuestions():ArrayList<Question>{
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1,"In the first season of In Sword Art Online, what is the black blade used by Kirito called?",
            "The Elucidator","Blue Dragon","Rising Sun","Excalibur",1)

        questionsArray.add(question1)

        val question2 = Question(2,"Bungee Gum has the properties of",
            "Rubber","Gum","Both option 1 and 2","None of the above",3)

        questionsArray.add(question2)

        val question3 = Question(3," What is Tanjiro's greatest sense?",
            "Smell","Sight","Taste","Hearing",1)

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

        val question9 = Question(9,"What must be sacrificed in order to use the powers of a Shinigami's Eye?",
            "Life of a loved one","Ability to use death note","Natural Vision","Half of your life expectancy",4)

        questionsArray.add(question9)

        val question10 = Question(10,"The manga JoJo’s Bizarre Adventure is split into how many parts?",
            "15","4","10","8",4)

        questionsArray.add(question10)

        return questionsArray
    }
}
