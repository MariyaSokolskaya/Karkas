package com.example.admin215.karkas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = (ImageView) findViewById(R.id.image_view1);
        Animation starAnim = AnimationUtils.loadAnimation(this, R.anim.fide_in);
        imageView.startAnimation(starAnim);
        intent = new Intent(SplashActivity.this,MainActivity.class);
        starAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(intent);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
