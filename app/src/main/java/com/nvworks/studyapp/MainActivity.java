package com.nvworks.studyapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;


public class MainActivity extends ActionBarActivity  {

    private Button startButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadFragment();
        setupToolNav();
    }

    private void setupToolNav() {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Home");
        NavgationFragment navfrag = (NavgationFragment) getFragmentManager().findFragmentById(R.id.nav_fragment);
        navfrag.setup((DrawerLayout) findViewById(R.id.maindrawerlayout), toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
       return super.onOptionsItemSelected(item);
    }

    private void LoadFragment (){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fStopWatch stopWatch = new fStopWatch();
        transaction.add(R.id.main_topFrag,stopWatch);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
