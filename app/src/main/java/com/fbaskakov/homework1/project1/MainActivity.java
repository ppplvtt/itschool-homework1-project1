package com.fbaskakov.homework1.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private Button setPosition;
    private SeekBar redColor, greenColor, blueColor;
    private TextView textRed, textGreen, textBlue;
    public String colorRGB;
    public int red_rgb, green_rgb, blue_rgb;


    private void init() {
        setPosition = (Button) findViewById(R.id.button);

        redColor = (SeekBar) findViewById(R.id.seekBar_red_color);
        greenColor = (SeekBar) findViewById(R.id.seekBar_green_color);
        blueColor = (SeekBar) findViewById(R.id.seekBar_blue_color);

        textRed = findViewById(R.id.text_red);
        textGreen = findViewById(R.id.text_green);
        textBlue = findViewById(R.id.text_blue);

        redColor.setMax(255);
        greenColor.setMax(255);
        blueColor.setMax(255);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        onSeekBar();
        ClickButton();
    }

    private void ClickButton() {
        setPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("COLOR_RGB", colorRGB);
                intent.putExtra("COLOR_RED", red_rgb);
                intent.putExtra("COLOR_GREEN", green_rgb);
                intent.putExtra("COLOR_BLUE", blue_rgb);
                startActivity(intent);
            }
        });
    }

    private void onSeekBar() {
        redColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        greenColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        blueColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void updateColor() {

        int red = redColor.getProgress();
        int green = greenColor.getProgress();
        int blue = blueColor.getProgress();

        textRed.setText(Integer.toString(red));
        textGreen.setText(Integer.toString(green));
        textBlue.setText(Integer.toString(blue));

        red_rgb = red;
        green_rgb = green;
        blue_rgb = blue;

        colorRGB = Integer.toString(red) + " " + Integer.toString(green) + " " + Integer.toString(blue);
    }
}