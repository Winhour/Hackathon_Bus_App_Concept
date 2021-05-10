package com.example.san.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _btnLogin;
    EditText _txtEmail, _txtPass;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _btnLogin = findViewById(R.id.btnLogin);
        _txtEmail = findViewById(R.id.txtEmail);
        _txtPass = findViewById(R.id.txtPass);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =_txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5+ "=? AND " + DatabaseHelper.COL_4  + "=? ", new String[]{email, pass} );
                if(cursor!=null);
                {
                    if (cursor.getCount()>0){
                        Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                        GlobalVariables.current_login = email;
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                        }
                    else
                        {
                            Toast.makeText(getApplicationContext(),"Login Unsuccessful", Toast.LENGTH_LONG).show(); }
                        }
            }
        }
        );
    }
}
