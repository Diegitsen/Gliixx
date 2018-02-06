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

public class SongAdapter extends BaseAdapter {

    private ArrayList<SongInfo> songs;
    private LayoutInflater songInf;

    public SongAdapter(Context c, ArrayList<SongInfo> theSongs){
        songs=theSongs;
        songInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return songs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //map to song layout
        LinearLayout songLay = (LinearLayout)songInf.inflate
                (R.layout.layout_musica_cancion, parent, false);
        //get title and artist views
        TextView songView = (TextView)songLay.findViewById(R.id.tvTituloCancion);
        TextView artistView = (TextView)songLay.findViewById(R.id.tvArtista);
        //get song using position
        SongInfo currSong = songs.get(position);
        //get title and artist strings
        songView.setText(currSong.getSong());
        artistView.setText(currSong.getArtist());
        //set position as tag
        songLay.setTag(position);
        return songLay;
    }

}



/*

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
 */