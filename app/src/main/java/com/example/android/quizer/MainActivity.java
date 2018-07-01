package com.example.android.quizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

// Declaring varaible and initializing to 0

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
    CheckBox questionFiveOptionOne, questionFiveOptionTwo, questionFiveOptionThree, questionFiveOptionFour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign button to refer an id from the xml file
        scoreTotalButton = (Button) findViewById(R.id.score_button);


        //section B question five
        //Assign checkbox id
        questionFiveOptionOne = (CheckBox) findViewById(R.id.q5_selection1);
        questionFiveOptionTwo = (CheckBox) findViewById(R.id.q5_selection2);
        questionFiveOptionThree = (CheckBox) findViewById(R.id.q5_selection3);
        questionFiveOptionFour = (CheckBox) findViewById(R.id.q5_selection4);

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
                //summation of all the sections
                scoreTotal = scoreSectionA + scoreSectionB + scoreScetionC;

                //check if the correct answer are picked
                    if (QuestionFive()){
                    //questionFiveAnswer = +1;
                    Log.v("MainActivity", "anser5: " + questionFiveAnswer);
                }
                else{
                    questionFiveAnswer = 0;
                }

                Log.v("MainActivity", "total: " + scoreTotal);
                Toast.makeText(getApplicationContext(), "You Scored: " + scoreTotal, Toast.LENGTH_SHORT).show();

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
    public boolean QuestionFive (){

        CheckBox questionFiveOptionOne = (CheckBox) findViewById(R.id.q5_selection1);
        CheckBox questionFiveOptionTwo = (CheckBox) findViewById(R.id.q5_selection2);
        CheckBox questionFiveOptionThree = (CheckBox) findViewById(R.id.q5_selection3);
        CheckBox questionFiveOptionFour = (CheckBox) findViewById(R.id.q5_selection4);

        if (questionFiveOptionOne.isChecked() && questionFiveOptionTwo.isChecked() && questionFiveOptionThree.isChecked() && !questionFiveOptionFour.isChecked()){
            questionFiveAnswer = +1;
            return true;
        }
        return false;
    }

}
