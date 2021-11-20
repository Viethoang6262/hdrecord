package com.example.hdrecord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.example.hdrecord.rvs.RecordActivity;
import com.example.hdrecord.rvs.SettingActivity;
import com.example.hdrecord.rvs.VideoActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private static final int FRAGMENT_RECORD = 0;
    private static final int FRAGMENT_VIDEO = 1;
    private static final int FRAGMENT_SETTING = 2;

    private int currentFragment = FRAGMENT_RECORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new RecordActivity());
        navigationView.getMenu().findItem(R.id.nav_record).setChecked(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_record) {
           if (currentFragment != FRAGMENT_RECORD) {
               replaceFragment(new RecordActivity());
               currentFragment = FRAGMENT_RECORD;
           }
        } else if (id == R.id.nav_video) {
           if (currentFragment != FRAGMENT_VIDEO) {
               replaceFragment(new VideoActivity());
               currentFragment = FRAGMENT_VIDEO;
           }
        }  else if (id == R.id.nav_setting) {
            if (currentFragment != FRAGMENT_SETTING) {
                replaceFragment(new SettingActivity());
                currentFragment = FRAGMENT_SETTING;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }
}