package rotaryinformatorapp.com.rotaryinformatorapp.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment.CategoryFragment;

/**
 * Created by Vladimir on 5/4/2016.
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCategoryFragment();

        openFragmentOnConfigurationChange(savedInstanceState);
    }

    private void openFragmentOnConfigurationChange(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("savedFragment")) {

            }
        }
    }

    public void displayHomeAsUpEnabled(boolean enabled) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
    }

    private void initCategoryFragment() {
        FragmentManager fm = getSupportFragmentManager();
        CategoryFragment fragment = new CategoryFragment();
        fm.beginTransaction().replace(R.id.container, fragment, CategoryFragment.TAG).commit();
    }

    public void changeActionbarColor(int statusbarColor, int actionbarColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(statusbarColor));
        }

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(actionbarColor)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}