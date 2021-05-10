package com.example.san.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlobalVariables.handler.removeCallbacksAndMessages(null);

        Button btnOK = findViewById(R.id.button);
        Button btnPunkty = findViewById(R.id.button2);
        Button btnLog = findViewById(R.id.button4);
        Button btnReg = findViewById(R.id.button6);
        final TextView THaslo = findViewById(R.id.editText);
        final TextView TClog = findViewById(R.id.textView7);

        if (!GlobalVariables.current_login.equals("")){
            TClog.setText("Witaj " + GlobalVariables.current_login + "!");
        }

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String haslo = THaslo.getText().toString();
                String logOK = TClog.getText().toString();

                String current_haslo = GlobalVariables.haslo;

                if (haslo.equals(current_haslo) && !logOK.equals("zaloguj się!")){

                    startActivity(new Intent(MainActivity.this, TimerActivity.class));

                }

                else {
                    if (!haslo.equals(current_haslo)) {
                        Toast.makeText(MainActivity.this, "Podano błędne hasło " + haslo, Toast.LENGTH_LONG).show();
                    }
                    else Toast.makeText(MainActivity.this, "Nie jesteś zalogowany", Toast.LENGTH_LONG).show();
                }

            }
        });


        btnPunkty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, PunktyActivity.class));


            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, LoginActivity.class));


            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegisterActivity.class));


            }
        });








    }
}
