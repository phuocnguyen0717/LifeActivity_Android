package com.example.lifeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    public  static  int TRAVE_TUACTIVITY2 = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_second); // thiet lap giao dien
        Intent i = getIntent(); //Goi lai Intent

        String z  = i.getStringExtra("dulieu"); //Doc  chuoi  du lieu

        EditText editText  = findViewById(R.id.EditText2); // lay lai doi tuong textView
        editText.setText(z); // xu ly du lieu roi dan' vao

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                String v = editText.getText().toString();
                i.putExtra("dulieu",v);
                setResult(TRAVE_TUACTIVITY2,i);
                finish();
            }
        });
    }
}