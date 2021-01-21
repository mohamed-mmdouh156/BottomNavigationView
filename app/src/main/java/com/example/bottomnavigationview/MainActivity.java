package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(NavBottom);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment3 , new FirstFragment()).commit();



    }


    private BottomNavigationView.OnNavigationItemSelectedListener NavBottom = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragmet = null;

            switch (item.getItemId())
            {
                case R.id.firstFragment :
                    selectedFragmet = new FirstFragment();
                    break;
                case R.id.secondFragment :
                    selectedFragmet = new SecondFragment();
                    break;
                case R.id.thirdFragment :
                    selectedFragmet = new ThirdFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment3 , selectedFragmet).commit();

            return true;
        }
    };


}