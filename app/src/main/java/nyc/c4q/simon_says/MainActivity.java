package nyc.c4q.simon_says;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button one, two, three, four;
    private TextView showrandom;
    private int level = 4;

    public ArrayList<String> randomSequence = new ArrayList<String>();
    public ArrayList<String> buttonSequence = new ArrayList<String>();

        Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(this);
        two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);
        showrandom = (TextView)findViewById(R.id.randomnumber);

    }

    public void play() {

    }

    @Override
    public void onClick(View view) {

            switch(view.getId()){
                case R.id.button1:
                    buttonSequence.add(String.valueOf(1));
                    break;
                case R.id.button2:
                    buttonSequence.add(String.valueOf(2));
                    break;
                case R.id.button3:
                    buttonSequence.add(String.valueOf(3));
                    break;
                case R.id.button4:
                    buttonSequence.add(String.valueOf(4));
                    break;
                case R.id.play:
                    for (int i = 0; i < level; i++) {
                        int randomNumber = ran.nextInt(4) + 1;
                        randomSequence.add(String.valueOf(randomNumber));
                    };showrandom.setText((CharSequence) randomSequence);break;
            }

        }
    }
