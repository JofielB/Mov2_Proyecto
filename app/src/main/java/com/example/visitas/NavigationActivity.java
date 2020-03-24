package com.example.visitas;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class NavigationActivity extends AppCompatActivity {

    private ActionBar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolBar = getSupportActionBar();

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        toolBar.setTitle("GROUPS");
        loadFragment(new GroupFragment());
    }
    
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_groups:
                    toolBar.setTitle("GROUPS");
                    NavigationActivity.this.loadFragment(new GroupFragment());
                    return true;
                case R.id.navigation_schedule:
                    toolBar.setTitle("SCHEDULE");
                    NavigationActivity.this.loadFragment(new ScheduleFragment());
                    return true;
                case R.id.navigation_profile:
                    toolBar.setTitle("PROFILE");
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
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
