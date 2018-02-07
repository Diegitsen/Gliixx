package com.example.diego.glix.Musica;

import android.Manifest;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.diego.glix.BuildConfig;
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

    private MusicService musicSrv;
    private Intent playIntent;
    //bandera para realizar un seguimiento de si la Activityclase está vinculada a la Serviceclase o no
    private boolean musicBound=false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_musica, container, false);


        songView = (ListView)view.findViewById(R.id.lvCanciones);
        songList = new ArrayList<>();

        checkUserPermissions();


        SongAdapter songAdt = new SongAdapter(getActivity(), songList);
        songView.setAdapter(songAdt);




        //ordenaremos los datos para que las canciones se presenten alfabéticamente
       Collections.sort(songList, new Comparator<SongInfo>(){
            public int compare(SongInfo a, SongInfo b){
                return a.getSong().compareTo(b.getSong());
            }
        });




        return view;
    }

    //connect to the service
    private ServiceConnection musicConnection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder)service;
            //get service
            musicSrv = binder.getService();
            //pass list
            musicSrv.setList(songList);
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };


    public void getSongList()
    {
        //retrieve song info
        //Una aplicación accede a datos de un proveedor de contenido
        ContentResolver musicResolver = getActivity().getContentResolver();
        //Represents a Uniform Resource Identifier (URI) reference
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //This interface provides random read-write access to the result set returned by a database query.
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);


      if(musicCursor!=null ){
          if(musicCursor.moveToFirst()) {
              do {
                  //CHECK THIS OUT!!!!!
                  String mySongData = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                  String mySongTitle = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                  String mySongArtist = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                  String mySongAlbum = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));

                  songList.add(new SongInfo(mySongTitle, mySongArtist, mySongData, mySongAlbum));
              }
              while (musicCursor.moveToNext());
          }


      }
    }

    public void checkUserPermissions()
    {
        if(Build.VERSION.SDK_INT>=23)
        {
            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED)
            {
               // requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                //        REQUEST_CODE_ASK_PERMISSIONS);

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
        getSongList();
    }

    static final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

       switch (requestCode)
       {
           case REQUEST_CODE_ASK_PERMISSIONS:
           {
               if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
               {getSongList();}
               else
               {
                   //Permission Denied
                   Toast.makeText(getActivity(), "denegado", Toast.LENGTH_SHORT).show();
               }
           }

           default:
           {
               super.onRequestPermissionsResult(requestCode, permissions, grantResults);
           }

       }
    }

    @Override
    public void onStart() {
        super.onStart();

        if(playIntent==null){
            playIntent = new Intent(getActivity(), MusicService.class);
            bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
            startService(playIntent);
        }
    }
}
