package com.example.englishquiz;

public class QuizData {
    private int image;
    private String textImage;
    private String textQuestion;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    public QuizData(int image, String textImage, String textQuestion, String option1, String option2, String option3, String option4, String answer) {
        this.image = image;
        this.textImage = textImage;
        this.textQuestion = textQuestion;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public int getImage() {
        return image;
    }

    public String getTextImage() {
        return textImage;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }
}
