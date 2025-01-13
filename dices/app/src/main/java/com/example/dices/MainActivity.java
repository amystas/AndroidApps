package com.example.dices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ImageView> dices = new ArrayList<ImageView>
                (Arrays.asList(findViewById(R.id.dice1), findViewById(R.id.dice2),
                        findViewById(R.id.dice3), findViewById(R.id.dice4), findViewById(R.id.dice5)));
        Button rollTheDice = findViewById(R.id.rollTheDiceButton);
        AtomicInteger score = new AtomicInteger(0);
        rollTheDice.setOnClickListener((View view) -> {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for(int i=0; i<5; i++) {
                int randomNum = (int)(1 + Math.random() * 6);
                numbers.add(randomNum);
                dices.get(i).setImageResource(getResources()
                        .getIdentifier("dice" + String.valueOf(randomNum), "drawable", view.getContext().getPackageName()));
            }
            int points = 0;
            for(int i=0; i<5; i++) {
                if(Collections.frequency(numbers, numbers.get(i)) > 1)
                {
                    points += numbers.get(i);
                    score.addAndGet(numbers.get(i));
                }
            }
            TextView pointsDisplay = findViewById(R.id.latestScore);
            pointsDisplay.setText("Wynik tego losowania: " + String.valueOf(points));
            TextView scoreDisplay = findViewById(R.id.score);
            scoreDisplay.setText("Wynik gry: " + String.valueOf(score));

        });

        Button reset = findViewById(R.id.resetButton);
        reset.setOnClickListener((View view) -> {
            for(int i=0; i<5; i++) {
                dices.get(i).setImageResource(R.drawable.questionmark);
            }
            score.set(0);
            TextView pointsDisplay = findViewById(R.id.latestScore);
            pointsDisplay.setText("Wynik tego losowania: 0");
            TextView scoreDisplay = findViewById(R.id.score);
            scoreDisplay.setText("Wynik gry: " + String.valueOf(score));
        });
    }
}