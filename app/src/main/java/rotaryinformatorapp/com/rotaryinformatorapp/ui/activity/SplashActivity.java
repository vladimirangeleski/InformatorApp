package rotaryinformatorapp.com.rotaryinformatorapp.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

import java.lang.ref.WeakReference;

import rotaryinformatorapp.com.rotaryinformatorapp.R;

public class SplashActivity extends AppCompatActivity {

    public static final int SPLASH_SCREEN_DURATION = 1700;

    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = (ImageView) findViewById(R.id.pdfview);

        Handler mainHandler = new Handler(getMainLooper());
        mainHandler.postDelayed(new PostDelayRunnable(this), SPLASH_SCREEN_DURATION);
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
