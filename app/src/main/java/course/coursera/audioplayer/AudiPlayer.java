package course.coursera.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class AudiPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audi_player);

        final String path = "/Users/ritesh/Documents/Ritesh/data/ritesh.mp3";

        final MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        final Button play = (Button) findViewById(R.id.button);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        final Button stop = (Button)findViewById(R.id.button2);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp.reset();
                try {
                    mp.setDataSource(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void playAudio(final String path, final MediaPlayer mp) {
        try {
            mp.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        mp.start();
    }

    private void stopAudio(final String path,final MediaPlayer mp) {

        mp.stop();
        mp.reset();

        try {
            mp.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
