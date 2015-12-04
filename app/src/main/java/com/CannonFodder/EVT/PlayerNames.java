package com.CannonFodder.EVT;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Override;import java.lang.String;

public class PlayerNames extends Activity {
    EditText et1;
    EditText et2;

    // Preference file name
    public static final String PREF_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        et1 = (EditText) findViewById(R.id.etxt1);
        et2 = (EditText) findViewById(R.id.etxt2);

        findViewById(R.id.save).setOnClickListener(saver);
    }

    private View.OnClickListener saver = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Shared Prefs is Now PlayerPrefs which unity uses
            SharedPreferences pref  = getApplicationContext().getSharedPreferences(getApplicationContext().getPackageName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            if(pref.contains("player1name") || pref.contains("player2name")){
                editor.clear();
                editor.commit();
            }

            editor.putString("player1name", et1.getText().toString());
            editor.putString("player2name", et2.getText().toString());
            editor.commit();

            Toast toast = Toast.makeText(getApplicationContext(), "SAVED NAMES", Toast.LENGTH_SHORT);
            toast.show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_names, menu);
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
