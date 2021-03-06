package com.example.diego.glix.Support;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.diego.glix.Ajustes.AjustesActivity;
import com.example.diego.glix.Letras.LetrasActivity;
import com.example.diego.glix.Musica.MainActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Temporizador.TemporizadorActivity;
import com.example.diego.glix.Utils.BottomNavigationBarHelper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by diego on 24/01/18.
 */

public class SupportActivity extends AppCompatActivity {

    private static final String TAG = "SupportActivity";

    Context mcontext = SupportActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: onStarting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

       // setUp(bottomBar);

        //changing name of toolbar
        TextView tvTitle = (TextView)findViewById(R.id.toolbarTitulo);
        tvTitle.setText(R.string.tSupport);


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
                    Intent intentA = new Intent(SupportActivity.this, AjustesActivity.class);
                    startActivity(intentA);
                }
                else if(tabId == R.id.tabTemp)
                {
                    Intent intentT = new Intent(SupportActivity.this, TemporizadorActivity.class);
                    startActivity(intentT);
                }
                else if(tabId == R.id.tabLetra)
                {
                    Intent intentL = new Intent(SupportActivity.this, LetrasActivity.class);
                    startActivity(intentL);
                }
                else if(tabId == R.id.tabMusica)
                {
                    Intent intentM = new Intent(SupportActivity.this, MainActivity.class);
                    startActivity(intentM);
                }
            }
        });
    }
}
