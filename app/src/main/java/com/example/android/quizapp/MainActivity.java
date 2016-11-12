/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */
package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Ths App gives a quiz on Core Java and provides the result
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the submit quiz is clicked.
     */
    public void submitQuiz(View view) {

        int score = 0;
        String name;
        EditText nameText = (EditText) findViewById(R.id.name_view);
        name = nameText.getText().toString();

        String qNum;
        for (int i=0; i<5; i++) {
            qNum = "q" + String.valueOf(i+1);
            System.out.println("submitQuiz " + qNum);
            if (checkAnswer(qNum)) {score = score + 1;}
            System.out.println("Score = " + score);
        }
        //Toast Total Score
        String message = name + " : You have " + score + " out of 5 correct." + " Your score is " + (score/5.0)*100 + "%.";
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /* This method checks the answers to see if it is correct and returns true/false */
    private boolean checkAnswer(String q) {
        boolean correct = false;
        RadioButton radioButton;
        CheckBox checkBox1;
        CheckBox checkBox2;
        CheckBox checkBox3;
        CheckBox checkBox4;
        String q3Input;
        EditText q3Text;

        switch (q) {
            case "q1": {System.out.println("case q1");
                        radioButton = (RadioButton) findViewById(R.id.q1d); //Answer: Not Assigned
                        correct = radioButton.isChecked();
                        break;
                       }
            case "q2": {System.out.println("case q2");
                        checkBox1 = (CheckBox) findViewById(R.id.q2a); //Answer1: hello=hello + " World!";
                        checkBox2 = (CheckBox) findViewById(R.id.q2b);
                        checkBox3 = (CheckBox) findViewById(R.id.q2c);//Answer2: hello += " World!";
                        checkBox4 = (CheckBox) findViewById(R.id.q2d);
                        correct = checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked();
                        break;}
            case "q3": {System.out.println("case q3");
                        q3Text = (EditText) findViewById(R.id.q3a);
                        q3Input = q3Text.getText().toString();
                        correct = q3Input.equals("64 Bit");// 64Bit
                        break;}
            case "q4": {System.out.println("case q4");
                        radioButton = (RadioButton) findViewById(R.id.q4b); //IS-A relationship
                        correct = radioButton.isChecked();
                        break;}
            case "q5": {System.out.println("case q5");
                        radioButton = (RadioButton) findViewById(R.id.q5c); //public static void main(String[] args)
                        correct = radioButton.isChecked();
                        break;}
            default: correct = false; break;
        }
        return correct;
    }


}

