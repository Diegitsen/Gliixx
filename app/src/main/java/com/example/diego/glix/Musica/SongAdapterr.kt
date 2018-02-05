package com.example.diego.glix.Musica

import android.app.Service
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.diego.glix.R
import java.util.*
import java.util.zip.Inflater
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.ViewParent


/**
 * Created by diego on 4/02/18.
 */
class SongAdapterr
{
/*
    var mp: MediaPlayer? = null
    /*Context context = parent!!.c
    val context:Context = count
    var inflater = context.getSystemService(Service.LAYOUT_INFLATER_SERVICE) as LayoutInflater*/
    var myListSong = ArrayList<SongInfo>()

    constructor(myListSong: ArrayList<SongInfo>):super()
    {
        this.myListSong = myListSong
    }





    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val myView = LayoutInflater.from(parent!!.context).inflate(R.layout.layout_musica_cancion, null)

        val song = this.myListSong[position]
        var url:String?=null
        myView.tvTituloCancion.text = song.song
        myView.tvArtista.text = song.artist

        myView.llSong.setOnClickListener(View.OnClickListener {


            mp = MediaPlayer()
            try {
                mp!!.setDataSource(song.songdata)
                url = song.songdata
                mp!!.prepare()
                mp!!.start()
                //sbProgress.max = mp!!.duration
                // tvAlbumPlaying.text = song.author.toString()
                //tvSongPlaying.text = song.song.toString()
            } catch(ex: Exception) {

            }

        })


        return myView
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

}