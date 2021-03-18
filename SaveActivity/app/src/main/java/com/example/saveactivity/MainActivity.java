package com.example.saveactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView message;
    Button button;

    private int m_number = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message1);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_number++;
                button.setBackgroundColor(Color.GRAY);
                setMessage();
            }
        });
    }
    private void setMessage(){
        message.setText("So thu tu" + m_number);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        ColorDrawable color = (ColorDrawable) button.getBackground();
        int mamau = color.getColor();

        outState.putInt("sothutu",m_number);
        outState.putInt("color",mamau);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        m_number = savedInstanceState.getInt("sothutu");
        int c = savedInstanceState.getInt("color");
        button.setBackgroundColor(c);

        setMessage();
    }
}