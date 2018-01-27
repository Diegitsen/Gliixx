package com.example.diego.glix.Musica;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diego.glix.R;

/**
 * Created by diego on 27/01/18.
 */

public class ArtistaFragment extends Fragment
{
    private static final String TAG = "ArtistaFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artista, container, false);
        return view;
    }
}
