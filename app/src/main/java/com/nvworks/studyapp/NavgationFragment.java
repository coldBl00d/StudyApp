package com.nvworks.studyapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavgationFragment extends Fragment {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Context context;


//__________________________________________________________________________________________________

    public NavgationFragment() {
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navgation, container, false);
    }

    public void setup(DrawerLayout drawerlayout, final Toolbar toolbar) {
        mDrawerLayout = drawerlayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerlayout,toolbar, R.string.open,R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
                Log.i("openein", "open");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
                Log.i("close","close");
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset<.4) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

}
