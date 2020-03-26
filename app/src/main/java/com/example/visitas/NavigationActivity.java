package com.example.visitas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.visitas.fragments.GroupFragment;
import com.example.visitas.fragments.ProfileFragment;
import com.example.visitas.fragments.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NavigationActivity extends AppCompatActivity {

    private ActionBar toolBar;
    private RelativeLayout relativeLayout;
    private  BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolBar = getSupportActionBar();

        navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        toolBar.setTitle("Groups");

        //LOAD FRAGMENT FOR THE FIRST TIME
        loadFragment(new GroupFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.header_nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.header_nav_settings){
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_groups:
                    toolBar.setTitle("Groups");
                    NavigationActivity.this.loadFragment(new GroupFragment());
                    return true;
                case R.id.navigation_schedule:
                    toolBar.setTitle("Schedule");
                    NavigationActivity.this.loadFragment(new ScheduleFragment());
                    return true;
                case R.id.navigation_profile:
                    toolBar.setTitle("Profile");
                    NavigationActivity.this.loadFragment(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment){
        //LOAD FRAGMENT
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    //TODO DARK MODE FUNCTION IN PROGRESS
    private void setDarkMode(){
        //GET THE DATA FROM SHARED PREFERENCE
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);
        boolean darkModePreference = sharedPreferences.getBoolean("dark_mode_preference",false);

        relativeLayout = findViewById(R.id.parent_layout);
        if(darkModePreference){//Dark mode
            relativeLayout.setBackgroundColor(getColor(R.color.backgroundColorDarkMode));
        }else{//Light mode
            relativeLayout.setBackgroundColor(Color.WHITE);
        }
        Toast.makeText(this,""+ darkModePreference,Toast.LENGTH_SHORT).show();
    }
}
