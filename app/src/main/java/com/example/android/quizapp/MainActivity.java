package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int questionNumber = 1;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set onClickListener for Submit button
        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAllAnswers();
            }
        });

        // set the onChecked Listener for the RadioGroup1
        final RadioGroup answersRadioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        answersRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = answersRadioGroup1.indexOfChild(findViewById(checkedId));
                RadioButton checkedButton = (RadioButton) answersRadioGroup1.getChildAt(id);

                // get the answer from the clicked button
                String yourAnswer1 = (String) checkedButton.getText();
                questionNumber = 1;
                // check if this is the right answer
                checkAnswer(yourAnswer1);
                // disable this radioGroup after one button was checked
                changeEnabled(answersRadioGroup1);
            }
        });

        // set the onChecked Listener for the RadioGroup4
        final RadioGroup answersRadioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        answersRadioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = answersRadioGroup4.indexOfChild(findViewById(checkedId));
                RadioButton checkedButton = (RadioButton) answersRadioGroup4.getChildAt(id);

                // get the answer from the clicked button
                String yourAnswer4 = (String) checkedButton.getText();
                questionNumber = 4;
                // check if this is the right answer
                checkAnswer(yourAnswer4);
                // disable this radioGroup after one button was checked
                changeEnabled(answersRadioGroup4);
            }
        });

        // set the onChecked Listener for the RadioGroup6
        final RadioGroup answersRadioGroup6 = (RadioGroup) findViewById(R.id.radioGroup6);
        answersRadioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = answersRadioGroup6.indexOfChild(findViewById(checkedId));
                RadioButton checkedButton = (RadioButton) answersRadioGroup6.getChildAt(id);

                // get the answer from the clicked button
                String yourAnswer6 = (String) checkedButton.getText();
                questionNumber = 6;
                // check if this is the right answer
                checkAnswer(yourAnswer6);
                // disable this radioGroup after one button was checked
                changeEnabled(answersRadioGroup6);
            }
        });

    }

    //disable the radioGroup
    protected void changeEnabled(RadioGroup answersRadioGroup) {
        for (int i = 0; i < answersRadioGroup.getChildCount(); i++) {
            answersRadioGroup.getChildAt(i).setEnabled(false);
        }
    }

    // check the submited answer for the checkboxes
    public void checkCheckBoxAnswers() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkboxA3);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkboxB3);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkboxC3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkboxD3);

        if (checkBox1.isChecked() &&
                checkBox3.isChecked() &&
                checkBox4.isChecked() &&
                !(checkBox2.isChecked())) {
            points++;
        }
    }

    /**
     * This method checks if the button clicked is the right answer. If so, add one point to total score
     */

    public void checkAnswer(String yourAnswer) {
        int rightAnswerId = getResources().getIdentifier("goodAnswerQ" + (questionNumber), "string", this.getPackageName());
        String rightAnswer = getString(rightAnswerId);

        if (yourAnswer.equals(rightAnswer)) {
            points++;
        }
    }

    public void checkAllAnswers() {

        // check answer for editText on question #2

        EditText textEntry2 = (EditText) findViewById(R.id.textEntry2);
        String yourAnswer2 = textEntry2.getText().toString();
        questionNumber = 2;
        checkAnswer(yourAnswer2);

        // check answer for editText on question #5

        EditText textEntry5 = (EditText) findViewById(R.id.textEntry5);
        String yourAnswer5 = textEntry5.getText().toString();
        questionNumber = 5;
        checkAnswer(yourAnswer5);

        // check answer for editText on question #8

        EditText textEntry7 = (EditText) findViewById(R.id.textEntry7);
        String yourAnswer7 = textEntry7.getText().toString();
        questionNumber = 7;
        checkAnswer(yourAnswer7);

        // check the answers for the checkbox
        checkCheckBoxAnswers();

        //display the message with the total points
        if (points == 7){
            Toast.makeText(MainActivity.this, "Your score is: " + points + " points out of 7. \nExcellent!", Toast.LENGTH_LONG).show();
        }
        else if (points == 1){
            Toast.makeText(MainActivity.this, "Your score is: " + points + " point", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Your score is: " + points + " points", Toast.LENGTH_LONG).show();
        }

        // disable the submit button
        Button submited = (Button) findViewById(R.id.submitButton);
        submited.setEnabled(false);

    }
}