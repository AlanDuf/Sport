package com.example.sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SQLiteDatabase db = openOrCreateDatabase("UserDB",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,login TEXT,password TEXT)");
        db.execSQL("INSERT INTO user (login, password) VALUES ('Ez','Ez')");

        EditText loginField = findViewById(R.id.loginField);
        EditText PasswordField = findViewById(R.id.PasswordField);
        boolean exist = false;
        Switch aSwitch = findViewById(R.id.switch1);
        if(aSwitch.isChecked()){
            ContentValues newTaskValues = new ContentValues();
            String log = loginField.getText().toString();
            String psw = PasswordField.getText().toString();
            newTaskValues.put("login",loginField.getText().toString());
            newTaskValues.put("password",PasswordField.getText().toString());


            Cursor cursorSELECT = db.rawQuery("SELECT * FROM user", null);
            cursorSELECT.moveToFirst();
            while (!cursorSELECT.isLast()) {
                if(cursorSELECT.getString(1).equals(loginField.getText().toString()) && cursorSELECT.getString(2).equals(PasswordField.getText().toString())){
                    exist=true;
                }
                System.out.println(cursorSELECT.getString(1)+" login "+loginField.getText().toString() + cursorSELECT.getString(2)+ " Password "+PasswordField.getText().toString());
                cursorSELECT.moveToNext();
            }
            if(!exist){
                db.insert("user",null,newTaskValues);
            }
            else{
                aSwitch.setChecked(false);
            }

        }
        else {
            Cursor cursorSELECT = db.rawQuery("SELECT * FROM user", null);
            cursorSELECT.moveToFirst();
            while (!cursorSELECT.isLast()) {
                cursorSELECT.moveToNext();
                if(cursorSELECT.getString(1).equals(loginField.getText().toString()) && cursorSELECT.getString(2).equals(PasswordField.getText().toString())){
                    Intent activity2Intent = new Intent(getApplicationContext(), Activity2.class);
                    startActivity(activity2Intent);
                }
            }

            aSwitch.setChecked(true);
        }
    }
}