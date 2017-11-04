package nyc.c4q.simon_says;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Button blue, red, green, yellow, play;
    private Button[] color;
    static Random random = new Random();
    AlphaAnimation animation = new AlphaAnimation(1f, 0f);
    Handler handler = new Handler();
    private int count = 1;
    private int level = 1;
    private int index = 0;

    private TextView roundnumber;

    public ArrayList<Integer> buttonSequence = new ArrayList<Integer>();
    public ArrayList<Integer> userChoice = new ArrayList<>();
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        red = (Button) findViewById(R.id.button1);
        blue = (Button) findViewById(R.id.button2);
        yellow = (Button) findViewById(R.id.button3);
        green = (Button) findViewById(R.id.button4);
        play = (Button) findViewById(R.id.play);
        roundnumber = (TextView) findViewById(R.id.roundnumber);

        animation.setDuration(100);
        color = new Button[]{blue, red, green, yellow};
    }

    public void onPlay(View view) {
        running = true;
        simon(view);
    }

    public void simon(View view) {
        while (running) {
            int r = random.nextInt(4);
            Log.e("random number = ", ("" + r));
            buttonSequence.add(r);
            for (int s : buttonSequence) {

                switch (color[s].getId()) {
                    case R.id.button1:

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                blue.startAnimation(animation);
                            }
                        }, 1000 * count);
                        count++;
                        break;
                    case R.id.button2:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                red.startAnimation(animation);
                            }
                        }, 1000 * count);
                        count++;
                        break;
                    case R.id.button3:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                green.startAnimation(animation);
                            }
                        }, 1000 * count);
                        count++;
                        break;
                    case R.id.button4:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                yellow.startAnimation(animation);
                            }
                        }, 1000 * count);
                        count++;
                        break;
                }
            }
            running = false;
        }
    }

    public void playerClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blue.startAnimation(animation);
                    }
                }, 500 * count);
                userChoice.add(0);
                break;
            case R.id.button2:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        red.startAnimation(animation);
                    }
                }, 500 * count);
                userChoice.add(1);
                break;
            case R.id.button3:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        green.startAnimation(animation);
                    }
                }, 500 * count);
                userChoice.add(2);
                break;
            case R.id.button4:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yellow.startAnimation(animation);
                    }
                }, 500 * count);
                userChoice.add(3);
                break;
        }
        if (index < level) {
            if (buttonSequence.get(index).equals(userChoice.get(index))) {
                running = true;
            } else {
                Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT).show();
                running = false;
                level = 0;
            }
            index++;
        } else {
            index = 0;
            level++;
            roundnumber.setText("level: " + level);
            Toast.makeText(this, "good job!", Toast.LENGTH_SHORT).show();
            userChoice.clear();
            simon(view);
        }
    }
}
