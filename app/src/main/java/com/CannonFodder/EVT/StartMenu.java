package com.CannonFodder.EVT;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.lang.Class;import java.lang.Override;

public class StartMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        findViewById(R.id.play_button).setOnClickListener(menulistener);
        findViewById(R.id.player_set_button).setOnClickListener(menulistener);
        findViewById(R.id.hist_button).setOnClickListener(menulistener);

        // Shared Prefs is Now PlayerPrefs which unity uses
        SharedPreferences pref  = getApplicationContext().getSharedPreferences(getApplicationContext().getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        // Instantiating match history uses same system as my Tic-Tac-Toe Game
        editor.putString("hist1", null);
        editor.putString("hist2", null);
        editor.putString("hist3", null);
        editor.putString("hist4", null);
        editor.putString("hist5", null);
        editor.apply();
    }

    private View.OnClickListener menulistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.play_button:
                    Log.d("CLICKED", "play button");
                    intent_starter(UnityPlayerActivity.class);
                    break;
                case R.id.player_set_button:
                    Log.d("CLICKED", "set player button");
                    intent_starter(PlayerNames.class);
                    break;
                 /* History is a heartbreaker
                 case R.id.hist_button:
                    Log.d("CLICKED", "hist button");
                    intent_starter(history.class);
                    break;
                 */
            }
        }
    };

    // Intent starter used to swap activities
    private void intent_starter(Class call_class){
        Intent swintent = new Intent((getApplicationContext()), call_class);
        startActivity(swintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_menu, menu);
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
