package com.example.superquizzer

object ScienceQuestions {

    fun getQuestions():ArrayList<Question>{
        val questionsArray = ArrayList<Question>()

        val question1 = Question(1,"What is the hardest natural substance on Earth?",
            "Graphite","Gold","Diamond","Wood",3)

        questionsArray.add(question1)

        val question2 = Question(2,"Which is the main gas that makes up the Earth's atmosphere?",
            "Oxygen","Nitrogen","Carbon-Dioxide","Argon",2)

        questionsArray.add(question2)

        val question3 = Question(3,"At what temperature are Celsius and Fahrenheit equal?",
            "-73","-49","-40","0",3)

        questionsArray.add(question3)

        val question4 = Question(4,"Which gas cause acid rain?",
            "Sulphur dioxide, Nitrogen oxides","Hydrogen","Carbon-di-oxide","Helium",
            1)

        questionsArray.add(question4)

        val question5 = Question(5,"What is the toxicity caused by silicon called?",
            "Carbon","Oxygen","Silicon","Silicosis",4)

        questionsArray.add(question5)

        val question6 = Question(6,"Which scientist proposed the three laws of motion?",
            "Isaac Newton","Albert Einstein","Stephen Hawking","Thomas Alva Edison",1)

        questionsArray.add(question6)

        val question7 = Question(7,"The outward force, away from the center, felt by an object in circular motion is ___.",
            "Centripetal force","Centrifugal force","Elastic force","Circular force",2)

        questionsArray.add(question7)

        val question8 = Question(8,"Diabetes happens because of problems in which organ of the body?",
            "Liver","Heart","Pancreas","Kidneys",3)

        questionsArray.add(question8)

        val question9 = Question(9,"Chlorophyll is a naturally occurring chelate compound in which central metal is?",
            "Copper","Magnesium","Iron","Calcium",2)

        questionsArray.add(question9)

        val question10 = Question(10,"Which of the following metals forms an amalgam with other metals?",
            "Lead","Tin","Zinc","Mercury",4)

        questionsArray.add(question10)

        return questionsArray
    }
}