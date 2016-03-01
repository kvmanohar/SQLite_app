package com.example.android.sqliteapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseController dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbcon = new DatabaseController(this);
        dbcon.openDB();
        populateListView();

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

        dbcon.insertDbRow(name, surname, marks);
        Toast.makeText(this, name + " Record added to Database", Toast.LENGTH_SHORT).show();

        populateListView();
    }

    public void populateListView(){

        Cursor cursor = dbcon.fetchDbRow();

        // The desired columns to be bound
        String[] columns = new String[]{
               "NAME","SURNAME"
        };

        //XML Defined view with the data will be bound to
        int[] to = new int[]{
//                R.id.textViewIdValue,
                R.id.textViewNameValue,
                R.id.textViewSurnameValue
//                R.id.textViewMarksValue
        };

//        Log.v("Cursor Object :" , DatabaseUtils.dumpCursorToString(cursor));

        ListView listView = (ListView) findViewById(R.id.listview_item);

        //Create the adapter using the cursor pointing to the desired data
        // as well as the layout information
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.student_record_layout,cursor,columns,to,1);

        // Now time to move the adapter to the list view
        listView.setAdapter(dataAdapter);


    }

}
