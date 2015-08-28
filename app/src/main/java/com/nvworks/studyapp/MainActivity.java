package com.nvworks.studyapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;


public class MainActivity extends ActionBarActivity  {

    String className = "DEBUG";

    private Button startButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(className,"Calling LoadFragment Method");
        LoadFragment();
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


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

    private void LoadFragment (){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Log.d(className,"Fragment manager created");
        fStopWatch stopWatch = new fStopWatch();
        transaction.add(R.id.main_topFrag,stopWatch);
        transaction.commit();

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */

}
