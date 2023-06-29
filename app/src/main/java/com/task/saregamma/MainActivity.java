package com.task.saregamma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private Button setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        FragmentManager fragmentManager=getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.frame_lobi,new LyricsSubtitles()).commit();


        setting =(Button) findViewById(R.id.setting);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog settingsDialog = new Dialog(MainActivity.this);
                // Set the content view of the dialog to the settings pop-up activity layout
                settingsDialog.setContentView(R.layout.frame_setting);

                // Set the width and height of the dialog window
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(settingsDialog.getWindow().getAttributes());
                int dialogWidth = (int) (getResources().getDisplayMetrics().widthPixels * 0.8); // 80% of screen width
                int dialogHeight = WindowManager.LayoutParams.WRAP_CONTENT; // Adjust the height as needed
                layoutParams.width = dialogWidth;
                layoutParams.height = dialogHeight;
                settingsDialog.getWindow().setAttributes(layoutParams);



                FrameLayout frameLayout =(FrameLayout) settingsDialog.findViewById(R.id.fragment_layout);
                TextView lyrics=(TextView) settingsDialog.findViewById(R.id.lyrics);
                TextView songAudio=(TextView) settingsDialog.findViewById(R.id.songAudio);
                TextView tempo=(TextView) settingsDialog.findViewById(R.id.tempo);
                TextView transpose=(TextView) settingsDialog.findViewById(R.id.transpose);





//                FragmentManager fragmentManager =getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                LyricsSubtitles lyricsSubtitles=new LyricsSubtitles();
//                fragmentTransaction.add(R.id.fragment_layout,lyricsSubtitles).commit();



                lyrics.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "lyrics", Toast.LENGTH_SHORT).show();
                        lyrics.setBackgroundResource(R.drawable.background_radius_text);
                        tempo.setBackground(null);
                        songAudio.setBackground(null);
                        transpose.setBackground(null);
                    }
                });
                songAudio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "songAudio", Toast.LENGTH_SHORT).show();
                        songAudio.setBackgroundResource(R.drawable.background_radius_text);
                        tempo.setBackground(null);
                        transpose.setBackground(null);
                        lyrics.setBackground(null);
                    }
                });
                tempo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "tempo", Toast.LENGTH_SHORT).show();
                        tempo.setBackgroundResource(R.drawable.background_radius_text);
                        transpose.setBackground(null);
                        songAudio.setBackground(null);
                        lyrics.setBackground(null);
                    }
                });
                transpose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "transpose", Toast.LENGTH_SHORT).show();
                        transpose.setBackgroundResource(R.drawable.background_radius_text);
                        tempo.setBackground(null);
                        songAudio.setBackground(null);
                        lyrics.setBackground(null);
                    }
                });



                // Show the dialog as a pop-up
                settingsDialog.show();
            }
        });

    }
}