package nyc.c4q.simon_says;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Intent intent = new Intent(this, MainActivity.class);
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        Animation textSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slidetext);
        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
        ImageView simonView= (ImageView) findViewById(R.id.simon_text);
        imageView.startAnimation(animSlide);
        simonView.startAnimation(textSlide);
        final Button play=(Button)findViewById(R.id.play_button);
        play.setVisibility(View.INVISIBLE);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                rippleBackground.startRippleAnimation();
                play.setVisibility(View.VISIBLE);
            }
        }, 4000);



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  startActivity(intent);

            }
        });
    }
}
