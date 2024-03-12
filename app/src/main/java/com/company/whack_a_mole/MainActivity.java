package com.company.whack_a_mole;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTime,textViewCountDown,textViewScore;
    private ImageView hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9;
    private GridLayout gridLayout;
    int score=0;
    ImageView[] holesArray;
    MediaPlayer mediaPlayer;
    Runnable runnable;
    Handler handler;
    boolean status=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTime = findViewById(R.id.textViewTime);
        textViewCountDown = findViewById(R.id.textViewCountDown);
        textViewScore = findViewById(R.id.textViewScore);
       hole1 = findViewById(R.id.hole1);
        hole2 = findViewById(R.id.hole2);
        hole3 = findViewById(R.id.hole3);
        hole4 = findViewById(R.id.hole4);
        hole5 = findViewById(R.id.hole5);
        hole6 = findViewById(R.id.hole6);
        hole7 = findViewById(R.id.hole7);
        hole8 = findViewById(R.id.hole8);
        hole9= findViewById(R.id.hole9);


        gridLayout = findViewById(R.id.gridLayout);



        holesArray = new ImageView[]{hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9};



        new CountDownTimer(5000,1000){
            @Override
            public void onTick(long millisUntilFinished){

                textViewCountDown.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                holesControl();



                new CountDownTimer(30000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        textViewTime.setText("Remaining Time : "+millisUntilFinished/1000);

                    }

                    @Override
                    public void onFinish() {

                        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra("score",score);
                        startActivity(intent);
                        finish();

                    }
                }.start();

            }
        }.start();
    }
    public void increaseScoreByOne(View view)
    {

        score++;
        textViewScore.setText("Score : "+score);

        if (view.getId() == hole1.getId())
        {
            hole1.setImageResource(R.drawable.hammer);
            hole1.setClickable(false);
        }
        if (view.getId() == hole2.getId())
        {
            hole2.setImageResource(R.drawable.hammer);
            hole2.setClickable(false);
        }
        if (view.getId() == hole3.getId())
        {
            hole3.setImageResource(R.drawable.hammer);
            hole3.setClickable(false);
        }
        if (view.getId() == hole4.getId())
        {
            hole4.setImageResource(R.drawable.hammer);
            hole4.setClickable(false);
        }
        if (view.getId() == hole5.getId())
        {
            hole5.setImageResource(R.drawable.hammer);
            hole5.setClickable(false);
        }
        if (view.getId() == hole6.getId())
        {
            hole6.setImageResource(R.drawable.hammer);
            hole6.setClickable(false);
        }
        if (view.getId() == hole7.getId())
        {
            hole7.setImageResource(R.drawable.hammer);
            hole7.setClickable(false);
        }
        if (view.getId() == hole8.getId())
        {
            hole8.setImageResource(R.drawable.hammer);
            hole8.setClickable(false);
        }
        if (view.getId() == hole9.getId())
        {
            hole9.setImageResource(R.drawable.hammer);
            hole9.setClickable(false);
        }

    }

    public void holesControl()
    {
        textViewCountDown.setVisibility(View.INVISIBLE);
        textViewTime.setVisibility(View.VISIBLE);
        textViewScore.setVisibility(View.VISIBLE);
        hole1.setClickable(false);
        hole2.setClickable(false);
        hole3.setClickable(false);
        hole4.setClickable(false);
        hole5.setClickable(false);
        hole6.setClickable(false);
        hole7.setClickable(false);
        hole8.setClickable(false);
        hole9.setClickable(false);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView hole : holesArray)
                {
                    hole.setImageResource(R.drawable.hole);


                }
                gridLayout.setVisibility(View.VISIBLE);

                Random random = new Random();
                int i = random.nextInt(holesArray.length);
                hole1.setClickable(false);
                hole2.setClickable(false);
                hole3.setClickable(false);
                hole4.setClickable(false);
                hole5.setClickable(false);
                hole6.setClickable(false);
                hole7.setClickable(false);
                hole8.setClickable(false);
                hole9.setClickable(false);
                holesArray[i].setClickable(true);
                holesArray[i].setImageResource(R.drawable.mole);



                if (score <= 5)
                {
                    handler.postDelayed(runnable,2000);
                }
                else if (score > 5 && score <= 10)
                {
                    handler.postDelayed(runnable,1500);
                }
                else if (score > 10 && score <= 15)
                {
                    handler.postDelayed(runnable,1000);
                }

                else if (score > 15)
                {
                    handler.postDelayed(runnable,500);
                }

            }
        };

        handler.post(runnable);

    }



    }
