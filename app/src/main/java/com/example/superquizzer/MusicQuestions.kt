package com.example.superquizzer

object MusicQuestions {
    fun getMusicQuestions(): ArrayList<Question> {
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1, "Gangubai Hangal was a well-known singer of",
            " Madrasi Music", "Carnatic Music", "Hindustani Music", "Urdu Music", 3)

        questionsArray.add(question1)

        val question2 = Question(2, "Tappa is the regional music of which state?",
            "Haryana", "Punjab", "Delhi", "Lucknow", 2)

        questionsArray.add(question2)

        val question3 = Question(3, "Pandwani is the regional music of which state?",
            "Raipur", "Bihar", "Chattisgarh", "Manipur", 3)

        questionsArray.add(question3)

        val question4 = Question(4, "In which year Pandit Ravi Sankar got Bharat Ratna?",
            "1999", "2000", "1998", "1997",
            1)

        questionsArray.add(question4)

        val question5 = Question(5, "The name 'Ustad Bismillah Khan' is associated with",
            "Harmonium", "Sitar", "Tabla", "Sehnai", 4)

        questionsArray.add(question5)

        val question6 = Question(6, "'Khuang' is a traditional musical instrument of which state?",
            "Mizoram", "Assam", "Manipur", "Nagaland", 1)

        questionsArray.add(question6)

        val question7 = Question(7,
            "Lotia is the regional music of",
            "Jaipur",
            "Rajasthan",
            "Digha",
            "Sonagaachi",
            2)

        questionsArray.add(question7)

        val question8 =
            Question(8, "Which folk music of Rajasthan is sung to praise water and rain?",
                "PaniGod", "JalRupa", "Panihari", "Jalvarsha", 3)

        questionsArray.add(question8)

        val question9 = Question(9,
            "Which of the following is a popular folk song of Bundelkhand?",
            "Rasia",
            "Alha",
            "Languriya",
            "Vasya",
            2)

        questionsArray.add(question9)

        val question10 =
            Question(10, "Which of the following song forms are sung in the rainy season in Uttar Pradesh?",
                "Nautanki", "rasiya", "Chaiti", "Kajri", 4)

        questionsArray.add(question10)

        return questionsArray
    }

}


