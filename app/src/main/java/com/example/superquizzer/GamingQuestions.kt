package com.example.superquizzer

object GamingQuestions {
    fun getQuestions():ArrayList<Question>{
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1,"What is the best selling videogame of all time?",
            "Minecraft","Fortnite","GTA V","Valorant",1)

        questionsArray.add(question1)

        val question2 = Question(2,"Blizzard Entertainment is most well known for what video game franchise?",
            "The GTA Series","World of Warcraft","Minecraft","Apex Legends",2)

        questionsArray.add(question2)

        val question3 = Question(3,"Who released the first flight simulator game?",
            "RIOT","Rockstar Games","Microsoft","Sony",3)

        questionsArray.add(question3)

        val question4 = Question(4,"Mario first appeared in what video game?",
            "Donkey Kong","Luigi's Mansion","Super Smash Bros","Super Mario Brothers",
            1)

        questionsArray.add(question4)

        val question5 = Question(5,"What was Super Mario’s first job?",
            "Engineer","Farmer","Teacher","Carpenter",4)

        questionsArray.add(question5)

        val question6 = Question(6,"What’s the name of the orange ghost in the ‘Pac-Man’ video game?",
            "Clyde","Jason","Mark","Vishesh Vijayvargiya",1)

        questionsArray.add(question6)

        val question7 = Question(7,"Who owns the castle in Castlevania?",
            "King Felix","Count Dracula","Prince Hector","Count of Monte Cristo",2)

        questionsArray.add(question7)

        val question8 = Question(8,"Which Mortal Kombat character was based on a ninja?",
            "Jax","Kung Lao","Sub Zero","Sonya",3)

        questionsArray.add(question8)

        val question9 = Question(9,"Who is the first character you defeat in Super Mario?",
            "Drogo","Bowser","Om Khangat","Jowser",2)

        questionsArray.add(question9)

        val question10 = Question(10,"How many types of Pokemon are there?",
            "15","18","21","24",2)

        questionsArray.add(question10)

        return questionsArray
    }
}
