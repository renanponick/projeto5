package com.example.projeto5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.tView);
        button1 = (Button)findViewById(R.id.bButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent, 2);// Activity com requestCode = 2
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Verifica se o requestCode recebido é o mesmo que o enviado
        if(requestCode == 2) {
            String message = data.getStringExtra("MESSAGE");
            textView1.setText(message);
        }
    }
}