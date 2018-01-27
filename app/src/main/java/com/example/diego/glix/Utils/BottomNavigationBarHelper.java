package com.example.diego.glix.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.util.Log;

import com.example.diego.glix.Ajustes.AjustesActivity;
import com.example.diego.glix.Letras.LetrasActivity;
import com.example.diego.glix.Musica.MainActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Support.SupportActivity;
import com.example.diego.glix.Temporizador.TemporizadorActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by diego on 24/01/18.
 */

public class BottomNavigationBarHelper {

    private static final String TAG = "BottomNavigationBarHelp";

    public static void enableNavigation(final Context context, BottomBar bottomBar)
    {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener()
        {
            
            @Override
            public void onTabSelected(@IdRes int tabId)
            {
                Log.d(TAG, "onTabSelected: strating");
                switch (tabId)
                {
                    case R.id.tabLetra:
                        Intent intent1 = new Intent(context, LetrasActivity.class);//ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        break;

                    case R.id.tabTemp:
                        Intent intent2 = new Intent(context, TemporizadorActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.tabMusica:
                        Intent intent3 = new Intent(context, MainActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.tabAjustes:
                        Intent intent4 = new Intent(context, AjustesActivity.class);
                        context.startActivity(intent4);
                        break;

                    case R.id.tabSupport:
                        Intent intent5 = new Intent(context, SupportActivity.class);
                        context.startActivity(intent5);
                        break;

                }


            }
        });
    }
}
