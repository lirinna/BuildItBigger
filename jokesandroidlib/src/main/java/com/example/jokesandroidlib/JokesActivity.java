package com.example.jokesandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    TextView tv_joke;
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        tv_joke = findViewById(R.id.tv_joke);
        joke = getIntent().getStringExtra("joke");
        if (joke != null) {
            tv_joke.setText(joke);
        }

    }

}
