package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button login;
    private EditText gmail;
    private EditText pass;
    private TextView signup;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        signup = findViewById(R.id.textView4);
        login = findViewById(R.id.button);
        gmail = findViewById(R.id.gmail);
        pass = findViewById(R.id.pass);
        db = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gm = gmail.getText().toString();
                String ps = pass.getText().toString();
                if(gm.isEmpty() || ps.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter all Details...", Toast.LENGTH_SHORT).show();
                }
                else if(db.check(gm,ps)){
                    Toast.makeText(MainActivity2.this, "Successfully Logged In!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, HomePage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity2.this, "Wrong Username/Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}