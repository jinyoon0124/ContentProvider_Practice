package com.example.jinyoon.userdictionary;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView dictextView = (ListView) findViewById(R.id.dictionary_text_view);

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);

//        String countStatement = String.format(getString(R.string.count_statement), cursor.getCount());
//        dictextView.setText(countStatement);
//        String xx = "COLUMNS: "+ UserDictionary.Words._ID +" - "
//                + UserDictionary.Words.FREQUENCY + " - " +UserDictionary.Words.WORD;
//        dictextView.append(xx);

//        int idColumn = cursor.getColumnIndex(UserDictionary.Words._ID);
//        int frequencyColumn = cursor.getColumnIndex(UserDictionary.Words.FREQUENCY);
//        int wordColumn = cursor.getColumnIndex(UserDictionary.Words.WORD);
//
//
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.two_line_list_item,
                cursor,
                new String[]{UserDictionary.Words.WORD, UserDictionary.Words.FREQUENCY},
                new int[]{android.R.id.text1, android.R.id.text2},
                0);


        dictextView.setAdapter(cursorAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
