package com.example.administrator.ortho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(MainActivity.this,meaningscreen.class);
        CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
        intent.putExtra("android.intent.extra.PROCESS_TEXT", text); // String
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", false); // boolean
        startActivity(intent);
//        String processedText = data.getStringExtra(android.intent.extra.PROCESS_TEXT);
    }
}
