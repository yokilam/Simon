package nyc.c4q.simon_says;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView red, green, blue, yellow;

    ImageView[] gamebuttons = { red, green, blue, yellow };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = (ImageView) findViewById(R.id.imagered);
        blue = (ImageView) findViewById(R.id.imageblue);
        green = (ImageView) findViewById(R.id.imagegreen);
        yellow = (ImageView) findViewById(R.id.imageyellow);


    }

    public void random(ImageView[] gamebuttons) {
        for (int i = 0; i< gamebuttons.length; i++) {
            int id = getResources().getIdentifier("R.id.imageView" + i, "id", null);
//            gamebuttons[i] = (ImageView) getApplicationContext().getResources().getLayout(findViewById(id));
        }
    }
}
