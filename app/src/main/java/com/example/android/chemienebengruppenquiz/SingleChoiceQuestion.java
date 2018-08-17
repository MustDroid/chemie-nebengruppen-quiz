package com.example.android.chemienebengruppenquiz;

/**
 * Created by Emoke Hajdu on 6/8/2018.
 */

public class SingleChoiceQuestion implements IQuestion {
    public SingleChoiceQuestion(String question, String answerA, String answerB, String answerC, String answerD, char correctAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestionText() {
        return question;
    }

    @Override
    public boolean checkAnswer(Object answer) {
        Character charAnswer = (Character)answer;
        return charAnswer.equals(correctAnswer);
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    private String question;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    private char correctAnswer;
}


