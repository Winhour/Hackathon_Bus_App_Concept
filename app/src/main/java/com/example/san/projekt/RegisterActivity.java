package com.example.san.projekt;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  RegisterActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    Button _btnlog;
    EditText _txtfname;
    EditText _txtlname;
    EditText _txtpass;
    EditText _txtemail;
    EditText _txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new DatabaseHelper(this);
        _btnreg = findViewById(R.id.btnreg);
        _txtfname = findViewById(R.id.txtfname);
        _txtlname = findViewById(R.id.txtlname);
        _txtpass = findViewById(R.id.txtpass);
        _txtemail = findViewById(R.id.txtemail);
        _txtphone = findViewById(R.id.txtphone);
        _btnlog = findViewById(R.id.btnlog);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname = _txtfname.getText().toString();
                String lname = _txtlname.getText().toString();
                String pass = _txtpass.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();
                insertdata(fname,lname,pass,email,phone);
                //GlobalVariables.current_fname = fname;
                Toast.makeText(getApplicationContext(),"Registration succesful", Toast.LENGTH_LONG).show();
            }
        });
        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });
    }

    public void insertdata(String fname, String lname,String pass, String email, String phone)
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_2, fname);
        values.put(DatabaseHelper.COL_3, lname);
        values.put(DatabaseHelper.COL_4, pass);
        values.put(DatabaseHelper.COL_5, email);
        values.put(DatabaseHelper.COL_6, phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null,values );
    }
}