package com.example.englishquiz;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
   private List<QuizData> questions= new ArrayList();
public List<QuizData> getQuestions(){
    questions.add(new QuizData(0, null, "Do you _____ chocolate milk?", "like","likes","be like ", "is like","like"));
    questions.add(new QuizData(0, null, "He _____ not want to go to the movies.", "do","does","is", "are","does"));
    questions.add(new QuizData(0, null, "He ____________ now.", "plays tennis","wants breakfast","walks home", "walks homes","wants breakfast"));
    questions.add(new QuizData(0, null, "It _____ a beautiful day today.", "is","are","am", "I","is"));
    questions.add(new QuizData(0, null, "Sorry, Lisa _____ not here at the moment.", "is","are","am", "I","is"));
    questions.add(new QuizData(0, null, "They're not here. They ____________ right now.", "go to school","swim at the beach","are on holiday", "holiday","are on holiday"));
    questions.add(new QuizData(0, null, "Robert _____ not go to my school.", "is","does","are", "a","does"));
    questions.add(new QuizData(R.drawable.dog, "What's the name of this animal?", null, "cat","dog","monkey", "bear","dog"));
    questions.add(new QuizData(0, null, "We _____ European.", "do be","are","are live", "do are","are"));
    questions.add(new QuizData(0, null, "You _____ so happy today!", "looks","seem","be", "do are","seem"));

return questions;
}

}
