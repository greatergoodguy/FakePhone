package greatergoodguy.fakephone;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.io.IOException;

public class ActivityMain extends Activity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViewById(R.id.secret_button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) { mediaPlayer.stop();}
            }
        });


        findViewById(R.id.secret_button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()) {
                    try {
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        findViewById(R.id.secret_button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) { mediaPlayer.stop();}
            }
        });


        findViewById(R.id.secret_button_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) { mediaPlayer.stop();}
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(this, R.raw.ctu_ringtone);
        if(!mediaPlayer.isPlaying()) { mediaPlayer.start();}
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying()) { mediaPlayer.stop();}
        mediaPlayer.release();
    }
}
