package com.example.diego.glix.Letras;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.diego.glix.Ajustes.AjustesActivity;
import com.example.diego.glix.Musica.MainActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Support.SupportActivity;
import com.example.diego.glix.Temporizador.TemporizadorActivity;
import com.example.diego.glix.Utils.BottomNavigationBarHelper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by diego on 24/01/18.
 */

public class LetrasActivity extends AppCompatActivity {

    private static final String TAG = "LetrasActivity";

    private Context mcontext = LetrasActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: onStarting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
       // setUpBottomNavigationView(bottomBar);
        setUp(bottomBar);

    }

    private void setUpBottomNavigationView(BottomBar bottomBar) {

        BottomNavigationBarHelper.enableNavigation(mcontext, bottomBar);
    }

    private void setUp(BottomBar bottomBar)
    {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tabAjustes) {
                    Intent intentA = new Intent(LetrasActivity.this, AjustesActivity.class);
                    startActivity(intentA);
                }
                else if(tabId == R.id.tabTemp)
                {
                    Intent intentT = new Intent(LetrasActivity.this, TemporizadorActivity.class);
                    startActivity(intentT);
                }
                else if(tabId == R.id.tabMusica)
                {
                    Intent intentM = new Intent(LetrasActivity.this, MainActivity.class);
                    startActivity(intentM);
                }
                else if(tabId == R.id.tabSupport)
                {
                    Intent intentS = new Intent(LetrasActivity.this, SupportActivity.class);
                    startActivity(intentS);
                }
            }
        });
    }
}
