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
    int count = 1;

    private TextView roundnumber;
    private TextView showrandom;
    private TextView queue;

    //    public ArrayList<Integer> buttonSequence = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
    public ArrayList<Integer> buttonSequence = new ArrayList<Integer>();
    public Queue<Integer> randomSequence = new LinkedList<>();
    public ArrayList<Integer> userChoice = new ArrayList<>();
    private boolean running= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        red = (Button) findViewById(R.id.button2);
        blue = (Button) findViewById(R.id.button1);
        green = (Button) findViewById(R.id.button3);
        yellow = (Button) findViewById(R.id.button4);
        play = (Button) findViewById(R.id.play);
        roundnumber= (TextView) findViewById(R.id.roundnumber);

        animation.setDuration(1000);
        color = new Button[]{blue, red, green, yellow};

    }
    public void onPlay(View view){
        running= true;
        simon(view);

    }

    public void simon(View view) {
        while (running) {


            int r = random.nextInt(4);
            Log.e("random number = ", ("" + r));
            buttonSequence.add(r);
            int size= userChoice.size()+1;
            roundnumber.setText("level: "+ size);
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
//                count = 1;

            }
            running = false;
            playerClick(view);
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
         if (buttonSequence.size() == userChoice.size()) {
             if (buttonSequence.equals(userChoice)) {
                 running = true;
                 userChoice.clear();
//                 int size= userChoice.size()+1;
//                 roundnumber.setText("level: "+ size);
                 Toast.makeText(this, "level: "+( userChoice.size()+2), Toast.LENGTH_SHORT).show();
                 simon(view);

             }
         }

    }









        /*

        showrandom = (TextView)findViewById(R.id.randomnumber);
        queue = (TextView) findViewById(R.id.queue);

    }

    public void Simon () {

    }

//    @Override
//    public void onClick(View view) {
//
//    }

//    public void changecolor (int num) {
////        num = randomSequence.poll();
//        originalColors();
//
//        switch (num) {
//            case 1:
//                one.setBackgroundColor(getResources().getColor(R.color.lightBlue));
//                break;
//            case 2:
//                two.setBackgroundColor(getResources().getColor(R.color.lightRed));
//                break;
//            case 3:
//                three.setBackgroundColor(getResources().getColor(R.color.lightGreen));
//                break;
//            case 4:
//                four.setBackgroundColor(getResources().getColor(R.color.lightYellow));
//                break;
//        }
//
//    }
//
//
//    public void originalColors() {
//        one.setBackgroundColor(getResources().getColor(R.color.blue));
//        two.setBackgroundColor(getResources().getColor(R.color.red));
//        three.setBackgroundColor(getResources().getColor(R.color.green));
//        four.setBackgroundColor(getResources().getColor(R.color.yellow));
//
//    }
//    public void simon () {
//        Toast.makeText(getBaseContext(), "Simon's turn", Toast.LENGTH_SHORT).show();
//        int size = randomSequence.size();
//        for (int count = 0; count < size; count++) {
//            final int j = count;
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    changecolor(randomSequence.poll());
////                    queue.setText("" + randomSequence.size());
//                }
//            }, 2000*j);
//        }
//        originalColors();
//    }
//    public void no(ArrayList<ImageView> bInput) {
//        for (int i = 0; i < buttonSequence.size(); i++) {
////            Button.setClickable(false);
////            Button.setEnabled(false);
//     }
// }
//
//
//
//
//
//
//    public void player(View view) {
//        Toast.makeText(getBaseContext(), "Your turn", Toast.LENGTH_SHORT).show();
////        Button b = (Button) view;
//        if (userChoice.size() == buttonSequence.size()) {
//            switch (view.getId()) {
//                case R.id.button1:
//                    userChoice.add(1);
//                    break;
//                 case R.id.button2:
//                    userChoice.add(2);
//                    break;
//                case R.id.button3:
//                    userChoice.add(3);
//                    break;
//                case R.id.button4:
//                    userChoice.add(4);
//                    break;
//
//            }
//        }
//
//
//    }
//
//
//
////    public void check() {
////        if (userChoice.size() == randomSequence.size()) {
////            userChoice
////        }
////    }
////
//    @Override
//    public void onClick(View view) {
//        Collections.shuffle(buttonSequence);
//        for (int i = 0; i < buttonSequence.size(); i++) {
//            int number = buttonSequence.get(i);
//            randomSequence.add(number);
//            //Collections.addAll(randomSequence, number);
//            showrandom.setText("" + randomSequence);
//        }
//        simon();
////        if (userChoice.size() == buttonSequence.size()) {
////           player(view);
////
////        } else {
////
////        }
////
////       player(view);
////        queue.setText("" + userChoice);
//
//
//    }
*/

}
