package com.example.android.chemienebengruppenquiz;

/**
 * Created by Emoke Hajdu on 6/8/2018.
 */

public interface IQuestion {
    String getQuestionText();
    boolean checkAnswer(Object answer);
}