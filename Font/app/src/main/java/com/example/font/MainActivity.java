package com.example.font;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button incrementButton = findViewById(R.id.incrementButton);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        SeekBar seekBar = findViewById(R.id.seekBar);
        EditText size = findViewById(R.id.size);
        TextView sampleText = findViewById(R.id.sampleText);

        size.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b == false)
                {
                    int fontSize = Integer.parseInt(size.getText().toString());
                    if(fontSize >= 10 && fontSize <= 50)
                    {
                        sampleText.setTextSize(fontSize);
                        seekBar.setProgress(fontSize);
                    }
                }
            }
        });

        incrementButton.setOnClickListener((View view) -> {
            if(progressBar.getProgress() == 9) {
                incrementButton.setEnabled(false);
            }
            progressBar.incrementProgressBy(1);
            int progress = Integer.parseInt(size.getText().toString()) + 1;
            size.setText(String.valueOf(progress));
            sampleText.setTextSize(progress);
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                size.setText(String.valueOf(progress));
                sampleText.setTextSize(progress);
            }
        });
    }
}