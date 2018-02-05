package com.example.diego.glix.Musica;

import android.app.Service;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diego.glix.R;

import java.util.ArrayList;

/**
 * Created by diego on 1/02/18.
 */

public class SongAdapter extends BaseAdapter
{
    ArrayList<SongInfo> myListSong;
    MediaPlayer mp;


    public SongAdapter(ArrayList<SongInfo> myListSong, MediaPlayer md)
    {
        this.myListSong = myListSong;
        this.mp = mp;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View myView = inflater.inflate(R.layout.layout_musica_cancion, null);

        final SongInfo song = myListSong.get(position);
        //String url;
        TextView tvTitC = myView.findViewById(R.id.tvTituloCancion);
        tvTitC.setText(song.song);
        TextView tvArt = myView.findViewById(R.id.tvArtista);
        tvArt.setText(song.artist);
        LinearLayout llc = myView.findViewById(R.id.LinearLayoutCancion);
        llc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mp.setDataSource(song.songdata);
                    mp.prepare();
                    mp.start();

                }catch(Exception ex)
                {

                }

            }
        });



        return myView;

    }
}
