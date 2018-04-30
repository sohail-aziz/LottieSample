package sohail.aziz.lottiesample;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;


public class MainActivity extends AppCompatActivity {


    int[] COLORS = {0xff5a5f,
            0x008489,
            0xa61d55};

    LottieAnimationView lottieAnimationView;
    int colorIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.animationView);


        findViewById(R.id.buttonChange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colorIndex = (colorIndex + 1) % COLORS.length;
                changeColor(COLORS[colorIndex]);

            }
        });
    }

    private void changeColor(final int color) {

        @SuppressLint("RestrictedApi") KeyPath keyPath = new KeyPath("Shirt", "Group 5", "Fill 1");
        lottieAnimationView.addValueCallback(keyPath, LottieProperty.COLOR, new SimpleLottieValueCallback<Integer>() {
                    @Override
                    public Integer getValue(LottieFrameInfo<Integer> frameInfo) {
                        return color;
                    }
                }

        );
    }


}
