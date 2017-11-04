package nyc.c4q.simon_says;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button one, two, three, four;
    private TextView showrandom;
    private TextView queue;

    public ArrayList<Integer> buttonSequence = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
    public Queue<Integer> randomSequence = new LinkedList<>();
    public  ArrayList<Integer> userChoice = new ArrayList<>();

    //array list with just 1,2,3,4
    //a queue
    static Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(this);
        two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);
        showrandom = (TextView)findViewById(R.id.randomnumber);
        queue = (TextView) findViewById(R.id.queue);

    }

    public void changecolor (int num) {
//        num = randomSequence.poll();
        originalColors();

        switch (num) {
            case 1:
                one.setBackgroundColor(getResources().getColor(R.color.lightBlue));
                break;
            case 2:
                two.setBackgroundColor(getResources().getColor(R.color.lightRed));
                break;
            case 3:
                three.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                break;
            case 4:
                four.setBackgroundColor(getResources().getColor(R.color.lightYellow));
                break;
        }

    }


    public void originalColors() {
        one.setBackgroundColor(getResources().getColor(R.color.blue));
        two.setBackgroundColor(getResources().getColor(R.color.red));
        three.setBackgroundColor(getResources().getColor(R.color.green));
        four.setBackgroundColor(getResources().getColor(R.color.yellow));

    }
    public void simon () {
        Toast.makeText(getBaseContext(), "Simon's turn", Toast.LENGTH_SHORT).show();
        int size = randomSequence.size();
        for (int count = 0; count < size; count++) {
            final int j = count;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    changecolor(randomSequence.poll());
//                    queue.setText("" + randomSequence.size());
                }
            }, 2000*j);
        }
        originalColors();
    }

    public void player(View view) {
        Toast.makeText(getBaseContext(), "Your turn", Toast.LENGTH_SHORT).show();
        Button b = (Button) view;

        switch (b.getId()) {
            case R.id.button1:
                int one=1;
                userChoice.add(one);
                break;
            case R.id.button2:
                int two= 2;
                userChoice.add(two);
                break;
            case R.id.button3:
                int three= 2;
                userChoice.add(three);
                break;
            case R.id.button4:
                int four= 2;
                userChoice.add(four);
                break;
        }

        
    }

    @Override
    public void onClick(View view) {
        Collections.shuffle(buttonSequence);
        for (int i = 0; i < buttonSequence.size(); i++) {
            int number = buttonSequence.get(i);
            randomSequence.add(number);
            //Collections.addAll(randomSequence, number);
            showrandom.setText("" + randomSequence);
        }
        simon();

       player(view);
//        queue.setText("" + userChoice);


    }
}
