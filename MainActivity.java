package com.example.mark.savetoandroidtest;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private int count;
    private TextView T;
    private Button advanceButton;

// Add this file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        T = (TextView) findViewById(R.id.idCount);

        advanceButton = (Button) findViewById(R.id.Advance);
        SharedPreferences settings = getSharedPreferences("myFile", 0);
        count = settings.getInt("Count", 0);

        //Toast.makeText(getApplicationContext(),count,
          //      Toast.LENGTH_SHORT).show();

        String c = Integer.toString(count);
        T.setText(c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onSaveClick(View v) {
        SharedPreferences settings = getSharedPreferences("myFile", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Count",count);
        editor.commit();
    }

    public void onAdvanceClick(View v){
        count++;
        String c = Integer.toString(count);
        T.setText(c);
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
