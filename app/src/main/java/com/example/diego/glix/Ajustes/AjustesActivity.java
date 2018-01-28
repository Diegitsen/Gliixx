package com.example.diego.glix.Ajustes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.diego.glix.Letras.LetrasActivity;
import com.example.diego.glix.Musica.MainActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Support.SupportActivity;
import com.example.diego.glix.Temporizador.TemporizadorActivity;
import com.example.diego.glix.Utils.BottomNavigationBarHelper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.w3c.dom.Text;

/**
 * Created by diego on 24/01/18.
 */

public class AjustesActivity extends AppCompatActivity {

    private static final String TAG = "AjustesActivity";

    Context mcontext = AjustesActivity.this;
    TextView tvTitle = (TextView)findViewById(R.id.toolbarTitulo);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: onStarting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
       // setUpBottomNavigationView(bottomBar);
        setUp(bottomBar);
        TextView tvTitle = (TextView)findViewById(R.id.toolbarTitulo);
        tvTitle.setText(R.string.tAjustes);


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
                if (tabId == R.id.tabLetra) {
                    Intent intentL = new Intent(AjustesActivity.this, LetrasActivity.class);
                    startActivity(intentL);
                }
                else if(tabId == R.id.tabTemp)
                {
                    Intent intentT = new Intent(AjustesActivity.this, TemporizadorActivity.class);
                    startActivity(intentT);
                }
                else if(tabId == R.id.tabMusica)
                {
                    Intent intentM = new Intent(AjustesActivity.this, MainActivity.class);
                    startActivity(intentM);
                }
                else if(tabId == R.id.tabSupport)
                {
                    Intent intentS = new Intent(AjustesActivity.this, SupportActivity.class);
                    startActivity(intentS);
                }
            }
        });
    }



}
