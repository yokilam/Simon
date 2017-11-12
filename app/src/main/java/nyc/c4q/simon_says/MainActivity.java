package nyc.c4q.simon_says;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button blue, red, green, yellow, play;
    private Button[] color;
    static Random random = new Random();
    AlphaAnimation animation = new AlphaAnimation(1f, 0f);
    Handler handler = new Handler();
    private int count = 1;
    private TextView roundnumber;
    public ArrayList<Integer> buttonSequence = new ArrayList<>(); //for the generate
    public ArrayList<Integer> userChoice = new ArrayList<>();   //for the userclick
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        red = (Button) findViewById(R.id.button2);
        blue = (Button) findViewById(R.id.button1);
        green = (Button) findViewById(R.id.button3);
        yellow = (Button) findViewById(R.id.button4);

        Animation buttonslide1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide1);
        red.startAnimation(buttonslide1);
        Animation buttonslide4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide4);
        green.startAnimation(buttonslide4);


        Animation buttonslide2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide2);
        blue.startAnimation(buttonslide2);
        Animation buttonslide3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide3);
        yellow.startAnimation(buttonslide3);

        play = (Button) findViewById(R.id.play);
        roundnumber = (TextView) findViewById(R.id.roundnumber);
        animation.setDuration(1000);
        color = new Button[]{blue, red, green, yellow};


    }

    public void onPlay(View view) {
        running = true;
        buttonSequence.clear();
        simon();
        //playerClick(view);
    }

    public void simon() {
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
                        }, 2000 * count);
                        count++;
                        break;
                    case R.id.button2:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                red.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                    case R.id.button3:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                green.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                    case R.id.button4:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                yellow.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                }  //swtich end
            } ///for each
            running = false;
            userChoice.clear();
        } //while end
    }

    public void playerClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                userChoice.add(0);
                break;
            case R.id.button2:
                userChoice.add(1);
                break;
            case R.id.button3:
                userChoice.add(2);
                break;
            case R.id.button4:
                userChoice.add(3);
                break;
        }
        Log.e("userChoiceLIST SIZE IS:", "" + userChoice.size());
        if (buttonSequence.size() == userChoice.size()) {
            Log.e("userchoice size: ", "" + userChoice.size());
            if (userChoice.equals(buttonSequence)) {
                running = true;
                int size = buttonSequence.size() + 1;
                roundnumber.setText("level: " + size);
                Toast.makeText(this, "good job!", Toast.LENGTH_SHORT).show();
                count = 1;
                simon();
            } else {
                Toast.makeText(this, "Game Over!", Toast.LENGTH_SHORT).show();
                running = false;
            }
        }
    }
}