package com.example.mentalgyaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeFields();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TherapyFragment()).commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    //handle bottomnavigation buttons
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {

                case R.id.bot_chatbot: {
                    startActivity(new Intent(MainActivity.this, ChatBotActivity.class));
                    break;
                }

                case R.id.bot_therapy: {
                    selectedFragment = new TherapyFragment();
                    break;
                }

                case R.id.bot_quotes: {
                    selectedFragment = new QuotesFragment();
                    break;
                }


                case R.id.bot_discover: {
                    selectedFragment = new DiscoverFragment();

                    break;
                }





            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();


            return true;

        }


    };
    private void InitializeFields() {

        SetupToolbar();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot_nav);


    }

    private void SetupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.main_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("MentalGyaan");


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
