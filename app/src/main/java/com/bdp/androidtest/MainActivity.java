package com.bdp.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton ibMcOption;
    ImageButton ibVisaOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_card);

        ibMcOption = findViewById(R.id.ibMcOption);
        ibVisaOption = findViewById(R.id.ibVisaOption);

        ibMcOption.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ibVisaOption.setBackground(getDrawable(R.drawable.btn_border_gray));
                ibMcOption.setBackground(getDrawable(R.drawable.btn_border_blue));
            }
        });

        ibVisaOption.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ibMcOption.setBackground(getDrawable(R.drawable.btn_border_gray));
                ibVisaOption.setBackground(getDrawable(R.drawable.btn_border_blue));
            }
        });
    }
}
