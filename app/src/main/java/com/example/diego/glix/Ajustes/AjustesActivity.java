package com.example.diego.glix.Ajustes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.util.ArrayList;

/**
 * Created by diego on 24/01/18.
 */

public class AjustesActivity extends AppCompatActivity {

    private static final String TAG = "AjustesActivity";

    Context mcontext = AjustesActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: onStarting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        //bottombar
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        //setUp(bottomBar);

        //changing title
        TextView tvTitle = (TextView)findViewById(R.id.toolbarTitulo);
        tvTitle.setText(R.string.tAjustes);

        //setUpListSettings
        setUpSettingList();

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


    private void setUpSettingList()
    {
        Log.d(TAG, "setUpSettingList: initialazing");
        ListView listView = (ListView)findViewById(R.id.lvSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.aTema));
        options.add(getString(R.string.aShake));
        options.add(getString(R.string.aPausar));
        options.add(getString(R.string.aLookScreen));

        ArrayAdapter adapter = new ArrayAdapter(AjustesActivity.this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);
    }



}
