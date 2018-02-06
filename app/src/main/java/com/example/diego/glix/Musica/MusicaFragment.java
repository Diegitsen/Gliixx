package com.example.diego.glix.Musica;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.diego.glix.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by diego on 27/01/18.
 */

public class MusicaFragment extends Fragment
{
    private static final String TAG = "MusicaFragment";

    private ArrayList<SongInfo> songList;
    private ListView songView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_musica, container, false);

        songView = (ListView)getActivity().findViewById(R.id.lvCanciones);
        songList = new ArrayList<SongInfo>();

        getSongList();

        //ordenaremos los datos para que las canciones se presenten alfabéticamente
        Collections.sort(songList, new Comparator<SongInfo>(){
            public int compare(SongInfo a, SongInfo b){
                return a.getSong().compareTo(b.getSong());
            }
        });


        SongAdapter songAdt = new SongAdapter(getActivity().getApplicationContext(), songList);
        songView.setAdapter(songAdt);

        return view;
    }

    public void getSongList()
    {
        //retrieve song info
        //Una aplicación accede a datos de un proveedor de contenido
        ContentResolver musicResolver = getActivity().getContentResolver();
        //Represents a Uniform Resource Identifier (URI) reference
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //This interface provides random read-write access to the result set returned by a database query.
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            //add songs to list
            do {
                //CHECK THIS OUT!!!!!
                String mySongData = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                String mySongTitle = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                String mySongArtist = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String mySongAlbum = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));

                songList.add(new SongInfo(mySongTitle, mySongArtist,mySongData,mySongAlbum ));
            }
            while (musicCursor.moveToNext());
        }
    }

}
