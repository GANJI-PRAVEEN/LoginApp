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


public class MainActivity extends AppCompatActivity {
    private Button signup;
    private EditText gmail;
    private EditText pass;

    //        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    private EditText name;
    private EditText ph;


    private TextView login;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nam);
        ph=findViewById(R.id.ph);
        pass=findViewById(R.id.pass1);

        signup = findViewById(R.id.button);
        login = findViewById(R.id.textView4);
        gmail = findViewById(R.id.gmail);

        db = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String gm = gmail.getText().toString();
                String ps = pass.getText().toString();
                String na = name.getText().toString();
                String p = ph.getText().toString();

                if(gm.isEmpty() || ps.isEmpty() || na.isEmpty() || p.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter all the Details", Toast.LENGTH_SHORT).show();

                }

                else if(db.addUser(gm,ps,na,p)){
                Toast.makeText(MainActivity.this, "Signed Up Successfully!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "code Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }
}