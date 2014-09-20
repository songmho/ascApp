package example.mh.com.ascapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by songmho on 2014-09-16.
 */
public class SplashActivity extends ActionBarActivity {

    private static final int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        handler();
    }

    private void handler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMain();
            }
        },SPLASH_TIME);
    }

    private void startMain() {
        dismissSplash();
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
    }

    protected void dismissSplash() {
        overridePendingTransition(0, android.R.anim.fade_out);
        finish();
    }
}
