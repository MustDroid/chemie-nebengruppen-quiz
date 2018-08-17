package com.example.android.chemienebengruppenquiz;

import java.util.List;

/**
 * Created by Emoke Hajdu on 6/8/2018.
 */

public class EditQuestion implements IQuestion {

    private String question;
    private String correctAnswer;

    public EditQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestionText() {
        return question;
    }

    @Override
    public boolean checkAnswer(Object answer) {
        if(!(answer instanceof String))
            return false;

        String answerAsString = (String)answer;
        // Das hier vergleicht Strings ohne grosse und kleine zu berucksichtigen
        return answerAsString.equalsIgnoreCase(correctAnswer);
    }
}


