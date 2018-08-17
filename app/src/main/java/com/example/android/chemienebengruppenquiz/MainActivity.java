package com.example.android.chemienebengruppenquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int curQuestion;
    private int score = 0;

    private TextView txtQuestionNumber;
    private TextView txtQuestion;

    private EditText txtEditAnswer;

    private TextView txtScore;

    private CheckBox checkA;
    private CheckBox checkB;
    private CheckBox checkC;
    private CheckBox checkD;

    private RadioGroup radioGroup;
    private RadioButton radioAnswerA;
    private RadioButton radioAnswerB;
    private RadioButton radioAnswerC;
    private RadioButton radioAnswerD;

    private LinearLayout layoutSingleChoice;
    private LinearLayout layoutMultiChoice;
    private LinearLayout layoutEdit;

    private void showLayoutByQuestion(IQuestion question) {
        layoutSingleChoice.setVisibility(question instanceof SingleChoiceQuestion ? View.VISIBLE : View.GONE);
        layoutMultiChoice.setVisibility(question instanceof MultiChoiceQuestion ? View.VISIBLE : View.GONE);
        layoutEdit.setVisibility(question instanceof EditQuestion ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEditAnswer = (EditText) findViewById(R.id.txtEditAnswer);

        txtQuestionNumber = (TextView)findViewById(R.id.txtQuestionNumber);
        txtQuestion = (TextView)findViewById(R.id.txtQuestion);
        txtScore = (TextView)findViewById(R.id.txtScore);

        checkA = (CheckBox)findViewById(R.id.checkA);
        checkB = (CheckBox)findViewById(R.id.checkB);
        checkC = (CheckBox)findViewById(R.id.checkC);
        checkD = (CheckBox)findViewById(R.id.checkD);

        radioGroup = (RadioGroup)findViewById(R.id.idRadioGroup);
        radioAnswerA = (RadioButton)findViewById(R.id.radioAnswerA);
        radioAnswerB = (RadioButton)findViewById(R.id.radioAnswerB);
        radioAnswerC = (RadioButton)findViewById(R.id.radioAnswerC);
        radioAnswerD = (RadioButton)findViewById(R.id.radioAnswerD);

        layoutSingleChoice = (LinearLayout)findViewById(R.id.layoutSingleChoice);
        layoutMultiChoice = (LinearLayout)findViewById(R.id.layoutMultiChoice);
        layoutEdit = (LinearLayout)findViewById(R.id.layoutEdit);

        curQuestion = 0;

        updateQuestion();
    }
    private void updateQuestion() {
        txtQuestionNumber.setText(String.format("Question %d / %d", curQuestion+1, QuestionDatabase.allQuestions.length));
        IQuestion q = QuestionDatabase.allQuestions[curQuestion];
        showLayoutByQuestion(q);

        txtQuestion.setText(q.getQuestionText());

        if(q instanceof SingleChoiceQuestion) {
            SingleChoiceQuestion sq = (SingleChoiceQuestion)q;
            radioAnswerA.setText(sq.getAnswerA());
            radioAnswerB.setText(sq.getAnswerB());
            radioAnswerC.setText(sq.getAnswerC());
            radioAnswerD.setText(sq.getAnswerD());
        }
        else if(q instanceof MultiChoiceQuestion) {
            MultiChoiceQuestion mq = (MultiChoiceQuestion)q;

            checkA.setText(mq.getAnswerA());
            checkB.setText(mq.getAnswerB());
            checkC.setText(mq.getAnswerC());
            checkD.setText(mq.getAnswerD());
        }
    }

    public void btnCheck_OnClick(View view) {
        IQuestion q = QuestionDatabase.allQuestions[curQuestion];
        Object answer = null;
        if(q instanceof SingleChoiceQuestion) {
            answer = 'A';
            if (radioAnswerB.isChecked())
                answer = 'B';
            else if (radioAnswerC.isChecked())
                answer = 'C';
            else if (radioAnswerD.isChecked())
                answer = 'D';
        }
        else if(q instanceof MultiChoiceQuestion) {
            List<Boolean> givenAnswer = new ArrayList<>();
            givenAnswer.add(checkA.isChecked());
            givenAnswer.add(checkB.isChecked());
            givenAnswer.add(checkC.isChecked());
            givenAnswer.add(checkD.isChecked());

            checkA.setChecked(false);
            checkB.setChecked(false);
            checkC.setChecked(false);
            checkD.setChecked(false);

            answer = givenAnswer;
        }
        else if(q instanceof EditQuestion)
        {
            answer = txtEditAnswer.getText().toString();
            txtEditAnswer.setText("");
        }
        curQuestion++;

        if(q.checkAnswer(answer)) {
            score++;
            Toast.makeText(this, "Korrekt!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Leider falsch!", Toast.LENGTH_SHORT).show();
        }

        if(curQuestion == QuestionDatabase.allQuestions.length)
        {
            Intent myIntent = new Intent(this, SummaryActivity.class);
            myIntent.putExtra("score", score);
            startActivity(myIntent);
            finish();
        }

        else updateQuestion();

        txtScore.setText("Punkte: " + score);
    }
}


