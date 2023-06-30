package com.task.saregamma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FrameSetting extends AppCompatActivity {
    private FrameLayout frameLayout;
    private TextView lyrics,songAudio,tempo,transpose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_setting);

        frameLayout =(FrameLayout) findViewById(R.id.fragment_layout);
        lyrics=(TextView) findViewById(R.id.lyrics);
        songAudio=(TextView) findViewById(R.id.songAudio);
        tempo=(TextView) findViewById(R.id.tempo);
        transpose=(TextView) findViewById(R.id.transpose);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_layout,new LyricsSubtitles()).commit();

        lyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click is going on ","error");
//                Toast.makeText(frameSetting.this, "hello", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction().replace(R.id.fragment_layout,new LyricsSubtitles()).commit();
                lyrics.setBackgroundResource(R.drawable.background_radius_text);
                tempo.setBackground(null);
                songAudio.setBackground(null);
                transpose.setBackground(null);
            }
        });

        songAudio.setOnClickListener(view -> {
            fragmentManager.beginTransaction().replace(R.id.fragment_layout,new SongAudio()).commit();
            songAudio.setBackgroundResource(R.drawable.background_radius_text);
            tempo.setBackground(null);
            transpose.setBackground(null);
            lyrics.setBackground(null);
        });

        tempo.setOnClickListener(view -> {
            fragmentManager.beginTransaction().replace(R.id.fragment_layout,new Tempo()).commit();
            tempo.setBackgroundResource(R.drawable.background_radius_text);
            transpose.setBackground(null);
            songAudio.setBackground(null);
            lyrics.setBackground(null);
        });
        transpose.setOnClickListener(view -> {
            fragmentManager.beginTransaction().replace(R.id.fragment_layout,new Transpose()).commit();
            transpose.setBackgroundResource(R.drawable.background_radius_text);
            tempo.setBackground(null);
            songAudio.setBackground(null);
            lyrics.setBackground(null);
        });
    }
}