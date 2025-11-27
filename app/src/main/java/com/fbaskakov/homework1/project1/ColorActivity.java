package com.fbaskakov.homework1.project1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ColorActivity extends Activity {
    private TextView RGB;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        setBackgroundColor();
    }

    private void setBackgroundColor() {
        RGB = (TextView) findViewById(R.id.text_background_rgb);
        layout = findViewById(R.id.mainLayout);

        Intent intent= getIntent();

        String colorRGB = intent.getStringExtra("COLOR_RGB");
        int red = intent.getIntExtra("COLOR_RED", 0);
        int green = intent.getIntExtra("COLOR_GREEN", 0);
        int blue = intent.getIntExtra("COLOR_BLUE", 0);

        int color = Color.rgb(red, green, blue);
        RGB.setText(colorRGB);
        layout.setBackgroundColor(color);
    }

}