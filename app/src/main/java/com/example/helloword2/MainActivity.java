package com.example.helloword2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.helloword2.fragment.AccountFragment;
import com.example.helloword2.fragment.AddFragment;
import com.example.helloword2.fragment.BudgetFragment;
import com.example.helloword2.fragment.HomeFragment;
import com.example.helloword2.fragment.TransactionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.fragmentContainerView, new HomeFragment()).commit();
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.navigation_transaction) {
                selectedFragment = new TransactionFragment();

            } else if (item.getItemId() == R.id.navigation_add) {
                selectedFragment = new AddFragment();

            } else if (item.getItemId() == R.id.navigation_budget) {
                selectedFragment = new BudgetFragment();

            } else if (item.getItemId() == R.id.navigation_account) {
                selectedFragment = new AccountFragment();
            }
            if (selectedFragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFragment).commit();
            }
            return true;
        });
    }
}
