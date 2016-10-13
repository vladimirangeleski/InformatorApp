package rotaryinformatorapp.com.rotaryinformatorapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import rotaryinformatorapp.com.rotaryinformatorapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler mainHandler = new Handler(getMainLooper());
        mainHandler.postDelayed(new PostDelayRunnable(this), 1700);
    }

    private static class PostDelayRunnable implements Runnable {
        WeakReference<SplashActivity> weakReference;
        public PostDelayRunnable(SplashActivity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            SplashActivity activity = weakReference.get();
            if (activity != null) {
                activity.startMainActivity();
            }
        }
    }

    private void startMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
