package com.example.diego.glix.Temporizador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.diego.glix.Ajustes.AjustesActivity;
import com.example.diego.glix.Letras.LetrasActivity;
import com.example.diego.glix.Musica.MainActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Support.SupportActivity;
import com.example.diego.glix.Utils.BottomNavigationBarHelper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by diego on 24/01/18.
 */

public class TemporizadorActivity extends AppCompatActivity {

    private static final String TAG = "TemporizadorActivity";

    Context mcontext = TemporizadorActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: onStarting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
       // setUpBottomNavigationView(bottomBar);
        setUp(bottomBar);


    }

    private void setUpBottomNavigationView(BottomBar bottomBar)
    {

        BottomNavigationBarHelper.enableNavigation(mcontext, bottomBar);
    }

    private void setUp(BottomBar bottomBar)
    {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tabAjustes) {
                    Intent intentA = new Intent(TemporizadorActivity.this, AjustesActivity.class);
                    startActivity(intentA);
                }
                else if(tabId == R.id.tabSupport)
                {
                    Intent intentT = new Intent(TemporizadorActivity.this, SupportActivity.class);
                    startActivity(intentT);
                }
                else if(tabId == R.id.tabLetra)
                {
                    Intent intentL = new Intent(TemporizadorActivity.this, LetrasActivity.class);
                    startActivity(intentL);
                }
                else if(tabId == R.id.tabMusica)
                {
                    Intent intentM = new Intent(TemporizadorActivity.this, MainActivity.class);
                    startActivity(intentM);
                }
            }
        });
    }
}
