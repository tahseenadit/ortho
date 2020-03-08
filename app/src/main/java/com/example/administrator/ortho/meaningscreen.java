package com.example.administrator.ortho;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class meaningscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaningscreen);
        DatabaseOpenHelper ms = new DatabaseOpenHelper(this);
        TextView text = (TextView) findViewById(R.id.textView2);
        TextView textView = (TextView) findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String t = extras.getString("android.intent.extra.PROCESS_TEXT") + " এর অর্থ  হল - ";
            text.setText(t);
            try {
                List<String> list = ms.getmeaning(extras.getString("android.intent.extra.PROCESS_TEXT"));
                //textView.setText(extras.getString("android.intent.extra.PROCESS_TEXT"));
                if(list.isEmpty()){
                    textView.setText("দুঃখিত, অর্থ  খুঁজে পাওয়া যায়নি ।");
                }else {
                    textView.setText(list.get(0));
                }
            }catch (Exception ex){

                textView.setText("দুঃখিত, অর্থ  খুঁজে পাওয়া যায়নি ।");
            }
        }else{

            text.setText("No text selected!");
            textView.setText("No meaning to show!");
        }
    }
}
