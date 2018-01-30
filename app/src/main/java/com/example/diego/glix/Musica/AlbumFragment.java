package com.example.diego.glix.Musica;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.diego.glix.Ajustes.AjustesActivity;
import com.example.diego.glix.Letras.LetrasActivity;
import com.example.diego.glix.R;
import com.example.diego.glix.Support.SupportActivity;
import com.example.diego.glix.Temporizador.TemporizadorActivity;
import com.example.diego.glix.Utils.GridImageAdapter;
import com.example.diego.glix.Utils.SectionPageAdapter;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by diego on 27/01/18.
 */

public class AlbumFragment extends Fragment
{
    private static final int NUM_GRID_COLUMNS = 3;
    private static final String TAG = "AlbumFragment";
    private GridView gridView;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        context = getActivity();
        gridView = (GridView) view.findViewById(R.id.gridView);

        tempGridSetup();
        return view;

    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");



        setupImageGrid(imgURLs);
    }

    private void setupImageGrid(ArrayList<String> imgURLs){

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(this.getActivity(), R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }

}
