package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mETUserId;
    private Button mBtnFetchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnFetchData = findViewById(R.id.btnFetch);
        mETUserId = findViewById(R.id.etEnter);

        mBtnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("number",Integer.parseInt(mETUserId.getText().toString()));
                startActivity(intent);
            }
        });

    }
}