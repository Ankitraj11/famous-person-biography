package com.example.c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
  private FrameLayout homeframelayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    homeframelayout=findViewById(R.id.Home_frameLayout);
           setHomeFragment(new HomeFragment());



    }

    private void setHomeFragment(HomeFragment homeFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(homeframelayout.getId(),homeFragment);
        fragmentTransaction.commit();



    }




}
