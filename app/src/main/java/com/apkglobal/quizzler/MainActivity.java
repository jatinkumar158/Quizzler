package com.apkglobal.quizzler;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_true, btn_false;
    TextView tv,score;
    int index,correctAns;
    int question;
    ProgressBar progressBar;
    TrueFalse[] questionBank = new TrueFalse[]{

            new TrueFalse(R.string.question1, true),
            new TrueFalse(R.string.question2, false),
            new TrueFalse(R.string.question3, false),
            new TrueFalse(R.string.question4, false),
            new TrueFalse(R.string.question5, false),
            new TrueFalse(R.string.question6, false),
            new TrueFalse(R.string.question7, false),
            new TrueFalse(R.string.question8, false),
            new TrueFalse(R.string.question9, true),
            new TrueFalse(R.string.question10, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_true = findViewById(R.id.btn_true);
        btn_false = findViewById(R.id.btn_false);
        tv = findViewById(R.id.tv);
        score=findViewById(R.id.score);
        progressBar=findViewById(R.id.progressbar);
        question = questionBank[index].getQuestionid();
        tv.setText(question);
        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                update();
            }
        });

        btn_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                update();
            }
        });
    }

    int increment;

    void update() {
        index = (index + 1) % questionBank.length;
        if(index == 0)
        {
            AlertDialog.Builder myalert=new AlertDialog.Builder(this);
            myalert.setTitle("Game over");
            myalert.setMessage("You scored "+correctAns+" out of "+questionBank.length);
            myalert.setCancelable(false);
            myalert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            myalert.show();
        }
        question = questionBank[index].getQuestionid();
        tv.setText(question);
        increment=(int)Math.ceil(100.0/questionBank.length);
        progressBar.incrementProgressBy(increment);
        score.setText("Score:"+correctAns+"/"+questionBank.length);

    }

    void checkAnswer(boolean userSelection)
    {
        boolean correct=questionBank[index].isAnswer();
        if(userSelection==correct)
        {
            Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
            correctAns++;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_SHORT).show();
        }
    }
}
