package com.example.diego.glix.Musica;

/**
 * Created by diego on 1/02/18.
 */

public class SongInfo
{
    String song, artist, songdata, album;

    SongInfo(String song, String artist, String songdata, String album)
    {
        this.song = song;
        this.artist = artist;
        this.songdata = songdata;
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public String getArtist() {
        return artist;
    }

    public String getSongdata() {
        return songdata;
    }

    public String getAlbum() {
        return album;
    }
}
