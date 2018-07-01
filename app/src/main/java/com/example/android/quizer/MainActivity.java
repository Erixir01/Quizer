/**
 * this project has no undergo code optimization
 * please do take your time to go through it
 * thanks you for your opportunity
 */

package com.example.android.quizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizer.R;


public class MainActivity extends AppCompatActivity {

// Declaring variable and initializing to 0
    int questionOneAnswer = 0;
    int questionTwoAnswer = 0;
    int questionThreeAnswer = 0;
    int questionFourAnswer = 0;
    int questionFiveAnswer = 0;
    int questionSixAnswer = 0;
    int questionSevenAnswer = 0;
    int questionEightAnswer = 0;
    int questionNineAnswer = 0;
    int questionTenAnswer = 0;
    int scoreSectionA = 0;
    int scoreSectionB = 0;
    int scoreScetionC = 0;
    int scoreTotal = 0;
    Button scoreTotalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign button to refer an id from the xml file
        scoreTotalButton = (Button) findViewById(R.id.score_button);
        // give the button an action to perform
        scoreTotalButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                //summation of section a of radiobutton
                scoreSectionA = questionOneAnswer + questionTwoAnswer + questionThreeAnswer + questionFourAnswer;
                //summation of section C multi selections
                scoreSectionB = questionFiveAnswer + questionSixAnswer + questionSevenAnswer;
                //summation of section C free text response
                scoreScetionC = questionEightAnswer + questionNineAnswer + questionTenAnswer;

                //check if the correct answer are picked for question 5
                    if (questionFive()){
                        questionFiveAnswer = 1;
                }
                else{
                    questionFiveAnswer = 0;
                }

                //check if the correct answer are picked for question 6
                if (questionSix()){
                    questionSixAnswer = 1;
                }
                else{
                    questionSixAnswer = 0;
                }

                //check if the correct answer are picked for question 7
                if (questionSeven()){
                    questionSevenAnswer = 1;
                }
                else{
                    questionSevenAnswer = 0;
                }

                //section C free text response
                // operation for question 8
                EditText questionEight = (EditText) findViewById(R.id.q8_answer);
                String questionEightInput = questionEight.getText().toString();
                // check if the value entered is equal to the answer
                if(questionEightInput.matches("20")){
                    questionEightAnswer = 1;
                }
                else{
                    questionEightAnswer = 0;
                }

                // operation for question 9
                EditText questionNine = (EditText) findViewById(R.id.q9_answer);
                String questionNineInput = questionNine.getText().toString();
                // check if the value entered is equal to the answer
                if(questionNineInput.matches("summary == 5")){
                    questionNineAnswer = 1;
                }
                else{
                    questionNineAnswer = 0;
                }

                // operation for question 10
                EditText questionTen = (EditText) findViewById(R.id.q10_answer);
                String questionTenInput = questionTen.getText().toString();
                // check if the value entered is equal to the answer
                if(questionTenInput.matches("colorPrimary") || questionTenInput.matches("colorPrimaryDark") || questionTenInput.matches("colorAccent")){
                    questionTenAnswer = 1;
                }
                else{
                    questionTenAnswer = 0;
                }

                //summation of all the sections
                scoreTotal = scoreSectionA + scoreSectionB + scoreScetionC;
                if (scoreTotal == 10){
                    Toast.makeText(getApplicationContext(), "Congratulations. You answered correctly \nTotal Scores: " + scoreTotal, Toast.LENGTH_SHORT).show();
                }
                else
                     Toast.makeText(getApplicationContext(), "Welll Done. Please check the courseware \nYou Scored: " + scoreTotal, Toast.LENGTH_SHORT).show();

            }
        });

    }

    //Method for question one button click
    public void onQuestionOneRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1_option1:
                if (checked)
                    // if true give value to 1
                    if(questionOneAnswer == 0){
                        questionOneAnswer = +1;
                    } break;
            case R.id.q1_option2:
                if (checked)
                    // if true give value to 0
                    questionOneAnswer = 0;
                break;
            case R.id.q1_option3:
                if (checked)
                    // if true give value to 0
                    questionOneAnswer = 0;
                break;
        }
    }

   //Method for question two button click
    public void onQuestionTwoRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q2_option1:
                if (checked)
                    // if true give value to 0
                    questionTwoAnswer = 0;
                    break;
            case R.id.q2_option2:
                if (checked)
                    // if true give vale of 0
                    questionTwoAnswer = 0;
                break;
            case R.id.q2_option3:
                if (checked)
                    // if true give value to 1
                    if(questionTwoAnswer == 0){
                        questionTwoAnswer = +1;
                    } break;
        }
    }

    //Method for question three button click
    public void onQuestionThreeRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q3_option1:
                if (checked)
                    // if true give value 0
                    questionThreeAnswer = 0;
                break;
            case R.id.q3_option2:
                if (checked)
                    // if true give 0
                    questionThreeAnswer = 0;
                break;
            case R.id.q3_option3:
                if (checked)
                    // if true give value 1
                    if(questionThreeAnswer == 0){
                        questionThreeAnswer = +1;
                    } break;
        }
    }

    //Method for question three button click
    public void onQuestionFourRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q4_option1:
                if (checked)
                    // if true give value 0
                    questionFourAnswer = 0;
                break;
            case R.id.q4_option2:
                if (checked)
                    // if true give value 1
                    if(questionFourAnswer == 0){
                        questionFourAnswer = +1;
                    } break;
            case R.id.q4_option3:
                if (checked)
                    // if true give 0
                    questionFourAnswer = 0;
                break;
        }
    }

    //method to check for checkboxes
    public boolean questionFive (){

        CheckBox questionFiveOptionOne = (CheckBox) findViewById(R.id.q5_selection1);
        CheckBox questionFiveOptionTwo = (CheckBox) findViewById(R.id.q5_selection2);
        CheckBox questionFiveOptionThree = (CheckBox) findViewById(R.id.q5_selection3);
        CheckBox questionFiveOptionFour = (CheckBox) findViewById(R.id.q5_selection4);

        if (questionFiveOptionOne.isChecked() && questionFiveOptionTwo.isChecked() && questionFiveOptionThree.isChecked() && !questionFiveOptionFour.isChecked()){
            return true;
        }
        return false;
    }

    //method to check for checkboxes
    public boolean questionSix (){
        CheckBox questionSixOptionOne = (CheckBox) findViewById(R.id.q6_selection1);
        CheckBox questionSixOptionTwo = (CheckBox) findViewById(R.id.q6_selection2);
        CheckBox questionSixOptionThree = (CheckBox) findViewById(R.id.q6_selection3);

        if (questionSixOptionOne.isChecked() && questionSixOptionTwo.isChecked() && !questionSixOptionThree.isChecked()){
            return true;
        }
        return false;
    }

    //method to check for checkboxes
    public boolean questionSeven (){
        CheckBox questionSevenOptionOne = (CheckBox) findViewById(R.id.q7_selection1);
        CheckBox questionSevenOptionTwo = (CheckBox) findViewById(R.id.q7_selection2);
        CheckBox questionSevenOptionThree = (CheckBox) findViewById(R.id.q7_selection3);

        if (questionSevenOptionOne.isChecked() && questionSevenOptionTwo.isChecked() && !questionSevenOptionThree.isChecked()){
            return true;
        }
        return false;
    }


}
