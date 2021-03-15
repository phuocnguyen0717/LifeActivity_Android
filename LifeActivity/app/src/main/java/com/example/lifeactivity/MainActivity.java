package com.example.lifeactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView; // thuoc tinh cua lop de truy cap tu cac phuong thuc khac


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       // Log.i(Tag, "OnCreate...");

        setContentView(R.layout.activity_main); //thiet lap giao dien

     textView = findViewById(R.id.textView1); //lay lai doi tuong textView

      //  textView.setText("AAA");// thiet lap dong chu moi
       // String s = textView.getText().toString();// Doc noi dung dong` chu
        Button button =findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(MainActivity.this,
//                    "Ban da nhan vao nut",
//                    Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        SecondActivity.class);


                String s = textView.getText().toString(); // Doc du lieu
                intent.putExtra("dulieu",s);
                startActivityForResult(intent,SecondActivity.TRAVE_TUACTIVITY2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SecondActivity.TRAVE_TUACTIVITY2){
            String s = data.getStringExtra("dulieu");
            textView.setText(s);
        }
    }
    //    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i(Tag,"onStart...");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i(Tag,"onResume...");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i(Tag,"onPause...");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i(Tag,"onStop...");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i(Tag,"onDestroy...");
//    }
}