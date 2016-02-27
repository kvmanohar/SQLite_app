package com.example.android.sqliteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseController dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbcon = new DatabaseController(this);
        dbcon.openDB();

    }


    public void insertButtonClick(View view){

        EditText nameText = (EditText) findViewById(R.id.name_field);
        EditText surnameText = (EditText) findViewById(R.id.surname_field);
        EditText marksText = (EditText) findViewById(R.id.marks_field);

        final String name = nameText.getText().toString();
        if (name.length() == 0) {
            Toast.makeText(this, "Enter Name value", Toast.LENGTH_SHORT).show();
            return;
        }

        final String surname = surnameText.getText().toString();
        int marks = Integer.valueOf(marksText.getText().toString());

        dbcon.insertDbRow(name,surname,marks);

        Toast.makeText(this, name + " Record added to Database", Toast.LENGTH_SHORT).show();

    }


}
