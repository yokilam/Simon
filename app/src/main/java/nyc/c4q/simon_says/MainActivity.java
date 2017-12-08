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
    private Button two, one, three, four, start;
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
        two = (Button) findViewById(R.id.button2);
        one = (Button) findViewById(R.id.button1);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);

        one.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);
        four.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);

        start = (Button) findViewById(R.id.start);
        roundnumber = (TextView) findViewById(R.id.roundnumber);
        roundnumber.setVisibility(View.INVISIBLE);
        animation.setDuration(1000);
        color = new Button[]{two, one, three, four};


    }

    public void onPlay(View view) {
        one.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        roundnumber.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);

        Animation buttonslide1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide1);
        one.startAnimation(buttonslide1);
        Animation buttonslide3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide3);
        three.startAnimation(buttonslide3);


        Animation buttonslide2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide2);
        two.startAnimation(buttonslide2);
        Animation buttonslide4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide4);
        four.startAnimation(buttonslide4);

        running = true;
        buttonSequence.clear();

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                disableClick();
                simon();
//                enableClick();
            }
        }, 1000);
    }

    public void reset(){
        one.setVisibility(View.GONE);
        three.setVisibility(View.GONE);
        four.setVisibility(View.GONE);
        two.setVisibility(View.GONE);
        roundnumber.setVisibility(View.GONE);
        start.setClickable(true);
        roundnumber.setText("Level: 1");
        start.setVisibility(View.VISIBLE);
        count= 0;
    }

    public void disableClick(){
        one.setClickable(false);
        two.setClickable(false);
        three.setClickable(false);
        four.setClickable(false);
    }

    public void enableClick(){
        one.setClickable(true);
        two.setClickable(true);
        three.setClickable(true);
        four.setClickable(true);
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
                                two.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                    case R.id.button2:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                one.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                    case R.id.button3:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                three.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                    case R.id.button4:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                four.startAnimation(animation);
                            }
                        }, 2000 * count);
                        count++;
                        break;
                }  //swtich end
            } ///for each
            running = false;
            userChoice.clear();
        } //while end
        enableClick();

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
                reset();


            }
        }
    }
}