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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavgationFragment extends Fragment {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Context context;

    private NavItem1Listener navItem1Listener= new NavItem1Listener();
    private NavItem2Listener navItem2Listener= new NavItem2Listener();
    private NavItem3Listener navItem3Listener= new NavItem3Listener();
    private NavItem4Listener navItem4Listener= new NavItem4Listener();
    private NavItem5Listener navItem5Listener= new NavItem5Listener();


//__________________________________________________________________________________________________

    public NavgationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_navgation, container, false);
        context= getActivity().getApplicationContext();

        TextView listText1=(TextView) view.findViewById(R.id.navListText1);
        ImageView listIcon1=(ImageView) view.findViewById(R.id.navDrawerIconView1);
        listText1.setOnClickListener(navItem1Listener);
        listIcon1.setOnClickListener(navItem1Listener);

        TextView listText2=(TextView) view.findViewById(R.id.navListText2);
        ImageView listIcon2=(ImageView) view.findViewById(R.id.navDrawerIconView2);
        listText2.setOnClickListener(navItem2Listener);
        listIcon2.setOnClickListener(navItem2Listener);

        TextView listText3=(TextView) view.findViewById(R.id.navListText3);
        ImageView listIcon3=(ImageView) view.findViewById(R.id.navDrawerIconView3);
        listText3.setOnClickListener(navItem3Listener);
        listIcon3.setOnClickListener(navItem3Listener);

        TextView listText4=(TextView) view.findViewById(R.id.navListText4);
        ImageView listIcon4=(ImageView) view.findViewById(R.id.navDrawerIconView4);
        listText4.setOnClickListener(navItem4Listener);
        listIcon4.setOnClickListener(navItem4Listener);

        TextView listText5=(TextView) view.findViewById(R.id.navListText5);
        ImageView listIcon5=(ImageView) view.findViewById(R.id.navDrawerIconView5);
        listText5.setOnClickListener(navItem5Listener);
        listIcon5.setOnClickListener(navItem5Listener);

        return view;
    }

    public void setup(DrawerLayout drawerlayout, final Toolbar toolbar) {
        mDrawerLayout = drawerlayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerlayout, toolbar, R.string.open, R.string.close) {

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
                Log.i("close", "close");
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset < .4) {
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

    //----------------------inner-classes----------aditya-kp----------------------------------------
    class NavItem1Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "list item 1", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getActivity(), demoActivity.class);
            startActivity(intent);
        }
    }

    class NavItem2Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
           Toast.makeText(context, "list item 2", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getActivity(), demoActivity.class);
            startActivity(intent);
        }
    }

    class NavItem3Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "list item 3", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getActivity(), demoActivity.class);
            startActivity(intent);
        }
    }

    class NavItem4Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "list item 4", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getActivity(), demoActivity.class);
            startActivity(intent);
        }
    }

    class NavItem5Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "list item 5", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getActivity(), demoActivity.class);
            startActivity(intent);
        }
    }

}
