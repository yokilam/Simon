package nyc.c4q.simon_says;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button one, two, three, four;
    private TextView showrandom;

    public ArrayList<Integer> buttonSequence = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
    public Queue<Integer> randomSequence = new LinkedList<>();

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
//        Collections.shuffle(buttonSequence);

//        red = (ImageView) findViewById(R.id.imagered);
//        blue = (ImageView) findViewById(R.id.imageblue);
//        green = (ImageView) findViewById(R.id.imagegreen);
//        yellow = (ImageView) findViewById(R.id.imageyellow);


    }
    public void play() {

    }

    @Override
    public void onClick(View view) {
        showrandom.setText("hi");
        Collections.shuffle(buttonSequence);
        for (int i= 0; i < buttonSequence.size(); i++) {
            int number= buttonSequence.get(i);
            Collections.addAll(randomSequence, number);
            showrandom.setText("" + randomSequence);
        }
    }


//    public void random(ImageView[] gamebuttons) {
//        for (int i = 0; i< gamebuttons.length; i++) {
//            int id = getApplicationContext().getResources().findViewByID(i);
//            gamebuttons[i] = (ImageView) getApplicationContext().getResources().getLayout(findViewById(id));
//        }
//    }
}
