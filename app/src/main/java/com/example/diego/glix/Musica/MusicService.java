package com.example.diego.glix.Musica;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import com.example.diego.glix.Musica.MusicService.MusicBinder;
import java.util.ArrayList;

/**
 * Created by diego on 6/02/18.
 */

public class MusicService extends Service implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener
{

    //media player
    private MediaPlayer player;
    //song list
    private ArrayList<SongInfo> songs;
    //current position
    private int songPosn;

    private final IBinder musicBind = new MusicBinder();


    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    public void onCreate(){
        //create the service
        super.onCreate();
        //initialize position
        songPosn=0;
        //create player
        player = new MediaPlayer();

        initMusicPlayer();
    }

    public void initMusicPlayer(){
        //set player properties

        //El "bloqueo de activación" permitirá que la reproducción continúe cuando el dispositivo esté inactivo
        player.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);


        //Set the class as listener for (1) when the MediaPlayer instance is prepared,
        // (2) when a song has completed playback, and when (3) an error is thrown
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }

    public void setList(ArrayList<SongInfo> theSongs){
        songs=theSongs;
    }

    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    //This will execute when the user exits the app, at which point we will stop the service.

    @Override
    public boolean onUnbind(Intent intent){
        player.stop();
        player.release();
        return false;
    }


}