package com.example.android.chemienebengruppenquiz;

import java.util.List;

/**
 * Created by Emoke Hajdu on 6/8/2018.
 */

public class MultiChoiceQuestion implements IQuestion {

    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private List<Boolean> correctAnswer; // [false, true, true, false]

    public MultiChoiceQuestion(String question, String answerA, String answerB, String answerC, String answerD, List<Boolean> correctAnswer) {
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
        List<Boolean> listAnswer = (List<Boolean>)answer;

        for(int i = 0; i < listAnswer.size(); i++)
            if(listAnswer.get(i) != correctAnswer.get(i))
                return false;

        return true;
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
}
