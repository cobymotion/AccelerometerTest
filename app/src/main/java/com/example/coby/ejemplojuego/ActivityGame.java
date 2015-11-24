package com.example.coby.ejemplojuego;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActivityGame extends Activity {

    MediaPlayer mp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_game);
        mp =MediaPlayer.create(this, R.raw.deporte);
        mp.setLooping(false);
        mp.start();

    }

}
