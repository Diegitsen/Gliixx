package com.example.diego.glix.Musica;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.diego.glix.Ajustes.AjustesActivity;
import com.example.diego.glix.Letras.LetrasActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Support.SupportActivity;
import com.example.diego.glix.Temporizador.TemporizadorActivity;
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
        setUpViewPager();

        //Changing name of toolbar
        TextView tvTitle = (TextView)findViewById(R.id.toolbarTitulo);
        tvTitle.setText(R.string.tMusica);


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


    //Resposable for adding 4 tabs: music, album, artist and playlist
    private void setUpViewPager()
    {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlaylistFragment()); //index 0
        adapter.addFragment(new MusicaFragment()); //index 1
        adapter.addFragment(new AlbumFragment()); //index 2
        adapter.addFragment(new ArtistaFragment()); //index 3
        ViewPager viewPager = (ViewPager)findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabsMusica);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icplaylist);
        tabLayout.getTabAt(1).setIcon(R.drawable.icmusica);
        tabLayout.getTabAt(2).setIcon(R.drawable.icalbum);
        tabLayout.getTabAt(3).setIcon(R.drawable.icartista);

    }
}
