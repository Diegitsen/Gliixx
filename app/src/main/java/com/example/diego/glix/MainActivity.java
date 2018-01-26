package com.example.diego.glix;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.diego.glix.Utils.BottomNavigationBarHelper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
     public int cont = 0;

    Context mcontext = MainActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: onStarting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        //setUpBottomNavigationView(bottomBar);
        setUp(bottomBar);


    }

    private void setUpBottomNavigationView(BottomBar bottomBar)
    {

        BottomNavigationBarHelper.enableNavigation(mcontext, bottomBar);
        cont++;
    }

    private void setUp(BottomBar bottomBar)
    {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tabAjustes) {
                    Intent intentA = new Intent(MainActivity.this, AjustesActivity.class);
                    startActivity(intentA);
                }
                else if(tabId == R.id.tabTemp)
                {
                    Intent intentT = new Intent(MainActivity.this, TemporizadorActivity.class);
                    startActivity(intentT);
                }
                else if(tabId == R.id.tabLetra)
                {
                    Intent intentL = new Intent(MainActivity.this, LetrasActivity.class);
                    startActivity(intentL);
                }
                else if(tabId == R.id.tabSupport)
                {
                    Intent intentS = new Intent(MainActivity.this, SupportActivity.class);
                    startActivity(intentS);
                }
            }
        });
    }
}
